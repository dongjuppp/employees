package dongjuppp.study.employees.manager;

import dongjuppp.study.employees.common.Period;
import dongjuppp.study.employees.department.Department;
import dongjuppp.study.employees.department.DepartmentRepository;
import dongjuppp.study.employees.department.manager.Manager;
import dongjuppp.study.employees.department.manager.ManagerRepository;
import dongjuppp.study.employees.employee.Employee;
import dongjuppp.study.employees.employee.EmployeeRepository;
import dongjuppp.study.employees.util.DepartmentMaker;
import dongjuppp.study.employees.util.EmployeeMaker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ManagerTest {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private ManagerRepository managerRepository;

    @Test
    void addManagerTableTest(){
        Employee messi = EmployeeMaker.messi();
        Department barca = DepartmentMaker.barcelona();

        Manager origin = new Manager(messi, barca, new Period(new Date(), new Date()));

        entityManager.persist(messi);
        entityManager.persist(barca);
        entityManager.persist(origin);

        Manager manager = managerRepository
                .getManagerByEmployee_EmpNoAndDepartment_DeptNo(messi.getEmpNo(), barca.getDeptNo());

        assertThat(manager.getEmployee().getEmpNo()).isEqualTo(messi.getEmpNo());
        assertThat(manager.getEmployee().getLastName()).isEqualTo(messi.getLastName());
        assertThat(manager.getEmployee() != messi).isFalse();
    }
}
