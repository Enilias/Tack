package com.example.task.data.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Setter
@Getter
@Entity(name = "bank")
@Builder
@EqualsAndHashCode(exclude = {"id", "typeShop", "balance", "lastOperationBonus", "totalBonusAccount", "commission"})
@NoArgsConstructor
@AllArgsConstructor
public class Bank {
    @Id
    @UuidGenerator
    private UUID id;
    @Column(name = "type_shop")
    private String typeShop;
    @Column(name = "balance")
    private BigDecimal balance;
    @Column(name = "last_operation_bonus")
    private BigDecimal lastOperationBonus;
    @Column(name = "total_bonus_account")
    private BigDecimal totalBonusAccount;
    @Column(name = "commission")
    private BigDecimal commission;

}
