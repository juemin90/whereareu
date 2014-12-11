package com.hallyutour.service.impl;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import com.hallyutour.dao.UserMapper;
import com.hallyutour.model.User;
import com.hallyutour.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	private UserMapper userMapper;

	public UserMapper getAddMapper() {
		return userMapper;
	}
	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public String addUser(User user) {
		if (userMapper.insertSelective(user) == 1) {
			return "ok";
		}
		return "failure";
	}
	@Override
	public List<User> getAll() {
		return userMapper.getAll();
	}
	@Override
	public String delete(String id) {
		if (userMapper.deleteByPrimaryKey(id) == 1) {
			return "ok";
		}
		return "failure";
	}
	@Override
	public User findById(String id) {
		return userMapper.selectByPrimaryKey(id);
	}
	@Override
	public String update(User user) {
		if (userMapper.updateByPrimaryKeySelective(user) == 1) {
			return "ok";
		}
		return "failure";
	}
	public User findByUsernameAndPassword(User user){
		return userMapper.selectByUsernameAndPassword(user);
	}
	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userMapper.selectUserByUsername(username);
	}
	@Override
	public User getUserByNickname(String nickname) {
		// TODO Auto-generated method stub
		return userMapper.selectUserByNickname(nickname);
	}
	

}
