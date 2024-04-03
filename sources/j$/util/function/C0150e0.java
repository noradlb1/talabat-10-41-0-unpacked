package j$.util.function;

import java.util.function.LongConsumer;

/* renamed from: j$.util.function.e0  reason: case insensitive filesystem */
public final /* synthetic */ class C0150e0 implements LongConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0152f0 f28843a;

    private /* synthetic */ C0150e0(C0152f0 f0Var) {
        this.f28843a = f0Var;
    }

    public static /* synthetic */ LongConsumer a(C0152f0 f0Var) {
        if (f0Var == null) {
            return null;
        }
        return f0Var instanceof C0148d0 ? ((C0148d0) f0Var).f28841a : new C0150e0(f0Var);
    }

    public final /* synthetic */ void accept(long j11) {
        this.f28843a.accept(j11);
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return a(this.f28843a.i(C0148d0.a(longConsumer)));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        C0152f0 f0Var = this.f28843a;
        if (obj instanceof C0150e0) {
            obj = ((C0150e0) obj).f28843a;
        }
        return f0Var.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28843a.hashCode();
    }
}
