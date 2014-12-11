package com.hallyutour.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;






import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;










import com.hallyutour.model.*;
import com.hallyutour.service.*;

@Controller
public class DateController {
	
	private DateService dateService;
	
	public DateService getDateService() {
		return dateService;
	}
	@Autowired
	public void setBaseService(DateService dateService) {
		this.dateService = dateService;
	}


	
	@RequestMapping("addDate")
	public String add(Date date,String nickname,HttpServletRequest request) throws IOException{
					

		User user = (User)request.getSession().getAttribute("user");
		date.setCreateuserid(user.getUserid());
		
		Map<String, Object> param=new HashMap<String, Object>();             
	    param.put("userid",user.getUserid());             
	    param.put("nickname", nickname);    
		List<Friend> list = dateService.getAllFriednByNickname(param);
		
		if(list.size() > 0){
			Friend friend= list.get(0);
			date.setWithuserid(friend.getUserid());
		}else
		{
			request.setAttribute("InfoMessage", "no such a friend");
			return "add";
		}
		
		String str = dateService.addDate(date);
		System.out.println(str);
		request.setAttribute("InfoMessage", str);
		
		//request.setAttribute("fileUrl", request.getContextPath()+"/upload/"+fileName);
		
		request.setAttribute("tab", "0");
		return "redirect:home.do";
		
	}

	
	@RequestMapping("getAllDate")
	public String getAddInfoAll(HttpServletRequest request){
		try {
			User user = (User)request.getSession().getAttribute("user");
			List<Date> list = dateService.getAll(user.getUserid());
			System.out.println(list);
			request.setAttribute("dateLists", list);
			return "date/listAll";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", e.getMessage());
			return "date/result";
		}
	}
	
	@SuppressWarnings("finally")
	@RequestMapping("delDate")
	public String del(String tid,HttpServletRequest request){
		try {			
			String str = dateService.delete(tid);
			request.setAttribute("InfoMessage", str);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage",  e.getMessage());
		} finally {	
			request.setAttribute("tab", "1");
			return "redirect:home.do";
		}
	}
	@RequestMapping("modifyDate")
	public String modify(String tid,HttpServletRequest request){
		try {			
			Date date = dateService.findById(tid);
			request.setAttribute("date", date);
			return "date/modify";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage",  e.getMessage());
			return "date/result";
		}
	}
	@SuppressWarnings("finally")
	@RequestMapping("updateDate")
	public String update(Date date,HttpServletRequest request){
		try {			
			String str = dateService.update(date);
			request.setAttribute("InfoMessage", str);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", e.getMessage());
		} finally {			
			return "date/result";
		}
	}

}
