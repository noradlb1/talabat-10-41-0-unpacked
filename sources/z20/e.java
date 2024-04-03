package z20;

import org.apiguardian.api.API;
import org.junit.jupiter.api.extension.DynamicTestInvocationContext;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.InvocationInterceptor;
import org.junit.jupiter.api.extension.ReflectiveInvocationContext;

public final /* synthetic */ class e {
    public static void a(InvocationInterceptor invocationInterceptor, InvocationInterceptor.Invocation invocation, ReflectiveInvocationContext reflectiveInvocationContext, ExtensionContext extensionContext) throws Throwable {
        invocation.proceed();
    }

    public static void b(InvocationInterceptor invocationInterceptor, InvocationInterceptor.Invocation invocation, ReflectiveInvocationContext reflectiveInvocationContext, ExtensionContext extensionContext) throws Throwable {
        invocation.proceed();
    }

    public static void c(InvocationInterceptor invocationInterceptor, InvocationInterceptor.Invocation invocation, ReflectiveInvocationContext reflectiveInvocationContext, ExtensionContext extensionContext) throws Throwable {
        invocation.proceed();
    }

    public static void d(InvocationInterceptor invocationInterceptor, InvocationInterceptor.Invocation invocation, ReflectiveInvocationContext reflectiveInvocationContext, ExtensionContext extensionContext) throws Throwable {
        invocation.proceed();
    }

    @API(since = "5.8", status = API.Status.EXPERIMENTAL)
    public static void e(InvocationInterceptor invocationInterceptor, InvocationInterceptor.Invocation invocation, DynamicTestInvocationContext dynamicTestInvocationContext, ExtensionContext extensionContext) throws Throwable {
        invocationInterceptor.interceptDynamicTest(invocation, extensionContext);
    }

    @Deprecated
    @API(since = "5.8", status = API.Status.DEPRECATED)
    public static void f(InvocationInterceptor invocationInterceptor, InvocationInterceptor.Invocation invocation, ExtensionContext extensionContext) throws Throwable {
        invocation.proceed();
    }

    public static Object g(InvocationInterceptor invocationInterceptor, InvocationInterceptor.Invocation invocation, ReflectiveInvocationContext reflectiveInvocationContext, ExtensionContext extensionContext) throws Throwable {
        return invocation.proceed();
    }

    public static Object h(InvocationInterceptor invocationInterceptor, InvocationInterceptor.Invocation invocation, ReflectiveInvocationContext reflectiveInvocationContext, ExtensionContext extensionContext) throws Throwable {
        return invocation.proceed();
    }

    public static void i(InvocationInterceptor invocationInterceptor, InvocationInterceptor.Invocation invocation, ReflectiveInvocationContext reflectiveInvocationContext, ExtensionContext extensionContext) throws Throwable {
        invocation.proceed();
    }

    public static void j(InvocationInterceptor invocationInterceptor, InvocationInterceptor.Invocation invocation, ReflectiveInvocationContext reflectiveInvocationContext, ExtensionContext extensionContext) throws Throwable {
        invocation.proceed();
    }
}
