package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.concretes.Employers;
import kodlamaio.hrms.entities.concretes.JobTitle;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "job_advertisement")
public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "open_position_count")
    private int openPositionCount;


    @Column(name = "min_salary")
    private double minSalary;

    @Column(name = "max_salary")
    private double maxSalary;


    @Column(name = "appeal_deadline")
    private LocalDate appealDeadline;

    @Column(name = "created_date")
    @JsonIgnore
    private LocalDate createdDate = LocalDate.now();

    @Column(name = "is_verified_by_employee", columnDefinition = "boolean default false")
    private Boolean isVerifiedByEmployee = false;


    @Column(name = "is_active", columnDefinition = "boolean default true")
    @JsonIgnore
    private Boolean isActive = true;

    @Column(name = "is_deleted", columnDefinition = "boolean default false")
    @JsonIgnore
    private Boolean isDeleted = false;

    @Column(name = "is_opened", columnDefinition = "boolean default true")
    private Boolean isOpened = true;

    //tamamlandı
    @ManyToOne
    @JoinColumn(name = "job_title_id")
    private JobTitle jobTitle;

    //tamalandı
    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employers employer;

    //tamamlandı
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
}
