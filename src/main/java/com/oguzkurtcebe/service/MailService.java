package com.oguzkurtcebe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.oguzkurtcebe.notalma.HomeController;

@Service
public class MailService {
    @Autowired
	private MailSender mailSender;

	public void registerMail(String mail,String key) {
		SimpleMailMessage email=new SimpleMailMessage();
		
		email.setFrom("aktivasyonhesabi@gmail.com");
		email.setTo(mail);
		email.setSubject("�yeli�i Tamamla");
		email.setText("�yeli�i tamamlamak i�in A�a��daki linke t�klay�n�z.\n\n"
		+HomeController.url+"/reg/"+key);
		mailSender.send(email);
		
	}
}
