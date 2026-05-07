package com.rosadavi.festpay.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private Integer price;

    private String description;

    private LocalDate created_at;

    private LocalDate updated_at;

    @PrePersist
    public void prePersist() {
        this.created_at = LocalDate.now();
        this.updated_at = LocalDate.now();
    }

    @ManyToOne
    @JoinColumn(name = "stall_id")
    private Stall stall;
}
