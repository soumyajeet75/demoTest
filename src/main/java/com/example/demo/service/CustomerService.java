package com.example.demo.service;

import com.example.demo.dto.customerDto.CustomerResponse;
import com.example.demo.repositeries.CustomerRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerService {
@Autowired
    CustomerRepo repo;
    public String saveDetails(CustomerResponse request)
    {
       try
       {
           repo.save(request);
       }
       catch(Exception e)
       {
          log.error("Error occurred due to cause {} and Msg{} ",e.getStackTrace(),e.getMessage());
          return "Can't update details due to SQL Exception";
       }
        return "Successfully updated the details o customer"+request.getCustomerName()+" in DataBase";
    }
}
