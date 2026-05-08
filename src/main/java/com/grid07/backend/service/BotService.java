package com.grid07.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class BotService {

    @Autowired
    private StringRedisTemplate redisTemplate;
    public boolean underCommentLimit(Long authorId) {

        String key = "bot:commentcount:" + authorId;

        Long count = redisTemplate.opsForValue().increment(key);

        return count <= 100;
    }
    public boolean canComment(Long authorId) {

        String key = "bot:cooldown:" + authorId;

        Boolean exists = redisTemplate.hasKey(key);

        if(Boolean.TRUE.equals(exists)) {
            return false;
        }

        redisTemplate.opsForValue().set(key, "LOCKED", 5, TimeUnit.SECONDS);

        return true;
    }
}