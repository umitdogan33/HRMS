package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Employers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployersDao extends JpaRepository<Employers,Integer> {
    DataResult<Employers> getByEmail(String email);
}