package com.sda.repository;

import com.sda.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserRepository {

    private static List<User> userList = loadMockData();

    private static List<User> loadMockData() {
        User user1 = new User("Me", "123", "@");
        User user2 = new User("You", "111", "@");
        return new ArrayList<>(Arrays.asList(user1, user2));
    }

    public User findUser(String login) {
        return userList.stream().filter(u -> u.getLogin().equals(login)).findFirst().orElse(null);

    }

    public void saveUser(User user) {
        userList.add(user);
    }
}
