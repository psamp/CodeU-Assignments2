package com.psamp.starbuzz.condiments;

import com.psamp.starbuzz.coffee.Beverage;

public class Whip extends CondimentDecarator {
	Beverage beverage;
	
	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Whip";
	}

	public double cost() {
		return .10 + beverage.cost();
	}

}
