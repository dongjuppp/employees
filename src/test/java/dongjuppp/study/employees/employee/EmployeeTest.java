package dongjuppp.study.employees.employee;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class EmployeeTest {

    @Autowired
    EmployeeRepository repository;

    Employee rooney(){
        return Employee.builder()
                .empNo(10001)
                .firstName("wayne")
                .lastName("rooney")
                .birthDate(new Date())
                .hireDate(new Date())
                .build();
    }

    @Test
    @DisplayName("사원 일반 추가 테스트")
    void addEmployeeTest(){
        Employee rooney = rooney();

        repository.save(rooney);

        Employee fromDbRooney = repository.getEmployeeByEmpNo(rooney.getEmpNo());

        assertThat(fromDbRooney)
                .isNotNull()
                .extracting(Employee::getFirstName)
                .isEqualTo(rooney.getFirstName());
    }

}