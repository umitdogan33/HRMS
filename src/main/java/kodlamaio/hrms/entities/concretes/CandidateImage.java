package kodlamaio.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="candidate_images")
public class CandidateImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="image_id")
    private int id;

    @Column(name="user_id")
    private int userId;

    @Column(name="image_path")
    private String imagePath;
}
