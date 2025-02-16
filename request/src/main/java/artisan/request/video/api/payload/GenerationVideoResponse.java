package artisan.request.video.api.payload;

import artisan.request.video.entity.GenerationStatus;
import artisan.request.video.entity.GenerationVideo;

public record GenerationVideoResponse(
        Long id,
        GenerationStatus status
){

    public static GenerationVideoResponse from(GenerationVideo generationVideo) {
        return new GenerationVideoResponse(
                generationVideo.getId(),
                generationVideo.getGenerationStatus()
        );
    }
}
