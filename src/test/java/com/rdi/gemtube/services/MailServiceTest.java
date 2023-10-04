package com.rdi.gemtube.services;

import com.rdi.gemtube.dto.requests.EmailRequest;
import com.rdi.gemtube.dto.requests.Recipient;
import com.rdi.gemtube.dto.requests.Sender;
import com.rdi.gemtube.dto.responses.EmailResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class MailServiceTest {

    @Autowired
    private MailService mailService;
    @Test
    public void testSendEmail() {
        EmailRequest emailRequest = new EmailRequest();
        Sender sender = new Sender();
        sender.setEmail("dayokr@gmailcom");
        sender.setName("Darda");

        Recipient recipient = new Recipient();
        recipient.setEmail("max_ret@yahoo.com");
        recipient.setName("Ret Max");
        Recipient recipient1 = new Recipient();
        recipient.setEmail("leyir20224@fesgrid.com");
        recipient.setName("Leyir Fesgrid");
        List<Recipient> recipients = List.of(
                recipient,
                recipient1
        );

        emailRequest.setSender(sender);
        emailRequest.setRecipients(recipients);
        emailRequest.setHtmlContent("<p>I am testing my application");
        emailRequest.setSubject("Testing my springboot app...");

        EmailResponse emailResponse = mailService.sendMail(emailRequest);
        assertNotNull(emailResponse);
        assertNotNull(emailResponse.getMessageId());
    }
}
