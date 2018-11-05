package com.nf147.dao;

import com.nf147.entity.User;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    User selectByPrimaryKey(Integer userId);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    int login(String username,String password);

    User selectName(String username);

    int updateByName(User user);

    int deleteByName(String username);
}