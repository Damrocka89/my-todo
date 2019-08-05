package com.sda.service;

import com.sda.model.User;
import com.sda.repository.UserRepository;

public class UserService {

    UserRepository userRepository = new UserRepository();

    public User findUser(String login) {
       return userRepository.findUser(login);
    }

    public void saveUser(User user) {
        userRepository.saveUser(user);
    }
}
