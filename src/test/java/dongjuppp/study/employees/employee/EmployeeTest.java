package dongjuppp.study.employees.employee;

import dongjuppp.study.employees.common.Period;
import dongjuppp.study.employees.config.TestDslConfig;
import dongjuppp.study.employees.employee.salary.Salary;
import dongjuppp.study.employees.employee.title.Title;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(TestDslConfig.class)
class EmployeeTest {
    @Autowired
    EmployeeRepository repository;

    Employee rooney(){
        Period period = new Period(new Date(), new Date());

        return Employee.builder()
                .empNo(10001L)
                .firstName("wayne")
                .lastName("rooney")
                .period(period)
                .title(title())
                .salary(salary())
                .build();
    }

    Salary salary(){
        Period period = new Period(new Date(), new Date());
        return Salary.builder()
                .empNo(10001L)
                .period(period)
                .salary(50000)
                .build();
    }

    Title title(){
        Period period = new Period(new Date(), new Date());
        return Title.builder()
                .empNo(10001L)
                .period(period)
                .title("title")
                .build();
    }

    @Test
    @DisplayName("사원 일반 추가 테스트")
    void addEmployeeTest(){
        Employee rooney = rooney();

        repository.save(rooney);

        Employee fromDbRooney = repository.getEmployeeByEmpNo(rooney.getEmpNo());

        assertThat(fromDbRooney.getSalary().getSalary()).isEqualTo(50000);

        assertThat(fromDbRooney)
                .isNotNull()
                .extracting(Employee::getFirstName)
                .isEqualTo(rooney.getFirstName());
    }


    @Test
    @DisplayName("최대 연봉 사원 조회 테스트")
    void findMaxSalaryEmployeeTest(){
        Employee employee = rooney();

        repository.save(employee);

        List<Employee> employees = repository.findMaxSalaryEmployee();

        assertThat(employees.size()).isEqualTo(1);
    }

}