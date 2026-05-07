package com.rosadavi.festpay.entity;

import com.rosadavi.festpay.enums.UserUpdatedRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
