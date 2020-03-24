package com.metacube.Assignment1.mailSender;

//Uncomment @Component to make it component.
//@Component("smtpmailsender")
//@Primary
public class SMTPMailSender implements MailSender
{
	@Override
	public void send() 
	{
		// TODO Auto-generated method stub
		System.out.println("Send SMTP Mail");
	}

}
