package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.FavoriteService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Favorite;
import kodlamaio.hrms.entities.dtos.FavoriteDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteManager implements FavoriteService {
    @Override
    public Result add(Favorite favorite) {
        return null;
    }

    @Override
    public DataResult<List<Favorite>> getAll() {
        return null;
    }

    @Override
    public DataResult<FavoriteDto> getDetailByUserId(int userId) {
        return null;
    }
}
