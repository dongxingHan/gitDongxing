package com.dongxing.service;

import java.util.List;

import com.dongxing.pojo.EasyUITreeNode;

public interface ItemCatService {
	public List<EasyUITreeNode> getCatList(Long pid);
}
