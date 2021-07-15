package com.hh99.adassignment.dto;

import com.hh99.adassignment.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class PostRequestDto {
    private String nickname;
    private String title;
    private String content;

    public PostRequestDto(Post post) {
        this.nickname = getNickname();
        this.title = getTitle();
        this.content = getContent();
    }
}
