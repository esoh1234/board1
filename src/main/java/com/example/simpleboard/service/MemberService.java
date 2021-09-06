//package com.example.simpleboard.service;
//
//import com.example.simpleboard.domain.repository.MemberRepository;
//import com.example.simpleboard.dto.MemberDto;
//import lombok.AllArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//
//@Service
//@AllArgsConstructor
//public class MemberService implements UserDetailsService {
//    private MemberRepository memberRepository;
//
//    @Transactional
//    public Long registerMember(MemberDto memberDto){
//        //Encoding Password
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//
//
//        //I want to test something like 'sout(Password)' someday.
//        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));
//
//        return memberRepository.save(memberDto.toEntity()).getId();
//
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String memberID) throws UsernameNotFoundException {
//
//    }
//}
