package com.hello.proto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hello.proto.dto.ResponseDto;
import com.hello.proto.dto.SignInDto;
import com.hello.proto.dto.SignInResponseDto;
import com.hello.proto.dto.SignUpDto;
import com.hello.proto.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	AuthService authService;

	@PostMapping("/signUp")
	public ResponseDto<?> signUp(@RequestBody SignUpDto requestBody) {
		System.out.println(requestBody.toString());
		ResponseDto<?> responseDto = authService.signUp(requestBody);
		return responseDto;
	}

	@PostMapping("/signIn")
	public ResponseDto<SignInResponseDto> signIn(@RequestBody SignInDto requestBody) {
		ResponseDto<SignInResponseDto> responseDto = authService.signIn(requestBody);
		return responseDto;
	}
}
