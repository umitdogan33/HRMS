package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.entities.concretes.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LanguageDto {
    private Language language;
}
