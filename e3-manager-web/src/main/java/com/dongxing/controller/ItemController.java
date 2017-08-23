package com.dongxing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dongxing.e3mall.pojo.TbItem;
import com.dongxing.pojo.EasyUIDataGridResult;
import com.dongxing.result.TaotaoResult;
import com.dongxing.service.ItemDescService;
import com.dongxing.service.ItemService;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;

	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIDataGridResult list(Integer page,Integer rows){
		EasyUIDataGridResult easyUIDataGridResult=itemService.getItemList(page,rows);
		return easyUIDataGridResult;
	}
	
	@RequestMapping("/item/save")
	@ResponseBody
	public TaotaoResult saveItem(TbItem item,String desc){
		TaotaoResult taotaoResult=itemService.saveItem(item,desc);
		System.out.println(taotaoResult);
		return taotaoResult;
	}
	
	
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public  TbItem findItemById(@PathVariable Long itemId){
		TbItem tbItem = itemService.getItemById(itemId);
		return tbItem; 
			
	}
}
