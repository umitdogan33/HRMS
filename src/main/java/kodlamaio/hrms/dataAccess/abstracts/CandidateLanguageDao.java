package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.CandidateLanguage;
import kodlamaio.hrms.entities.dtos.LanguageDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidateLanguageDao extends JpaRepository<CandidateLanguage,Integer> {
    @Query("select new kodlamaio.hrms.entities.dtos.LanguageDto(l) from Candidate c inner join CandidateLanguage cl on cl.candidateId=c.id inner join Language l on l.id=cl.languageId")
    List<LanguageDto> getDetails();
}
