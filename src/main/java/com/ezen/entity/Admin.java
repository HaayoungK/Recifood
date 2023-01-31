package com.ezen.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자 protected로 접근 제어
@Entity
public class Admin {
	@Id
	private String id;
	private String password;
	private String name;
	private String phone;
	private String email;

	@Builder // 생성자에 @Builder 적용
	public Admin(String id, String password, String name, String phone, String email) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
}
