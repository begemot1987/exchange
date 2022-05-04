package com.exchange.exchangeservice.controller;

import com.exchange.exchangeservice.dto.ExchangeResponseDto;
import com.exchange.exchangeservice.dto.RateResponseDto;
import com.exchange.exchangeservice.service.CurrencyService;
import com.exchange.exchangeservice.service.mapper.CurrencyMapper;
import com.exchange.exchangeservice.service.mapper.MapperWithMapstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	private CurrencyMapper mapper;
	private CurrencyService currencyService;
	private MapperWithMapstruct mapperv2;
	
	public MainController(CurrencyMapper mapper,
			CurrencyService currencyService,
			MapperWithMapstruct mapperv2) {
		this.mapper = mapper;
		this.currencyService = currencyService;
		this.mapperv2 = mapperv2;
	}
	
	@GetMapping("/")
	public String test() {
		return "You are here";
	}
	
    @GetMapping("/{code}")
    public RateResponseDto getByCurrencyCode(@PathVariable String code) {
    	return mapper.currencyToRateResponseDto(currencyService.findByCurrencyCode(code));
    }
    
    @GetMapping("/from/{from}/to/{to}")
    public ExchangeResponseDto exchange(@PathVariable String from, @PathVariable String to) {
    	ExchangeResponseDto response = new ExchangeResponseDto();
    	response.setFrom(from);
    	response.setTo(to);
    	response.setRate(currencyService.exchange(from, to));
    	return response;
    }
}
