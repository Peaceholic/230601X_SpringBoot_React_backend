USE PROTO;
DROP SCHEMA PROTO;

CREATE SCHEMA PROTO;
USE PROTO;

#사용자
CREATE TABLE `USER` (
`user_email`		 				VARCHAR(50) 	NOT NULL 					COMMENT 'ID (EMAIL)',
`user_password` 					VARCHAR(200) 	NOT NULL 					COMMENT '비밀번호',
`user_nickname` 					VARCHAR(30) 	NOT NULL 					COMMENT '별명',
`user_phone_number` 				VARCHAR(11) 			 					COMMENT '전화번호',
`user_address` 						TEXT		 			 					COMMENT '주소',
`user_profile` 						TEXT					 					COMMENT '프로파일',
PRIMARY KEY (`user_email`)
);

#게시글
CREATE TABLE `BOARD` (
`board_id`		 		BIGINT 			NOT NULL 	AUTO_INCREMENT				COMMENT '등록번호',
`title` 				VARCHAR(100) 	NOT NULL 								COMMENT '제목',
`content`				TEXT		 	NOT NULL 								COMMENT '본문',
`image`					TEXT		 											COMMENT '이미지',
`video`					TEXT		 	 										COMMENT '비디오',
`file`					TEXT		 			 								COMMENT '파일',
`writer_email`			VARCHAR(50) 	NOT NULL 								COMMENT '작성 회원ID',
`writer_profile`		TEXT													COMMENT '작성 회원ID',
`writer_nickname`		VARCHAR(30) 	NOT NULL 								COMMENT '작성 회원ID',
`hits`					BIGINT 						DEFAULT 0					COMMENT '게시글 조회수',
`likes`					BIGINT 						DEFAULT 0					COMMENT '게시글 라이크수',
`comments`				BIGINT 						DEFAULT 0					COMMENT '게시글 댓글수',
`created_date` 			DATETIME 		NOT NULL								COMMENT '생성 일시',
`modified_date` 		DATETIME 					DEFAULT CURRENT_TIMESTAMP	COMMENT '수정 일시',
PRIMARY KEY (`board_id`)
);

#인기 검색어
CREATE TABLE `POPULAR_SEARCH` (
`search_term` 			VARCHAR(200)	NOT NULL 								COMMENT '검색어',
`search_count`			INT 			NOT NULL	DEFAULT 1					COMMENT '검색어 사용횟수',
PRIMARY KEY (`search_term`)
);

#좋아요
CREATE TABLE `LIKES` (
`likes_id`		 		BIGINT 			NOT NULL 	AUTO_INCREMENT				COMMENT '등록번호',
`board_id` 				INT 			NOT NULL 								COMMENT '게시글번호',
`user_email` 			VARCHAR(50) 	NOT NULL 								COMMENT '작성자 ID',
`user_profile` 			TEXT 					 								COMMENT '작성자 프로필',
`user_nickname`			VARCHAR(30) 	NOT NULL 								COMMENT '작성자 별명',
PRIMARY KEY (`likes_id`)
);

#댓글
CREATE TABLE `COMMENT` (
`comment_id`		 	BIGINT 			NOT NULL 	AUTO_INCREMENT					COMMENT '등록번호',
`board_id` 				INT 			NOT NULL 									COMMENT '게시글번호',
`comment` 				TEXT 			NOT NULL									COMMENT '댓글 내용',
`user_email` 			VARCHAR(50) 	NOT NULL 									COMMENT '작성자 ID',
`user_profile` 			TEXT 					 									COMMENT '작성자 프로필',
`user_nickname`			VARCHAR(30) 	NOT NULL 									COMMENT '작성자 별명',
`created_date` 			DATETIME 		NOT NULL									COMMENT '생성 일시',
`modified_date` 		DATETIME 					DEFAULT CURRENT_TIMESTAMP		COMMENT '수정 일시',
PRIMARY KEY (`comment_id`)
);