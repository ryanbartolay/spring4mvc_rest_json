package com.ryan.runtime;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ryan.rest.model.ErrorResponse;
import com.ryan.rest.model.Response;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = null;
		try {
			context = new FileSystemXmlApplicationContext("../WEB-INF/springrest-servlet.xml"); 
			BeanFactory factory = context;
			Response test = (ErrorResponse) factory.getBean("restResponse");
			System.out.println(test.getLabels().getString("s1"));
		} finally {
			
		}
	}
} 

