package patterns.practicies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Service
public class EmailService {

    private JavaMailSender emailSender;

    public EmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    //public EmailService(JavaMailSenderImpl emailSender) {
        //this.emailSender = emailSender;
    //}

    @Async
    public void sendEmail(String className, String messageText) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("zhuravalfa08@yandex.ru");
        message.setTo("zhuravalfa08@yandex.ru");
        message.setSubject(className + " saved at " + DateTimeFormatter.
                ofLocalizedDateTime(FormatStyle.SHORT).format(LocalDateTime.now()));
        message.setText(messageText);
        emailSender.send(message);
    }
}
