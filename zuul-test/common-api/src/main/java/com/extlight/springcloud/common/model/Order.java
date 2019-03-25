package com.extlight.springcloud.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单类
 * @author MoonlightL
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

	
	private String orderId;
	
	private String goodsId;
	
	private int num;
	
}
