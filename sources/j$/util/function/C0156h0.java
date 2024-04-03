package j$.util.function;

import java.util.function.LongFunction;

/* renamed from: j$.util.function.h0  reason: case insensitive filesystem */
public final /* synthetic */ class C0156h0 implements LongFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0158i0 f28848a;

    private /* synthetic */ C0156h0(C0158i0 i0Var) {
        this.f28848a = i0Var;
    }

    public static /* synthetic */ LongFunction a(C0158i0 i0Var) {
        if (i0Var == null) {
            return null;
        }
        return i0Var instanceof C0154g0 ? ((C0154g0) i0Var).f28846a : new C0156h0(i0Var);
    }

    public final /* synthetic */ Object apply(long j11) {
        return this.f28848a.apply(j11);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        C0158i0 i0Var = this.f28848a;
        if (obj instanceof C0156h0) {
            obj = ((C0156h0) obj).f28848a;
        }
        return i0Var.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28848a.hashCode();
    }
}
