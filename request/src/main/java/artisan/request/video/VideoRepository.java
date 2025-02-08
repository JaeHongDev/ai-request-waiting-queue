package artisan.request.video;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<VideoCreateCommand, Long> {
}
