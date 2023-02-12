package com.sunTravel.customer.services;

import com.sunTravel.common.response.FraudCheckResponse;
import com.sunTravel.customer.dtos.CustomerDto;
import com.sunTravel.customer.entities.Customer;
import com.sunTravel.customer.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class CustomerService
{
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    RestTemplate restTemplate;

    public void registerCustomer( CustomerDto customerDto ) throws IllegalAccessException
    {

        //todo: validate values
        Customer customer=modelMapper.map( customerDto,Customer.class );
        Customer customer1=customerRepository.saveAndFlush( customer );
        //todo:check if fraudster
        System.out.println(customer1.getId());
        FraudCheckResponse fraudCheckResponse=restTemplate.getForObject("http://FRAUD/api/v1/fraudCheck/{customerId}",
                FraudCheckResponse.class,customer1.getId());

        if( fraudCheckResponse.getIsFraudster()){
            throw new IllegalAccessException("fraudster");
        }
        //todo:send notification

    }
}
