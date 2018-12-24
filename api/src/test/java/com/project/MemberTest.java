package com.project;

import javax.annotation.Resource;

import org.junit.Test;

import com.project.model.EsMember;
import com.project.service.EsMemberService;

public class MemberTest extends Tester{
	@Resource
    private EsMemberService esMemberService;
	
	@Test
	public void test(){
		EsMember esMember = esMemberService.findById(1);
		System.out.println(esMember.getName());
	}
}
