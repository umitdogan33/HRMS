package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

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

@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonType.class)
})
public class Employers extends User{

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

    @Column(name = "is_confirm")
    @JsonIgnore
    private Boolean isConfirm;

    @OneToMany(mappedBy = "employer")
  private List<JobAdvertisement> jobAdvertisements;


  @Type(type = "json")
  @Column(columnDefinition = "json",name = "updated_data")
  private Employers updatedData;


}
