package com.ezen.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@ToString
@Getter
@Entity
public class Member {
	@Id
	private String id;
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
	@Column(insertable=false, updatable=false, columnDefinition="date default sysdate")
	private Date regdate;

}
