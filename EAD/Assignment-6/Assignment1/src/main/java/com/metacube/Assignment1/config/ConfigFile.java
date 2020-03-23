package com.metacube.Assignment1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.metacube.Assignment1.mailSender.MailSender;
import com.metacube.Assignment1.mailSender.MockMailSender;
import com.metacube.Assignment1.mailSender.SMTPMailSender;

@Configuration
public class ConfigFile 
{
	@Bean("mockMail")
	public MailSender mockMailSender()
	{
		return new MockMailSender();
	}
	
	@Bean("smptMail")
	public MailSender smptMailSender()
	{
		return new SMTPMailSender();
	}
}
