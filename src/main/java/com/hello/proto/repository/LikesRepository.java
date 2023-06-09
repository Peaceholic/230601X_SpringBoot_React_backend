package com.hello.proto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hello.proto.entity.LikesEntity;

public interface LikesRepository extends JpaRepository<LikesEntity, Integer> {

}
