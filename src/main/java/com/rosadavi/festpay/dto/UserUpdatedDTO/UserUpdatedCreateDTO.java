package com.rosadavi.festpay.dto.UserUpdatedDTO;

import com.rosadavi.festpay.enums.UserUpdatedRole;

import java.util.UUID;

public record UserUpdatedCreateDTO(
        String social_name,
        String phone,
        String cpf_cnpj,
        String description,
        UserUpdatedRole role,
        UUID user_default_id
) {
}
