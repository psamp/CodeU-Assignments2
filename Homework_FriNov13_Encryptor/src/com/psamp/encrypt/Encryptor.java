package com.psamp.encrypt;

abstract class Encryptor {

	String fullyQualifiedClassName() {
		return this.getClass() + " | ";
	}

	abstract String encrypt(String str);
	abstract String decrypt(String str);
	
	String encrypt(String str, int shift) {
		String end = str.toLowerCase().substring(shift, str.length());
		String strng = str.toLowerCase().substring(0, shift);
		
		return this.fullyQualifiedClassName() + end + strng;
	}

}
