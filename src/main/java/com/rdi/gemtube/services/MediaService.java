package com.rdi.gemtube.services;

import com.rdi.gemtube.dto.requests.UploadMediaRequest;
import com.rdi.gemtube.dto.responses.UploadMediaResponse;
import com.rdi.gemtube.exceptions.GemTubeException;
import com.rdi.gemtube.exceptions.MediaUploadException;

public interface MediaService {

    UploadMediaResponse upload(UploadMediaRequest uploadMediaRequest) throws GemTubeException;
}
