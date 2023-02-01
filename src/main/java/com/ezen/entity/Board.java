package com.ezen.entity;

import java.util.Date;

import com.ezen.dto.BoardDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long board_seq;
	private String title;
	private String writer;
	private String content;
	@Column(insertable=false, updatable=false, columnDefinition="date default sysdate")
	private Date regdate;
	
	public BoardDTO toDTO(Board board) {
		return BoardDTO.builder()
				.board_seq(board.board_seq)
				.title(board.title)
				.writer(board.writer)
				.content(board.content)
				.regdate(board.regdate)
				.build();
	}
}
