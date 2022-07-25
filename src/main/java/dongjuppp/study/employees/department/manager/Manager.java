package dongjuppp.study.employees.department.manager;

import dongjuppp.study.employees.common.Period;
import dongjuppp.study.employees.department.Department;
import dongjuppp.study.employees.employee.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dept_manager")
@IdClass(ManagerId.class)
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Manager {

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_no")
    private Employee employee;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dept_no")
    private Department department;

    @Embedded
    private Period period;

}
