package com.psamp.roadsys;

abstract class Road {
	private Identifier identifier;
	private int number;
	private Orientation orientation;
	private Location generalLocation;

	public Road(int num) {
		try {
			this.setOrientation(this.determineOrientation(num));
			this.setNumber(this.determineIfRoadNumberIsValid(num));
			this.setGeneralLocation(this.determineLocation(this.getNumber(), this.getOrientation()));
		} catch (RoadNumberException e) {
			e.printStackTrace();
		}
	}
	
	abstract Location determineLocation(int i, Orientation orientation);

	Orientation determineOrientation(int num) {
		Orientation rtn = null;
		if (num % 2 == 0) {
			rtn = Orientation.EAST_WEST;
		} else {
			rtn = Orientation.NORTH_SOUTH;
		}

		return rtn;
	}

	int determineIfRoadNumberIsValid(int num) throws RoadNumberException {
		int rtn = 0;
		if (num >= 1 && num <= 99) {
			rtn = num;
		} else {
			throw new RoadNumberException("Valid road numbers are 1-99.");
		}
		return rtn;
	}
	
	public String toString() {
		return this.getIdentifier() + "-" + this.getNumber();
	}

	Identifier getIdentifier() {
		return identifier;
	}
	
	protected void setIdentifier(Identifier identifier) {
		this.identifier = identifier;
	}

	int getNumber() {
		return number;
	}

	private void setNumber(int number) {
		try {
			this.number = this.determineIfRoadNumberIsValid(number);
		} catch (RoadNumberException e) {
			e.printStackTrace();
		}
	}

	Orientation getOrientation() {
		return orientation;
	}

	private void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	Location getGeneralLocation() {
		return generalLocation;
	}

	private void setGeneralLocation(Location generalLocation) {
		this.generalLocation = generalLocation;
	}

}
