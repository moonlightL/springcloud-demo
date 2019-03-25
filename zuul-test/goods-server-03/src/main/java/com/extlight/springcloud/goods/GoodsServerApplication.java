package com.extlight.springcloud.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class GoodsServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoodsServerApplication.class, args);
	}
}
