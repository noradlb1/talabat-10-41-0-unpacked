package com.huawei.wisesecurity.kfs.validation.core;

import com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.annotation.Annotation;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

public class ValidatorDescriptorImpl<A extends Annotation> implements ValidatorDescriptor<A> {
    public final Map<Class<?>, Class<?>> primitiveArrayClassMap = new ConcurrentHashMap<Class<?>, Class<?>>() {
        {
            put(Byte.TYPE, byte[].class);
            put(Short.TYPE, short[].class);
            put(Integer.TYPE, int[].class);
            put(Long.TYPE, long[].class);
            put(Float.TYPE, float[].class);
            put(Double.TYPE, double[].class);
            put(Character.TYPE, char[].class);
            put(Boolean.TYPE, boolean[].class);
        }
    };
    public final Map<Class<?>, Class<?>> primitiveTypeMap = new ConcurrentHashMap<Class<?>, Class<?>>() {
        {
            put(Byte.TYPE, Byte.class);
            put(Short.TYPE, Short.class);
            put(Integer.TYPE, Integer.class);
            put(Long.TYPE, Long.class);
            put(Float.TYPE, Float.class);
            put(Double.TYPE, Double.class);
            put(Character.TYPE, Character.class);
            put(Boolean.TYPE, Boolean.class);
        }
    };
    public final Map<Type, Class<? extends KfsConstraintValidator<A, ?>>> validatorArrayMap = new ConcurrentHashMap();
    public final Map<Type, Class<? extends KfsConstraintValidator<A, ?>>> validatorDefaultMap = new ConcurrentHashMap();

    @SafeVarargs
    public ValidatorDescriptorImpl(Class<? extends KfsConstraintValidator<A, ?>>... clsArr) {
        for (Class<? extends KfsConstraintValidator<A, ?>> putConstraint : clsArr) {
            putConstraint(putConstraint);
        }
    }

    private Class<? extends KfsConstraintValidator<A, ?>> getValidatorForClassAndHierarchy(Map<Type, Class<? extends KfsConstraintValidator<A, ?>>> map, Class<?> cls) {
        if (map.containsKey(cls)) {
            return map.get(cls);
        }
        Class<? extends KfsConstraintValidator<A, ?>> validatorType = getValidatorType(map, cls.getGenericSuperclass());
        if (validatorType != null) {
            return validatorType;
        }
        for (Type validatorType2 : cls.getGenericInterfaces()) {
            Class<? extends KfsConstraintValidator<A, ?>> validatorType3 = getValidatorType(map, validatorType2);
            if (validatorType3 != null) {
                return validatorType3;
            }
        }
        return null;
    }

    private Class<? extends KfsConstraintValidator<A, ?>> getValidatorType(Map<Type, Class<? extends KfsConstraintValidator<A, ?>>> map, Type type) {
        Class<? extends KfsConstraintValidator<A, ?>> validatorForClassAndHierarchy;
        if (type == null) {
            return null;
        }
        if ((type instanceof Class) && (validatorForClassAndHierarchy = getValidatorForClassAndHierarchy(map, (Class) type)) != null) {
            return validatorForClassAndHierarchy;
        }
        if (!(type instanceof ParameterizedType)) {
            return null;
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        if (!(parameterizedType.getRawType() instanceof Class)) {
            return null;
        }
        return getValidatorForClassAndHierarchy(map, (Class) parameterizedType.getRawType());
    }

    private Class<?> normalizeClass(Class<?> cls) {
        return this.primitiveTypeMap.containsKey(cls) ? this.primitiveTypeMap.get(cls) : cls;
    }

    private void putConstraint(Class<? extends KfsConstraintValidator<A, ?>> cls) {
        Map<Type, Class<? extends KfsConstraintValidator<A, ?>>> map;
        Object extractValidatorType = TypeHelper.extractValidatorType(cls);
        if (extractValidatorType instanceof Class) {
            Class cls2 = (Class) extractValidatorType;
            if (cls2.isArray()) {
                this.validatorArrayMap.put(cls2.getComponentType(), cls);
            }
            map = this.validatorDefaultMap;
        } else if (extractValidatorType instanceof GenericArrayType) {
            Class cls3 = (Class) ((GenericArrayType) extractValidatorType).getGenericComponentType();
            if (this.primitiveArrayClassMap.containsKey(cls3)) {
                map = this.validatorDefaultMap;
                extractValidatorType = this.primitiveArrayClassMap.get(cls3);
            } else {
                return;
            }
        } else {
            return;
        }
        map.put(extractValidatorType, cls);
    }

    public Class<? extends KfsConstraintValidator<A, ?>> getValidator(Class<?> cls) {
        Object obj;
        if (cls == null) {
            return null;
        }
        Class<?> normalizeClass = normalizeClass(cls);
        Class<Object> cls2 = Object.class;
        if (this.validatorDefaultMap.containsKey(cls2)) {
            obj = this.validatorDefaultMap.get(cls2);
        } else if (this.validatorDefaultMap.containsKey(normalizeClass)) {
            obj = this.validatorDefaultMap.get(normalizeClass);
        } else {
            Class<? extends KfsConstraintValidator<A, ?>> validatorType = normalizeClass.isArray() ? getValidatorType(this.validatorArrayMap, normalizeClass.getComponentType()) : getValidatorType(this.validatorDefaultMap, normalizeClass);
            if (validatorType != null) {
                this.validatorDefaultMap.put(normalizeClass, validatorType);
            }
            return validatorType;
        }
        return (Class) obj;
    }
}
