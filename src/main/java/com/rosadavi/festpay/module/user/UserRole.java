package com.rosadavi.festpay.module.user;

public enum UserRole {
    STALL("stall"),
    OWNER("owner");

    private final String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
