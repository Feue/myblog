package com.feue.myblog.exception;

/**
 * @author Feue
 * @create 2021-11-16 17:16
 */
public class UnAuthenticatedException extends HttpException {
    public UnAuthenticatedException(int code) {
        this.code = code;
        this.httpStatusCode = 401;
    }
}
