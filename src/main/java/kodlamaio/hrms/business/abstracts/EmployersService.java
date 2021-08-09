package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employers;

import java.util.List;

public interface EmployersService {
    DataResult<List<Employers>> getAll();
    Result add(Employers employers);
    DataResult<Employers> getByEmail(String email);
    Result confirmEmployer(int id);
     Result update(Employers employer);
     Result updateConfirm(int userId);
     DataResult<Employers> getByUserId(int id);
   DataResult<List<Employers>> getByUpdatedDataNotNull();
}
