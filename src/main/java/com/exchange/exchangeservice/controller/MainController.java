package com.exchange.exchangeservice.controller;

import java.util.List;
import com.exchange.exchangeservice.ResponseDto;
import com.exchange.exchangeservice.TestBeen;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainController {

    @GetMapping
    public String test() {
        RestTemplate restTemplate = new RestTemplate();
        TestBeen[] forEntity = restTemplate.getForObject("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json",TestBeen[].class);

        for (TestBeen b : forEntity) {
            System.out.println(b);
        }
        return "test";
    }
}
