package com.rosadavi.festpay.controller;

import com.rosadavi.festpay.dto.UserDefaultDTO.UserDefaultSummaryDTO;
import com.rosadavi.festpay.entity.UserDefault;
import com.rosadavi.festpay.service.UserDefaultService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserDefaultController {
    UserDefaultService userDefaultService;

    public UserDefaultController(UserDefaultService userDefaultService) {
        this.userDefaultService = userDefaultService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserDefaultSummaryDTO> createUserDefault(@RequestBody UserDefault user) {
        return ResponseEntity.ok(userDefaultService.create(user));
    }
}
