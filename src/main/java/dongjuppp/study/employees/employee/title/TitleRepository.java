package dongjuppp.study.employees.employee.title;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleRepository extends JpaRepository<Title, Long> {

    Title getTitleByEmpNo(long empNo);
}
