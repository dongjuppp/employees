package dongjuppp.study.employees.department.manager;

import lombok.Getter;

import javax.persistence.Column;
import java.io.Serializable;

@Getter
public class ManagerId implements Serializable {

    private long employee;

    private long department;
}
