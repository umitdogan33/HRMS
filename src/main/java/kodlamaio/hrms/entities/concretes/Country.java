package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "countries")
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","city"})

public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String countryName;

    @OneToMany(mappedBy = "country")
    private List<City> city;
}
