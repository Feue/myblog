package com.feue.myblog.api.v1;

import com.feue.myblog.model.User;
import com.feue.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;

/**
 * @author Feue
 * @create 2021-11-16 13:54
 */
@RestController
@RequestMapping("v1/user")
@Validated
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("get/by/id/{id}")
    public User getById(@PathVariable @Min(value = 1, message = "id必须大于0") Long id) {
        return userService.getUserById(id);
    }
}
