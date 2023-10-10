package com.rdi.gemtube.dto.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Setter
@Getter
public class EmailRequest {
    private final Sender sender;
    @JsonProperty("to")
    private List<Recipient> recipients;
    private String htmlContent;
    private String subject;

    public EmailRequest() {
        this.sender = new Sender("gemstube@hotmail.africa", "rd industries");
    }
}
