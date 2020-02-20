package com.metacube.Assignment1.mailSender;

import org.springframework.stereotype.Component;

//Uncomment @Component to make it component.
//@Component("mockmailsender")
public class MockMailSender implements MailSender 
{
	@Override
	public void send() 
	{
		// TODO Auto-generated method stub
		System.out.println("Send MockMail");
	}

}
