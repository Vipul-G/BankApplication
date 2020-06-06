package com.prafful.bank.BankApplication;

import com.prafful.bank.BankApplication.User.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BankUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	private int userId;
    private String password;
    private boolean active;
    private List<GrantedAuthority> authorities;

    BankUserDetails(User user) {
        this.userId = user.getId();
        this.password = user.getPassword();
        this.authorities = Collections.singletonList(new SimpleGrantedAuthority(
                user.getRole()
        ));
        this.active = user.getActive();
    }

    BankUserDetails() {}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return (userId + "");
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
