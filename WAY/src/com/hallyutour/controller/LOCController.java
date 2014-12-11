package com.hallyutour.controller;

import java.io.PrintWriter;









import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hallyutour.model.*;
import com.hallyutour.service.*;

@Controller
public class LOCController {
	
	private DateService dateService;
	
	public DateService getDateService() {
		return dateService;
	}
	@Autowired
	public void setBaseService(DateService dateService) {
		this.dateService = dateService;
	}
	
	
	//直接传值来修改 对应参数赋值后即可修改数据库内容 必须要有 dateid
	@RequestMapping("uploadLoc")
	public void update(Date date,PrintWriter printWriter){
				
		String str = dateService.update(date);
	
        String jsonString = JSON.toJSONString(str, SerializerFeature.PrettyFormat); 
        printWriter.write(jsonString); 
        printWriter.flush(); 
        printWriter.close();
		
	}
	
	//session里有用户信息通过 userid 与 date的 createuserid 和 withuserid 作比较来确定 更新哪一个字段one 还是two
	@RequestMapping("getDate")
	public String get(String dateid,HttpServletRequest request){
			
		Date date = dateService.findById(dateid);
		request.setAttribute("date", date);
		return "date";
	}
	
	//取出当前dateid所有内容 更新坐标用
	@RequestMapping("getLoc")
	public void get(String dateid,PrintWriter printWriter){
			
		Date date = dateService.findById(dateid);
        String jsonString = JSON.toJSONString(date, SerializerFeature.PrettyFormat); 
        printWriter.write(jsonString); 
        printWriter.flush(); 
        printWriter.close();
	}

}
