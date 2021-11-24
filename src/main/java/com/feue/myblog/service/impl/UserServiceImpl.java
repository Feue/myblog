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
        UserDO oneByNickname = this.userRepository.findOneByNickname(userDO.getNickname());
        UserDO oneByEmail = this.userRepository.findOneByEmail(userDO.getEmail());
        UserDO oneByMobile = this.userRepository.findOneByMobile(userDO.getMobile());
        if (oneByNickname != null) {
            throw new ParameterException(20001);
        }
        if (oneByEmail != null) {
            throw new ParameterException(20004);
        }
        if (oneByMobile != null) {
            throw new ParameterException(20005);
        }
        return this.userRepository.save(userDO).getId();
    }
}
