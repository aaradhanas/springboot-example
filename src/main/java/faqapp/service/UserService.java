package faqapp.service;

import faqapp.bean.User;
import faqapp.constants.AuthorityConstants;
import faqapp.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

/**
 * Created by AAS on 3/5/2018.
 */
@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if(user.getAuthorities() == null || user.getAuthorities().isEmpty()){
            user.setAuthorities(Arrays.asList(AuthorityConstants.USER));
        }
        return this.userRepository.insert(user);
    }
}
