package com.neeraja.ShareMyOffer.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.neeraja.ShareMyOffer.config.TwilioProperties;
import com.twilio.Twilio;

import com.twilio.rest.verify.v2.service.Verification;
import com.twilio.rest.verify.v2.service.VerificationCheck;


import lombok.extern.slf4j.Slf4j;



@Slf4j
@Service
public class TwilioAuthServiceImpl implements AuthService
{
	
	@Autowired
	TwilioProperties twilioProps;
	
	Logger log=LoggerFactory.getLogger(TwilioAuthServiceImpl.class);

	
	@Override
	public boolean sendOtp(String mobileNumber) 
	{
		// TODO Auto-generated method stub
		
		Twilio.init(twilioProps.getAccSid(), twilioProps.getAuthToken());
		try
	      {
			Verification verification = Verification.creator(twilioProps.getServiceSid(), mobileNumber,"sms").create();
			log.info("Otp Sent Successfully");
	        return true;
	      }
	      
	     catch(Exception exception)
	     {
	    	 log.info("Couldn't send Otp to the number");
	    	  return false;
	     }
		
	}

	@Override
	public boolean verifyOtp(String mobileNumber, String Otp) 
	{
		// TODO Auto-generated method stub
		
		Twilio.init(twilioProps.getAccSid(), twilioProps.getAuthToken());
		VerificationCheck verificationCheck = VerificationCheck
												.creator(twilioProps.getServiceSid(),Otp)
												.setTo(mobileNumber).create();

		
		
        if(verificationCheck.getStatus().equals("approved"))
        {
        	log.info("Otp verified successfully");
        	
        	return true;
		}
        else
        {
        	log.info("Invalid otp entered");
        	return false;
        }
	
		
		
	}

}
	
	

