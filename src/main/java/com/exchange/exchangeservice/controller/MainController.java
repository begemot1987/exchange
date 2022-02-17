package com.exchange.exchangeservice.controller;

import com.exchange.exchangeservice.dto.RateResponseDto;
import com.exchange.exchangeservice.service.CurrencyService;
import com.exchange.exchangeservice.service.mapper.CurrencyMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	private CurrencyMapper mapper;
	private CurrencyService currencyService;
	
	public MainController(CurrencyMapper mapper, CurrencyService currencyService) {
		this.mapper = mapper;
		this.currencyService = currencyService;
	}
    @GetMapping("/{code}")
    public RateResponseDto getByCurrencyCode(@PathVariable String code) {
    	return mapper.currencyToRateResponseDto(currencyService.findByCurrencuCode(code));
    }
    
    @GetMapping("/from/{from}/to/{to}")
    public String exchange(@PathVariable String from, @PathVariable String to) {    	
    	return "Converting rate from " + from + " to " + to + " is " + currencyService.exchange(from, to);    	
    }
}
