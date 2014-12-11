package com.hallyutour.dao;

import java.util.List;

import com.hallyutour.model.*;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> getAll();
    

	User selectByUsernameAndPassword(User user);

	User selectUserByUsername(String username);

	User selectUserByNickname(String nickname);
}