package com.example.task.repository;

import com.example.task.data.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BackRepository extends JpaRepository<Bank, UUID> {
    Optional<Bank> findByTypeShop(String typeShop);
}
