package com.ezen.service;

import com.ezen.dto.BoardDTO;

public interface BoardService {

    void insertBoard(BoardDTO boardDTO); // 게시판 등록

    void updateBoard(BoardDTO boardDTO); // 수정

    void deleteBoard(BoardDTO boardDTO); // 삭제
}
