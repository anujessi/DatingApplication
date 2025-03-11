package com.example.dearapp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.dearapp.entity.User;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
@Service
public class EmailService {
	
	@Autowired
	
	private JavaMailSender javaMailSender;
	public void sendFirstEmail(User u) {
		MimeMessage  mimeMessage = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper =new MimeMessageHelper(mimeMessage,true);
			helper.setTo(u.getEmail());
			helper.setSubject("Account created Successfully for dear app");
			helper.setText("Dear"+u.getName()+"your Account is created Successfully  for dearApp , start your journeywith your perfect matchs here all the best,Thank you");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		javaMailSender.send(mimeMessage);
		
		
	}
}
