package com.feue.myblog.api.v1;

import com.feue.myblog.dto.TokenGetDTO;
import com.feue.myblog.exception.NotFoundException;
import com.feue.myblog.service.AuthenticationService;
import com.feue.myblog.vo.UnifyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Feue
 * @create 2021-11-17 11:00
 */
@RestController
@RequestMapping(value = "v1/token")
public class TokenController {
    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public UnifyResponse<Map<String, String>> getToken(@RequestBody @Validated TokenGetDTO tokenGetDTO) {
        Map<String, String> map = null;
        switch (tokenGetDTO.getLoginType()) {
            case User_Name:
                map = this.authenticationService.nameLogin(tokenGetDTO);
                break;
            case User_Email:
                map = this.authenticationService.emailLogin(tokenGetDTO);
                break;
            case User_Mobile:
                map = this.authenticationService.mobileLogin(tokenGetDTO);
                break;
            default:
                throw new NotFoundException(10003);
        }
        return new UnifyResponse<>(map, "登录成功");
    }
}
