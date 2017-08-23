package com.dongxing.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dongxing.e3mall.mapper.TbItemMapper;
import com.dongxing.e3mall.pojo.TbItem;
import com.dongxing.e3mall.pojo.TbItemDesc;
import com.dongxing.e3mall.pojo.TbItemExample;
import com.dongxing.pojo.EasyUIDataGridResult;
import com.dongxing.result.IDUtils;
import com.dongxing.result.TaotaoResult;
import com.dongxing.service.ItemDescService;
import com.dongxing.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.tools.internal.xjc.model.SymbolSpace;

@Service
public class ItemServiceImpl implements ItemService{
	@Test
	public void testName() throws Exception {
		ArrayList<Object> arrayList = new ArrayList<Object>(10);
		System.out.println(arrayList.size());
		arrayList.add(1);
		System.out.println(arrayList.size());
	}
	
	
	
	@Autowired
	private TbItemMapper tbItemMapper;
	@Autowired
	private ItemDescService itemDescService;
	@Override
	public TbItem getItemById(long itemId) {
		TbItem tbItem = tbItemMapper.selectByPrimaryKey(itemId);
		return tbItem;
	}

	@Override
	public EasyUIDataGridResult getItemList(int page,int rows) {
		PageHelper.startPage(page, rows);
		TbItemExample tbItemExample = new TbItemExample();
		List<TbItem> list = tbItemMapper.selectByExample(tbItemExample);
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		EasyUIDataGridResult easyUIDataGridResult = new EasyUIDataGridResult();
		easyUIDataGridResult.setRows(list);
		easyUIDataGridResult.setTotal(pageInfo.getTotal());
		return easyUIDataGridResult;
	}

	@Override
	public TaotaoResult saveItem(TbItem item,String desc) {
		long genItemId = IDUtils.genItemId();
		//设置商品id
		item.setId(genItemId);
		//添加商品状态
		item.setStatus((byte)1);
		Date date = new Date();
		item.setCreated(date);
		item.setUpdated(date);
		tbItemMapper.insert(item);
		TbItemDesc tbItemDesc = new TbItemDesc();
		tbItemDesc.setItemId(genItemId);
		tbItemDesc.setItemDesc(desc);
		tbItemDesc.setUpdated(date);
		tbItemDesc.setCreated(date);
		itemDescService.save(tbItemDesc);
		TaotaoResult taotaoResult = new TaotaoResult(null);
		return taotaoResult;
	}

}
