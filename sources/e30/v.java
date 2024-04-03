package e30;

import j$.util.function.Supplier;
import org.junit.platform.engine.discovery.MethodSelector;

public final /* synthetic */ class v implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodSelector f61976a;

    public /* synthetic */ v(MethodSelector methodSelector) {
        this.f61976a = methodSelector;
    }

    public final Object get() {
        return this.f61976a.getJavaMethod();
    }
}
