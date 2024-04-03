package j$.util.function;

import java.util.function.Supplier;

public final /* synthetic */ class H0 implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Supplier f28803a;

    private /* synthetic */ H0(Supplier supplier) {
        this.f28803a = supplier;
    }

    public static /* synthetic */ Supplier a(Supplier supplier) {
        if (supplier == null) {
            return null;
        }
        return supplier instanceof I0 ? ((I0) supplier).f28805a : new H0(supplier);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof H0) {
            obj = ((H0) obj).f28803a;
        }
        return this.f28803a.equals(obj);
    }

    public final /* synthetic */ Object get() {
        return this.f28803a.get();
    }

    public final /* synthetic */ int hashCode() {
        return this.f28803a.hashCode();
    }
}
