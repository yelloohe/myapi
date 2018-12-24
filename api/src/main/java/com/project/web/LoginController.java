package com.project.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.core.Result;
import com.project.core.ResultGenerator;
import com.project.model.EsMember;
import com.project.model.dto.TokenModel;
import com.project.service.EsMemberService;
import com.project.service.util.TokenManager;
import com.project.utils.JwtUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import tk.mybatis.mapper.entity.Condition;

@RestController
@Api("LoginController相关的api")

public class LoginController {

	
	@Resource
	private EsMemberService esMemberService;
	
	@Resource
    private TokenManager tokenManager;


	@ApiOperation(value="用户登录", notes="根据url的name和password登陆啦")
	@ApiImplicitParam(name = "esMember", value = "用户详细实体user", required = true, dataType = "EsMember")
    @PostMapping("/login")
    public Result<?> login( EsMember esMember) {    	
    	Condition condition=new Condition(EsMember.class);
        condition.createCriteria().andCondition("name = '"+esMember.getName()+"' and password = '"+esMember.getPassword()+"'");
        condition.setOrderByClause("name desc");    	
    	List<EsMember> list =  esMemberService.findByCondition(condition);//根据条件查找
		if(list!=null&&list.size()==1){
			  return ResultGenerator.genSuccessResult(list.get(0));
		}else{
			  return ResultGenerator.genFailResult("用户不存在或者存在多条!");
		}        
    }	
	
	@ApiOperation(value="用户登录", notes="根据url的name和password登陆啦")
    @PostMapping("/loginT")
    public Result<?> loginT(@RequestParam String name,@RequestParam String password) {    	
		EsMember model = new EsMember();
		model.setName(name);
		model.setPassword(password);
    	EsMember member =  esMemberService.findByModel(model);
		if(member!=null){
			 // String jwt = JwtUtil.generateToken(name);
			
			 //生成一个token，保存用户登录状态
	        TokenModel tokenmodel = tokenManager.createToken(Long.valueOf(member.getMemberId()));
			  Map<String,Object> map = new HashMap<String,Object>();
			  map.put("token", tokenmodel.getToken());
			  map.put("member", member);			  
			  return ResultGenerator.genSuccessResult(map);
		}else{
			  return ResultGenerator.genFailResult("用户不存在或者存在多条!");
		}        
    }
	
	
	@PostMapping("/loginOut")
    public Result<?> logout(EsMember member) {
        tokenManager.deleteToken(Long.valueOf(member.getMemberId()));
        return ResultGenerator.genSuccessResult("注销成功!");
    }
	
}
