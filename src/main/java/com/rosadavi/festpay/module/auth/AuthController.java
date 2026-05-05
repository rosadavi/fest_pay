package com.rosadavi.festpay.module.auth;

import com.rosadavi.festpay.module.dto.LoginRequest;
import com.rosadavi.festpay.module.dto.LoginResponse;
import com.rosadavi.festpay.module.user.UserEntity;
import com.rosadavi.festpay.module.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService service;
    private final PasswordEncoder passwordEncoder;
    private final AuthService jwtService;

    public AuthController(UserService service, PasswordEncoder passwordEncoder, AuthService jwtService) {
        this.service = service;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserEntity> register(@RequestBody UserEntity user) {
        return ResponseEntity.ok(service.create(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        UserEntity user = service.findByEmail(request.email).orElseThrow(() -> new RuntimeException("User not Found"));

        if (!passwordEncoder.matches(request.password, user.getPassword())) {
            return ResponseEntity.status(401).body("Invalid Password");
        }

        String token = jwtService.generateToken(user);

        return ResponseEntity.ok(new LoginResponse(token));
    }
}
