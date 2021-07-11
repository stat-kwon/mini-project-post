package com.hh99.adassignment.controller;

import com.hh99.adassignment.dto.PostDetailResponseDto;
import com.hh99.adassignment.dto.PostRequestDto;
import com.hh99.adassignment.dto.PostSimpleRequestDto;
import com.hh99.adassignment.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostRestController {

    private final PostService postService;

    @Autowired
    public PostRestController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/api/posts")
    public List<PostSimpleRequestDto> getPostLists() {
        return postService.findAll();
    }

    // 왜 Long 반환 타입???
    @PostMapping("/api/posts")
    public Long createPost(@RequestBody PostRequestDto postRequestDto) {
        return postService.createPost(postRequestDto);
    }

    @GetMapping("/api/posts/{id}")
    public PostDetailResponseDto postDetail(@PathVariable Long id) {
        return postService.findById(id);
    }

    @DeleteMapping("/api/posts/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }

    @PutMapping("/api/posts/{id}")
    public Long updatePost(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto) {
        return postService.updatePost(id, postRequestDto);
    }
}
