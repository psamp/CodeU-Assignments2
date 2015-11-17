package com.psamp.fileencryptor.encryption;

public abstract class Encryptor {

	String fullyQualifiedClassName() {
		return this.getClass() + " | ";
	}

	public abstract String encrypt(String str);

	public abstract String decrypt(String str);

}
