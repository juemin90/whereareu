package com.hallyutour.service;

import java.util.List;





import com.hallyutour.model.*;

public interface UserService {
	
	String addUser(User user);
	
	List<User> getAll();
	
	String delete(String id);
	
	User findById(String id);
	
	String update(User user);

	User findByUsernameAndPassword(User user);

	User getUserByUsername(String username);

	User getUserByNickname(String nickname);

}
