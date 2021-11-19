package com.feue.myblog.exception;

/**
 * @author Feue
 * @create 2021-11-17 12:44
 */
public class NotFoundException extends HttpException {
    public NotFoundException(int code) {
        this.code = code;
        this.httpStatusCode = 404;
    }
}
