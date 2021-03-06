package com.psamp.fileencryptor.encryption;

import java.util.HashMap;
import java.util.Map;

public class CaesarEncryptor extends Encryptor {
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

	public String encrypt(String str) {
		char[] word = str.toLowerCase().toCharArray();

		for (int i = 0; i < word.length; i++) {

			if ((word[i] >= 97 && word[i] <= 122)) {
				word[i] = alphaToCrypta.get(word[i]);

			}
		}

		return String.valueOf(word);
	}

	public String decrypt(String str) {
		char[] word = str.toLowerCase().toCharArray();

		for (int i = 0; i < word.length; i++) {

			if ((word[i] >= 97 && word[i] <= 122)) {

				word[i] = cryptaToAlpha.get(word[i]);

			}
		}

		return String.valueOf(word);
	}

}