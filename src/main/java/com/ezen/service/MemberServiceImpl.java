package com.ezen.service;

import java.util.List;
import java.util.Optional;

import com.ezen.dto.MemberDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.ezen.entity.Member;
import com.ezen.persistence.MemberRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void insertMember(MemberDTO memberDTO) {
		memberDTO.setPassword(passwordEncoder.encode(memberDTO.getPassword())); // 패스워드 암호화
		Member member = MemberDTO.toEntity(memberDTO);
		memberRepository.save(member);
	}

	@Override
	public void updateMember(MemberDTO memberDTO) {

	}

	@Override
	public void deleteMember(MemberDTO memberDTO) {

	}

	@Override
	public Member getMember(Member member) {
		Optional<Member> findMember = memberRepository.findById(member.getUsername());

		if(findMember.isPresent()) {
			return findMember.get();
		} else {
			return null;
		}
	}

	@Override
	public List<Member> getMemberList(Member Member) {
		// TODO Auto-generated method stub
		return null;
	}


}
