package com.inhyekang.myfintech.entity.product;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Saving {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private SavingsType type;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String company;

    @Column(nullable = false)
    private String maxRate;

    @Column(nullable = false)
    private String defaultRate;

    @Column(nullable = false)
    private String target;

    @Column(nullable = false)
    private boolean isProtected;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String detail;

    @Column(nullable = false)
    private String interest;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String url;

    @Column(nullable = false)
    private boolean isBankingSector;
}