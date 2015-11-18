package com.psamp.roadsys;

class Interstate extends Road {

	public Interstate(int number) {
		super(number);
		this.setIdentifier(Identifier.I);
	}

	@Override
	Location determineLocation(int num, Orientation orientation) {
		Location rtn = null;
		
		if(num >= 50 && num <= 99 && orientation == Orientation.EAST_WEST) {
			rtn =  Location.NORTH;
		} else if(num >= 1 && num <= 49 && orientation == Orientation.EAST_WEST) {
			rtn = Location.SOUTH;
		} else if(num >= 50 && num <= 99 && orientation == Orientation.NORTH_SOUTH) {
			rtn = Location.EAST;
		} else if(num >= 1 && num <= 49 && orientation == Orientation.NORTH_SOUTH) {
			rtn = Location.WEST;
		}
		
		return rtn;
	}

}
