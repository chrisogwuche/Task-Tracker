package com.decagon.taskTracker.serviceImpl;

import com.decagon.taskTracker.configuration.SecurityConfig;
import com.decagon.taskTracker.dto.UserDTO;
import com.decagon.taskTracker.entity.User;
import com.decagon.taskTracker.repository.UserRepository;
import com.decagon.taskTracker.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserImpl implements UserService {

    @Autowired
    SecurityConfig securityConfig;
    @Autowired
    UserRepository userRepo;

    @Override
    public void saveUser(UserDTO userDTO) {
        User user =
                new User(userDTO.getFirstName(),userDTO.getLastName(),userDTO.getEmail(),
                        this.securityConfig.passwordEncoder().encode(userDTO.getPassword()));
        userRepo.save(user);

    }

    @Override
    public boolean authUser(UserDTO userDTO) {
        User user = new User();
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        Optional<User> optUser = userRepo.findByEmail(user.getEmail());
        boolean auth = false;

        if(optUser.isPresent()){
            auth = securityConfig.passwordEncoder().matches(user.getPassword(),optUser.get().getPassword());
        }
        return auth;
    }

}
