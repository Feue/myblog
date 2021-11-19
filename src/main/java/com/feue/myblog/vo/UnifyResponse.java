package com.feue.myblog.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Feue
 * @create 2021-11-16 16:26
 */
@Getter
@Setter
public class UnifyResponse<T> {
    private int code;
    private T result;
    private String message;
    private String request;

    public UnifyResponse(T result, String message) {
        this.code = 0;
        this.result = result;
        this.message = message;
    }

    public UnifyResponse(int code, String message, String request) {
        this.code = code;
        this.message = message;
        this.request = request;
    }
}
