package com.psamp.encrypt;

class BasicEncryptor extends Encryptor {

	@Override
	String encrypt(String str) {
		StringBuffer buffer = new StringBuffer(str);
		return this.getClass() + " | " + buffer.reverse().toString().toUpperCase();
	}

}
