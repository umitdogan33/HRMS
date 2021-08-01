package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobTitleServie;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobtitle")
@CrossOrigin
public class JobTitleController {
    private JobTitleServie jobTitleService;

    @Autowired
    public JobTitleController(JobTitleServie jobTitleService) {
        this.jobTitleService = jobTitleService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobTitle>> getALl(){
       return this.jobTitleService.getAll();
    }

    @GetMapping("/add")
    public Result add(@RequestBody JobTitle jobTitle){
        return this.jobTitleService.add(jobTitle);
    }
}
