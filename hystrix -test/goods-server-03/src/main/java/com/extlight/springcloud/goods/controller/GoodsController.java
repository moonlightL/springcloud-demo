package com.extlight.springcloud.goods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.extlight.springcloud.common.model.Goods;
import com.extlight.springcloud.common.vo.Result;
import com.extlight.springcloud.goods.service.GoodsService;

@RestController
@RequestMapping("/goods")
public class GoodsController {

	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping("/goodsInfo/{goodsId}")
	public Result goodsInfo(@PathVariable String goodsId) {
		
		Goods goods = this.goodsService.findGoodsById(goodsId);
		return Result.success(goods);
	}
}
