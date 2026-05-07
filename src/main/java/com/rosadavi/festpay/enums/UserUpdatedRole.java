package com.rosadavi.festpay.enums;

import lombok.Getter;

@Getter
public enum UserUpdatedRole {
    VENDOR("vendor"),
    OWNER("owner");

    private final String role;

    UserUpdatedRole(String role) {
        this.role = role;
    }
}
