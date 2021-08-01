package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.candidateCvDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/canidate")
@CrossOrigin
public class CandidateController {
    private CandidateService candidateService;

    @Autowired
    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Candidate canidate){
        return  this.candidateService.add(canidate);


    }

    @GetMapping("/getall")
    public DataResult<List<Candidate>> getAll(){
       return this.candidateService.getAll();
    }

    @GetMapping("/getalldetails")
    public DataResult<List<candidateCvDto>> getDetails(){
    return this.candidateService.getDetails();
    }
}
