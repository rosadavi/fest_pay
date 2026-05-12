package com.rosadavi.festpay.controller;

import com.rosadavi.festpay.dto.UserUpdatedDTO.UserUpdatedCreateDTO;
import com.rosadavi.festpay.dto.UserUpdatedDTO.UserUpdatedSummaryDTO;
import com.rosadavi.festpay.service.UserUpdatedService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/updated")
public class UserUpdatedController {
    UserUpdatedService user;

    public UserUpdatedController(UserUpdatedService user) {
        this.user = user;
    }

    @RequestMapping("/create")
    public ResponseEntity<UserUpdatedSummaryDTO> create(@RequestBody UserUpdatedCreateDTO user) {
        return ResponseEntity.ok(this.user.create(user));
    }
}
