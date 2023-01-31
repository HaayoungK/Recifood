package com.ezen.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ezen.entity.Member;
import com.ezen.repository.MemberRepository;

@Component
public class MemberServiceImpl implements MemberService {

	private final MemberRepository memberRepository;

	public MemberServiceImpl(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Override
	public void updateMember(Member member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMember(Member member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Member getMember(Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> getMemberList(Member Member) {
		// TODO Auto-generated method stub
		return null;
	}


}
