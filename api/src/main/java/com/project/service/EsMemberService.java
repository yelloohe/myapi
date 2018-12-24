package com.project.service;
import com.project.model.EsMember;
import com.project.core.Service;


/**
 * Created by CodeGenerator on 2018/08/02.
 */
public interface EsMemberService extends Service<EsMember> {

	
	EsMember findEsMemberByName(String name,String uname);
}
