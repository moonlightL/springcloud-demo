package com.extlight.springcloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.extlight.springcloud"}) // 为了能扫描 common-api 项目中的 GoodsServiceClientFallbackFactory
@EnableCircuitBreaker
@EnableFeignClients(basePackages = {"com.extlight.springcloud"})
@EnableEurekaClient
@SpringBootApplication
public class OrderServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServerApplication.class, args);
	}
}
