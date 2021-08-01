package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.EmployersService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employer")
@CrossOrigin
public class EmployersController {
    private EmployersService employerService;

    @Autowired
    public EmployersController(EmployersService employerService) {
        this.employerService = employerService;
    }


    @GetMapping("/getall")
    public DataResult<List<Employers>> getAll(){
       return employerService.getAll();
    }


    @PostMapping("/add")
    public Result add(@RequestBody Employers employer){
        return employerService.add(employer);
    }
}
