package f30;

import org.junit.jupiter.api.extension.InvocationInterceptor;
import org.junit.jupiter.engine.execution.InvocationInterceptorChain;

public final /* synthetic */ class j implements InvocationInterceptorChain.InterceptorCall {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InvocationInterceptorChain.VoidInterceptorCall f62048a;

    public /* synthetic */ j(InvocationInterceptorChain.VoidInterceptorCall voidInterceptorCall) {
        this.f62048a = voidInterceptorCall;
    }

    public final Object apply(InvocationInterceptor invocationInterceptor, InvocationInterceptor.Invocation invocation) {
        return this.f62048a.apply(invocationInterceptor, invocation);
    }
}
