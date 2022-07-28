package dongjuppp.study.employees.employee;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import dongjuppp.study.employees.employee.salary.QSalary;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static dongjuppp.study.employees.employee.QEmployee.*;
import static dongjuppp.study.employees.employee.salary.QSalary.*;

public class EmployeeRepositorySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    public EmployeeRepositorySupport(JPAQueryFactory jpaQueryFactory) {
        super(Employee.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public List<Employee> findEmployeeByFistName(String firstName){
        return jpaQueryFactory
                .selectFrom(employee)
                .where(employee.firstName.eq(firstName))
                .fetch();
    }

    @Transactional(readOnly = true)
    public Employee findEmployeeByEmpNo(long empNo){
        return jpaQueryFactory
                .selectFrom(employee)
                .where(employee.empNo.eq(empNo))
                .fetchOne();
    }

    @Transactional(readOnly = true)
    public List<Employee> findEmployeesBetweenEmpNo(long start,  long end){
        return jpaQueryFactory
                .selectFrom(employee)
                .where(employee.empNo.between(start, end))
                .fetch();
    }
    @Transactional(readOnly = true)
    public List<Employee> findEmployeesByGenderAndBetweenEmpNo(Gender gender, long start, long end){
        return jpaQueryFactory
                .selectFrom(employee)
                .where(employee.gender.eq(gender)
                        ,employee.empNo.between(start,end)
                )
                .fetch();
    }

    public Long findBiggestEmpNo(){
        return jpaQueryFactory.select(employee.empNo.max())
                .from(employee)
                .fetchOne();
    }

    public void printEmployeeMeta(){
        Tuple tuple = jpaQueryFactory.select(employee.empNo.max(),
                employee.empNo.sum())
                .from(employee)
                .fetchOne();

        System.out.println(tuple.get(employee.empNo.max()));
        System.out.println(tuple.get(employee.empNo.sum()));
    }

    public void printEmployeesMetaByGender(Gender gender){
        Tuple tuple = jpaQueryFactory
                .select(
                        employee.empNo.max(),
                employee.empNo.sum()
                )
                .from(employee)
                .groupBy(employee.gender)
                .having(employee.gender.eq(gender))
                .fetchOne();
    }

    public Long findEmployeeMaxSalary(){
        return jpaQueryFactory.selectFrom(employee).join(salary1)
                .fetchJoin()
                .where(
                employee.empNo.eq(salary1.empNo),
                salary1.salary.eq(salary1.salary.max()))
                .fetchOne()
                .getSalary()
                .getSalary();
    }
}
