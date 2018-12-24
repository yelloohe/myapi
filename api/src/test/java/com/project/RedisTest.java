package com.project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Component
public class RedisTest {

	 	@Autowired
	    private RedisTemplate redisTemplate;
	 
	 	@Test
	    public void set(){
	        redisTemplate.opsForValue().set("test2","testValue2");
	        System.out.println(redisTemplate.opsForValue().get("test2"));
	    }
}
