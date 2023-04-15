package com.decagon.taskTracker.service;

import com.decagon.taskTracker.dto.UserDTO;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void saveUser(UserDTO userDTO);

    boolean authUser(UserDTO userDTO);
}
