package com.hello.proto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hello.proto.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {

	public boolean existsByUserEmailAndUserPassword(String userEmail, String userPassoword);

	public UserEntity findByUserEmail(String userEmail);
}
