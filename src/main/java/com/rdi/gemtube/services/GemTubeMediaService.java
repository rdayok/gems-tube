package com.rdi.gemtube.services;

import com.rdi.gemtube.data.models.Media;
import com.rdi.gemtube.data.models.User;
import com.rdi.gemtube.data.repositories.MediaRepository;
import com.rdi.gemtube.dto.requests.UploadMediaRequest;
import com.rdi.gemtube.dto.responses.UploadMediaResponse;
import com.rdi.gemtube.exceptions.GemTubeException;
import lombok.AllArgsConstructor;
import org.antlr.v4.runtime.misc.MultiMap;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GemTubeMediaService implements MediaService{

    private final CloudService cloudService;
    private final MediaRepository mediaRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Override
    public UploadMediaResponse upload(UploadMediaRequest uploadMediaRequest) throws GemTubeException {
        User user = userService.getUserById(uploadMediaRequest.getCreatorId());
        String url = cloudService.upload(uploadMediaRequest.getMultipartFile());
        Media media = modelMapper.map(uploadMediaRequest, Media.class);
        media.setUrl(url);
        media.setUploader(user);
        return buildUploadMediaResponse(media);
    }

    private UploadMediaResponse buildUploadMediaResponse(Media media) {
        Media savedMedia = mediaRepository.save(media);
        UploadMediaResponse response = new UploadMediaResponse();
        response.setMessage("Media upload successful");
        response.setMediaId(savedMedia.getId());
        return response;
    }
}
