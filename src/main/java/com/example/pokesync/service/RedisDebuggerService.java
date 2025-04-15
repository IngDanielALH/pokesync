package com.example.pokesync.service;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RedisDebuggerService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @PostConstruct
    public void testRedisConnection() {
        try {
            redisTemplate.opsForValue().set("dani:test", "activo");
            String value = redisTemplate.opsForValue().get("dani:test");
            log.info("✅ Redis respondió: {}", value);
        } catch (Exception e) {
            log.error("❌ Redis no responde desde RedisTemplate: {}", e.getMessage());
        }
    }
}
