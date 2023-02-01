package com.ezen.test;

import com.ezen.dto.MemberDTO;
import com.ezen.entity.Member;
import com.ezen.persistence.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;
    private PasswordEncoder passwordEncoder;

    @Test
    public void saveMember() {

        MemberDTO memberDTO = MemberDTO.builder()
                .username("user2")
                .name("김유저")
                .password("user2")
                .phone("010-1111-2222")
                .email("user1@email.com")
                .zip_num("12345")
                .address("서울시 관악구 신림동")
                .agree("n")
                .degree("SILVER")
                .role("MEMBER")
                .regdate(new Date())
                .build();

        Member member = MemberDTO.toEntity(memberDTO);
        memberRepository.save(member);
    }
}
