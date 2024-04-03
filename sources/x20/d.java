package x20;

import j$.util.function.Supplier;
import java.util.concurrent.atomic.AtomicReference;

public final /* synthetic */ class d implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicReference f57968a;

    public /* synthetic */ d(AtomicReference atomicReference) {
        this.f57968a = atomicReference;
    }

    public final Object get() {
        return (Thread) this.f57968a.get();
    }
}
