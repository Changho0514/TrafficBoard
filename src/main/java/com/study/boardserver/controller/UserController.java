package com.study.boardserver.controller;

import com.study.boardserver.service.UserService;
import com.study.boardserver.service.impl.UserServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Log4j2
public class UserController {

    // 수정에 닫혀있고, 확장에 열려있게끔 인터페이스를 사용한다.
    // 인터페이스를 구현했다는 의미로 Impl을 사용한다.
    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }
}
