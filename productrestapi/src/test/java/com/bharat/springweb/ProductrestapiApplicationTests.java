package com.bharat.springweb;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class ProductrestapiApplicationTests {

	@Test
	public void testGetProduct() {
		RestTemplate restTemplate= new RestTemplate();
	}

}
