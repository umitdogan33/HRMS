package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobTitleServie;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobTitle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobTitleManager implements JobTitleServie {
    @Override
    public DataResult<List<JobTitle>> getAll() {
        return null;
    }

    @Override
    public Result add(JobTitle jobTitle) {
        return null;
    }
}
