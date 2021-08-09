package kodlamaio.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="favorites")
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="favorite_id")
    private int favoriteId;

    @Column(name="user_id")
    private int userId;

    @Column(name="job_advertisement_id")
    private int jobAdvertisementId;
}
