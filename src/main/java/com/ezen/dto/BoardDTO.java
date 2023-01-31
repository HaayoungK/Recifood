package com.ezen.dto;

import java.util.Date;

import com.ezen.entity.Board;
import com.ezen.entity.Member;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Data
public class BoardDTO {

	private Long board_seq;
	private String title;
//	private String writer; // member 객체가 있으므로 제거.
	private String content;
	private Date regdate;
	
	@Builder
	public BoardDTO(Long board_seq, String title, Member member, String content, Date regdate) {
		this.board_seq = board_seq;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
	}
	
	public Board toEntity(BoardDTO dto) {
		return Board.builder()
				.board_seq(dto.board_seq)
				.title(dto.title)
				.content(dto.content)
				.regdate(dto.regdate)
				.build();
	}
	
	@ManyToOne
	@JoinColumn(name="id", nullable=false)
	private Member member;
	
	public void setMember(MemberDTO memberDTO) {
		this.member = member;
		memberDTO.getBoardList().add(this);
	}
}
