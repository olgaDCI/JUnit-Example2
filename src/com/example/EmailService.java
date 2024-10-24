package com.example;
import java.util.logging.Logger;

public class EmailService {
    private final Logger logger;


    public EmailService(){
        logger = null;
    }

    public EmailService(Logger logger){

        this.logger = logger;
    }

    public void sendEmail(String from,  String to, String subject,  String body){
        logger.info("From" + from);
        logger.info("To" + to);
        logger.info("Subject" + subject);
        logger.info("Body" + body);

        //business logic
    }

    public boolean sendEmail(String to, String subject, String body) {
        if (to == null || !to.contains("@")) {
            return false; // Invalid email
        }
        System.out.println("Email sent to " + to + " with subject: " + subject);
        return true;
    }
}
