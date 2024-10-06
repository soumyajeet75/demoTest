package com.example.demo.repositeries;

import com.example.demo.dto.customerDto.CustomerResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerResponse,Long> {


}
