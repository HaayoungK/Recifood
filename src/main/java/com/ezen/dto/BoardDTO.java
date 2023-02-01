package com.ezen.dto;

import java.util.Date;

import com.ezen.entity.Board;
import com.ezen.entity.Member;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class BoardDTO {

	private Long board_seq;
	private String title;
	private String writer;
	private String content;
	private Date regdate;
	
	public Board toEntity(BoardDTO dto) {
		return Board.builder()
				.board_seq(dto.board_seq)
				.title(dto.title)
				.writer(dto.writer)
				.content(dto.content)
				.regdate(dto.regdate)
				.build();
	}
	
//	@ManyToOne
//	@JoinColumn(name="id", nullable=false)
//	private Member member;
//
//	public void setMember(MemberDTO memberDTO) {
//		this.member = member;
//		memberDTO.getBoardList().add(this);
//	}
}
