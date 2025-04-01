package com.example.RentACar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RentACarApplicationTests {

	@Test
	void contextLoads() {
		Car car = new Car("AA11BB", "ferrari", 2000);
		String plate = car.getPlateNumber();

		assertEquals("AA11BB", plate);
	}

}
