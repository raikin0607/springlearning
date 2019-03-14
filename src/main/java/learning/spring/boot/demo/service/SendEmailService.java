package learning.spring.boot.demo.service;

import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.io.IOException;

@Service
public interface SendEmailService {
    boolean sendMail() throws MessagingException, IOException;
}
