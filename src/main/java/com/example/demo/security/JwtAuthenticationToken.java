package com.example.demo.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;


public class JwtAuthenticationToken extends AbstractAuthenticationToken {
    private final String username;

    public JwtAuthenticationToken(String username) {
        super(AuthorityUtils.createAuthorityList("ROLE_USER"));
        this.username = username;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return this.username;
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        throw new IllegalArgumentException("You can not set this");
    }
}
