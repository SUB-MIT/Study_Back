package com.example.test.controller;

import com.example.test.dao.PostDto.*;
import com.example.test.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/post")
@RestController
public class PostController {

    // mvc 패턴에서 controller 부분을 담당하는 부분입니다. 이곳에서 end-point(url)를 설정하고, 프론트로부터 어떤 값을 받을 지 알려줍니다.

    private final PostService postService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void writePost(@RequestBody PostRequest postRequest) {
        postService.writePost(postRequest);
    }

    @GetMapping
    public PostResponse getPost() {
        return postService.getPost();
    }

    @GetMapping("/{id}")
    public PostContent getPostContent(@PathVariable int id) {
        return postService.getPostContent(id);
    }

}
