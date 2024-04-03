package d30;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.InvocationInterceptor;
import org.junit.jupiter.api.extension.ReflectiveInvocationContext;
import org.junit.jupiter.engine.execution.InterceptingExecutableInvoker;

public final /* synthetic */ class l1 implements InterceptingExecutableInvoker.ReflectiveInterceptorCall {
    public final Object apply(InvocationInterceptor invocationInterceptor, InvocationInterceptor.Invocation invocation, ReflectiveInvocationContext reflectiveInvocationContext, ExtensionContext extensionContext) {
        return invocationInterceptor.interceptTestFactoryMethod(invocation, reflectiveInvocationContext, extensionContext);
    }
}
