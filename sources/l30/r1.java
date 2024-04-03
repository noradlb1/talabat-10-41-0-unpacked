package l30;

import j$.util.function.Supplier;
import java.lang.reflect.Method;

public final /* synthetic */ class r1 implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Method f26498a;

    public /* synthetic */ r1(Method method) {
        this.f26498a = method;
    }

    public final Object get() {
        return String.format("Cannot invoke non-static method [%s] on a null target.", new Object[]{this.f26498a.toGenericString()});
    }
}
