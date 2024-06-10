package com.inhyekang.myfintech.entity.product;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private DepositType type;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String company;

    private String maxRate;

    private String defaultRate;

    private String target;

    @Column(nullable = false)
    private boolean isProtected;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String detail;

    @Column(nullable = false)
    private Long URL;

    @Column(nullable = false)
    private boolean isBankingSector;
}