package com.example.prueba.Modelo.Repository;

import com.example.prueba.Modelo.Bean.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/*
Repositorio de la tabla PRICES con JPA en donde podremos indicar las querys necesarias
 */

@Repository
public interface PriceRepository extends JpaRepository<Price, Integer>{

    //Solicitamos un objeto completo que coincida con un id_producto, un brand_id y entre dos fechas.

    @Query("SELECT p FROM Price p "
            + "WHERE :applicationDate BETWEEN p.startDate AND p.endDate "
            + "AND p.productId = :productId "
            + "AND p.brandId = :chainId")
    List<Price> findPrices(@Param("applicationDate") LocalDateTime applicationDate,
                           @Param("productId") Long productId,
                           @Param("chainId") Long chainId);


}
