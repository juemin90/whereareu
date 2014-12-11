package com.hallyutour.dao;

import java.util.List;
import java.util.Map;

import com.hallyutour.model.*;

public interface FriendMapper {
    int deleteByPrimaryKey(String id);

    int insert(Friend record);

    int insertSelective(Friend record);

    Friend selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Friend record);

    int updateByPrimaryKey(Friend record);
  
    
    List<Friend> getAllByNickname(Map<String, Object> param);

	List<Friend> getAllByUserid(String userid);
}