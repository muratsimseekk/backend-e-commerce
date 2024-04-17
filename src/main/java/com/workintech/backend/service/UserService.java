package com.workintech.backend.service;

import com.workintech.backend.dto.UserResponse;
import com.workintech.backend.entity.User;
import com.workintech.backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    List<UserResponse> findAll();
    UserResponse findById(Long id);
    UserResponse save(User user);
    UserResponse delete(Long id);

    User findByUserId(Long id);

}
