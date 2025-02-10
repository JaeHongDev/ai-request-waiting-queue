package artisan.request.video;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;


@Slf4j
@Service
//@Transactional
@RequiredArgsConstructor
public class VideoService {

    private final VideoRepository videoRepository;
    private final AsyncVideoService asyncVideoService;

    public String create(VideoCreateRequest request) {

        var command = new VideoCreateCommand(request.userId());
        videoRepository.save(command);
        asyncVideoService.create(request);
        command.complete();
        videoRepository.save(command);

        return "OK";
    }

}
