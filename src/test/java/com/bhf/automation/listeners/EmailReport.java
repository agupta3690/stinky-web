package com.bhf.automation.listeners;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import javax.activation.*;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.bhf.automation.dataProvider.ConfigFileReader;
import com.bhf.automation.runner.TestRunner;



public class EmailReport {
	
	ConfigFileReader configFileReader = new ConfigFileReader();


	public void EmailReport() throws IOException {

		final String username = "pranjal.yadav.argildx@gmail.com";
		final String password = "Passtest123$";
		Properties props = new Properties();
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		java.util.Date date = new java.util.Date();
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("pranjal.yadav.argildx@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("arun.gupta@argildx.com"));
			
			message.setSubject("On "+date+" The testcases have been executed");
			message.setText("PFA");
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			Multipart multipart = new MimeMultipart();
			messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText("Please find attached the execution report.");
			messageBodyPart.attachFile(new File(TestRunner.filePath));
//			String file = "C:/Users/Arun Gupta/Argil DX LLC/Pulkit Jain - Reports/";
//			String fileName = "report_"+configFileReader.getTimeStamp()+".html";
//			DataSource source = new FileDataSource(file);
//			messageBodyPart.setDataHandler(new DataHandler(source));
//			messageBodyPart.setFileName(fileName);
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
			System.out.println("Sending Reports over email");
			Transport.send(message);
			System.out.println("Done");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}

