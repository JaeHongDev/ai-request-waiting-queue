package artisan.request.video.service;

import artisan.request.video.entity.GenerationVideo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<GenerationVideo, Long> {
}
