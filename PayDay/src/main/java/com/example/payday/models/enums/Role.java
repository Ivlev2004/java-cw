package com.example.payday.models.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_ADMIN,
    ROLE_ACCOUNTANT,
    ROLE_EMPLOYEE;

    @Override
    public String getAuthority() {
        return name();
    }
}
