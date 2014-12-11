package com.hallyutour.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hallyutour.model.*;
import com.hallyutour.service.*;

@Controller
public class UserController {
	
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}
	@Autowired
	public void setBaseService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("logout")
	public String logout( HttpServletRequest request){
		
		request.getSession().removeAttribute("user");
		return "index";

		
	}
	
	@RequestMapping("login")
	public String add(User user, HttpServletRequest request){
		
		
			User user2 = userService.findByUsernameAndPassword(user);
			
			if(user2 != null){
				//request.setAttribute("user", user2);
				user2.setLoginYN(true);
				request.getSession().setAttribute("user", user2);
			}else
			{
				request.setAttribute("InfoMessage", "<div class='bs-docs-section'><div class='bs-callout bs-callout-danger'><h4>username or password is wrong!!</h4></div></div>");
				return "index";
			}
			
			

		
			return "redirect:home.do";

		
	}
	
	@RequestMapping("addUser")
	public String add(User user,@RequestParam MultipartFile file, HttpServletRequest request) throws IOException{
					
		User user2 = userService.getUserByUsername(user.getUsername());
		if(user2 != null ){
			request.setAttribute("InfoMessage2", "<div class='bs-docs-section'><div class='bs-callout bs-callout-danger'><h4>username has been used!</h4></div></div>");
			request.setAttribute("tab", "1");
			return "index";
		}
		
		User user3 = userService.getUserByNickname(user.getNickname());
		
		if(user3 != null ){
			request.setAttribute("InfoMessage2", "<div class='bs-docs-section'><div class='bs-callout bs-callout-danger'><h4>username or password is wrong!!</h4></div></div>");
			request.setAttribute("tab", "1");
			return "index";
		}
		
		String path = request.getSession().getServletContext().getRealPath("upload");
		String fileName = new Date().getTime()+".jpg";
		
        File targetFile = new File(path, fileName);  
        
        if(!targetFile.exists()){  
            targetFile.mkdirs();  
        }  
        
        file.transferTo(targetFile);

        user.setImgpath(fileName);
        
		String str = userService.addUser(user);
		
		//request.setAttribute("fileUrl", request.getContextPath()+"/upload/"+fileName);
		
		request.setAttribute("tab", "0");
		return "index";
		
	}

	
	@RequestMapping("getAllUser")
	public String getAddInfoAll(HttpServletRequest request){
		try {			
			List<User> list = userService.getAll();
			System.out.println(list);
			request.setAttribute("userLists", list);
			return "user/listAll";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", e.getMessage());
			return "user/result";
		}
	}
	
	@SuppressWarnings("finally")
	@RequestMapping("delUser")
	public String del(String tid,HttpServletRequest request){
		try {			
			String str = userService.delete(tid);
			request.setAttribute("InfoMessage", str);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage",  e.getMessage());
		} finally {			
			return "user/result";
		}
	}
	@RequestMapping("modifyUser")
	public String modify(String tid,HttpServletRequest request){
		try {			
			User user = userService.findById(tid);
			request.setAttribute("user", user);
			return "user/modify";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage",  e.getMessage());
			return "user/result";
		}
	}
	@SuppressWarnings("finally")
	@RequestMapping("updateUser")
	public String update(User user,HttpServletRequest request){
		try {			
			String str = userService.update(user);
			request.setAttribute("InfoMessage", str);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", e.getMessage());
		} finally {			
			return "user/result";
		}
	}

}
