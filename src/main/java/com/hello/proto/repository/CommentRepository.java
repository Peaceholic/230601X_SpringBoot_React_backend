package com.hello.proto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hello.proto.entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {

}
