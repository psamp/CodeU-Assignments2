package com.psamp.encrypt;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class CaesarEncryptorTest {
	Encryptor caesar;

	@Before
	public void setUp() throws Exception {
		caesar = new CaesarEncryptor();
	}

	@Test
	public void testEncrypt() {
		String expected = "def1";
		String actual = caesar.encrypt("abc1");

		Writeable writeable = (Writeable) caesar;

		writeable.write(actual);

		assertEquals(true, actual.contains(expected));
	}

	@Test
	public void testDecrypt() {
		String expected = "princess";
		String actual = caesar.decrypt("sulqfhvv");

		assertEquals(true, actual.contains(expected));
	}

	@Test
	public void encryptScanner() {
		Scanner scn = new Scanner(System.in);
		try {
			System.out.println("Enter word to encrypt: ");
			String response = caesar.encrypt(scn.next());
			
			System.out.println(response);
			
			Writeable writeable = (Writeable) caesar;
			writeable.write(response);
			
		} finally {
			scn.close();
		}

	}

}
