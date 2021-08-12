package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.adapters.UserCheckService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.business.ImageService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.candidateCvDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class CandidateManager implements CandidateService {
    private CandidateDao candidateDao;
    private ImageService imageService;
    private UserCheckService userCheckService;

    @Autowired
    public CandidateManager(CandidateDao candidateDao, UserCheckService userCheckService,ImageService imageService) {
        this.candidateDao = candidateDao;
        this.userCheckService = userCheckService;
        this.imageService = imageService;
    }

    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<List<Candidate>>(candidateDao.findAll());
    }

    @Override
    public Result add(Candidate candidate) {
        if (!userCheckService.checkIfRealPerson(Long.parseLong(candidate.getNationalIdentity()), candidate.getFirstName(),candidate.getLastName()) == true) {
            return new ErrorResult();
        }
        if(candidate.getImageUrl()==null){
            candidate.setImageUrl("https://res.cloudinary.com/hrms2/image/upload/v1628762734/yqrp76mwuboxms6nztpm.png");
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

    @Override
    public Result imageUpload(int candidateId, MultipartFile file) throws IOException {
        var candidate = this.candidateDao.getByUser_id(candidateId);
        var imageUrl = uploadImageToCloudinary(file, candidate.getImageUrl());
        var result = BusinessRules.Run(checkCandidateHadImageUrl(imageUrl.getMessage(),candidate.getImageUrl()));

        if (!result.isSuccess()){
            return new ErrorDataResult<>(null, result.getMessage());
        }if (!imageUrl.isSuccess()){
            return new ErrorDataResult<>(null, imageUrl.getMessage());
        }
        candidate.setImageUrl(imageUrl.getMessage());
        return new SuccessDataResult<>(this.candidateDao.save(candidate));
    }


    private Result checkCandidateHadImageUrl(String newUrl, String oldUrl){
        if(oldUrl != null && newUrl == null){
            return new ErrorResult("Image must be required");
        }
        return new SuccessResult();
    }


    private  Result uploadImageToCloudinary( MultipartFile file, String imageUrl) throws IOException {

        var result = this.imageService.upload(file);
        if(!result.isSuccess()){
            return new ErrorResult(result.getMessage());
        }
        if(imageUrl != null){
            var imageId = imageUrl.split(("/"))[imageUrl.split(("/")).length - 1].split("\\.")[0];
            this.imageService.delete(imageId);
        }
        var url = result.getData().get("url");
        return new SuccessResult(url.toString());
    }
}
