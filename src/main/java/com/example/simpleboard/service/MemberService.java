package com.example.simpleboard.service;

import com.example.simpleboard.domain.Role;
import com.example.simpleboard.domain.entity.MemberEntity;
import com.example.simpleboard.domain.repository.MemberRepository;
import com.example.simpleboard.dto.MemberDto;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberService implements UserDetailsService {
    private MemberRepository memberRepository;

    @Transactional
    public Long registerMember(MemberDto memberDto){
        //Encoding Password
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //I want to test something like 'sout(Password)' someday.
        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));

        return memberRepository.save(memberDto.toEntity()).getId();

    }

    @Override
    public UserDetails loadUserByUsername(String memberID) throws UsernameNotFoundException {
        Optional<MemberEntity> userEntityWrapper = memberRepository.findByMemberID(memberID);
        MemberEntity userEntity = userEntityWrapper.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        if (("ADMIN").equals(memberID)) {
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
        }

        return new User(userEntity.getMemberID(), userEntity.getPassword(), authorities);
    }
}
