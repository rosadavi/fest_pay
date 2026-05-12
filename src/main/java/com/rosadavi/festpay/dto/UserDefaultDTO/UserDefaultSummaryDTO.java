package com.rosadavi.festpay.dto.UserDefaultDTO;


import java.time.LocalDate;
import java.util.UUID;

public record UserDefaultSummaryDTO(
        UUID id,
        String email,
        LocalDate created_at,
        LocalDate updated_at
) {
}
