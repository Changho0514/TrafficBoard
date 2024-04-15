package com.study.boardserver.dto.response;

import com.study.boardserver.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserInfoResponse {
	private UserDTO userDTO;
}