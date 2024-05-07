package com.example.application.roleUserDetails;

import com.example.linkagecatmaster.models.Master;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@RequiredArgsConstructor
public class RoleUserDetails implements UserDetails {
    private final Master master;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> role =  new LinkedList<>();
        role.add(new SimpleGrantedAuthority(master.getRole().toString()));
        return role;
    }

    @Override
    public String getPassword() {
        return master.getPassword();
    }

    @Override
    public String getUsername() {
        return master.getLogin();
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
        return true;
    }
}
