package org.junit.runners.model;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.List;

class NoGenericTypeParametersValidator {
    private final Method method;

    public NoGenericTypeParametersValidator(Method method2) {
        this.method = method2;
    }

    private void validateNoTypeParameterOnGenericArrayType(GenericArrayType genericArrayType, List<Throwable> list) {
        validateNoTypeParameterOnType(genericArrayType.getGenericComponentType(), list);
    }

    private void validateNoTypeParameterOnParameterizedType(ParameterizedType parameterizedType, List<Throwable> list) {
        for (Type validateNoTypeParameterOnType : parameterizedType.getActualTypeArguments()) {
            validateNoTypeParameterOnType(validateNoTypeParameterOnType, list);
        }
    }

    private void validateNoTypeParameterOnType(Type type, List<Throwable> list) {
        if (type instanceof TypeVariable) {
            list.add(new Exception("Method " + this.method.getName() + "() contains unresolved type variable " + type));
        } else if (type instanceof ParameterizedType) {
            validateNoTypeParameterOnParameterizedType((ParameterizedType) type, list);
        } else if (type instanceof WildcardType) {
            validateNoTypeParameterOnWildcardType((WildcardType) type, list);
        } else if (type instanceof GenericArrayType) {
            validateNoTypeParameterOnGenericArrayType((GenericArrayType) type, list);
        }
    }

    private void validateNoTypeParameterOnWildcardType(WildcardType wildcardType, List<Throwable> list) {
        for (Type validateNoTypeParameterOnType : wildcardType.getUpperBounds()) {
            validateNoTypeParameterOnType(validateNoTypeParameterOnType, list);
        }
        for (Type validateNoTypeParameterOnType2 : wildcardType.getLowerBounds()) {
            validateNoTypeParameterOnType(validateNoTypeParameterOnType2, list);
        }
    }

    public void a(List<Throwable> list) {
        for (Type validateNoTypeParameterOnType : this.method.getGenericParameterTypes()) {
            validateNoTypeParameterOnType(validateNoTypeParameterOnType, list);
        }
    }
}
