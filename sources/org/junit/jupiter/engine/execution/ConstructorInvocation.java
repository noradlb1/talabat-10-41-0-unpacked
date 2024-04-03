package org.junit.jupiter.engine.execution;

import j$.util.Optional;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.extension.InvocationInterceptor;
import org.junit.jupiter.api.extension.ReflectiveInvocationContext;
import org.junit.platform.commons.util.ReflectionUtils;
import z20.f;

class ConstructorInvocation<T> implements InvocationInterceptor.Invocation<T>, ReflectiveInvocationContext<Constructor<T>> {
    private final Object[] arguments;
    private final Constructor<T> constructor;

    public ConstructorInvocation(Constructor<T> constructor2, Object[] objArr) {
        this.constructor = constructor2;
        this.arguments = objArr;
    }

    public List<Object> getArguments() {
        return Collections.unmodifiableList(Arrays.asList(this.arguments));
    }

    public Optional<Object> getTarget() {
        return Optional.empty();
    }

    public Class<?> getTargetClass() {
        return this.constructor.getDeclaringClass();
    }

    public T proceed() {
        return ReflectionUtils.newInstance(this.constructor, this.arguments);
    }

    public /* synthetic */ void skip() {
        f.a(this);
    }

    public Constructor<T> getExecutable() {
        return this.constructor;
    }
}
