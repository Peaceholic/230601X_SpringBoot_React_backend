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
@Entity(name = "Board")
@Table(name = "Board")
public class BoardEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int boardId;
	private String title;
	private String content;
	private String image;
	private String video;
	private String file;
	private String writerEmail;
	private String writerProfile;
	private String writerNickname;
	private int hits;
	private int likes;
	private int comments;
	private String createdDate;
	private String modifiedDate;
}
