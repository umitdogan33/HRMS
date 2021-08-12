package kodlamaio.hrms.core.utilities.business;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryManager implements ImageService{
    Cloudinary cloudinary;

    public CloudinaryManager() {
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "hrms2",
                "api_key", "962842892274167",
                "api_secret", "cTWLiwfzoudoF1JYzj1P3EzyEjA")); // silincek
    }


    @Override
    public DataResult<Map> upload(MultipartFile multipartFile) throws IOException {
        Map<String , Object > options = new HashMap<>();
        var allowedFormats = Arrays.asList("png","jpg","jpeg","gif");
        options.put("allowed_formats",allowedFormats);
        File file = convertToFile(multipartFile);

        Map uploader  = null;
        try {
            uploader = cloudinary.uploader().upload(file, options);
        }
        catch(Exception e) {
            return new ErrorDataResult<>(e.getMessage()); // hatanın mesajı yakala
        }

        return new SuccessDataResult<>(uploader);
    }

    @Override
    public DataResult<Map> delete(String id) throws IOException {
        return null;
    }

    private File convertToFile(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream stream = new FileOutputStream(file);
        stream.write(multipartFile.getBytes());
        stream.close();

        return file;
    }

}
