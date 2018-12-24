package com.project.configurer;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerInterceptor;

import com.project.model.dto.TokenModel;
import com.project.service.util.TokenManager;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 通过继承spring提供的filter来实现filter
 * @author huanghe
 *
 */
@Component
public class JwtAuthenticationFilter implements HandlerInterceptor {
    private static final PathMatcher pathMatcher = new AntPathMatcher();

    @Autowired
    private TokenManager tokenManager;
    
    public final  TokenModel tokenModel = new TokenModel();
    
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	try {       
            
               // String token = request.getHeader("Authorization");
            	String token = request.getHeader("Authorization");
            	String userId = request.getHeader("userId");
                //检查jwt令牌, 如果令牌不合法或者过期, 里面会直接抛出异常, 下面的catch部分会直接返回
               // JwtUtil.validateToken(token);
            	if(StringUtils.isNotBlank(token) && StringUtils.isNotBlank(userId)  ){
            		tokenModel.setUserId(Long.valueOf(userId));
            		tokenModel.setToken(token);
            		if(!tokenManager.checkToken(tokenModel)){
            			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "验证参数非法");
                        return false;
            		};             	
            	}else{
            		 response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "验证参数为空");
                     return false;
            	}
            	
               
           
        } catch (Exception e) {
        	e.printStackTrace();
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
            return false;
        }
        
        return true;

    }
    
    
    
    //我们只对地址 /api 开头的api检查jwt. 不然的话登录/login也需要jwt
    private boolean isProtectedUrl(HttpServletRequest request) {
        return pathMatcher.match("/api/**", request.getServletPath());
    }

}