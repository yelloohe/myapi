package com.project.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * 负责页面跳转
 * @author huanghe
 *
 */
@Controller
public class IndexController {
	
	
    @RequestMapping("/q")
    public ModelAndView  welcome() {    	
		return  new ModelAndView("index");     
    }
	
    @RequestMapping("/aa")
    public ModelAndView  welcome1() {    	
		return  new ModelAndView("index");     
    }
}
