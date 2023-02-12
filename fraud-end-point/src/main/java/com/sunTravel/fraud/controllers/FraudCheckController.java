package com.sunTravel.fraud.controllers;

import com.sunTravel.common.response.FraudCheckResponse;
import com.sunTravel.fraud.services.FraudCheckService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/fraudCheck/")
@CrossOrigin
@Slf4j
public class FraudCheckController
{
    @Autowired
    private FraudCheckService fraudCheckService;

    @GetMapping(path="{customerId}")
    public ResponseEntity<FraudCheckResponse> get( @PathVariable("customerId") String customerId ){
        System.out.println("came fraud");
        log.info("check fraud customer {}",customerId  );
        FraudCheckResponse isFraudulent=fraudCheckService.isFraudulentCustomer( customerId );
        return new ResponseEntity<>( isFraudulent, HttpStatus.OK );
    }
    @PostMapping( "customerId")
    public ResponseEntity<String> get1( @RequestBody String id ){
        System.out.println("came fraud");
        return new ResponseEntity<>( id, HttpStatus.OK );
    }

}
