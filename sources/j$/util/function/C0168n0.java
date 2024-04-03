package j$.util.function;

import java.util.function.LongToDoubleFunction;

/* renamed from: j$.util.function.n0  reason: case insensitive filesystem */
public final /* synthetic */ class C0168n0 implements LongToDoubleFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0170o0 f28857a;

    private /* synthetic */ C0168n0(C0170o0 o0Var) {
        this.f28857a = o0Var;
    }

    public static /* synthetic */ LongToDoubleFunction a(C0170o0 o0Var) {
        if (o0Var == null) {
            return null;
        }
        return o0Var instanceof C0166m0 ? ((C0166m0) o0Var).f28855a : new C0168n0(o0Var);
    }

    public final /* synthetic */ double applyAsDouble(long j11) {
        return ((C0166m0) this.f28857a).a(j11);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        C0170o0 o0Var = this.f28857a;
        if (obj instanceof C0168n0) {
            obj = ((C0168n0) obj).f28857a;
        }
        return o0Var.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28857a.hashCode();
    }
}
