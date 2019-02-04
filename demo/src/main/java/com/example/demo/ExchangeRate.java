package com.example.demo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ExchangeRate {

@Id
@GeneratedValue
private Long id;
private Date exchangeDate;
private String currency;

private Float rateToRON;
public ExchangeRate() {
	
}

public ExchangeRate(Date exchangedate, String currency , Float ratetoron) {
	super();
	this.currency = currency;
	this.exchangeDate = exchangedate;
	this.rateToRON = ratetoron;	
}
public Date getExchangeDate() {
	return exchangeDate;
}
public void setExchangeDate(Date exchangeDate) {
	this.exchangeDate = exchangeDate;
}
public Float getRateToRON() {
	return rateToRON;
}
public void setRateToRON(Float rateToRON) {
	this.rateToRON = rateToRON;
}
public String getCurrency() {
	return currency;
}
public void setCurrency(String currency) {
	this.currency = currency;
}

}
