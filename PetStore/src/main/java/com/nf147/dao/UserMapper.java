package com.nf147.dao;

import com.nf147.entity.User;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer user_id);

    int insert(User record);

    User selectByPrimaryKey(Integer user_id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    int login(String user,String password);

    User selectName(String user_name);

    int updateByName(User record);

    int deleteByName(String  user_name);
}