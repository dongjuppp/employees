package dongjuppp.study.employees.department;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dept")
public class Department {

    @Id
    @Column(name = "dept_no")
    private long deptNo;

    @Column(name = "dept_name")
    private String deptName;
}
