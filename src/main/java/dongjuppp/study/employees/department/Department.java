package dongjuppp.study.employees.department;

import dongjuppp.study.employees.department.manager.Manager;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dept")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Department {

    @Id
    @Column(name = "dept_no")
    private long deptNo;

    @Column(name = "dept_name")
    private String deptName;

    @Builder.Default
    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
    private List<Manager> manager = new ArrayList<>();
}
