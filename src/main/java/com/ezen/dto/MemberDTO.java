package com.ezen.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ezen.entity.Degree;
import com.ezen.entity.Member;
import com.ezen.entity.Role;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class MemberDTO {
	
	private String username;
	private String password;
	private String name;
	private String phone;
	private String email;
	private String zip_num;
	private String address;
	private String agree; // 동의 여부
	private String degree; // 회원 등급
	private String role;
	private Date regdate;

	public static Member toEntity(MemberDTO dto) {
		return Member.builder()
				.username(dto.username)
				.password(dto.password)
				.name(dto.name)
				.phone(dto.phone)
				.email(dto.email)
				.zip_num(dto.zip_num)
				.address(dto.address)
				.degree(Degree.valueOf(dto.degree))
				.role(Role.valueOf(dto.role))
				.regdate(dto.regdate)
				.build();
	}

	@OneToMany(mappedBy="member", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<BoardDTO> boardList = new ArrayList<>();
	private List<FoodDTO> foodList = new ArrayList<>();

}
