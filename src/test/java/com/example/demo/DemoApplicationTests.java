package com.example.demo;

import com.example.demo.dto.customerDto.CustomerResponse;
import com.example.demo.repositeries.CustomerRepo;
import com.example.demo.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@Slf4j
@ExtendWith(MockitoExtension.class)
class DemoApplicationTests {

	@Mock
	private CustomerRepo repo;

	@InjectMocks
	private CustomerService customerService;

	@Test
	public void saveDetails_ShouldSaveCustomer_WhenValidRequest() {
		// Arrange
		CustomerResponse request = new CustomerResponse();
		request.setCustomerName("Rajesh Doe");
		request.setCustomerAge("30");
		request.setCustomerProfession("Engineer");
		request.setCustomerSalary("100000");

		// Act
		String response = customerService.saveDetails(request);

		// Assert
		verify(repo, times(1)).save(request);
		assertEquals("Successfully updated the details of customer Rajesh Doe in DataBase", response);
		log.info(response);
	}
	@Test
	void contextLoads() {
	}

}
