package com.feue.myblog.core.enumeration;

/**
 * @author Feue
 * @create 2021-11-17 11:57
 */
public enum LoginType {
    /**
     * 用户名登录
     */
    User_Name("用户名登录"),
    /**
     * 手机号登录
     */
    User_Mobile("手机号登录"),
    /**
     * 邮箱登录
     */
    User_Email("邮箱登录");

    private final String description;

    LoginType(String description) {
        this.description = description;
    }
}
