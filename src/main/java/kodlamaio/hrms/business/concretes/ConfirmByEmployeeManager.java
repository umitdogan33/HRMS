package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.ConfirmByEmployeeService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ConfirmByEmployeeDao;
import kodlamaio.hrms.entities.concretes.ConfirmByEmployee;
import kodlamaio.hrms.entities.concretes.Employers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfirmByEmployeeManager implements ConfirmByEmployeeService {
    private ConfirmByEmployeeDao confirmByEmployeeDao;

    @Autowired
    public ConfirmByEmployeeManager(ConfirmByEmployeeDao confirmByEmployeeDao) {
        this.confirmByEmployeeDao = confirmByEmployeeDao;
    }

    @Override
    public Result confirm(ConfirmByEmployee confirmByEmployee) {
       confirmByEmployeeDao.save(confirmByEmployee);
        return new SuccessResult();
    }
}
