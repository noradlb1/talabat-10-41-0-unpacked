package f30;

import j$.util.function.Supplier;
import java.lang.reflect.Method;

public final /* synthetic */ class o implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Method f62050a;

    public /* synthetic */ o(Method method) {
        this.f62050a = method;
    }

    public final Object get() {
        return this.f62050a.getDeclaringClass();
    }
}
