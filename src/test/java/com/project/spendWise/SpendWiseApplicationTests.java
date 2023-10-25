package com.project.spendWise;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest

@EntityScan(basePackages = "com.project.spendWise.entity")
@ComponentScan(basePackages = "com.project.spendWise")
class SpendWiseApplicationTests {

	@Test
	void contextLoads() {
	}

}
