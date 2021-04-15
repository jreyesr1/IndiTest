/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inditex.test.service;

import com.inditex.test.entity.PricesView;
import com.inditex.test.repository.PricesViewRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Joel
 */
@Service
public class PricesViewService {

    @Autowired
    PricesViewRepository repository;

    public ResponseEntity<PricesView> getPrice(LocalDateTime date, Long productId, int brandId) {        
        List<PricesView> result = repository.getPrice(date, productId, brandId,PageRequest.of(0, 1));        
        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(result.get(0), HttpStatus.OK);
        }
    }
}
