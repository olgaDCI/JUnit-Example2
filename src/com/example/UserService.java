package com.example;

public class UserService {

    public void deleteUser(String userId) {
        System.out.println("User with ID " + userId + " deleted.");
        sendDeletionNotification(userId);
    }

    public void sendDeletionNotification(String userId) {
        EmailService emailService = new EmailService();
        emailService.sendEmail("user@example.com", "Unsubscription", "Unsubscription Body");
        System.out.println("Notification sent to user with ID " + userId);
    }

}
