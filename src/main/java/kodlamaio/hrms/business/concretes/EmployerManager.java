package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployersService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.EmployersDao;
import kodlamaio.hrms.entities.concretes.Employers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployersService {
    EmployersDao employerDao;

    @Autowired
    public EmployerManager(EmployersDao employerDao) {
        this.employerDao = employerDao;
    }

    @Override
    public DataResult<List<Employers>> getAll() {
        return new SuccessDataResult<List<Employers>>(employerDao.findAll());
    }

    @Override
    public Result add(Employers employers) {
        if (!employers.getPassword().equals(employers.getPasswordRepeat())) {
            return new ErrorResult("doğrulama hatası");
        }
        if (getByEmail(employers.getEmail()) != null) {
            return new ErrorResult("zaten sistemde kayıtlısınız");
        }
        employerDao.save(employers);
        return new SuccessResult("ekleme başarılı ");
    }

    @Override
    public DataResult<Employers> getByEmail(String email) {
        return this.employerDao.getByEmail(email);
    }

}
