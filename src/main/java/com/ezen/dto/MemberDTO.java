package com.ezen.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

@Data
public class MemberDTO {

	private String id;
	private String password;
	private String name;
	private String phone;
	private String email;
	private String zip_num;
	private String address;
	private String agree; // 동의 여부
	private String degree; // 회원 등급
	private Date regdate;
	
	@Builder
	public MemberDTO(String id, String password, String name, String phone, String email, String zip_num,
			String address, String agree, String degree, Date regdate, List<BoardDTO> boardList) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.zip_num = zip_num;
		this.address = address;
		this.agree = agree;
		this.degree = degree;
		this.regdate = regdate;
		this.boardList = boardList;
	}

	

	@OneToMany(mappedBy="member", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<BoardDTO> boardList = new ArrayList<>();
}
