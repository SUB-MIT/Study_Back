package com.example.test.service;

import com.example.test.dao.PostDto.*;

public interface PostService {

    // service는 비즈니스 로직이라고 생각하시면 됩니다. interface에서는 정의만 해 줍니다.

    void writePost(PostRequest postRequest);
    PostResponse getPost();
    PostContent getPostContent(int id);
}
