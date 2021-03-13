package com.example.test.service;

import com.example.test.dao.PostDto;
import com.example.test.dao.PostDto.*;
import com.example.test.entity.Post;
import com.example.test.entity.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    //serviceImpl(이 코드에 있는 클래스 이름은 정답이 아니므로 다르게 설정하셔도 됩니다- 직관적으로만)
    //service에서 정의 해두었던 함수들을 구현하는 부분입니다.

    private final PostRepository postRepository;

    @Override
    public void writePost(PostRequest postRequest) {
        postRepository.save(
                Post.builder()
                        .title(postRequest.getTitle())
                        .content(postRequest.getContent())
                        .createdAt(LocalDate.now())
                        .build()
        );
    }

    @Override
    public PostResponse getPost() {
        List<Post> posts = postRepository.findAllBy();
        List<PostDto.Post> postContents = new ArrayList<>();

        for(Post post : posts) {
            postContents.add(
                    PostDto.Post.builder()
                            .id(post.getId())
                            .title(post.getTitle())
                            .build()
            );
        }

        return PostResponse.builder()
                .totalElements(posts.size())
                .postContents(postContents)
                .build();
    }

    @Override
    public PostContent getPostContent(int id) {
        Post post = postRepository.findById(id);

        return PostContent.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .createdAt(post.getCreatedAt())
                .build();
    }
}
