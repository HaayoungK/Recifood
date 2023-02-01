package com.ezen.dto;

import java.util.Date;
import java.util.List;

import com.ezen.entity.Food;
import com.ezen.entity.Member;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FoodDTO {
	
	private Long food_seq; // 식자재번호
	private String category; // 대분류
	private String name; // 소분류
	private Date exp; // 유통기한
	
	//@ManyToOne
	//@JoinColumn(name="username", nullable=false, updatable=false)
	private Member member;
	
	/*
	@Builder
	public FoodDTO(Long food_seq, String category, String name, Date exp) {
		this.food_seq = food_seq;
		this.category = category;
		this.name = name;
		this.exp = exp;
	}
	*/
	
	public Food toEntity(FoodDTO dto) {
		
		return Food.builder()
				.food_seq(dto.food_seq)
				.category(dto.category)
				.name(dto.name)
				.exp(dto.exp)
				.member(member)
				.build();
	}
	

	
	public void setMember(MemberDTO memberDTO) {
		this.member = member;
		memberDTO.getFoodList().add(this);
	}
	
	
}
