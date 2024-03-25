package com.tom13.userservice.security;

import com.tom13.userservice.entity.Role;
import com.tom13.userservice.entity.User;
import com.tom13.userservice.exception.authenticationExceptions.UserServiceUserNotActiveException;
import com.tom13.userservice.exception.authenticationExceptions.UserServiceUsernameNotFoundException;
import com.tom13.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final ErrorMessenger errorMessenger;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            if (!user.getIsActive()) {
                errorMessenger.setMessage("User with email '" + user.getEmail() +
                        "' is inactive. Please contact the administrator at: administrator@userservice.com");
                throw new UserServiceUserNotActiveException("Invalid username or password.");
            }
            return new org.springframework.security.core.userdetails.User
                    (user.getEmail(), user.getPassword(), user.getIsActive(),
                            true, true, true,
                            mapRolesToAuthorities(user.getRoles()));
        } else {
            errorMessenger.setMessage("Invalid username or password");
            throw new UserServiceUsernameNotFoundException("Invalid username or password.");
        }
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        Collection<? extends GrantedAuthority> mapRoles = roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
        return mapRoles;
    }
}
