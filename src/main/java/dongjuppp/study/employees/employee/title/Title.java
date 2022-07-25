package dongjuppp.study.employees.employee.title;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "titles")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Title {

    @Id
    @Column(name = "emp_no")
    private long empNo;


    @Column(name = "title")
    private String title;

    @Column(name = "from_date")
    private Date fromDate;

    @Column(name = "to_date")
    private Date toDate;
}
