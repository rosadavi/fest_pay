package com.rosadavi.festpay.dto.UserUpdatedDTO;

import com.rosadavi.festpay.dto.UserDefaultDTO.UserDefaultSummaryDTO;
import com.rosadavi.festpay.enums.UserUpdatedRole;

import java.time.LocalDate;
import java.util.UUID;

public record UserUpdatedSummaryDTO(
        UUID id,
        String social_name,
        String phone,
        String cpf_cnpj,
        String description,
        UserUpdatedRole role,
        LocalDate created_at,
        LocalDate updated_at,
        UserDefaultSummaryDTO user_default
) {
}