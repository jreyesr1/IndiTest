/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inditex.test.controller;

import com.inditex.test.entity.PricesView;
import com.inditex.test.service.PricesViewService;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Joel
 */
@RestController
@RequestMapping("/api/v1")
public class PricesController {

    @Autowired
    PricesViewService service;

    @GetMapping("/prices")
    public ResponseEntity<PricesView> getPrice(
            @RequestParam(name = "date", required = true) @DateTimeFormat(pattern="yyyy-MM-dd'-'HH.mm.ss") LocalDateTime date  ,
            @RequestParam(name = "product", required = true) Long productId,
            @RequestParam(name = "brand", required = true) int brandId) {
            
        return service.getPrice(date, productId, brandId);
    }


}
