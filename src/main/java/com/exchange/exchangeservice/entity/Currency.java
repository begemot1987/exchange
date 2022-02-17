package com.exchange.exchangeservice.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "currency")
public class Currency {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer r030;
	private String name;
	@Column(precision = 16, scale = 10)
	private BigDecimal rate;
	@Column(name = "currency_code")
	private String cc;
	@Column(name = "exchange_date")
	private LocalDate exchangeDate;

	public Currency() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getR030() {
		return r030;
	}

	public void setR030(Integer r030) {
		this.r030 = r030;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public LocalDate getExchangeDate() {
		return exchangeDate;
	}

	public void setExchangeDate(LocalDate exchangeDate) {
		this.exchangeDate = exchangeDate;
	}

	@Override
	public String toString() {
		return "Currency [id=" + id + ", r030=" + r030 + ", name=" + name + ", rate=" + rate + ", cc=" + cc
				+ ", exchangeDate=" + exchangeDate + "]";
	}
}
