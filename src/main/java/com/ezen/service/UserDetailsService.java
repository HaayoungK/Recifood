package com.ezen.service;

import com.ezen.dto.SecurityUser;
import com.ezen.entity.Member;
import com.ezen.persistence.MemberRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> optional = memberRepository.findById(username);

        log.info("로그인 유저 정보: " + optional);

        if(optional.isEmpty()) {
            throw new UsernameNotFoundException(username + "존재하지 않는 사용자입니다.");
        } else {
            Member member = optional.get();
            return new SecurityUser(member);
        }
    }
}
