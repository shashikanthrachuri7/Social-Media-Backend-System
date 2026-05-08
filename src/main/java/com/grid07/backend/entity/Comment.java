package com.grid07.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    private Long postId;

    private Long authorId;

    private String content;

    private int depthLevel;

    private LocalDateTime createdAt = LocalDateTime.now();
}