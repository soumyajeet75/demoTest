package com.example.demo.controller;

import com.example.demo.dto.customerDto.CustomerResponse;
import com.example.demo.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class CustomerController {
@Autowired
    CustomerService customerService;

    @PostMapping("/update/details")
    public ResponseEntity<String> saveCustomer(@RequestBody CustomerResponse request)
    {
        log.info("Customer Request to save in DataBase : {}",request);
        String status = customerService.saveDetails(request);
        log.info("Customer Response status after saving in DataBase : {}",status);
        return ResponseEntity.ok(status);
    }



}
