package com.study.boardserver.service.impl;

import static com.study.boardserver.util.SHA256Util.encryptSHA256;

import com.study.boardserver.dto.UserDTO;
import com.study.boardserver.exception.DuplicateIdException;
import com.study.boardserver.mapper.UserProfileMapper;
import com.study.boardserver.service.UserService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserProfileMapper userProfileMapper;

    public UserServiceImpl(UserProfileMapper userProfileMapper) {
        this.userProfileMapper = userProfileMapper;
    }

    @Override
    public void register(UserDTO userProfile) {
        boolean duplicatedIdResult = isDuplicatedId(userProfile.getUserId());
        if(duplicatedIdResult) {
            throw new DuplicateIdException("중복된 아이디입니다.");
        }
        userProfile.setCreateTime(new Date());
        userProfile.setPassword(encryptSHA256(userProfile.getPassword()));

    }

    @Override
    public UserDTO login(String id, String password) {
        return null;
    }

    @Override
    public boolean isDuplicatedId(String id) {
        return false;
    }

    @Override
    public UserDTO getUserInfo(String userId) {
        return null;
    }

    @Override
    public void updatePassword(String id, String beforePassword, String afterPassword) {

    }

    @Override
    public void deleteId(String id, String password) {

    }
}
