package com.crud.library.service;

import com.crud.library.domain.User;
import com.crud.library.exception.UserNotFoundException;
import com.crud.library.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public User addUser(final User user) {
        return userRepository.save(user);
    }

    public User findUserById(long id) throws UserNotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }
}
