package com.feue.myblog.service.impl;

import com.feue.myblog.dto.TokenGetDTO;
import com.feue.myblog.exception.ParameterException;
import com.feue.myblog.model.UserDO;
import com.feue.myblog.repository.UserRepository;
import com.feue.myblog.service.AuthenticationService;
import com.feue.myblog.util.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Feue
 * @create 2021-11-17 12:42
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Map<String, String> nameLogin(TokenGetDTO tokenGetDTO) {
        UserDO userDO = this.userRepository.findOneByNickname(tokenGetDTO.getAccount());
        if (userDO == null) {
            throw new ParameterException(20002);
        }
        if (!userDO.getPassword().equals(tokenGetDTO.getPassword())) {
            throw new ParameterException(20003);
        }
        String token = JwtToken.makeToken(userDO.getId());
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        map.put("nickname", userDO.getNickname());
        return map;
    }

    @Override
    public Map<String, String> emailLogin(TokenGetDTO tokenGetDTO) {
        UserDO userDO = this.userRepository.findOneByEmail(tokenGetDTO.getAccount());
        if (userDO == null) {
            throw new ParameterException(20002);
        }
        if (!userDO.getPassword().equals(tokenGetDTO.getPassword())) {
            throw new ParameterException(20003);
        }
        String token = JwtToken.makeToken(userDO.getId());
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        map.put("nickname", userDO.getNickname());
        return map;
    }

    @Override
    public Map<String, String> mobileLogin(TokenGetDTO tokenGetDTO) {
        UserDO userDO = this.userRepository.findOneByMobile(tokenGetDTO.getAccount());
        if (userDO == null) {
            throw new ParameterException(20002);
        }
        if (!userDO.getPassword().equals(tokenGetDTO.getPassword())) {
            throw new ParameterException(20003);
        }
        String token = JwtToken.makeToken(userDO.getId());
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        map.put("nickname", userDO.getNickname());
        return map;
    }
}
