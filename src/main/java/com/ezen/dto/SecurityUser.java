package com.ezen.dto;

import com.ezen.entity.Member;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class SecurityUser extends User {

    public SecurityUser(Member member) {
        super(member.getUsername(), "{noop}"+member.getPassword(),
                AuthorityUtils.createAuthorityList(member.getRole().toString()));


    }

}
