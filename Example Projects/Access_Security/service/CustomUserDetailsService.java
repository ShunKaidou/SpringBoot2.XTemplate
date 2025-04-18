package com.wecp.w3day5task1.service;


import com.wecp.w3day5task1.entity.User;
import com.wecp.w3day5task1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("username not found"));
        
        // String[] rolesArray=user.getRoles().split(",");
        List<SimpleGrantedAuthority> authorities=Arrays.stream(user.getRoles().split(","))
            .map(role -> new SimpleGrantedAuthority(role.trim()))
            .collect(Collectors.toList());
        
        return new org.springframework.security.core.userdetails.User(
            user.getUsername(),
            user.getPassword(),
            authorities // Collections.singletonList(new SimpleGrantedAuthority(user.getRoles()))
        );
        // method to load a user by its username

    }
}

