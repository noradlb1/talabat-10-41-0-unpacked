package org.junit.jupiter.engine.execution;

import f30.n;
import f30.o;
import j$.util.Optional;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.extension.InvocationInterceptor;
import org.junit.jupiter.api.extension.ReflectiveInvocationContext;
import org.junit.platform.commons.util.ReflectionUtils;
import z20.f;

class MethodInvocation<T> implements InvocationInterceptor.Invocation<T>, ReflectiveInvocationContext<Method> {
    private final Object[] arguments;
    private final Method method;
    private final Optional<Object> target;

    public MethodInvocation(Method method2, Optional<Object> optional, Object[] objArr) {
        this.method = method2;
        this.target = optional;
        this.arguments = objArr;
    }

    public List<Object> getArguments() {
        return Collections.unmodifiableList(Arrays.asList(this.arguments));
    }

    public Optional<Object> getTarget() {
        return this.target;
    }

    public Class<?> getTargetClass() {
        Optional<U> map = this.target.map(new n());
        Method method2 = this.method;
        Objects.requireNonNull(method2);
        return (Class) map.orElseGet(new o(method2));
    }

    public T proceed() {
        return ReflectionUtils.invokeMethod(this.method, this.target.orElse(null), this.arguments);
    }

    public /* synthetic */ void skip() {
        f.a(this);
    }

    public Method getExecutable() {
        return this.method;
    }
}
