package com.exchange.exchangeservice.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.stereotype.Service;

import com.exchange.exchangeservice.entity.Currency;
import com.exchange.exchangeservice.repository.CurrensyRepository;

@Service
public class CurrencyService {
	private final CurrensyRepository repository;
	
	public CurrencyService(CurrensyRepository repository) {
		this.repository = repository;
	}
	
	public Currency save(Currency currency) {
		return repository.save(currency);
	}
	
	public List<Currency> saveAll(List<Currency> currencies) {
		return repository.saveAll(currencies);
	}
	
	public List<Currency> getAll() {
		return repository.findAll();
	}
	
	public Currency findByCurrencuCode(String currencyCode) {
		return repository.findByCurrencyCode(currencyCode).orElseThrow();
	}
	
	public BigDecimal exchange(String from, String to) {
		Currency fromCurrency = repository.findByCurrencyCode(from).orElseThrow();
		Currency toCurrency = repository.findByCurrencyCode(to).orElseThrow();
		BigDecimal rate = fromCurrency.getRate().divide(toCurrency.getRate(), 10, RoundingMode.HALF_UP);		
		return rate;
	}
}
