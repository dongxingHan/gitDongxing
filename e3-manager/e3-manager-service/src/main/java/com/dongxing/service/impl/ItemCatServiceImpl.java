package com.dongxing.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dongxing.e3mall.mapper.TbItemCatMapper;
import com.dongxing.e3mall.pojo.TbItemCat;
import com.dongxing.e3mall.pojo.TbItemCatExample;
import com.dongxing.e3mall.pojo.TbItemCatExample.Criteria;
import com.dongxing.pojo.EasyUITreeNode;
import com.dongxing.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService{
	@Autowired
	TbItemCatMapper tbItemCatMapper;
	@Override
	public List<EasyUITreeNode> getCatList(Long pid) {
		TbItemCatExample tbItemCatExample=new TbItemCatExample();
		Criteria criteria = tbItemCatExample.createCriteria();
		criteria.andParentIdEqualTo(pid);
		List<TbItemCat> list = tbItemCatMapper.selectByExample(tbItemCatExample);
		ArrayList<EasyUITreeNode> arrayList = new ArrayList<>();
		for (TbItemCat tbItemCat : list) {
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(tbItemCat.getId());
			node.setState(tbItemCat.getIsParent()?"closed":"open");
			node.setText(tbItemCat.getName());
			arrayList.add(node);
		}
		
		return arrayList;
	}


}
