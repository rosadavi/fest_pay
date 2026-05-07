package com.rosadavi.festpay.entity;

import com.rosadavi.festpay.enums.UserUpdatedRole;
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
@Table(name = "user_updated")
public class UserUpdated {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String social_name;

    @Column(unique = true)
    private String phone;

    @Column(unique = true)
    private String cpf_cnpj;

    private String description;

    private UserUpdatedRole role;

    private LocalDate created_at;

    private LocalDate updated_at;

    @PrePersist
    public void prePersist() {
        this.created_at = LocalDate.now();
        this.updated_at = LocalDate.now();
    }

    @OneToOne
    @JoinColumn(name = "user_default_id")
    private UserDefault userDefault;

    @OneToMany(mappedBy = "userUpdated")
    private List<Event> events;

    @OneToMany(mappedBy = "userUpdated")
    private List<Stall> stallList;
}
