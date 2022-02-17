package com.exchange.exchangeservice.controller;

import com.exchange.exchangeservice.been.RateResponseBeen;
import com.exchange.exchangeservice.dto.RateResponseDto;
import com.exchange.exchangeservice.entity.Currency;
import com.exchange.exchangeservice.service.CurrencyService;
import com.exchange.exchangeservice.service.mapper.CurrencyMapper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainController {
	private CurrencyMapper mapper;
	private CurrencyService currencyService;
	private final Environment environment;
	
	public MainController(CurrencyMapper mapper, CurrencyService currencyService, Environment environment) {
		this.mapper = mapper;
		this.currencyService = currencyService;
		this.environment = environment;
	}

    @GetMapping
    public List<RateResponseDto> fetchData() {
        RateResponseBeen[] forEntity = new RestTemplate()
        		.getForObject(environment.getProperty("user.exchange.rate.path"),
        				RateResponseBeen[].class);        
        List<Currency> collect = Arrays.stream(forEntity)
        		.map(mapper::rateResponseBeenToCurrency)
        		.collect(Collectors.toList());
        return currencyService.saveAll(collect)
        		.stream()
        		.map(mapper::currencyToRateResponseDto)
        		.collect(Collectors.toList());
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
