package com.example.prueba.Modelo.Component;

import com.example.prueba.Modelo.Bean.Price;
import com.example.prueba.Modelo.Repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/*
Componente para la agregación de datos a la bbdd H2 al ejecutar la aplicación
 */

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private PriceRepository priceRepository;

    public DataLoader(PriceRepository priceRepository){
        this.priceRepository = priceRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event){
        loadPrices();
    }

    public void loadPrices() {
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
        price2.setEndDate(LocalDateTime.of(2020, 6, 18, 18, 30, 0));
        price2.setPriceList(2L);
        price2.setProductId(35455L);
        price2.setPriority(1);
        price2.setPrice(BigDecimal.valueOf(25.45));
        price2.setCurr("EUR");

        Price price3 = new Price();
        price3.setBrandId(1L);
        price3.setStartDate(LocalDateTime.of(2020, 6, 15, 0, 0, 0));
        price3.setEndDate(LocalDateTime.of(2020, 6, 20, 11, 0, 0));
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

        for (Price price : list){
            System.out.println(price.toString());
        }

        priceRepository.saveAll(list);
    }

    /*
    SCRIPT PARA LA CREACIÓN DE LA TABLA
    CREATE TABLE PRICES (
      BRAND_ID INT NOT NULL,
      START_DATE TIMESTAMP NOT NULL,
      END_DATE TIMESTAMP NOT NULL,
      PRICE_LIST INT NOT NULL,
      PRODUCT_ID INT NOT NULL,
      PRIORITY INT NOT NULL,
      PRICE DECIMAL(19,2) NOT NULL,
      CURR VARCHAR(3) NOT NULL,
      PRIMARY KEY (BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY),
      FOREIGN KEY (BRAND_ID) REFERENCES BRANDS(ID)
    );
     */

}
