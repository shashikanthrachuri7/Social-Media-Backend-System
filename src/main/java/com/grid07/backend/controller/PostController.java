package com.grid07.backend.controller;
import com.grid07.backend.entity.Comment;
import com.grid07.backend.repository.CommentRepository;
import com.grid07.backend.entity.Post;
import com.grid07.backend.service.LikeService;
import com.grid07.backend.service.BotService;
import com.grid07.backend.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.redis.core.StringRedisTemplate;
import java.util.Set;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private StringRedisTemplate redisTemplate;
    @GetMapping("/trending")
    public Set<String> getTrendingPosts() {

        Set<String> trending = redisTemplate.opsForZSet()
                .reverseRange("trending_posts", 0, 4);

        System.out.println(trending);

        return trending;
    }
    @Autowired
    private BotService botService;
    @Autowired
    private LikeService likeService;
    @PostMapping("/{postId}/like")
    public String likePost(@PathVariable Long postId) {

        Long likes = likeService.likePost(postId);

        return "Total Likes: " + likes;
    }

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;
    @PostMapping("/{postId}/comments")
    public Object addComment(@PathVariable Long postId,
                             @RequestBody Comment comment) {

        boolean allowed = botService.canComment(comment.getAuthorId());

        if (!allowed) {
            return "Cooldown active! Try again later.";
        }

        boolean underLimit =
                botService.underCommentLimit(comment.getAuthorId());

        if (!underLimit) {
            return "Bot comment limit exceeded!";
        }

        comment.setPostId(postId);

        return commentRepository.save(comment);
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postRepository.save(post);
    }
}