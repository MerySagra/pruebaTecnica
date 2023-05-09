package com.example.prueba.Modelo.Service.Impl;

import com.example.prueba.Modelo.Bean.Price;
import com.example.prueba.Modelo.DTO.PriceDTO;
import com.example.prueba.Modelo.Repository.PriceRepository;
import com.example.prueba.Modelo.Service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;

/*
Implementación del Service de price
 */

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceRepository priceRepository;

    //Método para conseguir el objeto deseado indicando tres argumentos de entrada.

        public PriceDTO getPrice(LocalDateTime applicationDate, Long productId, Long chainId) {
            List<Price> prices = priceRepository.findPrices(applicationDate, productId, chainId);
            PriceDTO priceDTO = null;

            if (prices != null && !prices.isEmpty()) {
                Price price = prices.get(0);
                priceDTO = new PriceDTO();
                priceDTO.setProductId(productId);
                priceDTO.setChainId(chainId);
                priceDTO.setPriceList(price.getPriceList());
                priceDTO.setPriority(price.getPriority());
                priceDTO.setPrice(price.getPrice());
                priceDTO.setCurrency(price.getCurr());
                priceDTO.setApplicationDate(applicationDate);

                for (int i = 1; i < prices.size(); i++) {
                    Price currentPrice = prices.get(i);
                    if (currentPrice.getPriority() > price.getPriority()) {
                        price = currentPrice;
                        priceDTO.setPriceList(price.getPriceList());
                        priceDTO.setPriority(price.getPriority());
                        priceDTO.setPrice(price.getPrice());
                        priceDTO.setCurrency(price.getCurr());
                    } else if (currentPrice.getPriority().equals(price.getPriority())
                            && currentPrice.getPriceList().equals(price.getPriceList())) {
                        if (currentPrice.getStartDate().isBefore(price.getStartDate())) {
                            price = currentPrice;
                            priceDTO.setPriceList(price.getPriceList());
                            priceDTO.setPriority(price.getPriority());
                            priceDTO.setPrice(price.getPrice());
                            priceDTO.setCurrency(price.getCurr());
                        } else if (currentPrice.getStartDate().equals(price.getStartDate())
                                && currentPrice.getEndDate().isAfter(price.getEndDate())) {
                            price = currentPrice;
                            priceDTO.setPriceList(price.getPriceList());
                            priceDTO.setPriority(price.getPriority());
                            priceDTO.setPrice(price.getPrice());
                            priceDTO.setCurrency(price.getCurr());
                        }
                    }
                }

                // calcular el precio final
                BigDecimal finalPrice = priceDTO.getPrice();
                if (priceDTO.getCurrency().equals("EUR")) {
                    finalPrice = finalPrice.setScale(2, RoundingMode.HALF_UP);
                } else if (priceDTO.getCurrency().equals("USD")) {
                    finalPrice = finalPrice.multiply(new BigDecimal("1.20")).setScale(2, RoundingMode.HALF_UP);
                } else if (priceDTO.getCurrency().equals("JPY")) {
                    finalPrice = finalPrice.multiply(new BigDecimal("130")).setScale(2, RoundingMode.HALF_UP);
                }

                priceDTO.setPrice(finalPrice);
            }

            return priceDTO;
        }

}


