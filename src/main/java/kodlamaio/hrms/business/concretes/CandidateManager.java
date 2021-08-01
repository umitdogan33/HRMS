package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.adapters.UserCheckService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.candidateCvDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateManager implements CandidateService {
    private CandidateDao candidateDao;
    private UserCheckService userCheckService;


    @Autowired
    public CandidateManager(CandidateDao candidateDao, UserCheckService userCheckService) {
        this.candidateDao = candidateDao;
        this.userCheckService = userCheckService;

    }

    @Override
    public DataResult<List<Candidate>> getAll() {
        return null;
    }

    @Override
    public Result add(Candidate candidate) {

        if (!userCheckService.checkIfRealPerson(Long.parseLong(candidate.getNationalIdentity()), candidate.getFirstName(),candidate.getLastName()) == true) {
           return new ErrorResult();
        }
        if (!candidate.getPassword().equals(candidate.getPasswordRepeat())) {
            return new ErrorResult("parola uyuşmuyor");
        }
        if(getByNationalIdentity(candidate.getNationalIdentity())!=null){
            return new ErrorResult("zaten sisteme kayıtlısınız");
        }
        candidateDao.save(candidate);
        return new SuccessResult("ekleme başarılı");
    }

    @Override
    public DataResult<Candidate> getByNationalIdentity(String tc) {
        return candidateDao.getByNationalIdentity(tc);
    }

    @Override
    public DataResult<List<candidateCvDto>> getDetails() {
        return new SuccessDataResult<List<candidateCvDto>>(candidateDao.getDetails());
    }
}

