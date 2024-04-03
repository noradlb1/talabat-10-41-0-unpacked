package f30;

import j$.util.function.Supplier;
import org.junit.jupiter.engine.execution.ExtensionValuesStore;

public final /* synthetic */ class f implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Object f62043a;

    public /* synthetic */ f(Object obj) {
        this.f62043a = obj;
    }

    public final Object get() {
        return ExtensionValuesStore.lambda$put$5(this.f62043a);
    }
}
