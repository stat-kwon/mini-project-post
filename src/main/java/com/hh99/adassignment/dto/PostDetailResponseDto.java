package com.hh99.adassignment.dto;

import com.hh99.adassignment.model.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostDetailResponseDto {
    private Long id;
    private String title;
    private String nickname;
    private String content;
    private LocalDateTime createdAt;

    public PostDetailResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.nickname = post.getNickname();
        this.content = post.getContent();
        this.createdAt = post.getCreatedAt();
    }
}
