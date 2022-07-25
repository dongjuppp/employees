package dongjuppp.study.employees.employee;

import dongjuppp.study.employees.common.Period;
import dongjuppp.study.employees.department.manager.Manager;
import dongjuppp.study.employees.employee.salary.Salary;
import dongjuppp.study.employees.employee.title.Title;
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
    @Column(name = "emp_no")
    private long empNo;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "fromDate",column = @Column(name = "birth_date")),
            @AttributeOverride(name = "toDate",column = @Column(name = "hire_date"))
    })
    private Period period;

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

    @Builder.Default
    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Manager> manager = new ArrayList<>();
}
