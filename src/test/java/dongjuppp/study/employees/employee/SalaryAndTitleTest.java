package dongjuppp.study.employees.employee;

import dongjuppp.study.employees.common.Period;
import dongjuppp.study.employees.employee.salary.Salary;
import dongjuppp.study.employees.employee.salary.SalaryRepository;
import dongjuppp.study.employees.employee.title.Title;
import dongjuppp.study.employees.employee.title.TitleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class SalaryAndTitleTest {

    @Autowired
    TitleRepository titleRepository;

    @Autowired
    SalaryRepository salaryRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    Employee messi(){
        return Employee.builder()
                .empNo(10001)
                .firstName("lionel")
                .lastName("messi")
                .salary(salary())
                .title(title())
                .gender(Gender.M)
                .build();
    }

    Salary salary(){
        Period period = new Period(new Date(), new Date());
        return Salary.builder()
                .empNo(10001)
                .period(period)
                .salary(50000)
                .build();
    }

    Title title(){
        Period period = new Period(new Date(), new Date());
        return Title.builder()
                .empNo(10001)
                .period(period)
                .title("title")
                .build();
    }

    @Test
    @DisplayName("연봉, 타이블 저장 테스트")
    void addTest(){
        Employee employee = messi();

        employeeRepository.save(employee);

        Employee fromDbEmployee = employeeRepository.getEmployeeByEmpNo(10001);

        assertThat(fromDbEmployee.getSalary()).extracting(Salary::getSalary).isEqualTo(50000L);
    }
}
