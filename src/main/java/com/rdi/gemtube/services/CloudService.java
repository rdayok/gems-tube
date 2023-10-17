package com.rdi.gemtube.services;

import com.rdi.gemtube.enums.Type;
import com.rdi.gemtube.exceptions.MediaUploadException;
import org.springframework.web.multipart.MultipartFile;

public interface CloudService {
    String upload(MultipartFile file) throws MediaUploadException;
}
