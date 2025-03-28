package com.example.tp1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Tp1ApplicationTests {

	@Test
	void contextLoads() {
		Car car = new Car("AA11BB", "Toyota", 200);
		assertEquals(car.getPlateNumber(), "AA11BB");
	}

}
