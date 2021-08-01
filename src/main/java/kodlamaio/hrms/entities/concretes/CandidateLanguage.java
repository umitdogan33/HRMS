package kodlamaio.hrms.entities.concretes;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@Entity
@NoArgsConstructor
@Table(name = "candidate_language")
public class CandidateLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name =  "candidate_id")
    private int candidateId;

    @Column(name = "language_id")
    private int languageId;

    @Min(1)
    @Max(5)
    @Column(name = "level")
    private int level;
}
