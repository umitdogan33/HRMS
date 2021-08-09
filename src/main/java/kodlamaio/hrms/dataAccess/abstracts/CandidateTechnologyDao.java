package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.CandidateTechnology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateTechnologyDao extends JpaRepository<CandidateTechnology,Integer> {

}
