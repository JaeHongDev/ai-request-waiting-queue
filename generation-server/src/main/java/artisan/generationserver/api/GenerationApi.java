package artisan.generationserver.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/videos")
public class GenerationApi {

    @PostMapping
    private void create() throws InterruptedException {
        Thread.sleep(30000);
    }
}
