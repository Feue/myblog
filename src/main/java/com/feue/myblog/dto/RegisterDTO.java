package com.feue.myblog.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Feue
 * @create 2021-11-19 16:13
 */
@Getter
@Setter
@ToString
public class RegisterDTO {
    private String nickname;
    private String password;
    private String email;
    private String mobile;
}
