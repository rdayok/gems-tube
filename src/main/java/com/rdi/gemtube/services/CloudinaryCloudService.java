package com.rdi.gemtube.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.rdi.gemtube.config.CloudinaryConfig;
import com.rdi.gemtube.exceptions.MediaUploadException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
@Slf4j
@AllArgsConstructor
public class CloudinaryCloudService implements CloudService{

    private final Cloudinary cloudinary;

    @Override
    public String upload(MultipartFile file) throws MediaUploadException {
        try {
            Map<?, ?> uploadResponse = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap());
            log.info("upload response -> {}", uploadResponse);
            return uploadResponse.get("secure_url").toString();
        } catch (IOException exception) {
            throw new MediaUploadException(exception.getMessage());
        }
    }
}

