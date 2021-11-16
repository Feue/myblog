package com.feue.myblog.core;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Feue
 * @create 2021-11-16 16:26
 */
@Getter
@Setter
public class UnifyResponse {
    private int code;
    private String message;
    private String request;

    public UnifyResponse(int code, String message, String request) {
        this.code = code;
        this.message = message;
        this.request = request;
    }
}
