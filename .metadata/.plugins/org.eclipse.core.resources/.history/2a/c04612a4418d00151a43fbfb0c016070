package com.psamp.fileencryptor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import com.psamp.fileencryptor.encryption.CaesarEncryptor;
import com.psamp.fileencryptor.encryption.Encryptor;

class FileEncryptor {
	private Encryptor encryptor;
	private Reader reader;
	private Writer writer;

	public FileEncryptor() {
		encryptor = new CaesarEncryptor();
	}

	File encryptFile(File file) {
		int current = 0;
		String character = "";
		File encryptedFile = new File("encrypted" + file.getName());

		try {

			reader = new BufferedReader(new FileReader(file));
			writer = new BufferedWriter(new FileWriter(encryptedFile));

			while ((current = reader.read()) != -1) {
				character = encryptor.encrypt(String.valueOf((char) current));
				writer.write(character.toCharArray());
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {
				reader.close();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return encryptedFile;

	}

	File decryptFile(File file) {
		int current = 0;
		String character = "";
		File decryptedFile = new File("decrypted" + file.getName());

		try {

			reader = new BufferedReader(new FileReader(file));
			writer = new BufferedWriter(new FileWriter(decryptedFile));

			while ((current = reader.read()) != -1) {
				character = encryptor.decrypt(String.valueOf((char) current));
				writer.write(character.toCharArray());
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {
				reader.close();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return decryptedFile;

	}

}
