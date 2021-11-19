package com.feue.myblog.api.v1;

import com.feue.myblog.core.annotation.Authenticate;
import com.feue.myblog.dto.RegisterDTO;
import com.feue.myblog.model.UserDO;
import com.feue.myblog.service.UserService;
import com.feue.myblog.vo.RegisterVO;
import com.feue.myblog.vo.UnifyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Authenticate
    @RequestMapping("get/by/id/{id}")
    public UnifyResponse<UserDO> getById(@PathVariable @Min(value = 1, message = "id必须大于0") Long id) {
        UserDO userDO = this.userService.getUserById(id);
        return new UnifyResponse<>(userDO, "查询成功");
    }

    @RequestMapping("register")
    public UnifyResponse<RegisterVO> register(@RequestBody RegisterDTO registerDTO) {
        UserDO userDO = UserDO.builder()
                .nickname(registerDTO.getNickname())
                .password(registerDTO.getPassword())
                .email(registerDTO.getEmail())
                .mobile(registerDTO.getMobile())
                .build();
        Long id = this.userService.register(userDO);
        RegisterVO registerVO = new RegisterVO(id);
        return new UnifyResponse<>(registerVO, "注册成功");
    }
}
