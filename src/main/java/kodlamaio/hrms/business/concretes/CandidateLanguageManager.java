package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CandidateLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateLanguageDao;
import kodlamaio.hrms.entities.concretes.CandidateLanguage;
import kodlamaio.hrms.entities.dtos.LanguageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateLanguageManager implements CandidateLanguageService {
    private CandidateLanguageDao languageDao;

    @Autowired
    public CandidateLanguageManager(CandidateLanguageDao languageDao) {
        this.languageDao = languageDao;
    }

    @Override
    public DataResult<List<LanguageDto>> getDetails() {
        return new SuccessDataResult<List<LanguageDto>>(languageDao.getDetails());
    }

    @Override
    public Result add(CandidateLanguage candidateLanguage) {
        languageDao.save(candidateLanguage);
        return new SuccessResult("ekleme başarılı");
    }
}
