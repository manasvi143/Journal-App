package com.manasvi.Journal.App.service;

import com.manasvi.Journal.App.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userService.findByusername(username);
        if (user != null) {

            return User.builder().username(user.getUsername()).password(user.getPassword())
                    .roles(user.getRoles().toArray(new String[0])).build();
        }
        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}
