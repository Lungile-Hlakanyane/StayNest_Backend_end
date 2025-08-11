package com.staynest.repository;
import com.staynest.entity.BankCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BankCardRepository extends JpaRepository<BankCard, Long> {
    List<BankCard> findByLandlordId(Long landlordId);
}
