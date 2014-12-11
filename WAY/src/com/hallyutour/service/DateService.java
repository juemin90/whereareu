package com.hallyutour.service;

import java.util.List;




import java.util.Map;

import com.hallyutour.model.*;

public interface DateService {
	
	String addDate(Date date);
	
	List<Date> getAll(String userid);
	
	String delete(String id);
	
	Date findById(String id);
	
	String update(Date date);

	Date findByDatenameAndPassword(Date date);


	List<Friend> getAllFriednByNickname(Map<String, Object> param);

}
