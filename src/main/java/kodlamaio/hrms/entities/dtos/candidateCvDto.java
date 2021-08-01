package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.entities.concretes.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class candidateCvDto {
    private Candidate candidate;
    private CoverLetter coverLetter;
      private School school;
     private SchoolPart schoolPart;
    private Technology technology ;
    private WorkExperience workExperience;
}
