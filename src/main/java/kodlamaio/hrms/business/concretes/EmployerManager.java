package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployersService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.EmployersDao;
import kodlamaio.hrms.entities.concretes.Employers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
            return new ErrorResult("do�rulama hatas�");
        }
        if (getByEmail(employers.getEmail()) != null) {
            return new ErrorResult("zaten sistemde kay�tl�s�n�z");
        }
        employerDao.save(employers);
        return new SuccessResult("ekleme ba�ar�l� ");
    }

    @Override
    public DataResult<Employers> getByEmail(String email) {
        return this.employerDao.getByEmail(email);
    }

    @Override
    public Result confirmEmployer(int id) {
        Employers employer = employerDao.getByUserId(id);
        employer.setIsConfirm(true);
        employerDao.save(employer);
        return new SuccessResult("onaylama ba�ar�l�");
    }

    @Override
    public Result update(Employers employer) {
        Employers updatedUser = employerDao.getByUserId(employer.getUser_id());

        updatedUser.setUpdatedData(employer);

        employerDao.save(updatedUser);
        return new SuccessResult("G�ncelleme ba�ar�l� (aktivasyon i�lemi i�in l�tfen bekleyin.)");
    }

    @Override
    public Result updateConfirm(int userId) {
        Employers employer = employerDao.getByUserId(userId);
        if (!Objects.isNull(employer.getUpdatedData())) {
            Employers updatedData = employer.getUpdatedData();
            //Saves updated data instead of main data and deletes updated data row.
            employerDao.save(updatedData);
            return new SuccessResult("Kullan�c� onay durumu 'Onayland�' olarak de�i�tirildi!");
        }
        employer.setIsActive(!employer.getIsActive());
        employerDao.save(employer);
        return new SuccessResult("Kullan�c� onay durumu 'Onayland�' olarak de�i�tirildi!");
    }

    @Override
    public DataResult<Employers> getByUserId(int id) {
        return new SuccessDataResult<Employers>(employerDao.getByUserId(id));
    }

    @Override
    public DataResult<List<Employers>> getByUpdatedDataNotNull() {
        return new SuccessDataResult<List<Employers>>(employerDao.getByUpdatedDataNotNull());
    }
}
