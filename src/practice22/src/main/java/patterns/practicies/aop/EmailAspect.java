package patterns.practicies.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import patterns.practicies.service.EmailService;

@Aspect
@Component
public class EmailAspect {

    private final EmailService emailService;

    @Autowired
    public EmailAspect(EmailService emailService){
        this.emailService = emailService;
    }

    @Async
    @AfterReturning("execution(public void patterns.practicies.service..*.save(..))")
    public void sendEmail(JoinPoint joinPoint) {
        Object entity = joinPoint.getArgs()[0];
        String className = entity.getClass().getSimpleName();
        String messageText = "Object: " + entity + " successfully saved";
        emailService.sendEmail(className, messageText);
    }
}
