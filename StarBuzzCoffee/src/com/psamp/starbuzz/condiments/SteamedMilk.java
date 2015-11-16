package com.psamp.starbuzz.condiments;

import com.psamp.starbuzz.coffee.Beverage;

class SteamedMilk extends CondimentDecarator {
	Beverage beverage;
	
	public SteamedMilk(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Steamed milk";
	}

	public double cost() {
		return .10 + beverage.cost();
	}

}
