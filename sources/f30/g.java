package f30;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.InvocationInterceptor;
import org.junit.jupiter.api.extension.ReflectiveInvocationContext;
import org.junit.jupiter.engine.execution.InterceptingExecutableInvoker;
import org.junit.jupiter.engine.execution.InvocationInterceptorChain;

public final /* synthetic */ class g implements InvocationInterceptorChain.InterceptorCall {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InterceptingExecutableInvoker.ReflectiveInterceptorCall f62044a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ReflectiveInvocationContext f62045b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext f62046c;

    public /* synthetic */ g(InterceptingExecutableInvoker.ReflectiveInterceptorCall reflectiveInterceptorCall, ReflectiveInvocationContext reflectiveInvocationContext, ExtensionContext extensionContext) {
        this.f62044a = reflectiveInterceptorCall;
        this.f62045b = reflectiveInvocationContext;
        this.f62046c = extensionContext;
    }

    public final Object apply(InvocationInterceptor invocationInterceptor, InvocationInterceptor.Invocation invocation) {
        return this.f62044a.apply(invocationInterceptor, invocation, this.f62045b, this.f62046c);
    }
}
