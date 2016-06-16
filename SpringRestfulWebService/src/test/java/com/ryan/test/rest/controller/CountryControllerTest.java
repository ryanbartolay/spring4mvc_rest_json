package com.ryan.test.rest.controller;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.ryan.model.Country;

import junit.framework.TestCase;

public class CountryControllerTest extends TestCase {
	@Test
	public void testSample() {
		RestTemplate restTemplate = new RestTemplate();
        Country country = restTemplate.getForObject("http://localhost:8080/SpringRestfulWebService/country/3", Country.class);
        System.out.println(country);
	}
}
