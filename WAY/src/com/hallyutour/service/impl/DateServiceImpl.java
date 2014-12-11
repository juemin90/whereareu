package com.hallyutour.service.impl;

import java.util.List;




import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;






import com.hallyutour.dao.DateMapper;
import com.hallyutour.model.Date;
import com.hallyutour.model.Friend;
import com.hallyutour.service.DateService;

@Service("dateService")
public class DateServiceImpl implements DateService {
	
	private DateMapper dateMapper;

	public DateMapper getAddMapper() {
		return dateMapper;
	}
	@Autowired
	public void setDateMapper(DateMapper dateMapper) {
		this.dateMapper = dateMapper;
	}

	@Override
	public String addDate(Date date) {
		if (dateMapper.insertSelective(date) == 1) {
			return "ok";
		}
		return "failure";
	}
	@Override
	public List<Date> getAll(String userid) {
		return dateMapper.getAll(userid);
	}
	@Override
	public String delete(String id) {
		if (dateMapper.deleteByPrimaryKey(id) == 1) {
			return "ok";
		}
		return "failure";
	}
	@Override
	public Date findById(String id) {
		return dateMapper.selectByPrimaryKey(id);
	}
	@Override
	public String update(Date date) {
		if (dateMapper.updateByPrimaryKeySelective(date) == 1) {
			return "ok";
		}
		return "failure";
	}
	public Date findByDatenameAndPassword(Date date){
		return dateMapper.selectByDatenameAndPassword(date);
	}
	@Override
	public List<Friend> getAllFriednByNickname(Map<String, Object> param) {
		return dateMapper.getAllFriednByNickname(param);

	}

	

}
