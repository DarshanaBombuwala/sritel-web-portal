package sritel_web_portal.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sritel_web_portal.demo.dto.BillDto;
import sritel_web_portal.demo.service.BillService;

@RestController
@Controller("/bill")
@RequiredArgsConstructor
public class BillController {

    private final BillService billService;

    @GetMapping("/")
    public ResponseEntity<Object> getBills(){
        try{
            return ResponseEntity.ok(billService.getBills());
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/create")
    public ResponseEntity<Object> createBill(@RequestBody BillDto billDto){
        try{
            billService.createBill(billDto);
            return ResponseEntity.ok("Bill created successfully.");
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
