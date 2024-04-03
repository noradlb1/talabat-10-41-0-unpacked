package org.junit.jupiter.api.extension.support;

import a30.b;
import j$.util.function.Supplier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import org.apiguardian.api.API;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.platform.commons.util.Preconditions;

@API(since = "5.6", status = API.Status.EXPERIMENTAL)
public abstract class TypeBasedParameterResolver<T> implements ParameterResolver {
    private final Type supportedParameterType = enclosedTypeOfParameterResolver();

    private Type enclosedTypeOfParameterResolver() {
        ParameterizedType findTypeBasedParameterResolverSuperclass = findTypeBasedParameterResolverSuperclass(getClass());
        Preconditions.notNull(findTypeBasedParameterResolverSuperclass, (Supplier<String>) new b(this));
        return findTypeBasedParameterResolverSuperclass.getActualTypeArguments()[0];
    }

    private ParameterizedType findTypeBasedParameterResolverSuperclass(Class<?> cls) {
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass == null || superclass == Object.class) {
            return null;
        }
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            if (parameterizedType.getRawType() == TypeBasedParameterResolver.class) {
                return parameterizedType;
            }
        }
        return findTypeBasedParameterResolverSuperclass(superclass);
    }

    private Type getParameterType(ParameterContext parameterContext) {
        return parameterContext.getParameter().getParameterizedType();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ String lambda$enclosedTypeOfParameterResolver$0() {
        return String.format("Failed to discover parameter type supported by %s; potentially caused by lacking parameterized type in class declaration.", new Object[]{getClass().getName()});
    }

    public abstract T resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException;

    public final boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return this.supportedParameterType.equals(getParameterType(parameterContext));
    }
}
