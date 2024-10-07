package com.example.demo.controller;

import com.example.demo.dto.customerDto.CustomerResponse;
import com.example.demo.dto.customerDto.FetchCustomerDetails;
import com.example.demo.service.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Slf4j
public class CustomerController {
@Autowired
    CustomerService customerService;
@Autowired
    ObjectMapper objectMapper;

    @PostMapping("/update/details")
    public ResponseEntity<String> saveCustomer(@RequestBody CustomerResponse request)
    {
        log.info("Customer Request to save in DataBase : {}",request);
        String status = customerService.saveDetails(request);
        log.info("Customer Response status after saving in DataBase : {}",status);
        return ResponseEntity.ok(status);
    }
    @GetMapping("/fetchAll/360/details")
    public ResponseEntity<FetchCustomerDetails> fetchAllDetailsByPage(@RequestParam int page,@RequestParam int size) throws JsonProcessingException {
        log.info("Page size{} and page{}}",size,page);
        FetchCustomerDetails fetchCustomerDetails =customerService.fetchCustomerDetails(page,size);
        log.info("Successfully Fetched the Details : {}",objectMapper.writeValueAsString(fetchCustomerDetails));
       return ResponseEntity.ok(fetchCustomerDetails);
    }


}
