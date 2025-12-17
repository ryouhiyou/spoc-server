package com.spoc.mapper;

import com.spoc.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User selectByUsername(@Param("username") String username);
}