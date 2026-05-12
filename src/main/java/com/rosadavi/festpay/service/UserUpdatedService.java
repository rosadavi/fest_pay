package com.rosadavi.festpay.service;

import com.rosadavi.festpay.dto.UserDefaultDTO.UserDefaultSummaryDTO;
import com.rosadavi.festpay.dto.UserUpdatedDTO.UserUpdatedCreateDTO;
import com.rosadavi.festpay.dto.UserUpdatedDTO.UserUpdatedSummaryDTO;
import com.rosadavi.festpay.entity.UserDefault;
import com.rosadavi.festpay.entity.UserUpdated;
import com.rosadavi.festpay.repository.UserDefaultRepository;
import com.rosadavi.festpay.repository.UserUpdatedRepository;
import org.springframework.stereotype.Service;

@Service
public class UserUpdatedService {
    UserUpdatedRepository userUpdatedRepository;
    UserDefaultRepository userDefaultRepository;

    public UserUpdatedService(UserUpdatedRepository userUpdatedRepository, UserDefaultRepository userDefaultRepository) {
        this.userUpdatedRepository = userUpdatedRepository;
        this.userDefaultRepository = userDefaultRepository;
    }

    public UserUpdatedSummaryDTO create(UserUpdatedCreateDTO user) {
        UserDefault userDefault = userDefaultRepository
                .findById(user.user_default_id())
                .orElseThrow(() -> new RuntimeException("User not found!"));

        UserUpdated userUpdated = new UserUpdated();
        userUpdated.setSocial_name(user.social_name());
        userUpdated.setPhone(user.phone());
        userUpdated.setCpf_cnpj(user.cpf_cnpj());
        userUpdated.setDescription(user.description());
        userUpdated.setRole(user.role());
        userUpdated.setUserDefault(userDefault);

        UserUpdated newUser = userUpdatedRepository.save(userUpdated);

        return new UserUpdatedSummaryDTO(
                newUser.getId(),
                newUser.getSocial_name(),
                newUser.getPhone(),
                newUser.getCpf_cnpj(),
                newUser.getDescription(),
                newUser.getRole(),
                newUser.getCreated_at(),
                newUser.getUpdated_at(),
                new UserDefaultSummaryDTO(
                        userDefault.getId(),
                        userDefault.getEmail(),
                        userDefault.getCreated_at(),
                        userDefault.getUpdated_at()
                )
        );
    }
}