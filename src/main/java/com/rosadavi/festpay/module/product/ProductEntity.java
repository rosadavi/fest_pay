package com.rosadavi.festpay.module.product;

import com.rosadavi.festpay.module.product_item.ProductItemEntity;
import com.rosadavi.festpay.module.stall.StallEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String value;

    private String amount;

    private String description;

    @ManyToOne
    @JoinColumn(name = "stall_id")
    private StallEntity stall;

    @OneToMany(mappedBy = "product")
    private List<ProductItemEntity> productItem;
}
