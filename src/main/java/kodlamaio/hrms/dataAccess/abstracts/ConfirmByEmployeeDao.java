package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.ConfirmByEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfirmByEmployeeDao extends JpaRepository<ConfirmByEmployee,Integer> {
}
