package com.example.demo.service;

import com.example.demo.dto.customerDto.CustomerResponse;
import com.example.demo.dto.customerDto.FetchCustomerDetails;
import com.example.demo.repositeries.CustomerRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CustomerService {
@Autowired
    CustomerRepo repo;
@Autowired
    ObjectMapper mapper;
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
        return "Successfully updated the details of customer "+request.getCustomerName()+" in DataBase";
    }

    public FetchCustomerDetails fetchCustomerDetails(int page, int size) throws JsonProcessingException {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<CustomerResponse> customerList=  repo.findAll(pageRequest);
        List<CustomerResponse> custo = customerList.getContent().stream()
                .map(customer -> new CustomerResponse(
                        customer.getId(),
                        customer.getCustomerName(),
                        customer.getCustomerAge(),
                        customer.getCustomerProfession(),
                        customer.getCustomerSalary()))
                .collect(Collectors.toList());
        FetchCustomerDetails fetchCustomerDetails = FetchCustomerDetails.builder().customerResponseList(custo).build();
        log.info("Customer Data List for {} customers : {}",size,mapper.writeValueAsString(fetchCustomerDetails));

        return fetchCustomerDetails;
    }
}
