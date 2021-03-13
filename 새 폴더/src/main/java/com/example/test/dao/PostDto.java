package com.example.test.dao;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public class PostDto {

    //Dto는 request와 response처럼 프론트와 통신할 때 주고받는 정보 묶음이라고 생각해 두시면 될 것 같습니다.

    @Getter
    @Builder
    public static class PostRequest {

        @NotNull
        private String title;

        @NotNull
        private String content;

    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PostResponse {

        List<Post> postContents;

        private int totalElements;

    }

    @Getter
    @Builder
    public static class Post {

        private Integer id;

        private String title;

    }

    @Getter
    @Builder
    public static class PostContent {

        private String title;

        private String content;

        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate createdAt;

    }

}
