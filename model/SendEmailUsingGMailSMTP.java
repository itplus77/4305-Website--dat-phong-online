package model;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

public class SendEmailUsingGMailSMTP {
    
    // Recipient's email ID needs to be mentioned.
    String to;//change accordingly

    // Sender's email ID needs to be mentioned
    String from = "fairybaynt@gmail.com";//change accordingly
    final String username = "fairybaynt@gmail.com";//change accordingly
    final String password = "phuong7772";//change accordingly

    boolean guithanhcong = false;

    public SendEmailUsingGMailSMTP(String email_to, String message_to) {
        this.to = email_to;
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Get the Session object.
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));

            // Set Subject: header field
            message.setSubject("Xác nhận đặt phòng", "utf-8");

            // Now set the actual message
            message.setText(message_to, "utf-8");

            // Send message
            Transport.send(message);

            System.out.println("Sent message successfully....");
            guithanhcong = true;

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isSendMail() {
        return guithanhcong;
    }
}
