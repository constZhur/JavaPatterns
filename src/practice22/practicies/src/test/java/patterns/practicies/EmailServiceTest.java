package patterns.practicies;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import patterns.practicies.service.EmailService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class EmailServiceTest {
    private EmailService emailService;

    @Mock
    private JavaMailSender emailSender;

    @BeforeEach
    public void setUp() {
        emailService = new EmailService(emailSender);
    }

    @Test
    public void testSendEmail() {
        String className = "TestClass";
        String messageText = "Test message";
        emailService.sendEmail(className, messageText);

        ArgumentCaptor<SimpleMailMessage> argumentCaptor = ArgumentCaptor.forClass(SimpleMailMessage.class);
        Mockito.verify(emailSender).send(argumentCaptor.capture());
        SimpleMailMessage sentMessage = argumentCaptor.getValue();

        assertThat(sentMessage.getFrom()).isEqualTo("zhuravalfa08@yandex.ru");
        assertThat(sentMessage.getTo()).containsExactly("zhuravalfa08@yandex.ru");
        assertThat(sentMessage.getSubject()).isEqualTo(className + " saved at " + DateTimeFormatter.
                ofLocalizedDateTime(FormatStyle.SHORT).format(LocalDateTime.now()));
        assertThat(sentMessage.getText()).isEqualTo(messageText);
    }
}
