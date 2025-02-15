package artisan.request.video;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Slf4j
@Service
@RequiredArgsConstructor
public class AsyncVideoService {

    private final RestClient restClient;


    @Async
    public void create(VideoCreateRequest request){
        log.info("start to make video user:{}", request.userId());
        restClient.post()
                .contentType(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(Void.class);

        log.info("create video user:{}", request.userId());
    }

}
