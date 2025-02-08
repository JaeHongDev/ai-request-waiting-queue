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
    private final RestClient restClient;

    public String create(VideoCreateRequest request) {

        var command = new VideoCreateCommand(request.userId());
        videoRepository.save(command);

        log.info("start to make video user:{}", request.userId());
        restClient.post()
                .contentType(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(Void.class);

        log.info("create video user:{}", request.userId());
        command.complete();
        videoRepository.save(command);

        return "OK";
    }


}
