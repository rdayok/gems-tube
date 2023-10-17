package com.rdi.gemtube.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.rdi.gemtube.enums.Type;
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
    public String upload(MultipartFile multipartFile) throws MediaUploadException {
        try {
            Map<?, ?> uploadResponse = cloudinary.uploader().upload(multipartFile.getBytes(), ObjectUtils.asMap(
                    "resource_type", "auto"
            ));
            log.info("upload response -> {}", uploadResponse);
            return uploadResponse.get("secure_url").toString();
        } catch (IOException exception) {
            throw new MediaUploadException(exception.getMessage());
        }
    }
}

