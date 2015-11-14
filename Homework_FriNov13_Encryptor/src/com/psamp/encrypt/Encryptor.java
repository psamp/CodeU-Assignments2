package com.psamp.encrypt;

abstract class Encryptor {

	String header() {
		return this.getClass() + " | ";
	}

	abstract String encrypt(String str);
	abstract String decrypt(String str);

}
