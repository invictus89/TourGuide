package edu.autoar.base.sec;

import edu.autoar.base.util.Input;

public class EncEx1 {
	public static void main(String[] args) {
		String password = "1234";
		String salt = SHA256Util.generateSalt();
		String encPassword = SHA256Util.getEncrypt(password, salt);
		
		System.out.println("salt : " + salt);
		System.out.println("encPassword " + encPassword);
		System.out.println("encPassword.length: " + encPassword.length());
		
		String userPassword = Input.getString("입력 : ");
		
		String encPassword2 = SHA256Util.getEncrypt(userPassword, salt);
		if(encPassword.equals(encPassword2)) {
			//System.out.println("��ġ");
		}else {
			//System.out.println("����ġ");
		}
	}
	public EncEx1() {
		// TODO Auto-generated constructor stub
	}

}
