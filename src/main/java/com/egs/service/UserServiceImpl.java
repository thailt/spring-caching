package com.egs.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.egs.entity.User;
import com.egs.main.AppRunner;
import com.egs.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);
    @Autowired
    UserRepository userRepo;

    @Override
    @CachePut(value = "users", key = "#result.id")
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    @Cacheable(value = "users", key = "#userId")
    public User find(Long userId) {
        return userRepo.findOne(userId);
    }

}
