package kodlamaio.hrms.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
@Inheritance(strategy=InheritanceType.JOINED)

@Data


public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="user_id")
    private int user_id;

    @Column(name="email")
   /* @Email
    @NotBlank
    @NotNull */
    private String email;


    @Column(name="password")
   // @NotBlank
    //@NotNull
   // @JsonIgnore
    private String password;

    @Column(name="is_active",columnDefinition = "boolean default true")
    private Boolean isActive=true;

    @JsonIgnore
    @Column(name="created_date")
    private LocalDate createdDate=LocalDate.now();

    @JsonIgnore
    @Column(name="is_deleted",columnDefinition = "boolean default false")
    private Boolean isDeleted= false;

}