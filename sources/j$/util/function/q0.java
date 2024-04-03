package j$.util.function;

import java.util.function.LongToIntFunction;

public final /* synthetic */ class q0 implements LongToIntFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ r0 f28861a;

    private /* synthetic */ q0(r0 r0Var) {
        this.f28861a = r0Var;
    }

    public static /* synthetic */ LongToIntFunction a(r0 r0Var) {
        if (r0Var == null) {
            return null;
        }
        return r0Var instanceof C0172p0 ? ((C0172p0) r0Var).f28859a : new q0(r0Var);
    }

    public final /* synthetic */ int applyAsInt(long j11) {
        return ((C0172p0) this.f28861a).a(j11);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        r0 r0Var = this.f28861a;
        if (obj instanceof q0) {
            obj = ((q0) obj).f28861a;
        }
        return r0Var.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28861a.hashCode();
    }
}
