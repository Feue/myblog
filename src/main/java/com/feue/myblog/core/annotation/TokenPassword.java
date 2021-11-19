package com.feue.myblog.core.annotation;

import com.feue.myblog.dto.validators.TokenPasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Feue
 * @create 2021-11-17 12:08
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
@Constraint(validatedBy = TokenPasswordValidator.class)
public @interface TokenPassword {
    String message() default "字段不符合要求";
    int min() default 6;
    int max() default 30;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
