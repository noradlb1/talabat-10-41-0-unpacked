package com.huawei.wisesecurity.kfs.validation;

import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.kfs.validation.metadata.BeanMetaData;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class KfsValidator {
    public static final Map<Class<?>, BeanMetaData<?>> CACHE_BEAN_META_DATA_MAP = new ConcurrentHashMap();
    public static final String TAG = "KfsValidator";

    public static BeanMetaData<?> getBeanMetaData(Class<?> cls) throws KfsValidationException {
        Map<Class<?>, BeanMetaData<?>> map = CACHE_BEAN_META_DATA_MAP;
        if (map.containsKey(cls)) {
            return map.get(cls);
        }
        BeanMetaData<?> beanMetaData = new BeanMetaData<>(cls);
        map.put(cls, beanMetaData);
        return beanMetaData;
    }

    public static <T> void validate(T t11) throws KfsValidationException {
        if (t11 != null) {
            BeanMetaData<?> beanMetaData = getBeanMetaData(t11.getClass());
            if (beanMetaData.hasConstraints()) {
                beanMetaData.validate(t11);
                return;
            }
            return;
        }
        throw new KfsValidationException("validate bean is null");
    }
}
