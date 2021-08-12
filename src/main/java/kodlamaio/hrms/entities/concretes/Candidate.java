package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper=false)
@PrimaryKeyJoinColumn(name = "user_id",referencedColumnName = "user_id")
@Table(name = "candidates")
public class Candidate extends User{

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "user_id")
    @JsonIgnore
   private int user_id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "national_identity")
    private String nationalIdentity;

    @Column(name = "year_of_birth")
    private Date yearOfBirth;

    private String passwordRepeat;


    @Column(name = "is_verified_by_email")
    @JsonIgnore
    private boolean verifiyEmail=false;


    @Column(name = "created_date")
    @JsonIgnore
    private LocalDate createDate;

    @Column(name = "is_deleted")
    @JsonIgnore
    private boolean is_deleted;

    @Column(name = "image_url")
    private String imageUrl;

    public Candidate() {
        this.createDate = LocalDate.now();
    }
}
