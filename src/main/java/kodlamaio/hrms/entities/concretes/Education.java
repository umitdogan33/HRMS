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
@Table(name = "educations")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "candidate_id")
    private int candidateId;

    @Column(name = "school_id")
    private int schoolId;

    @Column(name = "school_part_id")
    private int schoolPartId;


    @Column(name = "started_year")
    @NotNull
    @NotBlank
    private Date startedYear;

    @Column(name = "graduated_year")
    private Date graduatedYear;

}
