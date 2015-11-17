package com.psamp.fileencryptor;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FileEncryptorTest {
	private File fileQuickBrownFox;
	private File fileDEFG;
	private FileEncryptor fe;
	private BufferedReader readerQuickBrownFox;
	private BufferedReader readerDEFG;

	@Before
	public void setUp() throws Exception {
		fe = new FileEncryptor();

		fileQuickBrownFox = new File("file.txt");
		fileDEFG = new File("defg.txt");

		readerQuickBrownFox = new BufferedReader(new FileReader(fe.encryptFile(fileQuickBrownFox)));
		readerDEFG = new BufferedReader(new FileReader(fe.decryptFile(fileDEFG)));
	}

	@After
	public void tearDown() throws Exception {
		readerQuickBrownFox.close();
		readerDEFG.close();
	}

	@Test
	public void testEncryptFile() {

		String line = null;
		StringBuilder sb = new StringBuilder();

		try {
			while ((line = readerQuickBrownFox.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		String expected = "wkh txlfn eurzq ira";
		String actual = sb.toString();

		assertEquals(expected, actual);
	}

	@Test
	public void testDecryptFile() {

		String line = null;
		StringBuilder sb = new StringBuilder();

		try {
			while ((line = readerDEFG.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		String expected = "abcd";
		String actual = sb.toString();

		assertEquals(expected, actual);
	}

}
