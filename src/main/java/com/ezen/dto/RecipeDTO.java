package com.ezen.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RecipeDTO {
	private Long recipe_seq;
	private String id; // 사용자 아이디
	private String recipe_name; // 레시피명
	private String degree; // 난이도
	private int cooking_time;
	private String name; // 식자재명
	private String image;
	private String amount; // 요리분량
	private String kind; // 종류
	private int good; // 추천수
}
