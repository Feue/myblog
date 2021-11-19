package com.feue.myblog.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Feue
 * @create 2021-11-19 16:13
 */
@Getter
@Setter
public class RegisterDTO {
    private String nickname;
    private String password;
    private String email;
    private String mobile;
}
