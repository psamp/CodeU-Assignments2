package com.psamp.auto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AutoPolicyTest {
	AutoPolicy ap;
	private Driver driver18;
	private Driver driver27;
	private Driver driver35;
	private Driver driver48;
	private Driver driver70;
	
	@Before
	public void setUp() throws Exception {
		driver18 = new Driver(18, "Female", 2);
		driver27 = new Driver(27, "Male", 0);
		driver35 = new Driver(35, "Male", 19);
		driver48 = new Driver(48, "Nunya", 20);
		driver70 = new Driver(70, "Male", 55);
		ap = new AutoPolicy();
	}
	
	@Rule
	public ExpectedException exp = ExpectedException.none();

	@Test
	public void testAutoPolicyCost() {;
	
		ap = new AutoPolicy(driver70);
		assertEquals(0, ap.getCost(), .001);
		
//		assertEquals(990, driver18.getAutoPolicy().getCost(), .001);
//		assertEquals(880, driver27.getAutoPolicy().getCost(), .001);
//		assertEquals(565, driver35.getAutoPolicy().getCost(), .001);
//		assertEquals(300, driver48.getAutoPolicy().getCost(), .001);
	}
	
	@Test
	public void testCalculateBaseCost() throws AgeException {
		
		assertEquals(1000, ap.calculateBaseCost(15), .001);
		assertEquals(800, ap.calculateBaseCost(27), .001);
		assertEquals(600, ap.calculateBaseCost(35), .001);
		assertEquals(400, ap.calculateBaseCost(42), .001);
		assertEquals(200, ap.calculateBaseCost(65), .001);
		
	}
	
	@Test
	public void testCalculateAdditionalForMaleCustomersWithoutFactoringInExperience() throws AgeException {
		ap = new AutoPolicy(driver27);
		assertEquals(880, ap.getCost(), .001);
		
		ap = new AutoPolicy(driver18);
		assertEquals(990, ap.getCost(), .001);
	}
	
	@Test
	public void testExperienceDeductible() throws AgeException {
		assertEquals(100, ap.experienceDeductible(20));
	}
	
	@Test
	public void testCalculateMultipleDriverDiscount() {
		ap = new AutoPolicy(driver48, driver18, driver35);
		assertEquals(37.1, ap.calculateMultipleDriverDiscount(), .001);
	}

	@Test
	public void testInvalidAge() throws AgeException {
		exp.expect(AgeException.class);
		exp.expectMessage("Policy holder must be over 15 and under 100.");
		ap.calculateBaseCost(14);
	}
}
