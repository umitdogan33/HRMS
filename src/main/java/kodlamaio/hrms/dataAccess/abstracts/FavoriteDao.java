package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.Favorite;
import kodlamaio.hrms.entities.dtos.FavoriteDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FavoriteDao extends JpaRepository<Favorite,Integer> {
    @Query("select new kodlamaio.hrms.entities.dtos.FavoriteDto(j) from Favorite f inner join Candidate c on c.user_id = f.userId inner join JobAdvertisement j on j.id = f.jobAdvertisementId where f.userId =:userId")
    FavoriteDto getDetailsByUserId(int userId);

    Favorite getByUserIdAndJobAdvertisementId(int userId,int jobId);
}
