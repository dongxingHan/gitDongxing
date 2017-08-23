package com.dongxing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dongxing.content.service.ContentCategoryService;
import com.dongxing.pojo.EasyUITreeNode;

@Controller
public class ContentCategoryController {
	@Autowired
	private ContentCategoryService contentCategoryService;
	@RequestMapping("/content/category/list")
	@ResponseBody
	public List<EasyUITreeNode> getContentCategoryList(
			@RequestParam(value="id",defaultValue="0") Long pid){
		List<EasyUITreeNode> contentCategoryList = contentCategoryService.getContentCategoryList(pid);
		return contentCategoryList;
	}
	
}
