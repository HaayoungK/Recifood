package com.ezen.dto;

import com.ezen.entity.Admin;
import lombok.Builder;
import lombok.Data;

@Data
public class AdminDTO {

	private String id;
	private String password;
	private String name;
	private String phone;
	private String email;

	@Builder
	public AdminDTO(String id, String password, String name, String phone, String email) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	public Admin toEntity(AdminDTO dto) {
		return Admin.builder()
				.id(dto.id)
				.password(dto.password)
				.name(dto.name)
				.phone(dto.phone)
				.email(dto.email)
				.build();
	}
}
