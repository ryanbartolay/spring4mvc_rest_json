package com.ryan.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ryan.rest.model.ErrorResponse;
import com.ryan.rest.model.Response;

import com.ryan.model.Country;

@Service
public class CountryService {

	private ErrorResponse restResponse;
	
	private List<Country> listOfCountries = new ArrayList<>();
	private Country tempCountry = null;

	{  
		Country indiaCountry=new Country(1, "India");  
		Country chinaCountry=new Country(4, "China");  
		Country nepalCountry=new Country(3, "Nepal");  
		Country bhutanCountry=new Country(2, "Bhutan");  


		listOfCountries.add(indiaCountry);  
		listOfCountries.add(chinaCountry);  
		listOfCountries.add(nepalCountry);  
		listOfCountries.add(bhutanCountry);  

	}
	
	public Response getRestResponse() {
		return restResponse;
	}

	public void setRestResponse(ErrorResponse restResponse) {
		this.restResponse = restResponse;
	}

	public List<Country> getAllCountries() {
		System.out.println(restResponse.getLabels().getString("s1"));
		return listOfCountries;
	}

	public Country getCountry(int id) {
		tempCountry = new Country(id);
		if(listOfCountries.contains(tempCountry)) {
			return listOfCountries.get(listOfCountries.indexOf(tempCountry));
		}
		return null;
	}

	public Country addCountry(Country country) {
		if(country != null) {
			listOfCountries.add(country);
			return country;
		}
		return null;
	}

	public Country updateCountry(Country country) {  
		if(listOfCountries.contains(country)) {
			listOfCountries.set(listOfCountries.indexOf(country), country);  
			return country;  
		}
		return null;
	}  
	
	public void deleteCountry(int id) {  
		listOfCountries.remove(new Country(id));  
	} 	

	// Utility method to get max id  
	public int getMaxId() {   
		int max = 0;  
		Collections.sort(listOfCountries, new Comparator<Country>() {
			@Override
			public int compare(Country o1, Country o2) {
				if(o1.getId() > o2.getId()) {
					return 1;
				} else if(o1.getId() < o2.getId()) {
					return -1;
				} else {
					return 0;
				}
			}
		});
		if(listOfCountries != null) {
			return listOfCountries.get(listOfCountries.size() - 1).getId();
		}
		return max;
	} 
}
