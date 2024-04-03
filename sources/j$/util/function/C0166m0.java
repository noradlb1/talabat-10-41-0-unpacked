package j$.util.function;

import java.util.function.LongToDoubleFunction;

/* renamed from: j$.util.function.m0  reason: case insensitive filesystem */
public final /* synthetic */ class C0166m0 implements C0170o0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LongToDoubleFunction f28855a;

    private /* synthetic */ C0166m0(LongToDoubleFunction longToDoubleFunction) {
        this.f28855a = longToDoubleFunction;
    }

    public static /* synthetic */ C0170o0 b(LongToDoubleFunction longToDoubleFunction) {
        if (longToDoubleFunction == null) {
            return null;
        }
        return longToDoubleFunction instanceof C0168n0 ? ((C0168n0) longToDoubleFunction).f28857a : new C0166m0(longToDoubleFunction);
    }

    public final /* synthetic */ double a(long j11) {
        return this.f28855a.applyAsDouble(j11);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof C0166m0) {
            obj = ((C0166m0) obj).f28855a;
        }
        return this.f28855a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28855a.hashCode();
    }
}
