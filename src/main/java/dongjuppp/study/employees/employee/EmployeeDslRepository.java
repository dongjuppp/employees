package dongjuppp.study.employees.employee;

import java.util.List;

public interface EmployeeDslRepository {

    List<Employee> findMaxSalaryEmployee();
}
