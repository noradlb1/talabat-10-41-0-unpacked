package j$.util.stream;

import j$.util.function.C0159j;
import j$.util.function.C0165m;
import j$.util.function.Consumer;
import java.util.Objects;

/* renamed from: j$.util.stream.i2  reason: case insensitive filesystem */
public abstract class C0237i2 implements C0257m2 {

    /* renamed from: a  reason: collision with root package name */
    protected final C0272p2 f29160a;

    public C0237i2(C0272p2 p2Var) {
        Objects.requireNonNull(p2Var);
        this.f29160a = p2Var;
    }

    public final /* synthetic */ void accept(int i11) {
        C0314y0.k0();
        throw null;
    }

    public final /* synthetic */ void accept(long j11) {
        C0314y0.l0();
        throw null;
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        p((Double) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    public void end() {
        this.f29160a.end();
    }

    public boolean h() {
        return this.f29160a.h();
    }

    public final C0165m m(C0165m mVar) {
        Objects.requireNonNull(mVar);
        return new C0159j(this, mVar);
    }

    public final /* synthetic */ void p(Double d11) {
        C0314y0.e0(this, d11);
    }
}
