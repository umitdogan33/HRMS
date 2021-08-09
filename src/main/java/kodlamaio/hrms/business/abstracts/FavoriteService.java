package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Favorite;
import kodlamaio.hrms.entities.dtos.FavoriteDto;

import java.util.List;

public interface FavoriteService {
    Result add(Favorite favorite);
    DataResult<List<Favorite>> getAll();
    DataResult<FavoriteDto> getDetailByUserId(int userId);
}
