package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateLanguage;
import kodlamaio.hrms.entities.dtos.LanguageDto;

import java.util.List;

public interface CandidateLanguageService {
    DataResult<List<LanguageDto>> getDetails();
    Result add(CandidateLanguage candidateLanguage);
}
