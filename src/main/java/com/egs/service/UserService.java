package com.egs.service;

import com.egs.entity.User;

public interface UserService {

    User save(User user);

    User find(Long userId);
}
