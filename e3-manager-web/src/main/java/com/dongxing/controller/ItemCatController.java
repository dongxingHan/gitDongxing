package com.dongxing.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dongxing.e3mall.pojo.TbItem;
import com.dongxing.fastDfs.FastDFSClient;
import com.dongxing.fastDfs.JsonUtils;
import com.dongxing.pojo.EasyUITreeNode;
import com.dongxing.result.TaotaoResult;
import com.dongxing.service.ItemCatService;
import com.sun.xml.internal.xsom.impl.scd.Iterators.Map;

@Controller
public class ItemCatController {
	@Autowired
	private ItemCatService itemCatService;
	
	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;
	@RequestMapping("/item/cat/list")
	@ResponseBody
	public List<EasyUITreeNode> getItemCatList(
			@RequestParam(name="id",defaultValue="0")Long pid){
		List<EasyUITreeNode> catList = itemCatService.getCatList(pid);
		return catList;
	}
	
	@RequestMapping("/pic/upload")
	@ResponseBody
	public String fileUpload(MultipartFile uploadFile){
		try {
			//1、取文件的扩展名
			String filename = uploadFile.getOriginalFilename();
			String extName=filename.substring(filename.lastIndexOf("."));
			//2、创建一个FastDFS的客户端
			FastDFSClient fastDFSClient = new FastDFSClient("classpath:config/client.conf");
			String path = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
			String url=IMAGE_SERVER_URL+path;
			HashMap<Object, Object> map = new HashMap<>();
			map.put("error", 0);
			map.put("url", url);
			String json = JsonUtils.objectToJson(map);
			return json;
		} catch (Exception e) {
			HashMap<Object, Object> map = new HashMap<>();
			map.put("error", 1);
			map.put("url", "上传失败");
			String json = JsonUtils.objectToJson(map);
			return json;
		}
	}
	
	
	
}
