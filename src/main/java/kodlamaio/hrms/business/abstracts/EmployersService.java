package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employers;

import java.util.List;

public interface EmployersService {
    DataResult<List<Employers>> getAll();
    Result add(Employers employers);
    DataResult<Employers> getByEmail(String email);
}
