package com.psamp.starbuzz.condiments;

import com.psamp.starbuzz.coffee.Beverage;

class Soy extends CondimentDecarator {
	Beverage beverage;
	
	public Soy(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Soy";
	}

	public double cost() {
		return .15 + beverage.cost();
	}

}
