package sritel_web_portal.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sritel_web_portal.demo.enums.BillStatus;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bill")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billId;

    private float amount;
    private LocalDate createdDate;
    private BillStatus billStatus;
    private int userId;
    private String serviceName;
    private int serviceId;
}
