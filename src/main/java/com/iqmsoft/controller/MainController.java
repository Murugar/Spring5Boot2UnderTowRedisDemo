package com.iqmsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ClusterOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class MainController {

    private final StringRedisTemplate stringRedisTemplate;

    @Autowired
    public MainController(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @GetMapping("str")
    public String addStr(
            @RequestParam String key,
            @RequestParam String value) {

        ValueOperations operations = stringRedisTemplate.opsForValue();

        operations.set(key, value);
        
        return "success";

    }

}
