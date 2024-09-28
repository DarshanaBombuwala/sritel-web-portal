package sritel_web_portal.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sritel_web_portal.demo.dto.BillDto;
import sritel_web_portal.demo.dto.PaymentDto;
import sritel_web_portal.demo.enums.BillStatus;
import sritel_web_portal.demo.model.Bill;
import sritel_web_portal.demo.repository.BillRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BillService {

    private final BillRepository billRepository;
    private final JwtService jwtService;

    public List<Bill> getBills(){
        return billRepository.findAll();
    }

    public void createBill(BillDto billDto){
        Bill bill = new Bill();
        bill.setAmount(billDto.getAmount());
        bill.setBillStatus(billDto.getBillStatus());
        bill.setCreatedDate(LocalDate.now());
        bill.setUserId(jwtService.extractUserId());
        bill.setServiceName(billDto.getServiceName());
        bill.setServiceId(billDto.getServiceId());
        billRepository.save(bill);
    }

    public void payBill(PaymentDto paymentDto){
        Optional<Bill> bill = billRepository.findById((long) paymentDto.getBillId());

        if(bill.isPresent()) {
            Bill newBill = bill.get();

            newBill.setBillStatus(BillStatus.COMPLETED);

            billRepository.save(newBill);
        }
    }
}
