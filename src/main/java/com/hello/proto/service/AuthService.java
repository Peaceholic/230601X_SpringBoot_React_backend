package com.hello.proto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hello.proto.dto.ResponseDto;
import com.hello.proto.dto.SignInDto;
import com.hello.proto.dto.SignInResponseDto;
import com.hello.proto.dto.SignUpDto;
import com.hello.proto.entity.UserEntity;
import com.hello.proto.repository.UserRepository;
import com.hello.proto.security.TokenProvider;

@Service
public class AuthService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	TokenProvider tokenProvider;

	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public ResponseDto<?> signUp(SignUpDto dto) {

		// System.out.println(dto.toString());

		String userEmail = dto.getUserEmail();
		String userPassword = dto.getUserPassword();
		String userPasswordCheck = dto.getUserPasswordCheck();

		try {
			// Email 중복확인
			if (userRepository.existsById(userEmail)) {
				return ResponseDto.setFail("Exited Email.", null);
			}
		} catch (Exception error) {
			System.out.println(error.toString());
			return ResponseDto.setFail("Database Error.", null);
		}

		// 비밀번호가 다르면 Fail
		if (!userPassword.equals(userPasswordCheck)) {
			return ResponseDto.setFail("Password dost not matched.", null);
		}

		// 주소 상세주소 병합
		String userAddress = dto.getUserAddress() + " " + dto.getUserAddressDetail();
		dto.setUserAddress(userAddress);

		// UserEntity 생성
		UserEntity userEntity = new UserEntity(dto);
		String encodedPassword = passwordEncoder.encode(userPassword);
		userEntity.setUserPassword(encodedPassword);

		try {
			// UserEntity DB저장
			userRepository.save(userEntity);
		} catch (Exception error) {
			System.out.println(error.toString());
			return ResponseDto.setFail("Database Error.", null);
		}
		// 성공시 Success 반환
		return ResponseDto.setSuccess("Sign Up Success!", null);

	}

	public ResponseDto<SignInResponseDto> signIn(SignInDto dto) {

		String userEmail = dto.getUserEmail();
		String userPassword = dto.getUserPassword();

		UserEntity userEntity = null;

		try {
			userEntity = userRepository.findByUserEmail(userEmail);
			if (userEntity == null) {
				return ResponseDto.setFail("Sign In Fail.", null);
			}

			if (!passwordEncoder.matches(userPassword, userEntity.getUserPassword())) {
				return ResponseDto.setFail("Sign In Fail.", null);
			}

		} catch (Exception error) {
			System.out.println(error.toString());
			return ResponseDto.setFail("Database Error.", null);
		}

		userEntity.setUserPassword("");

		String token = tokenProvider.createToken(userEmail);
		int expireTime = 3600000;

		SignInResponseDto signInResponseDto = new SignInResponseDto(token, expireTime, userEntity);
		return ResponseDto.setSuccess("Sign In Success!", signInResponseDto);
	}

}
