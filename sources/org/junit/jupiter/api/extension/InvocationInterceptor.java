package org.junit.jupiter.api.extension;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.apiguardian.api.API;

@API(since = "5.5", status = API.Status.EXPERIMENTAL)
public interface InvocationInterceptor extends Extension {

    @API(since = "5.5", status = API.Status.EXPERIMENTAL)
    public interface Invocation<T> {
        T proceed() throws Throwable;

        @API(since = "5.6", status = API.Status.EXPERIMENTAL)
        void skip();
    }

    void interceptAfterAllMethod(Invocation<Void> invocation, ReflectiveInvocationContext<Method> reflectiveInvocationContext, ExtensionContext extensionContext) throws Throwable;

    void interceptAfterEachMethod(Invocation<Void> invocation, ReflectiveInvocationContext<Method> reflectiveInvocationContext, ExtensionContext extensionContext) throws Throwable;

    void interceptBeforeAllMethod(Invocation<Void> invocation, ReflectiveInvocationContext<Method> reflectiveInvocationContext, ExtensionContext extensionContext) throws Throwable;

    void interceptBeforeEachMethod(Invocation<Void> invocation, ReflectiveInvocationContext<Method> reflectiveInvocationContext, ExtensionContext extensionContext) throws Throwable;

    @API(since = "5.8", status = API.Status.EXPERIMENTAL)
    void interceptDynamicTest(Invocation<Void> invocation, DynamicTestInvocationContext dynamicTestInvocationContext, ExtensionContext extensionContext) throws Throwable;

    @API(since = "5.8", status = API.Status.DEPRECATED)
    @Deprecated
    void interceptDynamicTest(Invocation<Void> invocation, ExtensionContext extensionContext) throws Throwable;

    <T> T interceptTestClassConstructor(Invocation<T> invocation, ReflectiveInvocationContext<Constructor<T>> reflectiveInvocationContext, ExtensionContext extensionContext) throws Throwable;

    <T> T interceptTestFactoryMethod(Invocation<T> invocation, ReflectiveInvocationContext<Method> reflectiveInvocationContext, ExtensionContext extensionContext) throws Throwable;

    void interceptTestMethod(Invocation<Void> invocation, ReflectiveInvocationContext<Method> reflectiveInvocationContext, ExtensionContext extensionContext) throws Throwable;

    void interceptTestTemplateMethod(Invocation<Void> invocation, ReflectiveInvocationContext<Method> reflectiveInvocationContext, ExtensionContext extensionContext) throws Throwable;
}
