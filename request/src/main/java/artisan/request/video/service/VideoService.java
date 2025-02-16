package artisan.request.video.service;

import artisan.request.video.api.payload.GenerationVideoResponse;
import artisan.request.video.api.payload.VideoCreateResponse;
import artisan.request.video.entity.GenerationVideo;
import artisan.request.video.infra.ExternalGenerationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class VideoService {

    private final VideoRepository videoRepository;
    private final ExternalGenerationService externalGenerationService;

    public VideoCreateResponse create() {
        var video = videoRepository.save(new GenerationVideo());

        externalGenerationService.generateVideo();

        return new VideoCreateResponse(video.getId());
    }

    @Transactional(readOnly = true)
    public GenerationVideoResponse find(Long id) {
        return videoRepository.findById(id)
                .map(GenerationVideoResponse::from)
                .orElseThrow();
    }
}
