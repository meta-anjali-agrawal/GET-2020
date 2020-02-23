package com.metacube.Assignment1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metacube.Assignment1.mailSender.MailSender;

@RestController
public class MailController 
{
	// Uncomment @Qualifier to solve the multiple bean problem.
	// @Qualifier("smtpmailsender")
	private MailSender mailSender;
	
	/*
	  public MailController(MailSender mailSender) { 
	  	this.mailSender = mailSender;
	  }
	 */
	
	@Autowired
	public void setMailSender(MailSender smptMail) {
		this.mailSender = smptMail;
	}
	
	@GetMapping("/send")
	public String sendMail() {

		mailSender.send();

		return "Mail sent successfully!";
	}
}
