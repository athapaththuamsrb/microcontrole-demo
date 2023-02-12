package com.sunTravel.fraud.services;


import com.sunTravel.common.response.FraudCheckResponse;
import com.sunTravel.fraud.entities.FraudCheckHistory;
import com.sunTravel.fraud.repository.FraudCheckHistoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class FraudCheckService
{
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public FraudCheckResponse isFraudulentCustomer( String customerId )
    {
        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                                 .customerId( customerId )
                                 .isFraudster( false )
                                 .createdAt( LocalDateTime.now())
                                 .build()
        );
        return FraudCheckResponse.builder().isFraudster( false ).build();
    }
}
