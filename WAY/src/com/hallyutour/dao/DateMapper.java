package com.hallyutour.dao;

import java.util.List;
import java.util.Map;

import com.hallyutour.model.*;

public interface DateMapper {
    int deleteByPrimaryKey(String id);

    int insert(Date record);

    int insertSelective(Date record);

    Date selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Date record);

    int updateByPrimaryKey(Date record);
    
    List<Date> getAll(String userid);
    

	Date selectByDatenameAndPassword(Date date);

	List<Friend> getAllFriednByNickname(Map<String, Object> param);

	
}