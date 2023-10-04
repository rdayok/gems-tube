package com.rdi.gemtube.dto.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;

import java.util.List;

@Setter
public class EmailRequest {

    private Sender sender;
    @JsonProperty("to")
    private List<Recipient> recipients;

    private String subject;
    private String htmlContent;
}
