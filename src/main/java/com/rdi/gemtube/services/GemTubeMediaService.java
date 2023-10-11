package com.rdi.gemtube.services;

import com.rdi.gemtube.data.models.Media;
import com.rdi.gemtube.data.models.User;
import com.rdi.gemtube.data.repositories.MediaRepository;
import com.rdi.gemtube.dto.requests.UploadMediaRequest;
import com.rdi.gemtube.dto.responses.UploadMediaResponse;
import com.rdi.gemtube.exceptions.GemTubeException;
import com.rdi.gemtube.exceptions.MediaUploadException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GemTubeMediaService implements MediaService{

    private final CloudService cloudService;
    private final MediaRepository mediaRepository;
    private final UserService userService;

    @Override
    public UploadMediaResponse upload(UploadMediaRequest uploadMediaRequest) throws GemTubeException {
        User user = userService.getUserById(uploadMediaRequest.getCreatorId());
        String url = cloudService.upload(uploadMediaRequest.getMultipartFile());
        Media media = new Media();
        media.setDescription(uploadMediaRequest.getDescription());
        media.setUrl(url);
        media.setDescription(uploadMediaRequest.getDescription());
        media.setTitle(uploadMediaRequest.getTitle());
        media.setUploader(user);

        mediaRepository.save(media);
        return null;
    }
}
