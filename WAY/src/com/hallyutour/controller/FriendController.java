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
public class FriendController {
	
	private FriendService friendService;
	
	public FriendService getFriendService() {
		return friendService;
	}
	
	@Autowired
	public void setBaseService(FriendService friendService) {
		this.friendService = friendService;
	}
	

	private DateService dateService;
	
	public DateService getDateService() {
		return dateService;
	}
	@Autowired
	public void setBaseService(DateService dateService) {
		this.dateService = dateService;
	}
	
	@RequestMapping("addFriend")
	public String add(String tid,HttpServletRequest request) throws IOException{
					
		Friend myfriend = new Friend();
		myfriend.setFriendid(tid);
		User user = (User)request.getSession().getAttribute("user");
		myfriend.setUserid(user.getUserid());
		
		friendService.addFriend(myfriend);
		
		//request.setAttribute("tab", "1");
		
		return "redirect:home.do?tab=1";
		
	}
	
	
//	@RequestMapping("getAllByUserid")
//	public String getAllByUserid(HttpServletRequest request){
//		try {			
//			User user = (User)request.getSession().getAttribute("user");
//			
//			List<Friend> list = friendService.getAllByUserid(user.getUserid());
//			System.out.println(list);
//			request.setAttribute("friendLists", list);
//			return "friend/friendlist";
//		} catch (Exception e) {
//			e.printStackTrace();
//			request.setAttribute("InfoMessage", e.getMessage());
//			return "friend/result";
//		}
//	}
	
	@RequestMapping("home")
	public String getAllByUserid(String tab,HttpServletRequest request){
		try {			
			User user = (User)request.getSession().getAttribute("user");
			
			List<Friend> list = friendService.getAllByUserid(user.getUserid());
			System.out.println(tab);
			
			request.setAttribute("friendLists", list);
			
			
			List<Date> list2 = dateService.getAll(user.getUserid());
			System.out.println(list);
			request.setAttribute("dateLists", list2);
			request.setAttribute("tab", tab);
			return "home";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", e.getMessage());
			return "home";
		}
	}
	
	@RequestMapping("getAllByNickname")
	public String getAddInfoAll(String nickname, HttpServletRequest request){
		try {
			User user = (User)request.getSession().getAttribute("user");
			Map<String, Object> param=new HashMap<String, Object>();             
		    param.put("userid",user.getUserid());             
		    param.put("nickname", nickname);  
			List<Friend> list = friendService.getAllByNickname(param);
			System.out.println(list);
			request.setAttribute("friendLists", list);
			return "add_friend";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", e.getMessage());
			return "add_friend";
		}
	}
	


	@RequestMapping("delFriend")
	public String del(String tid,HttpServletRequest request){
				
			String str = friendService.delete(tid);

			//request.setAttribute("tab", "1");
			return "redirect:home.do?tab=1";
	
	}



}
