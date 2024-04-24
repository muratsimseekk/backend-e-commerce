package com.workintech.backend.service;

import com.workintech.backend.dto.UserResponse;
import com.workintech.backend.entity.User;
import com.workintech.backend.exception.CommonException;
import com.workintech.backend.repository.UserRepository;
import com.workintech.backend.util.UserDtoConvertion;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Override
    public List<UserResponse> findAll() {
        return UserDtoConvertion.convertUserList(userRepository.findAll()) ;
    }

    @Override
    public UserResponse findById(Long id) {
        Optional<User> optional = userRepository.findById(id);

        if (optional.isPresent()){
            return UserDtoConvertion.convertUser( optional.get());
        }

        throw new CommonException("Girilen Id de bir kullanici bulunamadi . ID : " + id , HttpStatus.NOT_FOUND);
    }

    @Override
    public UserResponse save(User user) {
        userRepository.save(user);
        return UserDtoConvertion.convertUser(user);
    }

    @Override
    public UserResponse delete(Long id) {
        userRepository.delete(findByUserId(id));
        return findById(id);
    }
    @Override
    public User findByUserId(Long id) {
        Optional<User> optional = userRepository.findById(id);

        if (optional.isPresent()){
            return optional.get();
        }

        throw new CommonException("Girilen Id de bir kullanici bulunamadi . ID : " + id , HttpStatus.NOT_FOUND);
    }
}
