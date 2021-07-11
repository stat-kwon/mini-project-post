package com.hh99.adassignment.dto;

import com.hh99.adassignment.model.Post;
import lombok.Getter;

@Getter
public class PostSimpleRequestDto {
    private Long id;
    private String title;
    private String nickname;

    public PostSimpleRequestDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.nickname = post.getNickname();
    }
}
