package com.revature.util;

import java.nio.charset.StandardCharsets;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;


public class HashUtil {
	
	private HashUtil() {
		super();
	}
	
	public static String sha512Hash(String in) {
		Hasher hasher = Hashing.sha256().newHasher();
		hasher.putString(in, StandardCharsets.UTF_8);
		HashCode out = hasher.hash();
		
		return out.toString();
	}
}
