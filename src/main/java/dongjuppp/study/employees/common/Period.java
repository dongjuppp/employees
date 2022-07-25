package dongjuppp.study.employees.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Period {

    @Column(name = "from_date")
    @Temporal(TemporalType.DATE)
    private Date fromDate;

    @Column(name = "to_date")
    @Temporal(TemporalType.DATE)
    private Date toDate;
}
