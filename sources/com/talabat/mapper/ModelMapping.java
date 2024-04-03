package com.talabat.mapper;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ModelMapping {
    boolean acceptNulls() default false;

    Class<? extends ModelMapper> mapper() default DefaultModelMapper.class;

    String[] value();
}
