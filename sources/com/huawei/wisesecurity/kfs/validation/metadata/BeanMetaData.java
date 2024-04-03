package com.huawei.wisesecurity.kfs.validation.metadata;

import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class BeanMetaData<T> {
    public final List<FieldMetaData> allConstraintFieldMetaData;
    public final String beanName;

    public BeanMetaData(Class<T> cls) throws KfsValidationException {
        this((String) null, cls);
    }

    public BeanMetaData(String str, Class<?> cls) throws KfsValidationException {
        String str2;
        this.allConstraintFieldMetaData = new ArrayList();
        if (str != null) {
            str2 = str + RealDiscoveryConfigurationRepository.VERSION_DELIMETER + cls.getSimpleName();
        } else {
            str2 = cls.getSimpleName();
        }
        this.beanName = str2;
        getFieldMetaDataFromClassAndHierarchy(cls);
    }

    private void getFieldMetaDataFromClassAndHierarchy(Class<?> cls) throws KfsValidationException {
        if (cls != null) {
            getFieldMetaDataFromClassAndHierarchy(cls.getSuperclass());
            for (Field fieldMetaData : cls.getDeclaredFields()) {
                FieldMetaData fieldMetaData2 = new FieldMetaData(this.beanName, fieldMetaData);
                if (fieldMetaData2.hasConstraints()) {
                    this.allConstraintFieldMetaData.add(fieldMetaData2);
                }
            }
        }
    }

    public boolean hasConstraints() {
        return this.allConstraintFieldMetaData.size() > 0;
    }

    public void validate(T t11) throws KfsValidationException {
        if (t11 != null) {
            for (FieldMetaData next : this.allConstraintFieldMetaData) {
                if (next.hasConstraints()) {
                    next.validate(t11);
                }
            }
        }
    }
}
