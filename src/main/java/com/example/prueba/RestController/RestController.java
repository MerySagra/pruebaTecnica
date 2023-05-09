package com.example.prueba.RestController;

import com.example.prueba.Modelo.DTO.PriceDTO;
import com.example.prueba.Modelo.Service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/v1")
public class RestController {

    /*
    Controlador de la tabla price
     */

    @Autowired
    private PriceService priceService;

    // Solicitamos un objeto price indicando tres campos. Id_producto, Brand_Id y una fecha entre el Start_date y end_date

    @GetMapping("/price")
    public PriceDTO getPrice(@RequestParam(name = "applicationDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate,
                             @RequestParam(name = "productId") Long productId,
                             @RequestParam(name = "chainId") Long chainId) {

        PriceDTO priceDTO = priceService.getPrice(applicationDate, productId, chainId);
        return priceDTO;
    }



}
