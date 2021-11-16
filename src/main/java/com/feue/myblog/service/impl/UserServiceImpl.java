package com.feue.myblog.service.impl;

import com.feue.myblog.model.User;
import com.feue.myblog.repository.UserRepository;
import com.feue.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Feue
 * @create 2021-11-16 13:54
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(Long id) {
        return userRepository.findOneById(id);
    }
}
