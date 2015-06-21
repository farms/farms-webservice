package br.com.core;

import org.mindrot.jbcrypt.BCrypt;

public class FarmsCrypt {
	
	public static String hashPwd(String password){
		return BCrypt.hashpw(password, BCrypt.gensalt(12));
	}
	
	public static boolean checkPwd(String candidatePassword, String hashedPassword){
		return BCrypt.checkpw(candidatePassword, hashedPassword);
	}

}
