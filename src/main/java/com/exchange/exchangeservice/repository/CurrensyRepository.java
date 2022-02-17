package com.exchange.exchangeservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exchange.exchangeservice.entity.Currency;

@Repository
public interface CurrensyRepository extends JpaRepository<Currency, Long>  {
	@Query("from Currency where cc = :currencyCode")
	public Optional<Currency> findByCurrencyCode(String currencyCode);
}
