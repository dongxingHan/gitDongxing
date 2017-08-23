package com.dongxing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dongxing.pojo.EasyUIDataGridResult;
@Controller
public class PageController {
	
	
	@RequestMapping("/page/{itemId}")
	public String toPage(@PathVariable String itemId){
		System.out.println(123);
		return itemId;
	}
	
}
