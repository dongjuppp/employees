package dongjuppp.study.employees.department.manager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

    Manager getManagerByEmployee_EmpNoAndDepartment_DeptNo(long empNo, long deptNo);
}
