package kodlamaio.hrms.core.adapters;

import java.time.LocalDate;

public interface UserCheckService {
    boolean checkIfRealPerson(long nationalityId, String firstName, String lastName);
}
