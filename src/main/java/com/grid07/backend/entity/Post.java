package com.grid07.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    private Long authorId;

    private String content;

    private LocalDateTime createdAt = LocalDateTime.now();
}