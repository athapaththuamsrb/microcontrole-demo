package com.sunTravel.customer.controllers;

import com.sunTravel.customer.dtos.CustomerDto;
import com.sunTravel.customer.services.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/customer/")
@CrossOrigin
@Slf4j
public class CustomerController
{
    @Autowired
    private CustomerService customerService;

    @PostMapping("add")
    public void get( @RequestBody CustomerDto customerDto ) throws IllegalAccessException
    {
        log.info("new customer registration {}",customerDto  );
        customerService.registerCustomer(customerDto);
    }

}
