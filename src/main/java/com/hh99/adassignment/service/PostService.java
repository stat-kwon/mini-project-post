package com.hh99.adassignment.service;

import com.hh99.adassignment.dto.PostDetailResponseDto;
import com.hh99.adassignment.dto.PostRequestDto;
import com.hh99.adassignment.dto.PostSimpleRequestDto;
import com.hh99.adassignment.model.Post;
import com.hh99.adassignment.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    // Read 부분 기존 작성
//    @Transactional(readOnly = true)
//    public List<PostSimpleRequestDto> findAll() {
//        List<Post> postList = postRepository.findAllByOrderByCreatedAtDesc();
//
//        List<PostSimpleRequestDto> postSimpleRequestDtos = new ArrayList<>();
//
//        for (Post post : postList) {
//
//
//            postSimpleRequestDtos.add(new PostSimpleRequestDto(post));
//        }
//
//        return postSimpleRequestDtos;
//    }

    // Read부분 Refactoring 한 결과
    @Transactional(readOnly = true)
    public List<PostSimpleRequestDto> findAll() {
        return postRepository.findAllByOrderByCreatedAtDesc()
                .stream()
                .map(PostSimpleRequestDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long createPost(PostRequestDto postRequestDto) {
        Post post = new Post(postRequestDto);
        return postRepository.save(post).getId();
    }

    @Transactional(readOnly = true)
    public PostDetailResponseDto findById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("찾으려는 아이디가 없습니다."));
        return new PostDetailResponseDto(post);
    }

    @Transactional
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    @Transactional
    public Long updatePost(Long id, PostRequestDto postRequestDto) {
        Post post = postRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("찾으려는 아이디가 없습니다."));

        post.update(postRequestDto);
        return id;
    }
}
