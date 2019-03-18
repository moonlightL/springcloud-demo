package com.extlight.springcloud.goods.service;

import com.extlight.springcloud.common.model.Goods;

public interface GoodsService {

	Goods findGoodsById(String goodsId);
}
