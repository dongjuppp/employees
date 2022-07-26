package dongjuppp.study.employees.employee;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class EmployeeRepositorySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    public EmployeeRepositorySupport(JPAQueryFactory jpaQueryFactory) {
        super(Employee.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public List<Employee> findEmployeeByFistName(String firstName){
        return jpaQueryFactory
                .selectFrom(QEmployee.employee)
                .where(QEmployee.employee.firstName.eq(firstName))
                .fetch();
    }
}
