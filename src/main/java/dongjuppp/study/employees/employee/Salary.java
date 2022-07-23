package dongjuppp.study.employees.employee;

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

    @Column(name = "from_date")
    private Date fromDate;

    @Column(name = "to_date")
    private Date toDate;
}
