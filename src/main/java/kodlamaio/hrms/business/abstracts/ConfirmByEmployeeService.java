package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ConfirmByEmployee;

public interface ConfirmByEmployeeService {
    Result confirm(ConfirmByEmployee confirmByEmployee);
}
