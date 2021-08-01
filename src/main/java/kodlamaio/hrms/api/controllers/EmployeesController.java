package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.EmployeesService;
import kodlamaio.hrms.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin
public class EmployeesController {
    private EmployeesService employeesService;

    @Autowired
    public EmployeesController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    @PostMapping("/add")
    public void add(@RequestBody Employee employee) {

         this.employeesService.add(employee);

    }
}
