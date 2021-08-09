package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Employers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployersDao extends JpaRepository<Employers,Integer> {
    DataResult<Employers> getByEmail(String email);

    @Query("from Employers where user_id=:id")
    Employers getByUserId(int id);

    @Query("from Employers where user_id=:id and isActive=false")
    Employers getByUserIdIsActivateIsFalse(int id); //user id'ye göre getir aktif olmayanları

    List<Employers> getByUpdatedDataNotNull();


}