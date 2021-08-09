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
            return new ErrorResult("doğrulama hatası");
        }
        if (getByEmail(employers.getEmail()) != null) {
            return new ErrorResult("zaten sistemde kayıtlısınız");
        }
        employerDao.save(employers);
        return new SuccessResult("ekleme başarılı");
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
        return new SuccessResult("onaylama başarılı");
    }

    @Override
    public Result update(Employers employer) {
        Employers updatedUser = employerDao.getByUserId(employer.getUser_id());

        updatedUser.setUpdatedData(employer);

        employerDao.save(updatedUser);
        return new SuccessResult("Güncelleme başarılı (aktivasyon için onay bekleniyor)");
    }

    @Override
    public Result updateConfirm(int userId) {
        Employers employer = employerDao.getByUserId(userId);
        if (!Objects.isNull(employer.getUpdatedData())) {
            Employers updatedData = employer.getUpdatedData();
            //Saves updated data instead of main data and deletes updated data row.
            employerDao.save(updatedData);
            return new SuccessResult("kullanıcı onay durumu Onaylandı olarak değiştirildi");
        }
        employer.setIsActive(!employer.getIsActive());
        employerDao.save(employer);
        return new SuccessResult("kullanıcı onay durumu Onaylandı olarak değiştirildi");
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
