package com.project.dao;

import org.apache.ibatis.annotations.Param;

import com.project.core.Mapper;
import com.project.model.EsMember;

public interface EsMemberMapper extends Mapper<EsMember> {
	/**
	 * 根据uname和name查找用户
	 * @param name
	 * @param uname
	 * @return
	 */
	EsMember queryYhByYhAndUname(@Param("name") String name, @Param("uname") String uname);
}