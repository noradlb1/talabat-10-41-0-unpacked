package f30;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.InvocationInterceptor;
import org.junit.jupiter.api.extension.ReflectiveInvocationContext;
import org.junit.jupiter.engine.execution.InterceptingExecutableInvoker;

public final /* synthetic */ class h implements InterceptingExecutableInvoker.ReflectiveInterceptorCall {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InterceptingExecutableInvoker.ReflectiveInterceptorCall.VoidMethodInterceptorCall f62047a;

    public /* synthetic */ h(InterceptingExecutableInvoker.ReflectiveInterceptorCall.VoidMethodInterceptorCall voidMethodInterceptorCall) {
        this.f62047a = voidMethodInterceptorCall;
    }

    public final Object apply(InvocationInterceptor invocationInterceptor, InvocationInterceptor.Invocation invocation, ReflectiveInvocationContext reflectiveInvocationContext, ExtensionContext extensionContext) {
        return this.f62047a.apply(invocationInterceptor, invocation, reflectiveInvocationContext, extensionContext);
    }
}
