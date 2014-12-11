package com.hallyutour.service;

import java.util.List;





import java.util.Map;

import com.hallyutour.model.*;

public interface FriendService {
	
	String addFriend(Friend friend);
	
	
	
	String delete(String id);
	
	Friend findById(String id);
	
	String update(Friend friend);


	List<Friend> getAllByUserid(String userid);



	List<Friend> getAllByNickname(Map<String, Object> param);

}
