package com.tourstravels.tourstravels;

import com.tourstravels.tourstravels.services.impl.emailservice;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class TourstravelsApplication {
	@Autowired
	private HttpServletRequest req;
	private emailservice senderService;
	//String email = req.getParameter("email");//
	/*@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {
		senderService.sendSimpleEmail(email,
				"This is email body",
				"This is email subject");

	}*/

	private static final Logger log = LoggerFactory.getLogger(TourstravelsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TourstravelsApplication.class, args);
	}

}
