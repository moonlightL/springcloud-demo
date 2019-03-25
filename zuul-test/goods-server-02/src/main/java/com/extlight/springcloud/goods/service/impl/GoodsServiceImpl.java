package com.extlight.springcloud.goods.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.extlight.springcloud.common.model.Goods;
import com.extlight.springcloud.goods.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService{
	
	// 模拟数据库
	private static Map<String, Goods> data;
	
	static {
		data = new HashMap<>();
		data.put("1", new Goods("1", "手机", "国产手机", 8081));
		data.put("2", new Goods("2", "电脑", "台式电脑", 8081));
	}

	@Override
	public Goods findGoodsById(String goodsId) {
		Goods goods = data.get(goodsId);
		if (goods == null) {
		    throw new RuntimeException("商品不存在");
		}
		
		return goods;
	}
}
