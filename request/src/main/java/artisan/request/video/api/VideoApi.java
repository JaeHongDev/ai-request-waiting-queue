package artisan.request.video.api;

import artisan.request.video.api.payload.GenerationVideoResponse;
import artisan.request.video.api.payload.VideoCreateRequest;
import artisan.request.video.api.payload.VideoCreateResponse;
import artisan.request.video.entity.GenerationVideo;
import artisan.request.video.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/videos")
public class VideoApi {

    private final VideoService videoService;

    @PostMapping
    public VideoCreateResponse create(@RequestBody VideoCreateRequest request){
        return videoService.create();
    }

    @GetMapping("/{id}")
    public GenerationVideoResponse get(@PathVariable("id") Long videoId){
        return videoService.find(videoId);
    }
}
