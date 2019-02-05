package com.example.demo;


import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.json.JSONParser;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
public class ExchangeRateController {
	@Autowired
	ExchangeRateRepository repository;

	@GetMapping (value="/api/exchangerates", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ExchangeRate> exchangeRatesList() {
		return (List<ExchangeRate>) repository.findAll();
	}
		
	@PostMapping (value="/api/exchangerates")
	public String createRate(@RequestBody ExchangeRate sData) {
		Logger l = Logger.getLogger(ExchangeRateController.class);
		l.info(""+sData.getCurrency());
		l.info(""+sData.getRateToRON());
		l.info(""+sData.getExchangeDate());
		//return String.format("%s %s %d", sData.getCurrency(), sData.getExchangeDate(), sData.getRateToRON());
		return String.format("Created %s %s %s", sData.getExchangeDate(), sData.getCurrency(),sData.getRateToRON());
	}
	
	
	/// ---- Si cu stringuri ---
	
	@PostMapping (value="/api/exchangerates2")
	public String createRate2(@RequestBody String sData) {
		Logger l = Logger.getLogger(ExchangeRateController.class);
		ObjectMapper om = new ObjectMapper();
		ExchangeRate rate = null;
		try {
			rate = om.readValue(sData, ExchangeRate.class);
			l.info(""+rate.getCurrency());
			l.info(""+rate.getRateToRON());
			l.info(""+rate.getExchangeDate());
		} catch(Exception e) {
			l.debug("Error on mapping");
		}	
		
		if(rate!=null) {
			return String.format("Created %s %s %s", rate.getExchangeDate(), rate.getCurrency(),rate.getRateToRON());
		} else {
			return "NOK";
		}
	}
}
