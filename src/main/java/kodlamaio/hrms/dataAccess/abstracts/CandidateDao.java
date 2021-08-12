package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.candidateCvDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidateDao extends JpaRepository<Candidate,Integer> {
    DataResult<Candidate> getByEmail(String email);
    DataResult<Candidate> getByNationalIdentity(String tc);

    @Query("select new kodlamaio.hrms.entities.dtos.candidateCvDto(cd,cvl,s,sp,t,we) from Candidate cd inner join Education e on e.candidateId =cd.user_id join School s on s.id = e.schoolId inner join SchoolPart sp on sp.id = e.schoolPartId inner join CandidateTechnology ct on ct.candidateId = cd.user_id inner join Technology t on t.id = ct.technologyId inner join CoverLetter cvl on cvl.candidateId = cd.user_id inner join WorkExperience we on we.candidateId = cd.user_id")
    List<candidateCvDto> getDetails();

    @Query("from Candidate c where c.user_id=:userId")
    Candidate getByUser_id(int userId);
}
