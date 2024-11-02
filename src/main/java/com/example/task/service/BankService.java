package com.example.task.service;

import com.example.task.data.model.Bank;
import com.example.task.repository.BackRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
@Slf4j
public class BankService {
    private final BackRepository backRepository;

    @Transactional
    public Bank payment(String shop, BigDecimal amount) {
        log.info("Payment of shop:{}, amount:{}", shop, amount);
        var bonusPercentage = BigDecimal.ZERO;

        var bank = backRepository.findByTypeShop(shop)
                .orElseThrow(() -> new IllegalArgumentException("Invalid shop"));

        switch (shop.toLowerCase()) {
            case "shop" -> bonusPercentage = BigDecimal.valueOf(10);
            case "online" -> bonusPercentage = BigDecimal.valueOf(17);
        }

        if (amount.compareTo(BigDecimal.valueOf(20)) >= 0) {
            bank.setLastOperationBonus(amount.multiply(bonusPercentage).divide(BigDecimal.valueOf(100)));
        } else {
            bank.setCommission(amount.multiply(BigDecimal.valueOf(0.1)));
        }

        if (amount.compareTo(BigDecimal.valueOf(300)) < 0) {
            bank.setLastOperationBonus(amount.multiply(BigDecimal.valueOf(0.3)));
        }

        bank.setTotalBonusAccount(bank.getTotalBonusAccount().add(bank.getLastOperationBonus()));
        bank.setBalance(bank.getBalance().subtract(amount));
        backRepository.save(bank);
        return bank;
    }

}
