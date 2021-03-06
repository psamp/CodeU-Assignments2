package com.psamp.fileencryptor;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class FileEncryptorTest {
	private File fileQuickBrownFox;
	private File fileDEFG;
	private FileEncryptor fe;

	@Before
	public void setUp() throws Exception {
		fe = new FileEncryptor();

		fileQuickBrownFox = new File("file.txt");
		fileDEFG = new File("defg.txt");
	}

	@Test
	public void testEncryptFile() {

		String line = null;
		StringBuilder sb = new StringBuilder();

		try(BufferedReader readerQuickBrownFox = new BufferedReader(new FileReader(fe.encryptFile(fileQuickBrownFox)))) {
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

		try(BufferedReader readerDEFG = new BufferedReader(new FileReader(fe.decryptFile(fileDEFG)))) {
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
