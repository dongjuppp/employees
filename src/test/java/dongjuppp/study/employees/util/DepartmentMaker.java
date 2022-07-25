package dongjuppp.study.employees.util;

import dongjuppp.study.employees.department.Department;

public class DepartmentMaker {

    public static Department barcelona(){
        return Department.builder()
                .deptNo(200)
                .deptName("barcelona")
                .build();
    }
}
