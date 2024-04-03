package j$.util.function;

import java.util.function.LongFunction;

/* renamed from: j$.util.function.g0  reason: case insensitive filesystem */
public final /* synthetic */ class C0154g0 implements C0158i0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LongFunction f28846a;

    private /* synthetic */ C0154g0(LongFunction longFunction) {
        this.f28846a = longFunction;
    }

    public static /* synthetic */ C0158i0 a(LongFunction longFunction) {
        if (longFunction == null) {
            return null;
        }
        return longFunction instanceof C0156h0 ? ((C0156h0) longFunction).f28848a : new C0154g0(longFunction);
    }

    public final /* synthetic */ Object apply(long j11) {
        return this.f28846a.apply(j11);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof C0154g0) {
            obj = ((C0154g0) obj).f28846a;
        }
        return this.f28846a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28846a.hashCode();
    }
}
