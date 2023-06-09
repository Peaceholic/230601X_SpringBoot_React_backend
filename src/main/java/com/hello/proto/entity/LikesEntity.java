package com.hello.proto.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Likes")
@Table(name = "Likes")
public class LikesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int likesId;
	private int boardId;
	private String userEmail;
	private String userProfile;
	private String userNickname;
}
