package com.example.test.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {

    //Entity는 데이터베이스와 직접적으로 연결하는 부분입니다.

    @Id @GeneratedValue
    private Integer id;

    private String title;

    private String content;

    private LocalDate createdAt;

}
