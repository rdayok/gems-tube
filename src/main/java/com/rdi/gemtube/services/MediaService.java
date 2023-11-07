package com.rdi.gemtube.services;

import com.rdi.gemtube.data.models.Media;
import com.rdi.gemtube.dto.requests.UploadMediaRequest;
import com.rdi.gemtube.dto.responses.UploadMediaResponse;
import com.rdi.gemtube.exceptions.GemTubeException;
import com.rdi.gemtube.exceptions.MediaNotFoundException;
import com.rdi.gemtube.exceptions.MediaUploadException;
import org.springframework.web.multipart.MultipartFile;

public interface MediaService {

    UploadMediaResponse upload(UploadMediaRequest uploadMediaRequest) throws GemTubeException;

    Media getMediaById(Long mediaId) throws MediaNotFoundException;

    default UploadMediaRequest buildUploadMediaRequest(MultipartFile media,
                                                       String description,
                                                       String title,
                                                       Long uploaderId) {
        UploadMediaRequest uploadMediaRequest = new UploadMediaRequest();
        uploadMediaRequest.setMultipartFile(media);
        uploadMediaRequest.setCreatorId(uploaderId);
        uploadMediaRequest.setDescription(description);
        uploadMediaRequest.setTitle(title);
        return uploadMediaRequest;
    }

}
