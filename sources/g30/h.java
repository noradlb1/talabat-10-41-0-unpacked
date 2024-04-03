package g30;

import org.junit.jupiter.api.extension.InvocationInterceptor;
import org.junit.jupiter.api.function.ThrowingSupplier;

public final /* synthetic */ class h implements ThrowingSupplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InvocationInterceptor.Invocation f62084a;

    public /* synthetic */ h(InvocationInterceptor.Invocation invocation) {
        this.f62084a = invocation;
    }

    public final Object get() {
        return this.f62084a.proceed();
    }
}
