package com.example.task.controller;


import com.example.task.data.model.Bank;
import com.example.task.service.BankService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class BankController {
    private final BankService bankService;

    @GetMapping("/payment/{shop}/{amount}")
    public ResponseEntity<Bank> payment(@PathVariable("shop") String shop, @PathVariable("amount") BigDecimal amount) {
        return ResponseEntity.ok(bankService.payment(shop, amount));
    }
}
