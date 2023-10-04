package com.rdi.gemtube.services;

import com.rdi.gemtube.dto.requests.EmailRequest;
import com.rdi.gemtube.dto.responses.EmailResponse;

public interface MailService {
    EmailResponse sendMail(EmailRequest emailRequest);
}
