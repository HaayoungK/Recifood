package com.ezen.entity;

import java.util.Date;

import com.ezen.dto.BoardDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@Entity
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long board_seq;
	private String title;
//	private String writer; // member 객체가 있으므로 제거.
	private String content;
	@Column(insertable=false, updatable=false, columnDefinition="date default sysdate")
	private Date regdate;
	
	@Builder
	public Board(Long board_seq, String title, Member member, String content, Date regdate) {
		this.board_seq = board_seq;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
	}
	
	public BoardDTO toDTO(Board board) {
		return BoardDTO.builder()
				.board_seq(board.board_seq)
				.title(board.title)
				.content(board.content)
				.regdate(board.regdate)
				.build();
	}
}
