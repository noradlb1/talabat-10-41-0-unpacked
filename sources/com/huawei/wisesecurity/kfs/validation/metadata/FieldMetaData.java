package com.huawei.wisesecurity.kfs.validation.metadata;

import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsConstraint;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsValid;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class FieldMetaData {
    public final String beanName;
    public final List<ConstraintMetaData> constraintMetaDataList = new ArrayList();
    public final Field field;
    public BeanMetaData validKfsMetaData;

    public FieldMetaData(String str, Field field2) throws KfsValidationException {
        this.beanName = str;
        this.field = field2;
        field2.setAccessible(true);
        for (Annotation annotation : field2.getDeclaredAnnotations()) {
            if (((KfsConstraint) annotation.annotationType().getAnnotation(KfsConstraint.class)) != null) {
                if (annotation.annotationType() != KfsValid.class) {
                    this.constraintMetaDataList.add(new ConstraintMetaData(getFieldName(), annotation, field2.getType()));
                } else {
                    this.validKfsMetaData = new BeanMetaData(str, field2.getType());
                }
            }
        }
    }

    private String getFieldName() {
        return this.beanName + RealDiscoveryConfigurationRepository.VERSION_DELIMETER + this.field.getName();
    }

    public boolean hasConstraints() {
        return this.constraintMetaDataList.size() > 0 || this.validKfsMetaData != null;
    }

    public <T> void validate(T t11) throws KfsValidationException {
        try {
            Object obj = this.field.get(t11);
            for (ConstraintMetaData validate : this.constraintMetaDataList) {
                validate.validate(obj);
            }
            BeanMetaData beanMetaData = this.validKfsMetaData;
            if (beanMetaData != null) {
                beanMetaData.validate(obj);
            }
        } catch (IllegalAccessException e11) {
            throw new KfsValidationException("field validate failed:" + e11.getMessage());
        }
    }
}
