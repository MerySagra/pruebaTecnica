package com.example.prueba.Modelo.Service;


import com.example.prueba.Modelo.DTO.PriceDTO;

import java.time.LocalDateTime;

/*
Métodos del servicio de price
 */

public interface PriceService {

    public PriceDTO getPrice(LocalDateTime applicationDate, Long productId, Long chainId);

}
