package com.pankajcreation.flightreservation.utilmail;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;


@Component
public class Emailutilsendingconfig {

	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(Emailutilsendingconfig.class);

	
	@Autowired
	private JavaMailSender mailSender;
	
	public void mailsenderflight(String toaddress, String filepath )
	{
		logger.info("this is inside of this method -> mailsenderflight() ");
		
		MimeMessage message = this.mailSender.createMimeMessage();
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);//true for multiple parts attached with the message and want to send message.
			
			helper.setTo(toaddress);
			helper.setSubject("Itinerary for your Flight");
			helper.setText("Please flight your Itinerary attached.");
			helper.addAttachment("Itineary", new File(filepath));
			
			
			mailSender.send(message);
			
			
		
		}
		
		catch (MessagingException e)
		{
			// TODO Auto-generated catch block
			
			
			logger.error("exception is happen in this method mailsenderflight()"+e);
		}
	}
	
	
	
}
