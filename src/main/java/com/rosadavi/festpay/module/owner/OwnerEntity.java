package com.rosadavi.festpay.module.owner;

import com.rosadavi.festpay.module.event.EventEntity;
import com.rosadavi.festpay.module.user.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "owner")
public class OwnerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true)
    private String cpf_cnpj;

    private LocalDate created_at;

    @PrePersist
    public void prePersist() {
        this.created_at = LocalDate.now();
    }

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "owner")
    private List<EventEntity> event;
}
