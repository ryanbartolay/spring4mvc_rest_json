package com.ryan.test.rest.controller;

import java.net.URI;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.ryan.model.Country;
import com.ryan.test.rest.util.Config;

import junit.framework.TestCase;

public class CountryControllerTest extends TestCase {

	private RestTemplate restTemplate;

	@Before
	public void setUp() throws Exception {
		restTemplate = new RestTemplate();
	}

	@Test
	public void testGETRetrieveList() {

		List<Country> countries = restTemplate.getForObject(Config.REST_SERVICE_URI + "/countries", List.class);
		assertFalse(countries instanceof List);
		assertNotNull(countries);
	}
	@Test
	public void testGETRetrieveSuccess() {
		RestTemplate restTemplate = new RestTemplate();
		Country country = restTemplate.getForObject(Config.REST_SERVICE_URI + "/country/3", Country.class);		
		assertNotNull(country);
	}

	@Test
	public void testGETRetrieveFail() {
		Country country = restTemplate.getForObject(Config.REST_SERVICE_URI + "/country/0", Country.class);
		assertNull(country);
	}

	@Test
	public void testPOSTSuccess() {
		Country user = new Country(5, "Philippines");
		URI uri = restTemplate.postForLocation(Config.REST_SERVICE_URI + "/user/", user, Country.class);
		System.out.println("Location : "+uri.toASCIIString());		
	}
}
