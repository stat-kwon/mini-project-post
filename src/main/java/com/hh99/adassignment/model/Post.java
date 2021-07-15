package com.hh99.adassignment.model;

import com.hh99.adassignment.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Post extends Timestamped {

    public Post(PostRequestDto postRequestDto) {
        this.nickname = postRequestDto.getNickname();
        this.title = postRequestDto.getTitle();
        this.content = postRequestDto.getContent();
    }

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "Text")
    private String content;

    public void update(PostRequestDto postRequestDto) {
        this.title = postRequestDto.getTitle();
        this.content = postRequestDto.getContent();
    }
}
