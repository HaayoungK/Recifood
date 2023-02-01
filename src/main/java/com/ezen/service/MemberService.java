package com.ezen.service;

import java.util.List;

import com.ezen.dto.MemberDTO;
import com.ezen.entity.Member;

public interface MemberService {

	void insertMember(MemberDTO memberDTO); // 회원 가입
	
	void updateMember(MemberDTO memberDTO); // 회원 수정
	
	void deleteMember(MemberDTO memberDTO); // 회원 탈퇴
	
	Member getMember(Member member);
	
	List<Member> getMemberList(Member Member);
}
