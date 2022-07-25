package dongjuppp.study.employees.employee.salary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long> {

    Salary getSalariesByEmpNo(long empNo);
}
