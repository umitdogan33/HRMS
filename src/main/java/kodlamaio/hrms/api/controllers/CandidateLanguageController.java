package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CandidateLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateLanguage;
import kodlamaio.hrms.entities.dtos.LanguageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidatelanguage")
@CrossOrigin
public class CandidateLanguageController {
    private CandidateLanguageService candidateLanguageService;

    @Autowired
    public CandidateLanguageController(CandidateLanguageService candidateLanguageService) {
        this.candidateLanguageService = candidateLanguageService;
    }

    @GetMapping("/getdetails")
    public DataResult<List<LanguageDto>> getDetail(){
        return candidateLanguageService.getDetails();
    }

    @PostMapping("/add")
    public Result add(CandidateLanguage candidateLanguage){
        return candidateLanguageService.add(candidateLanguage);
    }
}
