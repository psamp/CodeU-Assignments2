package com.psamp.auto;

class Driver {
	private int age;
	private int drivingExperience;
	private Gender gender;
	
	
	Driver(int age, String gender, int drivingExperience) {
		this.setAge(age);
		this.setDrivingExperience(drivingExperience);
		this.setGender(Gender.valueOf(gender.toUpperCase()));
	}
	
	int getAge() {
		return age;
	}
	private void setAge(int age) {
		this.age = age;
	}
	int getDrivingExperience() {
		return drivingExperience;
	}
	private void setDrivingExperience(int drivingExperience) {
		this.drivingExperience = drivingExperience;
	}
	Gender getGender() {
		return gender;
	}
	void setGender(Gender gender) {
		this.gender = gender;
	}

}
