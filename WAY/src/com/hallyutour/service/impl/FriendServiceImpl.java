package com.hallyutour.service.impl;

import java.util.List;





import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;






import com.hallyutour.dao.FriendMapper;
import com.hallyutour.model.Friend;
import com.hallyutour.service.FriendService;

@Service("friendService")
public class FriendServiceImpl implements FriendService {
	
	private FriendMapper friendMapper;

	public FriendMapper getAddMapper() {
		return friendMapper;
	}
	@Autowired
	public void setFriendMapper(FriendMapper friendMapper) {
		this.friendMapper = friendMapper;
	}

	@Override
	public String addFriend(Friend friend) {
		if (friendMapper.insertSelective(friend) == 1) {
			return "ok";
		}
		return "failure";
	}
	@Override
	public List<Friend> getAllByNickname(Map<String, Object> param) {
		return friendMapper.getAllByNickname(param);
	}
	@Override
	public String delete(String id) {
		if (friendMapper.deleteByPrimaryKey(id) == 1) {
			return "ok";
		}
		return "failure";
	}
	@Override
	public Friend findById(String id) {
		return friendMapper.selectByPrimaryKey(id);
	}
	@Override
	public String update(Friend friend) {
		if (friendMapper.updateByPrimaryKeySelective(friend) == 1) {
			return "ok";
		}
		return "failure";
	}
	@Override
	
	public List<Friend> getAllByUserid(String userid) {
		// TODO Auto-generated method stub
		return  friendMapper.getAllByUserid(userid);
	}

	

}
