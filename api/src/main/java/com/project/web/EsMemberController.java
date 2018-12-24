package com.project.web;
import com.project.core.Result;
import com.project.core.ResultGenerator;
import com.project.model.EsMember;
import com.project.service.EsMemberService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/08/02.
*/
@RestController
@RequestMapping("/api/member")
public class EsMemberController {
    @Resource
    private EsMemberService esMemberService;

    @PostMapping("/add")
    public Result<?> add(EsMember esMember) {
        esMemberService.save(esMember);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result<?> delete(@RequestParam Integer id) {
        esMemberService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result<?> update(EsMember esMember) {
        esMemberService.update(esMember);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result<EsMember> detail(@RequestParam Integer id) {
        EsMember esMember = esMemberService.findById(id);
        return ResultGenerator.genSuccessResult(esMember);
    }

    @PostMapping("/list")
    public Result<?> list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        PageHelper.startPage(page, size);
        List<EsMember> list = esMemberService.findAll();
        PageInfo<EsMember> pageInfo = new PageInfo<EsMember>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
    
    @ApiOperation(value="查询", notes="根据name和uname查询用户")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "name", value = "用户名", required = true, dataType = "String",paramType = "body"),
			@ApiImplicitParam(name = "uname", value = "用户昵称", required = true, dataType = "String")
	})
    @RequestMapping("/query")
    public Result<EsMember> query(@RequestParam String name,@RequestParam String uname) {
        EsMember esMember = esMemberService.findEsMemberByName(name, uname);
        return ResultGenerator.genSuccessResult(esMember);
    }
}
