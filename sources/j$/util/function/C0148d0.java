package j$.util.function;

import java.util.function.LongConsumer;

/* renamed from: j$.util.function.d0  reason: case insensitive filesystem */
public final /* synthetic */ class C0148d0 implements C0152f0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LongConsumer f28841a;

    private /* synthetic */ C0148d0(LongConsumer longConsumer) {
        this.f28841a = longConsumer;
    }

    public static /* synthetic */ C0152f0 a(LongConsumer longConsumer) {
        if (longConsumer == null) {
            return null;
        }
        return longConsumer instanceof C0150e0 ? ((C0150e0) longConsumer).f28843a : new C0148d0(longConsumer);
    }

    public final /* synthetic */ void accept(long j11) {
        this.f28841a.accept(j11);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof C0148d0) {
            obj = ((C0148d0) obj).f28841a;
        }
        return this.f28841a.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28841a.hashCode();
    }

    public final /* synthetic */ C0152f0 i(C0152f0 f0Var) {
        return a(this.f28841a.andThen(C0150e0.a(f0Var)));
    }
}
