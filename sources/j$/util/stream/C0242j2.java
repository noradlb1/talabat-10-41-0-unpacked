package j$.util.stream;

import j$.util.function.Consumer;
import j$.util.function.H;
import j$.util.function.K;
import java.util.Objects;

/* renamed from: j$.util.stream.j2  reason: case insensitive filesystem */
public abstract class C0242j2 implements C0262n2 {

    /* renamed from: a  reason: collision with root package name */
    protected final C0272p2 f29166a;

    public C0242j2(C0272p2 p2Var) {
        Objects.requireNonNull(p2Var);
        this.f29166a = p2Var;
    }

    public final /* synthetic */ void accept(double d11) {
        C0314y0.d0();
        throw null;
    }

    public final /* synthetic */ void accept(long j11) {
        C0314y0.l0();
        throw null;
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        g((Integer) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    public void end() {
        this.f29166a.end();
    }

    public final /* synthetic */ void g(Integer num) {
        C0314y0.g0(this, num);
    }

    public boolean h() {
        return this.f29166a.h();
    }

    public final K n(K k11) {
        Objects.requireNonNull(k11);
        return new H(this, k11);
    }
}
