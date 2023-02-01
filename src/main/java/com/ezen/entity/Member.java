package com.ezen.entity;

import com.ezen.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자 접근 제한
@AllArgsConstructor // 생성자 자동 생성
@Builder
@Entity
public class Member {
	@Id
	private String username;
	private String password;
	private String name;
	private String phone;
	private String email;
	private String zip_num;
	private String address;
	@Column(columnDefinition = "char default 'n'")
	private String agree; // 동의 여부
	@Enumerated(EnumType.STRING)
	private Degree degree; // 회원 등급
	@Enumerated(EnumType.STRING)
	private Role role;
	@Column(insertable=false, updatable=false, columnDefinition="date default sysdate")
	private Date regdate;

	public MemberDTO toDTO(Member member) {
		return MemberDTO.builder()
				.username(member.username)
				.password(member.password)
				.name(member.name)
				.phone(member.phone)
				.email(member.email)
				.zip_num(member.zip_num)
				.address(member.address)
				.degree(String.valueOf(member.degree))
				.role(String.valueOf(member.role))
				.regdate(member.regdate)
				.build();
	}

	@OneToMany(mappedBy="member", fetch=FetchType.EAGER)
	private List<Food> foodList = new ArrayList<Food>();

}
