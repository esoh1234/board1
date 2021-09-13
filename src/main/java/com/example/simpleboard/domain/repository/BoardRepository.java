package com.example.simpleboard.domain.repository;

import com.example.simpleboard.domain.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;
import java.util.List;


public interface BoardRepository extends PagingAndSortingRepository<BoardEntity, Long> {
    //List<BoardEntity> findAllByDSCId(double id, Pageable page);
}