package com.test.ws.services;

import com.test.ws.dao.UserDao;
import com.test.ws.enumeration.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    UserDao userDao = new UserDao();

    @Override
    public UserDetails loadUserByUsername(String email) {
        try {
            // Retrieve the user by email
            com.test.ws.domain.User user = userDao.getUser(email);

            int roleId = user.getRole().getValue();
            return new User(
                    user.getEmail(), user.getPassword(), true, true, true, true, getAuthorities(roleId)
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Collection<? extends GrantedAuthority> getAuthorities(Integer role) {
        List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
        return authList;
    }

    public List<String> getRoles(Integer role) {

        List<String> roles = new ArrayList<String>();

        if (role.intValue() == Role.ROLE_ADMIN.getValue()) {
            roles.add(String.valueOf(Role.ROLE_ADMIN));
        } else if (role.intValue() == Role.ROLE_MEMBER.getValue()) {
            roles.add(String.valueOf(Role.ROLE_MEMBER));
        }
        return roles;
    }

    public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
}