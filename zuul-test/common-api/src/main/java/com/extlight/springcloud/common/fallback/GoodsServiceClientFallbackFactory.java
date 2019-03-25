package com.extlight.springcloud.common.fallback;

import org.springframework.stereotype.Component;

import com.extlight.springcloud.common.client.GoodsServiceClient;
import com.extlight.springcloud.common.vo.Result;

import feign.hystrix.FallbackFactory;

@Component
public class GoodsServiceClientFallbackFactory implements FallbackFactory<GoodsServiceClient> {

	@Override
	public GoodsServiceClient create(Throwable cause) {
		return new GoodsServiceClient() {

			@Override
			public Result goodsInfo(String goodsId) {
				return Result.fail(500, "商品服务系统出现异常,请联系管理员");
			}
			
		};
	}

}
