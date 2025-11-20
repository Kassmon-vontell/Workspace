package com.kassmon.modules.encodingSystem;

import java.util.HashMap;

public class EncodeDecodeSystem {
	
	private static HashMap<Character, Byte> encodingMap = new HashMap<>();
	private static HashMap<Byte, Character> decodingMap = new HashMap<>();
	
	static {
		for (int i = 0; i < 26; i++) {
			addEncodingDecoding((char) ('a' + i), (byte) (i + 1));
			
		}
		addEncodingDecoding('(', (byte) 27);
		addEncodingDecoding('<', (byte) 28);
		addEncodingDecoding('[', (byte) 29);
		addEncodingDecoding('{', (byte) 30);
		for (int i = 0; i < 26; i++) {
			addEncodingDecoding((char) ('A' + i), (byte) (i + 33));
		}
		addEncodingDecoding(')', (byte) 59);
		addEncodingDecoding('>', (byte) 60);
		addEncodingDecoding(']', (byte) 61);
		addEncodingDecoding('}', (byte) 62);
		
		addEncodingDecoding('1', (byte) 65);
		addEncodingDecoding('2', (byte) 66);
		addEncodingDecoding('3', (byte) 67);
		addEncodingDecoding('4', (byte) 68);
		addEncodingDecoding('5', (byte) 69);
		addEncodingDecoding('6', (byte) 70);
		addEncodingDecoding('7', (byte) 71);
		addEncodingDecoding('8', (byte) 72);
		addEncodingDecoding('9', (byte) 73);
		addEncodingDecoding('0', (byte) 74);
		
		addEncodingDecoding(' ', (byte) 75);
		addEncodingDecoding('\n', (byte) 76);
		
	}
	
	private static void addEncodingDecoding(Character str, byte code) {
        encodingMap.put(str, code);
        decodingMap.put(code, str);
    }
	
	public static byte[] encodeString(String input) {
		byte[] encoded = new byte[input.length()];
		for (int i = 0; i < input.length(); i++) {
			encoded[i] = encodingMap.getOrDefault(input.charAt(i), (byte) 0);
		}
		return encoded;
	}
	
	public static String decodeBytes(byte[] input) {
		StringBuilder decoded = new StringBuilder();
		for (byte b : input) {
			decoded.append(decodingMap.getOrDefault(b, '?'));
		}
		return decoded.toString();
	}
	
	public static byte encodeChar(char input) {
		return encodingMap.getOrDefault(input, (byte) 0);
	}
	
	public static char decodeByte(byte input) {
		return decodingMap.getOrDefault(input, '?');
	}
	
	
	
}
