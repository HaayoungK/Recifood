package com.ezen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezen.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {

}
