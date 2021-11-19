package com.feue.myblog.exception;

/**
 * @author Feue
 * @create 2021-11-17 13:26
 */
public class ParameterException extends HttpException {
    public ParameterException(int code) {
        this.code = code;
        this.httpStatusCode = 400;
    }
}
