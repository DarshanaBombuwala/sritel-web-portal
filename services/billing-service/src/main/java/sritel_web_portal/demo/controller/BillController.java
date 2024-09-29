package sritel_web_portal.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sritel_web_portal.demo.dto.BillDto;
import sritel_web_portal.demo.dto.PaymentDto;
import sritel_web_portal.demo.service.BillService;

@RestController
@RequestMapping("bill")
@RequiredArgsConstructor
public class BillController {

    private final BillService billService;

    @GetMapping("/")
    public ResponseEntity<Object> getBills(){
        try{
            System.out.println(1);
            return ResponseEntity.ok(billService.getBills());
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<String> createBill(@RequestBody BillDto billDto){
        try{
            System.out.println(billDto);
            billService.createBill(billDto);
            return ResponseEntity.ok("Bill created successfully.");
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping("/pay")
    public ResponseEntity<Object> payBill(@RequestBody PaymentDto paymentDto){
        try{
            billService.payBill(paymentDto);
            return ResponseEntity.ok("Payment created successfully.");
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
