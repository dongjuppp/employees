package dongjuppp.study.employees.util;

import dongjuppp.study.employees.common.Period;
import dongjuppp.study.employees.employee.Employee;
import dongjuppp.study.employees.employee.Gender;
import dongjuppp.study.employees.employee.salary.Salary;
import dongjuppp.study.employees.employee.title.Title;

import java.util.Date;

public class EmployeeMaker {

    public static Employee messi(){
        Period period = new Period(new Date(), new Date());
        return Employee.builder()
                .empNo(10001L)
                .firstName("lionel")
                .lastName("messi")
                .salary(salary())
                .title(title())
                .gender(Gender.M)
                .period(period)
                .build();
    }

    private static Salary salary(){
        Period period = new Period(new Date(), new Date());
        return Salary.builder()
                .empNo(10001L)
                .period(period)
                .salary(50000)
                .build();
    }


    private static Title title(){
        Period period = new Period(new Date(), new Date());
        return Title.builder()
                .empNo(10001L)
                .period(period)
                .title("title")
                .build();
    }
}
