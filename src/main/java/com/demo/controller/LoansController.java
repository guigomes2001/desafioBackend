package com.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/custumer-loans")
public class LoansController {
	
	@PostMapping
	public Map<String, Object> getAvaibleLoans (@RequestBody Map<String, Object> request){
		
		int age = (int) request.get("age");
		double income = (double) request.get("income");
		String location = (String) request.get("location");
		String name = (String) request.get("name");
		
		List<Map<String, Object>> loans = new ArrayList<Map<String, Object>>();
		
		if(income <= 5000) {
			loans.add(createLoans("PERSONAL", 4));
			loans.add(createLoans("GUARANTEED", 3));
		}
		
		if(income <= 3000) {
			loans.add(createLoans("CONSIGNMENT", 2));
		}
		
		if(income <= 5000 && age < 25 && "DF".equalsIgnoreCase(location)) {
			loans.add(createLoans("PERSONAL", 4));
			loans.add(createLoans("GUARANTEED", 3));
			loans.add(createLoans("CONSIGMENT", 2));
			
		}
		
		Map<String, Object> response = new HashMap<>();
		response.put("custumer", name);
		response.put("loans", loans);
		return response;
		
	}
	
	private Map<String, Object> createLoans (String type, int interesRate){
		Map<String, Object> loans = new HashMap<>();
		loans.put("type", type);
		loans.put("interesRate", interesRate);
		return loans;
	}
	
}