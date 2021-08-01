package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployeesService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.EmployeesDao;
import kodlamaio.hrms.entities.concretes.Employee;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.String;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;

@Service
public class EmployeesManager implements EmployeesService{
    private EmployeesDao employeesDao;

    @Autowired
    public EmployeesManager(EmployeesDao employeesDao) throws UnknownHostException {
        this.employeesDao = employeesDao;
    }



    @Override
    public DataResult<List<Employee>> getAll() {
        return new SuccessDataResult<List<Employee>>(employeesDao.findAll());
    }

    @Override
    public Result add(Employee employee) {
        this.employeesDao.save(employee);
       return new SuccessResult("ekleme başarılı");

    }


}
