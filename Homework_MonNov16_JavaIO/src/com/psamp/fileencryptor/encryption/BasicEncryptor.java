package com.psamp.fileencryptor.encryption;

class BasicEncryptor extends Encryptor {

	public String encrypt(String str) {
		StringBuilder buffer = new StringBuilder(str);
		return super.fullyQualifiedClassName() + "encrypt | " + buffer.reverse().toString().toUpperCase();
	}

	@Override
	public String decrypt(String str) {
		StringBuffer buffer = new StringBuffer(str);
		return super.fullyQualifiedClassName() + "decrypt | " + buffer.reverse().toString().toLowerCase();
	}
}
