package com.ezen.test;

import com.ezen.dto.AdminDTO;
import com.ezen.entity.Admin;
import com.ezen.repository.AdminRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AdminRepositoryTest {

    @Autowired
    private AdminRepository adminRepository;

    @Test
    public void saveAdmin() {

//        AdminDTO adminDTO = new AdminDTO("admin123", "admin123", "관리자",
//                "010-1234-1234", "admin123@email.com");

        AdminDTO adminDTO = AdminDTO.builder()
                .id("admin123")
                .password("admin123")
                .name("관리자")
                .phone("010-1234-1234")
                .email("admin123@email.com")
                .build();

        Admin admin = adminDTO.toEntity(adminDTO);
        adminRepository.save(admin);

    }
}
