package dongjuppp.study.employees.employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Entity
@Table(name = "employees")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    private long empNo;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "hire_date")
    private Date hireDate;

    @Column(name = "birth_date")
    private Date birthDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_no")
    @MapsId
    private Salary salary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_no")
    @MapsId
    private Title title;
}
