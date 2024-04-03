package com.huawei.wisesecurity.kfs.validation.constrains;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@KfsConstraint
@Retention(RetentionPolicy.RUNTIME)
public @interface KfsIn {
    int[] intArr() default {};

    String message() default "";

    String[] strArr() default {};
}
