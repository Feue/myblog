package com.feue.myblog.core;

import com.feue.myblog.model.UserDO;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Feue
 * @create 2021-11-16 17:10
 */
public class LocalUser {
    private static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<>();

    public static void setUser(UserDO userDO) {
        Map<String, Object> map = new HashMap<>();
        map.put("user", userDO);
        LocalUser.threadLocal.set(map);
    }

    public static UserDO getUser() {
        return (UserDO) LocalUser.threadLocal.get().get("user");
    }

    public static void clear() {
        LocalUser.threadLocal.remove();
    }
}
