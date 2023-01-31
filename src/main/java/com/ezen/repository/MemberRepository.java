package com.ezen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezen.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

}
