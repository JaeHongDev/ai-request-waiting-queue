package artisan.request.video.infra;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ExternalGenerationService {

    private final RestClient restClient;

    public ExternalGenerationService(
            @Qualifier("generationServerClient") RestClient restClient
    ) {
        this.restClient = restClient;
    }

    @Async
    public void generateVideo(){
        restClient.post().uri("/api/videos")
                .retrieve()
                .body(Void.class);
    }
}
