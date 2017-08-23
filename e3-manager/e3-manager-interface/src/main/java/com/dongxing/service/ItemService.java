package com.dongxing.service;

import com.dongxing.e3mall.pojo.TbItem;
import com.dongxing.pojo.EasyUIDataGridResult;
import com.dongxing.result.TaotaoResult;

public interface ItemService {
	//通过商品id查询商品
	public TbItem getItemById(long itemId);

	public EasyUIDataGridResult getItemList(int page, int rows);

	public TaotaoResult saveItem(TbItem item, String desc);
}
