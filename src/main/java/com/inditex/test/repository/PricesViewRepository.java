/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inditex.test.repository;

import com.inditex.test.entity.PricesView;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Joel
 */
public interface PricesViewRepository extends JpaRepository<PricesView, Long> {

    @Query("SELECT p FROM PricesView p WHERE "
            + ":date BETWEEN  p.startDate AND p.endDate"
            + " AND p.productId= :productId "
            + " AND p.brandId= :brandId"
            + " ORDER BY p.priority DESC")
    List< PricesView> getPrice(
            @Param("date") LocalDateTime date,
            @Param("productId") Long productId,
            @Param("brandId") int brandId,Pageable pageable);
}
