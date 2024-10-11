package sritel_web_portal.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {

    private long cardNumber;
    private String cardName;
    private String expiryDate;
    private int cvv;
    private float amount;
    private int billId;
}
