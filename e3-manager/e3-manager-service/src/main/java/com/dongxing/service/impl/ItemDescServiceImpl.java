package com.dongxing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dongxing.e3mall.mapper.TbItemDescMapper;
import com.dongxing.e3mall.pojo.TbItemDesc;
import com.dongxing.service.ItemDescService;

@Service
public class ItemDescServiceImpl implements ItemDescService{
	@Autowired
	private TbItemDescMapper tbItemDescMapper;

	@Override
	public void save(TbItemDesc tbItemDesc) {
		tbItemDescMapper.insert(tbItemDesc);
	}
}
