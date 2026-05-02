package com.rosadavi.festpay.module.event;


import com.rosadavi.festpay.module.owner.OwnerEntity;
import com.rosadavi.festpay.module.stall.StallEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "event")
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String description;

    private LocalDateTime date_time;

    private String location;

    private LocalDate created_at;

    @PrePersist
    public void prePersist() {
        this.created_at = LocalDate.now();
    }

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private OwnerEntity owner;

    @OneToMany(mappedBy = "event")
    private List<StallEntity> stall;
}
