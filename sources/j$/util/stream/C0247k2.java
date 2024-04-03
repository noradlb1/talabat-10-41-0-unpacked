package j$.util.stream;

import j$.util.function.C0146c0;
import j$.util.function.C0152f0;
import j$.util.function.Consumer;
import java.util.Objects;

/* renamed from: j$.util.stream.k2  reason: case insensitive filesystem */
public abstract class C0247k2 implements C0267o2 {

    /* renamed from: a  reason: collision with root package name */
    protected final C0272p2 f29169a;

    public C0247k2(C0272p2 p2Var) {
        Objects.requireNonNull(p2Var);
        this.f29169a = p2Var;
    }

    public final /* synthetic */ void accept(double d11) {
        C0314y0.d0();
        throw null;
    }

    public final /* synthetic */ void accept(int i11) {
        C0314y0.k0();
        throw null;
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        l((Long) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    public void end() {
        this.f29169a.end();
    }

    public boolean h() {
        return this.f29169a.h();
    }

    public final C0152f0 i(C0152f0 f0Var) {
        Objects.requireNonNull(f0Var);
        return new C0146c0(this, f0Var);
    }

    public final /* synthetic */ void l(Long l11) {
        C0314y0.i0(this, l11);
    }
}
