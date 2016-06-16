package com.ryan.rest.model;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class ErrorResponse implements Response {
	
	private ResourceBundle labels = PropertyResourceBundle.getBundle("conf.locale.LabelsBundle");
	
	public ErrorResponse() {
		System.out.println("Hello World");
		
		System.out.println(labels.getString("s1"));
	}	
	
	public ResourceBundle getLabels() {
		return labels;
	}
	public void setLabels(ResourceBundle labels) {
		this.labels = labels;
	}
}
