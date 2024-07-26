package com.example.application.service;

import com.example.application.roleUserDetails.RoleUserDetails;
import com.example.linkagecatmaster.models.Master;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailsServices implements UserDetailsService {
    private final UserDetailsRepositoryInterface userDetailsRepositoryInterface;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Master master = userDetailsRepositoryInterface.findMasterByLogin(username);
        return new RoleUserDetails(master);
    }
}
