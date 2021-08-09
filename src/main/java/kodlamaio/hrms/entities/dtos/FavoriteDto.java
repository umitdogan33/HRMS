package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FavoriteDto {
    private JobAdvertisement jobAdvertisement;
}
