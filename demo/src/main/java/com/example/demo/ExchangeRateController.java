package com.example.demo;


import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParser;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@RestController
@RequestMapping(value="/api")
public class ExchangeRateController {
	@Autowired
	ExchangeRateRepository repository;
	@RequestMapping (value="/exchangerates",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ExchangeRate> exchangeRatesList(Model model) {
		return (List<ExchangeRate>) repository.findAll();
	}
	@RequestMapping (value="/exchangerate/{id}")
	public String exchangeRate(@PathVariable Long id, Model model) {
		model.addAttribute("exchangeRate",repository.findById(id));		
		return "exchangeRate";
	}
	@RequestMapping (value="/exchangerates",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String exchangeRatesList(String sIn) {
		return "OK";
	}
	@RequestMapping (value="/createrate",method = RequestMethod.POST)
	public String createRate(@RequestBody String sData) {
		Gson gson = new Gson();
		Type stringStringMap = new TypeToken<Map<String, String>>(){}.getType();
		Map<String,String> map = gson.fromJson(sData, stringStringMap);
		return "OK";
	}
}
