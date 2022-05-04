package com.exchange.exchangeservice.service.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.exchange.exchangeservice.dto.RateResponseDto;
import com.exchange.exchangeservice.dto.RateResponseDtoV2;

@Component
@Mapper(componentModel = "spring")
public interface MapperWithMapstruct {
	RateResponseDtoV2 map(RateResponseDto responseDto);
}
