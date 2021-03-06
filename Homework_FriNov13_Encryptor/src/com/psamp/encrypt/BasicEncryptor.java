package com.psamp.encrypt;

class BasicEncryptor extends Encryptor {

	String encrypt(String str) {
		StringBuilder buffer = new StringBuilder(str);
		return super.fullyQualifiedClassName() + "encrypt | " + buffer.reverse().toString().toUpperCase();
	}

	@Override
	String decrypt(String str) {
		StringBuffer buffer = new StringBuffer(str);
		return super.fullyQualifiedClassName() + "decrypt | " + buffer.reverse().toString().toLowerCase();
	}
}
