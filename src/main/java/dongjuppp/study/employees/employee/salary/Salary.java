package dongjuppp.study.employees.employee.salary;

import dongjuppp.study.employees.common.Period;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "salaries")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Salary {

    @Id
    @Column(name = "emp_no")
    private long empNo;

    @Column(name = "salary")
    private long salary;

    @Embedded
    private Period period;
}
