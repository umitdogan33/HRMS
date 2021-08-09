package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.FavoriteService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.FavoriteDao;
import kodlamaio.hrms.entities.concretes.Favorite;
import kodlamaio.hrms.entities.dtos.FavoriteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteManager implements FavoriteService {
    private FavoriteDao favoriteDao;

    @Autowired
    public FavoriteManager(FavoriteDao favoriteDao) {
        this.favoriteDao = favoriteDao;
    }

    @Override
    public Result add(Favorite favorite) {
        favoriteDao.save(favorite);
        return new SuccessResult("favorilere eklendi");
    }

    @Override
    public DataResult<List<Favorite>> getAll() {
        return new SuccessDataResult<List<Favorite>>(favoriteDao.findAll());
    }

    @Override
    public DataResult<FavoriteDto> getDetailByUserId(int userId) {
        return new SuccessDataResult<FavoriteDto>(favoriteDao.getDetailsByUserId(userId));
    }
}
