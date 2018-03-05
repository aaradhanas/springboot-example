package faqapp.security;

import faqapp.bean.User;
import faqapp.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by AAS on 3/3/2018.
 */

@Component("userDetailsService")
public class AuthUserDetailsService implements UserDetailsService {
    private final Logger log = LoggerFactory.getLogger(AuthUserDetailsService.class);

    private final UserRepository userRepository;

    public AuthUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        Optional<User> userFromDB = userRepository.findOneByUsername(username);
        return userFromDB.map(user -> createSpringSecurityUser(user.getUsername(), user)).orElse(null);
    }

    private org.springframework.security.core.userdetails.User createSpringSecurityUser(String username, User user) {
        List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream()
                .map(authority -> new SimpleGrantedAuthority(authority))
                .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                grantedAuthorities);
    }
}
