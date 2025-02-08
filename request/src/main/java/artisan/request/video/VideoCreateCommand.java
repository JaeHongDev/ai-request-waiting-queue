package artisan.request.video;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity @NoArgsConstructor
public class VideoCreateCommand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private boolean isComplete;

    public VideoCreateCommand(Long userId) {
        this.userId = userId;
        this.isComplete = false;
    }

    public void complete(){
        this.isComplete = true;
    }
}
