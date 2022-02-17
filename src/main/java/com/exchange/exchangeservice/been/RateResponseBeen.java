package com.exchange.exchangeservice.been;

import java.math.BigDecimal;

public class RateResponseBeen {
	private int r030;
	private String txt;
	private BigDecimal rate;
	private String cc;
	private String exchangedate;

	public RateResponseBeen() {
    }

	public int getR030() {
		return r030;
	}

	public void setR030(int r030) {
		this.r030 = r030;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
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

	public String getExchangedate() {
		return exchangedate;
	}

	public void setExchangedate(String exchangedate) {
		this.exchangedate = exchangedate;
	}

	@Override
	public String toString() {
		return "Response{" + "r030=" + r030 
				+ ", txt='" + txt + '\'' 
				+ ", rate=" + rate 
				+ ", cc='" + cc + '\''
				+ ", exchangedate=" + exchangedate + '}';
	}
}
