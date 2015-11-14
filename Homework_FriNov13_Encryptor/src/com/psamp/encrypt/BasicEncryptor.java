package com.psamp.encrypt;

class BasicEncryptor extends Encryptor {
	
	String encrypt(String str) {
		StringBuffer buffer = new StringBuffer(str);
		return super.header() + buffer.reverse().toString().toUpperCase();
	}

	@Override
	String decrypt(String str) {
		StringBuffer buffer = new StringBuffer(str);
		return super.header() + "decrypt | " + buffer.reverse().toString().toLowerCase();
	}
}
