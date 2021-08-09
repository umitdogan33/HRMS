package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateImage;

import java.io.IOException;
import java.util.List;

public interface CandidateImageService {
    Result add(CandidateImage candidateImage) throws IOException;
    Result update(CandidateImage candidateImage);
    DataResult<List<CandidateImage>> getAll();
}
