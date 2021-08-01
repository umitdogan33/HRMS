package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.lang.String;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper=false)
@PrimaryKeyJoinColumn(name = "id",referencedColumnName = "user_id")
@Table(name = "employees")
public class Employee extends User {

    @JsonIgnore
    @Column(name = "employees_id")
    //@Id

    private int id;

    @Column(name="first_name")
    private String firstName;


    @Column(name="last_name")
    private String lastName;



}
