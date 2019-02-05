package com.amazonshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ShoppingController {
	@Autowired
	private RestTemplate resttamplate;
	
	@GetMapping("/amazon-payment/{price}")
	public String invokePaymentService(@PathVariable int price) {
		
		String url = "http://SPRING-BOOT-PAYMENT-SERVICE/payment-provider/paynow"+ price;
		return resttamplate.getForObject(url, String.class);
	}
}
