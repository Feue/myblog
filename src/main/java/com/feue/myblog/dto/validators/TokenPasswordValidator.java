package com.feue.myblog.dto.validators;

import com.feue.myblog.core.annotation.TokenPassword;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Feue
 * @create 2021-11-17 12:11
 */
public class TokenPasswordValidator implements ConstraintValidator<TokenPassword, String> {
    private Integer min;
    private Integer max;

    @Override
    public void initialize(TokenPassword constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (!StringUtils.hasText(s)) {
            return false;
        }
        int len = s.length();
        return len >= this.min && len <= this.max;
    }
}
