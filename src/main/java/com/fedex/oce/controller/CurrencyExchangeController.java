package com.fedex.oce.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fedex.oce.entity.ExchangeValue;

@RestController
public class CurrencyExchangeController {

	private final static Logger LOG = LoggerFactory.getLogger(CurrencyExchangeController.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	ExchangeValueRepository evRepo;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue getExchangeValue(@PathVariable String from, @PathVariable String to) {
		ExchangeValue ev = evRepo.findByFromAndTo(from, to);
		LOG.info("{}", ev);
		//ExchangeValue ev = new ExchangeValue(1l, from, to, new BigDecimal(65));
		ev.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return ev;
	}

}
