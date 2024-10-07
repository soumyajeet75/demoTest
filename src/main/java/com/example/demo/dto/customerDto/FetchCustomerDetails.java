package com.example.demo.dto.customerDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FetchCustomerDetails {

    @JsonProperty("CustomerDetails")
    private List<CustomerResponse> customerResponseList;
}
