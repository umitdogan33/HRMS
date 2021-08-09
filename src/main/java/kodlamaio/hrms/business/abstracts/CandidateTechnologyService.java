package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateTechnology;

public interface CandidateTechnologyService {
    Result add(CandidateTechnology candidateTechnology);
}
