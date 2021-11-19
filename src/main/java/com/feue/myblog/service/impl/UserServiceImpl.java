package com.feue.myblog.service.impl;

import com.feue.myblog.exception.ParameterException;
import com.feue.myblog.model.UserDO;
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
    public UserDO getUserById(Long id) {
        return userRepository.findOneById(id);
    }

    @Override
    public Long register(UserDO userDO) {
        UserDO exist = this.userRepository.findOneByNickname(userDO.getNickname());
        if (exist != null) {
            throw new ParameterException(20001);
        }
        return this.userRepository.save(userDO).getId();
    }
}
