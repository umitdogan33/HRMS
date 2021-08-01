package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper=false)
@PrimaryKeyJoinColumn(name = "user_id",referencedColumnName = "user_id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
@Table(name = "employers")

public class Employers extends User{

   /* @Column(name = "id")
    private int id;*/

  @NotNull(message = "webSite alanı boş bırakılamaz")
    @Column(name = "web_site")
    private String webSite;

  @NotNull(message = "companyname alanı boş bırakılamaz")
    @Column(name = "company_name")
    private String companyname;

  @NotNull(message = "phoneNumber alanı boş bırakılamaz")
    @Column(name = "phone_number")
    private String phoneNumber;

    @NotNull(message = "paswordRepeat alanı boş bırakılamaz")
    private String passwordRepeat;

    @OneToMany(mappedBy = "employer")
  private List<JobAdvertisement> jobAdvertisements;

}
