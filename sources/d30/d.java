package d30;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.InvocationInterceptor;
import org.junit.jupiter.api.extension.ReflectiveInvocationContext;
import org.junit.jupiter.engine.execution.InterceptingExecutableInvoker;

public final /* synthetic */ class d implements InterceptingExecutableInvoker.ReflectiveInterceptorCall.VoidMethodInterceptorCall {
    public final void apply(InvocationInterceptor invocationInterceptor, InvocationInterceptor.Invocation invocation, ReflectiveInvocationContext reflectiveInvocationContext, ExtensionContext extensionContext) {
        invocationInterceptor.interceptBeforeEachMethod(invocation, reflectiveInvocationContext, extensionContext);
    }
}
