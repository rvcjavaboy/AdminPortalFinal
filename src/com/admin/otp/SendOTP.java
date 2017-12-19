package com.admin.otp;

public class SendOTP {
	
	/*
	 * Sends the Account verification message to admin
	 */
	public boolean sendMessage(String mobile_no,int otp) {
		
		new AccountVerficationSMS(mobile_no,otp);
		
		return true;
	}
	/*
	 * generates 6 digit random number
	 */
	public int getOTP() {
		int otp= 100000 + (int)(Math.random() * 999999); 
		return otp;
		
	}
}
