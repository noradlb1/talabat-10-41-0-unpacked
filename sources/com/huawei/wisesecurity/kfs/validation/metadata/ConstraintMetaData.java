package com.huawei.wisesecurity.kfs.validation.metadata;

import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator;
import com.huawei.wisesecurity.kfs.validation.core.ConstraintHelper;
import java.lang.annotation.Annotation;

public class ConstraintMetaData {
    public final Annotation constraint;
    public final String fieldName;
    public final KfsConstraintValidator validator;

    public ConstraintMetaData(String str, Annotation annotation, Class<?> cls) throws KfsValidationException {
        try {
            this.fieldName = str;
            this.constraint = annotation;
            this.validator = (KfsConstraintValidator) ConstraintHelper.getValidator(annotation.annotationType(), cls).newInstance();
        } catch (IllegalAccessException | InstantiationException e11) {
            throw new KfsValidationException("create constraint meta data for field:" + str + " failed, " + e11.getMessage());
        }
    }

    public KfsConstraintValidator getValidator() {
        return this.validator;
    }

    public <T> void validate(T t11) throws KfsValidationException {
        KfsConstraintValidator kfsConstraintValidator = this.validator;
        if (kfsConstraintValidator != null) {
            kfsConstraintValidator.initialize(this.fieldName, this.constraint);
            if (!this.validator.isValid(t11)) {
                throw new KfsValidationException(this.validator.getMessage());
            }
        }
    }
}
