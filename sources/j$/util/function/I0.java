package j$.util.function;

import java.util.function.Supplier;

public final /* synthetic */ class I0 implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Supplier f28805a;

    private /* synthetic */ I0(Supplier supplier) {
        this.f28805a = supplier;
    }

    public static /* synthetic */ Supplier a(Supplier supplier) {
        if (supplier == null) {
            return null;
        }
        return supplier instanceof H0 ? ((H0) supplier).f28803a : new I0(supplier);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        Supplier supplier = this.f28805a;
        if (obj instanceof I0) {
            obj = ((I0) obj).f28805a;
        }
        return supplier.equals(obj);
    }

    public final /* synthetic */ Object get() {
        return this.f28805a.get();
    }

    public final /* synthetic */ int hashCode() {
        return this.f28805a.hashCode();
    }
}
