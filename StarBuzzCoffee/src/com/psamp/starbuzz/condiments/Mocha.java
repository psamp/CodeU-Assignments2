package com.psamp.starbuzz.condiments;

import com.psamp.starbuzz.coffee.Beverage;

public class Mocha extends CondimentDecarator {
	Beverage beverage;
	
	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}

	public double cost() {
		return .20 + beverage.cost();
	}

}
