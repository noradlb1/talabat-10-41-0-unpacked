package org.junit.jupiter.engine.execution;

import f30.g;
import j$.util.Optional;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Method;
import org.apiguardian.api.API;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.InvocationInterceptor;
import org.junit.jupiter.api.extension.ReflectiveInvocationContext;
import org.junit.jupiter.engine.extension.ExtensionRegistry;

@API(since = "5.0", status = API.Status.INTERNAL)
public class InterceptingExecutableInvoker {
    private static final InvocationInterceptorChain interceptorChain = new InvocationInterceptorChain();

    public interface ReflectiveInterceptorCall<E extends Executable, T> {

        public interface VoidMethodInterceptorCall {
            void apply(InvocationInterceptor invocationInterceptor, InvocationInterceptor.Invocation<Void> invocation, ReflectiveInvocationContext<Method> reflectiveInvocationContext, ExtensionContext extensionContext) throws Throwable;
        }

        T apply(InvocationInterceptor invocationInterceptor, InvocationInterceptor.Invocation<T> invocation, ReflectiveInvocationContext<E> reflectiveInvocationContext, ExtensionContext extensionContext) throws Throwable;
    }

    public <T> T invoke(Constructor<T> constructor, Optional<Object> optional, ExtensionContext extensionContext, ExtensionRegistry extensionRegistry, ReflectiveInterceptorCall<Constructor<T>, T> reflectiveInterceptorCall) {
        ConstructorInvocation constructorInvocation = new ConstructorInvocation(constructor, ParameterResolutionUtils.resolveParameters(constructor, Optional.empty(), optional, extensionContext, extensionRegistry));
        return invoke(constructorInvocation, constructorInvocation, extensionContext, extensionRegistry, reflectiveInterceptorCall);
    }

    public <T> T invoke(Method method, Object obj, ExtensionContext extensionContext, ExtensionRegistry extensionRegistry, ReflectiveInterceptorCall<Method, T> reflectiveInterceptorCall) {
        Optional optional;
        if (obj instanceof Optional) {
            optional = (Optional) obj;
        } else {
            optional = Optional.ofNullable(obj);
        }
        MethodInvocation methodInvocation = new MethodInvocation(method, optional, ParameterResolutionUtils.resolveParameters(method, optional, extensionContext, extensionRegistry));
        return invoke(methodInvocation, methodInvocation, extensionContext, extensionRegistry, reflectiveInterceptorCall);
    }

    private <E extends Executable, T> T invoke(InvocationInterceptor.Invocation<T> invocation, ReflectiveInvocationContext<E> reflectiveInvocationContext, ExtensionContext extensionContext, ExtensionRegistry extensionRegistry, ReflectiveInterceptorCall<E, T> reflectiveInterceptorCall) {
        return interceptorChain.invoke(invocation, extensionRegistry, new g(reflectiveInterceptorCall, reflectiveInvocationContext, extensionContext));
    }
}
