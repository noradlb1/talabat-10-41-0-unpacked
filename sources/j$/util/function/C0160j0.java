package j$.util.function;

import java.util.function.LongPredicate;

/* renamed from: j$.util.function.j0  reason: case insensitive filesystem */
public final /* synthetic */ class C0160j0 implements C0164l0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LongPredicate f28851a;

    private /* synthetic */ C0160j0(LongPredicate longPredicate) {
        this.f28851a = longPredicate;
    }

    public static /* synthetic */ C0164l0 b(LongPredicate longPredicate) {
        if (longPredicate == null) {
            return null;
        }
        return longPredicate instanceof C0162k0 ? ((C0162k0) longPredicate).f28853a : new C0160j0(longPredicate);
    }

    public final /* synthetic */ C0164l0 a(C0164l0 l0Var) {
        return b(this.f28851a.and(C0162k0.a(l0Var)));
    }

    public final /* synthetic */ C0164l0 c() {
        return b(this.f28851a.negate());
    }

    public final /* synthetic */ C0164l0 d(C0164l0 l0Var) {
        return b(this.f28851a.or(C0162k0.a(l0Var)));
    }

    public final /* synthetic */ boolean e(long j11) {
        return this.f28851a.test(j11);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof C0160j0) {
            obj = ((C0160j0) obj).f28851a;
        }
        return this.f28851a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28851a.hashCode();
    }
}
