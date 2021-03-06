package com.psamp.encrypt;

import java.util.HashMap;
import java.util.Map;

import com.jits.shipping.util.TrackingWriter;

class CaesarEncryptor extends Encryptor implements Writeable {
	private char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
			'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
	private char[] cryptabet = { 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
			'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c' };
	private Map<Character, Character> alphaToCrypta;
	private Map<Character, Character> cryptaToAlpha;

	public CaesarEncryptor() {
		this.fillMap();
	}

	private void fillMap() {
		alphaToCrypta = new HashMap<Character, Character>();
		cryptaToAlpha = new HashMap<Character, Character>();

		for (int i = 0; i < Math.min(alphabet.length, cryptabet.length); i++) {
			alphaToCrypta.put(alphabet[i], cryptabet[i]);
			cryptaToAlpha.put(cryptabet[i], alphabet[i]);
		}
	}

	String encrypt(String str) {
		char[] word = str.toLowerCase().toCharArray();

		for (int i = 0; i < word.length; i++) {

			if ((word[i] >= 97 && word[i] <= 122)) {
				word[i] = alphaToCrypta.get(word[i]);

			}
		}

		return super.fullyQualifiedClassName() + String.valueOf(word);
	}

	String decrypt(String str) {
		char[] word = str.toLowerCase().toCharArray();

		for (int i = 0; i < word.length; i++) {

			if ((word[i] >= 97 && word[i] <= 122)) {

				word[i] = cryptaToAlpha.get(word[i]);

			}
		}

		return super.fullyQualifiedClassName() + String.valueOf(word);
	}

	@Override
	public void write(String str) {

		TrackingWriter tw = new TrackingWriter("caesar.txt", true);
		tw.write(str);

	}

	// String encrypt(String str) {
	//
	// char[] characters = str.toLowerCase().toCharArray();
	//
	// for (int i = 0; i < characters.length; i++) {
	// if ((characters[i] >= 97 && characters[i] <= 122) || (characters[i] >= 48
	// && characters[i] <= 57)) {
	// int shift = characters[i] + 3;
	// characters[i] = (char) shift;
	// }
	// }
	//
	// return super.header() + String.valueOf(characters);
	// }

	// @Override
	// String decrypt(String caesar) {
	//
	// char[] characters = caesar.toLowerCase().trim().toCharArray();
	//
	// for (int i = 0; i < characters.length; i++) {
	// if ((characters[i] >= 97 && characters[i] <= 122) || (characters[i] >= 48
	// && characters[i] <= 57)) {
	// int shift = characters[i] - 3;
	// characters[i] = (char) shift;
	// }
	// }
	//
	// return super.header() + String.valueOf(characters);
	// }

}