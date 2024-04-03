package j$.util.function;

import java.util.function.LongPredicate;

/* renamed from: j$.util.function.k0  reason: case insensitive filesystem */
public final /* synthetic */ class C0162k0 implements LongPredicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0164l0 f28853a;

    private /* synthetic */ C0162k0(C0164l0 l0Var) {
        this.f28853a = l0Var;
    }

    public static /* synthetic */ LongPredicate a(C0164l0 l0Var) {
        if (l0Var == null) {
            return null;
        }
        return l0Var instanceof C0160j0 ? ((C0160j0) l0Var).f28851a : new C0162k0(l0Var);
    }

    public final /* synthetic */ LongPredicate and(LongPredicate longPredicate) {
        return a(((C0160j0) this.f28853a).a(C0160j0.b(longPredicate)));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        C0164l0 l0Var = this.f28853a;
        if (obj instanceof C0162k0) {
            obj = ((C0162k0) obj).f28853a;
        }
        return l0Var.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28853a.hashCode();
    }

    public final /* synthetic */ LongPredicate negate() {
        return a(((C0160j0) this.f28853a).c());
    }

    public final /* synthetic */ LongPredicate or(LongPredicate longPredicate) {
        return a(((C0160j0) this.f28853a).d(C0160j0.b(longPredicate)));
    }

    public final /* synthetic */ boolean test(long j11) {
        return ((C0160j0) this.f28853a).e(j11);
    }
}
