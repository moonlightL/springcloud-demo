package com.extlight.springcloud.common.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.extlight.springcloud.common.vo.Result;

@FeignClient(value="GOODS")
public interface GoodsServiceClient {

	@RequestMapping("/goods/goodsInfo/{goodsId}")
	public Result goodsInfo(@PathVariable("goodsId") String goodsId);
}
