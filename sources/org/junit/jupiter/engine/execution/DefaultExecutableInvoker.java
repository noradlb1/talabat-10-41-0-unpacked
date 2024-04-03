package org.junit.jupiter.engine.execution;

import j$.util.Optional;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.apiguardian.api.API;
import org.junit.jupiter.api.extension.ExecutableInvoker;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.engine.extension.ExtensionRegistry;
import org.junit.platform.commons.util.ReflectionUtils;
import z20.a;

@API(since = "5.9", status = API.Status.INTERNAL)
public class DefaultExecutableInvoker implements ExecutableInvoker {
    private final ExtensionContext extensionContext;
    private final ExtensionRegistry extensionRegistry;

    public DefaultExecutableInvoker(ExtensionContext extensionContext2, ExtensionRegistry extensionRegistry2) {
        this.extensionContext = extensionContext2;
        this.extensionRegistry = extensionRegistry2;
    }

    public /* synthetic */ Object invoke(Constructor constructor) {
        return a.a(this, constructor);
    }

    public <T> T invoke(Constructor<T> constructor, Object obj) {
        return ReflectionUtils.newInstance(constructor, ParameterResolutionUtils.resolveParameters(constructor, Optional.empty(), Optional.ofNullable(obj), this.extensionContext, this.extensionRegistry));
    }

    public /* synthetic */ Object invoke(Method method) {
        return a.b(this, method);
    }

    public Object invoke(Method method, Object obj) {
        return ReflectionUtils.invokeMethod(method, obj, ParameterResolutionUtils.resolveParameters(method, Optional.ofNullable(obj), this.extensionContext, this.extensionRegistry));
    }

    public DefaultExecutableInvoker(JupiterEngineExecutionContext jupiterEngineExecutionContext) {
        this(jupiterEngineExecutionContext.getExtensionContext(), jupiterEngineExecutionContext.getExtensionRegistry());
    }
}
