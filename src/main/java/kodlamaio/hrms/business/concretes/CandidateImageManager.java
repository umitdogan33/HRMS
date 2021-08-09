package kodlamaio.hrms.business.concretes;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import kodlamaio.hrms.business.abstracts.CandidateImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateImageDao;
import kodlamaio.hrms.entities.concretes.CandidateImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class CandidateImageManager implements CandidateImageService{
    private CandidateImageDao candidateImageDao;

    @Autowired
    public CandidateImageManager(CandidateImageDao candidateImageDao) {
        this.candidateImageDao = candidateImageDao;
    }

    @Override
    public Result add(IFormF,CandidateImage candidateImage) throws IOException {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "hrms2",
                "api_key", "962842892274167",
                "api_secret", "cTWLiwfzoudoF1JYzj1P3EzyEjA",
                "secure", true));

        File file = new File(candidateImage.getImagePath());
        var result = file.isDirectory();
        Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());

    var url = uploadResult.get("url");
    candidateImage
        candidateImageDao.save(candidateImage);
        return new SuccessResult();
    }

    @Override
    public Result update(CandidateImage candidateImage) {
        return null;
    }

    @Override
    public DataResult<List<CandidateImage>> getAll() {
        return null;
    }
}
