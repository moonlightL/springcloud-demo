package com.extlight.springcloud.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.extlight.springcloud.common.client.GoodsServiceClient;
import com.extlight.springcloud.common.model.Order;
import com.extlight.springcloud.common.vo.Result;
import com.extlight.springcloud.order.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
//@DefaultProperties(defaultFallback = "defaultByHystrix")
public class OrderServiceImpl implements OrderService{
	
//	@Autowired
//	private RestTemplate restTemplate;
	
	@Autowired
	private GoodsServiceClient goodsServiceClient;

//	@HystrixCommand
	@Override
	public void placeOrder(Order order) throws Exception{
		
//		Result result = this.restTemplate.getForObject("http://GOODS/goods/goodsInfo/" + order.getGoodsId(), Result.class);
		
		Result result = this.goodsServiceClient.goodsInfo(order.getGoodsId());
		
		if (result != null && result.getCode() == 200) {
			System.out.println("=====下订单====");
			System.out.println(result.getData());
		} else {
			System.out.println(result.getMsg());
		}
	}
	
//	public void defaultByHystrix() {
//		System.out.println("商品服务系统异常");
//	}
}
