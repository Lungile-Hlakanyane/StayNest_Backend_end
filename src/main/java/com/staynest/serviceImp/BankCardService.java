package com.staynest.serviceImp;
import com.staynest.entity.BankCard;
import com.staynest.repository.BankCardRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BankCardService {
    private final BankCardRepository bankCardRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public BankCardService(BankCardRepository bankCardRepository) {
        this.bankCardRepository = bankCardRepository;
    }
    public BankCard saveCard(Long landlordId, String cardholder, String cardNumber, String expiry, String cvv) {
        BankCard bankCard = new BankCard();
        bankCard.setLandlordId(landlordId);
        bankCard.setCardholder(cardholder);
        bankCard.setExpiry(expiry);
        // Store last 4 digits separately
        String last4 = cardNumber.substring(cardNumber.length() - 4);
        bankCard.setLast4Digits(last4);
        // Hash sensitive data
        bankCard.setCardNumberHash(passwordEncoder.encode(cardNumber));
        bankCard.setCvvHash(passwordEncoder.encode(cvv));
        return bankCardRepository.save(bankCard);
    }
    public Object getCardsByUserId(Long userId) {
        return bankCardRepository.findByLandlordId(userId);
    }

    public boolean deleteCardById(Long cardId) {
        if (bankCardRepository.existsById(cardId)) {
            bankCardRepository.deleteById(cardId);
            return true;
        }
        return false;
    }
}
