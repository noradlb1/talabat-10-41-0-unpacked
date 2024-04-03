package com.huawei.wisesecurity.kfs.validation.core;

import com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator;
import java.lang.annotation.Annotation;

public interface ValidatorDescriptor<A extends Annotation> {
    Class<? extends KfsConstraintValidator<A, ?>> getValidator(Class<?> cls);
}
