package com.example.simpleboard.domain.repository;

import com.example.simpleboard.domain.entity.BoardEntity;
import com.example.simpleboard.domain.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    Optional<MemberEntity> findByMemberID(String memberID);
}