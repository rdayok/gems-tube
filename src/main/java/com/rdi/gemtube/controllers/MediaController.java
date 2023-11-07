package com.rdi.gemtube.controllers;

import com.rdi.gemtube.dto.requests.UploadMediaRequest;
import com.rdi.gemtube.exceptions.GemTubeException;
import com.rdi.gemtube.services.MediaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@RestController
@RequestMapping("/api/v1/media")
@AllArgsConstructor
public class MediaController {

    private final MediaService mediaService;

    @PostMapping(consumes = MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadMedia(@RequestParam MultipartFile media,
                                         @RequestParam String description,
                                         @RequestParam String title,
                                         @RequestParam("creator") Long id) throws GemTubeException {
        UploadMediaRequest request = mediaService.buildUploadMediaRequest(media, description, title, id);
        var response = mediaService.upload(request);
        return ResponseEntity.ok(request);
    }

}
