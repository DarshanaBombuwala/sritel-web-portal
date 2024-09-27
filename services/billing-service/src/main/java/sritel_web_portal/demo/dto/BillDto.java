package sritel_web_portal.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sritel_web_portal.demo.enums.BillStatus;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillDto {

    private int billId;
    private float amount;
    private BillStatus billStatus;
    private int userId;
    private int serviceId;
}
