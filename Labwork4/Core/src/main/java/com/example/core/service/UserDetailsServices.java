package com.example.core.service;

import com.example.core.roleUserDetails.RoleUserDetails;
import com.example.core.model.Master;
import com.example.core.ports.MasterRepositoryInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailsServices implements UserDetailsService {
    private final MasterRepositoryInterface masterRepositoryInterface;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Master master = masterRepositoryInterface.findMasterByLogin(username);
        return new RoleUserDetails(master);
    }
}
