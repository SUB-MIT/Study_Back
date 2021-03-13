package com.example.test.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post,Integer> {

    //repository는 DB의 CRUD(작성, 읽기, 수정, 삭제) 작업을 도와주는 도구라고 생각하시면 될 것 같습니다.

    Post findById(int id);
    List<Post> findAllBy();
}
