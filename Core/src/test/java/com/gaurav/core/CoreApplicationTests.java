package com.gaurav.core;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gaurav.core.service.PaymentService;

//import static org.junit.Assert.assertNotNull;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class CoreApplicationTests {
	
	@Autowired
	PaymentService service;

	@Test
	void testDependancyInjection() {
		assertNotNull(service);
	}

}
