package com.staynest.controller;
import com.staynest.DTO.BankCardRequest;
import com.staynest.serviceImp.BankCardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cards")
public class BankCardController {
    private final BankCardService bankCardService;
    public BankCardController(BankCardService bankCardService) {
        this.bankCardService = bankCardService;
    }
    @PostMapping("/add")
    public ResponseEntity<String> addCard(@RequestBody BankCardRequest request) {
        bankCardService.saveCard(request.getLandlordId(), request.getCardholder(),
                request.getCardNumber(), request.getExpiry(), request.getCvv());
        return ResponseEntity.ok("Card saved successfully");
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getCardsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(bankCardService.getCardsByUserId(userId));
    }

    @DeleteMapping("/{cardId}")
    public ResponseEntity<String> deleteCard(@PathVariable Long cardId) {
        boolean deleted = bankCardService.deleteCardById(cardId);
        if (deleted) {
            return ResponseEntity.ok("Card deleted successfully");
        } else {
            return ResponseEntity.status(404).body("Card not found");
        }
    }

}
