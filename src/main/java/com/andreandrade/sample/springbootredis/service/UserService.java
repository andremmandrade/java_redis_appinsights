package com.andreandrade.sample.springbootredis.service;

import com.andreandrade.sample.springbootredis.dao.RedisDAO;
import com.andreandrade.sample.springbootredis.domain.User;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    private final RedisDAO redisDAO;

    public UserService(RedisDAO redisDAO) {
        this.redisDAO = redisDAO;
    }

    public User registerUser(String username) throws IOException {
        User user = new User();
        user.setUsername(username);
        user.setCreatedAt(LocalDateTime.now());

        redisDAO.setUser(user);

        return redisDAO.getUser(username);
    }

    public void deleteUser(String username) {
        redisDAO.deleteUser(username);
    }

    public User getUser(String username) throws IOException {
        return redisDAO.getUser(username);
    }

    public List<String> getUsernameList() {
        return redisDAO.getAllUsers();
    }

    public boolean isUserBlocked(String username) {
        return redisDAO.isUserBlocked(username);
    }

    public long getUserBlockedSecondsLeft(String username) {
        return redisDAO.getUserBlockedSecondsLeft(username);
    }

    public void blockUser(String username) {
        redisDAO.setUserBlocked(username);
    }

    public void unblockUser(String username) {
        redisDAO.deleteUserBlocked(username);
    }
}
