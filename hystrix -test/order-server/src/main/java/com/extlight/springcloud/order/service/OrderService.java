package com.extlight.springcloud.order.service;

import com.extlight.springcloud.common.model.Order;

public interface OrderService {

	void placeOrder(Order order) throws Exception;
}
