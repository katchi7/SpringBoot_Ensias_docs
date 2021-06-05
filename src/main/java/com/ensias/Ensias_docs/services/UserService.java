package com.ensias.Ensias_docs.services;

import com.ensias.Ensias_docs.models.User;
import com.ensias.Ensias_docs.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        final Optional<User> optionalUser = userRepository.findByEmail(s.trim());

        if (optionalUser.isPresent()) {

            UserDetails userDetails =  optionalUser.get();
            return userDetails;
        }
        else {
            throw new UsernameNotFoundException(MessageFormat.format("User with email {0} cannot be found.", s));
        }
    }

    public User loadUserByEmail(String s) throws UsernameNotFoundException {

        final Optional<User> optionalUser = userRepository.findByEmail(s.trim());

        if (optionalUser.isPresent()) {

            User userDetails =  optionalUser.get();
            return userDetails ;
        }
        else {
            throw new UsernameNotFoundException(MessageFormat.format("User with email {0} cannot be found.", s));
        }
    }



    public void saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println(user.getPassword().length());
        userRepository.save(user);
    }

    public User getCurrentUser(){
        User user = null;
        Object principal = (SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        UserDetails details = principal instanceof UserDetails ? (UserDetails) principal:null;
        if(details!=null){
            user = loadUserByEmail(details.getUsername());
        }
        return user;
    }
}
