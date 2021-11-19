package com.feue.myblog.service;

import com.feue.myblog.dto.TokenGetDTO;

import java.util.Map;

/**
 * @author Feue
 * @create 2021-11-17 12:42
 */
public interface AuthenticationService {
    Map<String, String> nameLogin(TokenGetDTO dto);
    Map<String, String> emailLogin(TokenGetDTO dto);
    Map<String, String> mobileLogin(TokenGetDTO dto);
}
