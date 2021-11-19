package com.feue.myblog.core.interceptors;

import com.auth0.jwt.interfaces.Claim;
import com.feue.myblog.core.LocalUser;
import com.feue.myblog.core.annotation.Authenticate;
import com.feue.myblog.exception.UnAuthenticatedException;
import com.feue.myblog.model.UserDO;
import com.feue.myblog.service.UserService;
import com.feue.myblog.util.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Optional;

/**
 * @author Feue
 * @create 2021-11-17 10:07
 */
public class PermissionInterceptor implements HandlerInterceptor {
    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Optional<Authenticate> authenticate = this.getAuthenticate(handler);
        if (!authenticate.isPresent()) {
            return true;
        }
        String bearerToken = request.getHeader("Authorization");
        if (!StringUtils.hasLength(bearerToken) || !bearerToken.startsWith("Bearer")) {
            throw new UnAuthenticatedException(10004);
        }
        String[] tokens = bearerToken.split(" ");
        if (tokens.length != 2) {
            throw new UnAuthenticatedException(10004);
        }
        String token = tokens[1];
        Optional<Map<String, Claim>> optionalMap = JwtToken.getClaims(token);
        Map<String, Claim> map = optionalMap.orElseThrow(() -> new UnAuthenticatedException(10004));
        boolean valid = this.hasPermission(map);
        if (valid) {
            this.setToThreadLocal(map);
        }
        return valid;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LocalUser.clear();
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

    private boolean hasPermission(Map<String, Claim> map) {
        return true;
    }

    private void setToThreadLocal(Map<String, Claim> map) {
        Long uid = map.get("uid").asLong();
        UserDO userDO = this.userService.getUserById(uid);
        LocalUser.setUser(userDO);
    }

    private Optional<Authenticate> getAuthenticate(Object handler) {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Authenticate authenticate = handlerMethod.getMethodAnnotation(Authenticate.class);
            if (authenticate == null) {
                return Optional.empty();
            }
            return Optional.of(authenticate);
        }
        return Optional.empty();
    }
}
