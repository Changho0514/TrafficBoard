package com.study.boardserver.mapper;

import com.study.boardserver.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserProfileMapper {

    public UserDTO getUserProfile(@Param("id") String id);

    int insertUserProfile(
        @Param("id") String id,
        @Param("password") String password,
        @Param("name") String name,
        @Param("phone") String phone,
        @Param("address") String address,
        @Param("createTime") String createTime,
        @Param("updateTime") String updateTime
        );

    int deleteUserProfile(@Param("id") String id);

    public UserDTO findByIdAndPassword(@Param("id") String id, @Param("password") String password);

    int idCheck(@Param("id") String id);

    public int updatePassword(UserDTO userDTO);
    public int updateAddress (UserDTO userDTO);
}
