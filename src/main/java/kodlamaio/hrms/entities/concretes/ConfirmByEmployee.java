package kodlamaio.hrms.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.lang.String;

@Data
@Entity
@Table(name = "confirm_by_employee")
public class ConfirmByEmployee {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "employers_id")
    private int employerId;
    
    @Column(name = "date")
    private LocalDate date;

    @Column(name = "isActivate")
    @JsonIgnore
    private boolean isActivate=true;

    @Column(name = "isDelete")
    @JsonIgnore
    private boolean İsDeleted=false;
}
