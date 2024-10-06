package com.example.demo.dto.customerDto;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="customer_details")
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CustomerResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Primary Key, Auto-incremented

    @Column(name = "customer_name")
    @JsonProperty("customer_name")
    private String customerName;

    @JsonProperty("customer_age")
    @Column(name = "customer_age")
    private String customerAge;

    @Column(name = "customer_profession")
    @JsonProperty("customer_profession")
    private String customerProfession;

    @Column(name = "customer_salary")
    @JsonProperty("customer_salary")
    private String customerSalary;


}
