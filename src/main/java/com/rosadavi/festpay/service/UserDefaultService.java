package com.rosadavi.festpay.service;

import com.rosadavi.festpay.dto.UserDefaultDTO.UserDefaultSummaryDTO;
import com.rosadavi.festpay.entity.UserDefault;
import com.rosadavi.festpay.repository.UserDefaultRepository;
import org.springframework.stereotype.Service;

@Service
public class UserDefaultService {

    UserDefaultRepository repository;

    public UserDefaultService(UserDefaultRepository repository) {
        this.repository = repository;
    }

    public UserDefaultSummaryDTO create(UserDefault user) {
        UserDefault newUser = repository.save(user);
        return new UserDefaultSummaryDTO(
                newUser.getId(),
                newUser.getEmail(),
                newUser.getCreated_at(),
                newUser.getUpdated_at()
        );
    }
}
