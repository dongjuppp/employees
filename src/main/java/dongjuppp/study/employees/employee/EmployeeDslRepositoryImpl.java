package dongjuppp.study.employees.employee;

import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import dongjuppp.study.employees.employee.salary.QSalary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

import static dongjuppp.study.employees.employee.QEmployee.*;
import static dongjuppp.study.employees.employee.salary.QSalary.*;

@Repository
public class EmployeeDslRepositoryImpl implements EmployeeDslRepository{

    private final JPAQueryFactory jpaQueryFactory;

    public EmployeeDslRepositoryImpl(EntityManager em){
        this.jpaQueryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Employee> findMaxSalaryEmployee() {
        
        return jpaQueryFactory
                .selectFrom(employee)
                .where(employee.salary.salary.eq(
                        JPAExpressions
                                .select(salary1.salary.max())
                                .from(salary1)
                        ))
                .fetch();

    }
}
