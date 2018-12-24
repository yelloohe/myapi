package com.project.service.util.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Component;


import com.project.model.dto.TokenModel;
import com.project.service.util.TokenManager;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class RedisTokenManager implements TokenManager{
	
	@Autowired
    private RedisTemplate<String,String> redisTemplate;
	
	static final String SECRET = "yakamoz";
	static final String DEFAULTBEARER = "Bearer ";
	static final Long expireTime = (long) 1;
	
	 
	 
	@Override
	public TokenModel createToken(Long userId) {
		 HashMap<String, Object> map = new HashMap<>();
	        //you can put any data in the map
	        map.put("userId", userId);
	       
	        String jwt = Jwts.builder()
	                .setClaims(map)
	                .setExpiration(new Date(System.currentTimeMillis() + 3600_000_000L))// 1000 hour
	                .signWith(SignatureAlgorithm.HS512, SECRET)
	                .compact();
	        String token = DEFAULTBEARER+jwt; //jwt前面一般都会加Bearer
	        
	        TokenModel model = new TokenModel(userId, token);
	        
	      //存储到redis并设置过期时间
	        redisTemplate.boundValueOps(userId.toString()).set(token, expireTime, TimeUnit.MINUTES);
	        return model;
	}

	@Override
	public boolean checkToken(TokenModel model) {
		
		 if (model == null) {
	            return false;
	        }
		
		try {
            // parse the token.
            Map<String, Object> body = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(model.getToken().replace("Bearer ",""))
                    .getBody();
            
            body.forEach((k,v)->
            System.out.println("k="+k+",v="+v)
            );
            String userId = String.valueOf(model.getUserId());
            String token = (String) redisTemplate.boundValueOps(userId).get();
            if (token == null || !token.equals(model.getToken())) {
                return false;
            }
            //如果验证成功，说明此用户进行了一次有效操作，延长token的过期时间
            redisTemplate.boundValueOps(userId).expire(expireTime, TimeUnit.HOURS);
            return true;
            
        }catch (Exception e){
            throw new IllegalStateException("Invalid Token. "+e.getMessage());
        }
				
	}

	@Override
	public TokenModel getToken(String authentication) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteToken(long userId) {
		redisTemplate.delete(String.valueOf(userId));
	}

}
