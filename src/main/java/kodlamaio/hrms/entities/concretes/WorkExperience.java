package kodlamaio.hrms.entities.concretes;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Data
@Entity
@NoArgsConstructor
@Table(name = "work_experiences")
public class WorkExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "candidate_id")
    private int candidateId;
    @Column(name = "company_name")
    @NotNull
    @NotBlank
    private String companyName;

    @Column(name = "position")
    @NotNull
    @NotBlank
    private String position;

    @Column(name = "started_date")
    @NotNull
    @NotBlank
    private Date startedDate;

    @Column(name = "end_date")
    private Date endDate;
}
