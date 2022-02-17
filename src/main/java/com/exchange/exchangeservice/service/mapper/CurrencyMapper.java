package com.exchange.exchangeservice.service.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;
import com.exchange.exchangeservice.been.RateResponseBeen;
import com.exchange.exchangeservice.dto.RateResponseDto;
import com.exchange.exchangeservice.entity.Currency;

@Component
public class CurrencyMapper {
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
	
	public Currency rateResponseBeenToCurrency(RateResponseBeen rateResponseBeen) {
		Currency currency = new Currency();
		currency.setR030(rateResponseBeen.getR030());
		currency.setName(rateResponseBeen.getTxt());
		currency.setRate(rateResponseBeen.getRate());
		currency.setCc(rateResponseBeen.getCc());
		currency.setExchangeDate(LocalDate.parse(rateResponseBeen.getExchangedate(), formatter));
	return currency;	
	}
	
	public RateResponseDto currencyToRateResponseDto(Currency currency) {
		RateResponseDto response = new RateResponseDto();
		response.setR030(currency.getR030());
		response.setName(currency.getName());
		response.setRate(currency.getRate());
		return response;
	}
}
