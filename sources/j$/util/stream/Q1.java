package j$.util.stream;

import j$.util.function.C0144b0;
import j$.util.function.C0146c0;
import j$.util.function.C0152f0;
import j$.util.function.Consumer;
import java.util.Objects;

final class Q1 implements S1, C0267o2 {

    /* renamed from: a  reason: collision with root package name */
    private long f29013a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ long f29014b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ C0144b0 f29015c;

    Q1(long j11, C0144b0 b0Var) {
        this.f29014b = j11;
        this.f29015c = b0Var;
    }

    public final /* synthetic */ void accept(double d11) {
        C0314y0.d0();
        throw null;
    }

    public final /* synthetic */ void accept(int i11) {
        C0314y0.k0();
        throw null;
    }

    public final void accept(long j11) {
        this.f29013a = this.f29015c.applyAsLong(this.f29013a, j11);
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        l((Long) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ void end() {
    }

    public final void f(long j11) {
        this.f29013a = this.f29014b;
    }

    public final Object get() {
        return Long.valueOf(this.f29013a);
    }

    public final /* synthetic */ boolean h() {
        return false;
    }

    public final C0152f0 i(C0152f0 f0Var) {
        Objects.requireNonNull(f0Var);
        return new C0146c0(this, f0Var);
    }

    public final void k(S1 s12) {
        accept(((Q1) s12).f29013a);
    }

    public final /* synthetic */ void l(Long l11) {
        C0314y0.i0(this, l11);
    }
}
