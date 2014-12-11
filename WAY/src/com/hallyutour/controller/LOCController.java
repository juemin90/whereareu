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
	
	
	//ֱ�Ӵ�ֵ���޸� ��Ӧ������ֵ�󼴿��޸����ݿ����� ����Ҫ�� dateid
	@RequestMapping("uploadLoc")
	public void update(Date date,PrintWriter printWriter){
				
		String str = dateService.update(date);
	
        String jsonString = JSON.toJSONString(str, SerializerFeature.PrettyFormat); 
        printWriter.write(jsonString); 
        printWriter.flush(); 
        printWriter.close();
		
	}
	
	//session�����û���Ϣͨ�� userid �� date�� createuserid �� withuserid ���Ƚ���ȷ�� ������һ���ֶ�one ����two
	@RequestMapping("getDate")
	public String get(String dateid,HttpServletRequest request){
			
		Date date = dateService.findById(dateid);
		request.setAttribute("date", date);
		return "date";
	}
	
	//ȡ����ǰdateid�������� ����������
	@RequestMapping("getLoc")
	public void get(String dateid,PrintWriter printWriter){
			
		Date date = dateService.findById(dateid);
        String jsonString = JSON.toJSONString(date, SerializerFeature.PrettyFormat); 
        printWriter.write(jsonString); 
        printWriter.flush(); 
        printWriter.close();
	}

}
