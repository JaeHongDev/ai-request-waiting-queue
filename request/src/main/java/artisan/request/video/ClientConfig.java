package artisan.request.video;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class ClientConfig {


    @Bean
    RestClient restClient(){
        return RestClient.create("http://localhost:8081/api/videos");
    }
}
