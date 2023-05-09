package com.example.prueba;

import com.example.prueba.Modelo.Bean.Price;
import com.example.prueba.Modelo.Repository.PriceRepository;
import com.example.prueba.Modelo.Service.PriceService;
import com.example.prueba.RestController.RestController;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class PruebaApplicationTests {

	@Autowired
	private PriceRepository priceRepository;

	@Autowired
	private PriceService priceService;

	@Autowired
	private RestController restController;

	@Before
	public void setUp() {
		Price price1 = new Price();
		price1.setBrandId(1L);
		price1.setStartDate(LocalDateTime.of(2020, 6, 14, 0, 0, 0));
		price1.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
		price1.setPriceList(1L);
		price1.setProductId(35455L);
		price1.setPriority(0);
		price1.setPrice(BigDecimal.valueOf(35.50));
		price1.setCurr("EUR");

		Price price2 = new Price();
		price2.setBrandId(1L);
		price2.setStartDate(LocalDateTime.of(2020, 6, 14, 15, 0, 0));
		price2.setEndDate(LocalDateTime.of(2020, 6, 14, 18, 30, 0));
		price2.setPriceList(2L);
		price2.setProductId(35455L);
		price2.setPriority(1);
		price2.setPrice(BigDecimal.valueOf(25.45));
		price2.setCurr("EUR");

		Price price3 = new Price();
		price3.setBrandId(1L);
		price3.setStartDate(LocalDateTime.of(2020, 6, 15, 0, 0, 0));
		price3.setEndDate(LocalDateTime.of(2020, 6, 15, 11, 0, 0));
		price3.setPriceList(3L);
		price3.setProductId(35455L);
		price3.setPriority(1);
		price3.setPrice(BigDecimal.valueOf(30.50));
		price3.setCurr("EUR");

		Price price4 = new Price();
		price4.setBrandId(1L);
		price4.setStartDate(LocalDateTime.of(2020, 6, 15, 16, 0, 0));
		price4.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
		price4.setPriceList(4L);
		price4.setProductId(35455L);
		price4.setPriority(1);
		price4.setPrice(BigDecimal.valueOf(38.95));
		price4.setCurr("EUR");

		List<Price> list = new ArrayList<>();
		list.add(price1);
		list.add(price2);
		list.add(price3);
		list.add(price4);
		priceRepository.saveAll(list);
	}

	//Test para comprobar el correcto funcionamiento del controller

	@Test
	void contextLoads() {
	}

	@Test
	public void test1() {
		LocalDateTime date = LocalDateTime.of(2020, 7, 14, 10, 0, 0);
		List<Price> price = priceRepository.findPrices(date,35455L, 1L);
		Assertions.assertEquals(BigDecimal.valueOf(38.95), price.get(0).getPrice());
	}

	@Test
	public void test2() {
		LocalDateTime date = LocalDateTime.of(2020, 7, 14, 16, 0, 0);
		List<Price> price = priceRepository.findPrices(date,35455L, 1L);
		Assertions.assertEquals(BigDecimal.valueOf(38.95), price.get(0).getPrice());
	}

	@Test
	public void test3() {
		LocalDateTime date = LocalDateTime.of(2020, 7, 14, 21, 0, 0);
		List<Price> price = priceRepository.findPrices(date,35455L, 1L);
		Assertions.assertEquals(BigDecimal.valueOf(38.95), price.get(0).getPrice());
	}

	@Test
	public void test4() {
		LocalDateTime date = LocalDateTime.of(2020, 7, 15, 10, 0, 0);
		List<Price> price = priceRepository.findPrices(date,35455L, 1L);
		Assertions.assertEquals(BigDecimal.valueOf(38.95), price.get(0).getPrice());
	}

	@Test
	public void test5() {
		LocalDateTime date = LocalDateTime.of(2020, 7, 16, 21, 0, 0);
		List<Price> price = priceRepository.findPrices(date,35455L, 1L);
		Assertions.assertEquals(BigDecimal.valueOf(38.95), price.get(0).getPrice());
	}

}
