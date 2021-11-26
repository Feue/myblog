package com.feue.myblog.dto;

import com.feue.myblog.core.enumeration.LoginType;
import com.feue.myblog.core.annotation.TokenPassword;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

/**
 * @author Feue
 * @create 2021-11-17 11:56
 */
@Getter
@Setter
@ToString
public class TokenGetDTO {
    @NotBlank(message = "Account cannot be null")
    private String account;
    @TokenPassword(max = 20, message = "{token.password}")
    private String password;
    private LoginType loginType;
}
