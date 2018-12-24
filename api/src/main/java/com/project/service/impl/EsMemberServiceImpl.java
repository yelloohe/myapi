package com.project.service.impl;

import com.project.dao.EsMemberMapper;
import com.project.model.EsMember;
import com.project.service.EsMemberService;
import com.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/08/02.
 */
@Service
@Transactional
public class EsMemberServiceImpl extends AbstractService<EsMember> implements EsMemberService {
    @Resource
    private EsMemberMapper esMemberMapper;

	@Override
	public EsMember findEsMemberByName(String name, String uname) {
		// TODO Auto-generated method stub
		return esMemberMapper.queryYhByYhAndUname(name, uname);
	}

}
