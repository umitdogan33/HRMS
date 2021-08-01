package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.dtos.LanguageDto;

import java.util.List;

public interface LanguageService {
    DataResult<List<LanguageDto>> getDetails();
}
