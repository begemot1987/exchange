package com.exchange.exchangeservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.exchange.exchangeservice.been.RateResponseBeen;
import com.exchange.exchangeservice.repository.CurrencyRepository;
import com.exchange.exchangeservice.service.mapper.CurrencyMapper;

@Component
@EnableScheduling
public class RateUpdater {
	private CurrencyMapper mapper;
	private final CurrencyRepository repository;
	private final Environment environment;
	
	public RateUpdater(CurrencyRepository repository,
			Environment environment, CurrencyMapper mapper) {
		this.repository = repository;
		this.environment = environment;
		this.mapper = mapper;
	}
	
	@Scheduled(cron = "0 * * * * * ", zone = "Europe/Kiev")
	private void udateRate() {
		List<RateResponseBeen> currentRates = List.of(new RestTemplate()
        		.getForObject(environment.getProperty("user.exchange.rate.path"),
        				RateResponseBeen[].class));
		repository.saveAll(currentRates
				.stream()
				.map(mapper::rateResponseBeenToCurrency)
				.collect(Collectors.toList()));		
	}
}
