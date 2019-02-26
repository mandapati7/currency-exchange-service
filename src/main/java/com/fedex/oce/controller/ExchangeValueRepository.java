package com.fedex.oce.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fedex.oce.entity.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Integer> {

	ExchangeValue findByFromAndTo(String from, String to);
	
}
