package com.feue.myblog.service;

import com.feue.myblog.model.UserDO;

/**
 * @author Feue
 * @create 2021-11-16 13:54
 */
public interface UserService {
    UserDO getUserById(Long id);
    Long register(UserDO userDO);
}
