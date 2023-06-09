package com.hello.proto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hello.proto.entity.PopularSearchEntity;

public interface PopularSearchRepository extends JpaRepository<PopularSearchEntity, String> {

}
