package com.ly.shiro.mapper;

import com.ly.shiro.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    public User selectUserByName(String name);

}
