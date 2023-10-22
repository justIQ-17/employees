package employees.employees.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @SequenceGenerator(
            allocationSize = 1,
            name = "employee_sequence",
            sequenceName = "employee_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )
    private Long id;
    @NotBlank(message = "Cannot be left blank")
    private String fName;
    @NotBlank(message = "Cannot be left blank")
    private String lName;
    @Email(message = "Enter proper email")
    private String email;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private LocalDate dob;
    @NotBlank(message = "Cannot be left blank")
    private String jobTitle;
    @Pattern(regexp = "^([\\+])9989[012345789][0-9]{7}$", message = "Must be formatted: +998901234567")
    private String phoneNumber;

    @ManyToOne
    private Department department;

    public Employee(String fName, String lName, String email, LocalDate dob, String jobTitle, String phoneNumber) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.dob = dob;
        this.jobTitle = jobTitle;
        this.phoneNumber = phoneNumber;
    }

    @OneToMany(cascade = CascadeType.ALL)
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {

        this.employees.add(employee);
    }

}
