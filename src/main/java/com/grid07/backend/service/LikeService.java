package com.grid07.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class LikeService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public Long likePost(Long postId) {

        String likeKey = "post:" + postId + ":likes";

        Long likes = redisTemplate.opsForValue().increment(likeKey);

        // Trending score update
        redisTemplate.opsForZSet()
                .incrementScore("trending_posts", postId.toString(), 1);

        return likes;
    }
}