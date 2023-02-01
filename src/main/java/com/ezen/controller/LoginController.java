package com.ezen.controller;

import com.ezen.entity.Member;
import com.ezen.service.MemberService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Log4j2
public class LoginController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping("/login")
    public String login() {
        return "sign/login";
    }

    @PostMapping("/login")
    public String login(Member member, Model model) {
        Member findMember = (Member) userDetailsService.loadUserByUsername(member.getUsername());

        if (findMember != null && findMember.getPassword().equals(member.getPassword())) {
            model.addAttribute("member", findMember);
            return "redirect:index";
        } else {
            return "redirect:login";
        }
    }

    @GetMapping("/join")
    public String join() {
        return "sign/join";
    }
}
