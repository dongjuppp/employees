package dongjuppp.study.employees.department.manager;

import dongjuppp.study.employees.department.Department;
import dongjuppp.study.employees.employee.Employee;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dept_manager")
@IdClass(ManagerId.class)
public class Manager {

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_no")
    private Employee employee;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dept_no")
    private Department department;

    @Column(name = "from_date")
    private Date fromDate;

    @Column(name = "to_date")
    private Date toDate;

}
