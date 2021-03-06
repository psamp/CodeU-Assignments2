package com.psamp.roadsys;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RoadTest {
	private Road interstateEven;
	private Road routeOdd;
	
	@Rule
	public ExpectedException exp = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
		interstateEven = new Interstate(40);
		routeOdd = new Route(5);
	}
	
	@Test
	public void testDetermineIfRoadNumberIsValid() throws RoadNumberException {
		exp.expect(RoadNumberException.class);
		exp.expectMessage("Valid road numbers are 1-99.");
		interstateEven.determineIfRoadNumberIsValid(0);
	}
	
	@Test
	public void testOrientationWithInt() {
		assertEquals(Orientation.EAST_WEST, interstateEven.determineOrientation(40));
		assertEquals(Orientation.NORTH_SOUTH, routeOdd.determineOrientation(81));
	}

	@Test
	public void testOrientationOnRoads() {
		assertEquals(Orientation.EAST_WEST, interstateEven.getOrientation());
		assertEquals(Orientation.NORTH_SOUTH, routeOdd.getOrientation());
	}
	
	@Test
	public void testDetermineGeneralLocationWithInt() {
		assertEquals(Location.EAST, interstateEven.determineLocation(99, Orientation.NORTH_SOUTH));
		assertEquals(Location.SOUTH, interstateEven.determineLocation(40, Orientation.EAST_WEST));
		assertEquals(Location.WEST, interstateEven.determineLocation(5, Orientation.NORTH_SOUTH));
		assertEquals(Location.WEST, routeOdd.determineLocation(67, Orientation.NORTH_SOUTH));
		assertEquals(Location.NORTH, routeOdd.determineLocation(48, Orientation.EAST_WEST));
		assertEquals(Location.EAST, routeOdd.determineLocation(19, Orientation.NORTH_SOUTH));
	}
	
	@Test
	public void testDetermineGeneralLocationOnRoads() {
		assertEquals(Location.SOUTH, interstateEven.getGeneralLocation());
		assertEquals(Location.EAST, routeOdd.getGeneralLocation());
	}
	
	@Test
	public void testRoadNumber() {
		assertEquals(40, interstateEven.getNumber());
		assertEquals(5, routeOdd.getNumber());
	}
	
	@Test
	public void testIdentifier() {
		assertEquals(Identifier.I, interstateEven.getIdentifier());
		assertEquals(Identifier.US, routeOdd.getIdentifier());
	}
	
	@Test
	public void testToString() {
		assertEquals("I-40", interstateEven.toString());
		assertEquals("US-5", routeOdd.toString());
	}

}
