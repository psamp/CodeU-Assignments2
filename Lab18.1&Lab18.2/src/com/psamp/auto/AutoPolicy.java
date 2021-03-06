package com.psamp.auto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class AutoPolicy {
	private double cost;
	private static Map<Integer, Integer> priceTiers = new HashMap<Integer, Integer>();
	private List<Driver> drivers = new ArrayList<Driver>();
	
	AutoPolicy() {
	}
	
	AutoPolicy(Driver d, Driver ... people) {
		
		this.populateDrivers(d, people);
		this.setCostBasedOnAllDrivers();
		
	}
	
	static {
		AutoPolicy.populatePriceTiers();
	}
	
	private static void populatePriceTiers() {
		priceTiers.put(1, 1000);
		priceTiers.put(2, 800);
		priceTiers.put(3, 600);
		priceTiers.put(4, 400);
		priceTiers.put(5, 200);
	}
	
	private void populateDrivers(Driver d, Driver[] candidates) {
		
		drivers.add(d);
		if(candidates != null) {
			for (Driver driver : candidates) {
				drivers.add(driver);
			}
		}
		
	}
	
	private void setCostBasedOnAllDrivers() {
		try {
			for (Driver policyHolder : drivers) {
				this.setCost(policyHolder);
			}
		} catch (AgeException e) {
			e.printStackTrace();
		}
	}

	double calculateBaseCost(int age) throws AgeException {
		double rtn = 0;
		
		if(age < 15 || age > 100) {
				throw new AgeException("Policy holder must be over 15 and under 100.", new IllegalArgumentException());
		} else if(age < 25) {
			rtn = priceTiers.get(1);
		} else if(age >= 25 && age <= 30) {
			rtn = priceTiers.get(2);
		} else if(age >= 31 && age <= 40) {
			rtn = priceTiers.get(3);
		} else if(age >= 41 && age <= 50) {
			rtn = priceTiers.get(4);
		} else if (age > 50) {
			rtn = priceTiers.get(5);
		}
		
		return rtn;
	}
	
	private double calculateAdditional(Gender gender, int age) throws AgeException {
		double rtn = 0;
		
		if(gender == Gender.MALE) {
			rtn = this.calculateBaseCost(age) * 0.1;
		}
		
		return rtn;
	}
	
	int experienceDeductible(int experience) throws AgeException {
		int rtn = 0;
		
		for (int i = 0; i < experience; i++) {
			rtn += 5;
		}
		
		return rtn;
	}
	
	double calculateMultipleDriverDiscount() {
		int discount = 0;
		double rtn = 0;
		
		if(drivers.size() > 2) {
			for (int i = 0; i < drivers.size() - 2; i++) {
				discount +=2;
			}
			rtn = this.getCost() / 100 * discount;
		}
		return rtn;
	}

	private void setCost(Driver driver) throws AgeException {
		try {
			this.cost += this.calculateBaseCost(driver.getAge());
			this.cost += this.calculateAdditional(driver.getGender(), driver.getAge());
			this.cost -= this.experienceDeductible(driver.getDrivingExperience());
			
			if(this.getCost() < 0) {
				this.cost = 0;
			}
			
		} catch (AgeException e) {
			e.printStackTrace();
			throw e;
		}
	}

	double getCost() {
		return this.cost;
	}

	List<Driver> getDrivers() {
		return drivers;
	}

}
