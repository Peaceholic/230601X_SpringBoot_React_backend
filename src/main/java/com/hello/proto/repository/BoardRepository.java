package com.hello.proto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hello.proto.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {

}
