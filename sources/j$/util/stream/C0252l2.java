package j$.util.stream;

import j$.util.function.Consumer;
import java.util.Objects;

/* renamed from: j$.util.stream.l2  reason: case insensitive filesystem */
public abstract class C0252l2 implements C0272p2 {

    /* renamed from: a  reason: collision with root package name */
    protected final C0272p2 f29177a;

    public C0252l2(C0272p2 p2Var) {
        Objects.requireNonNull(p2Var);
        this.f29177a = p2Var;
    }

    public final /* synthetic */ void accept(double d11) {
        C0314y0.d0();
        throw null;
    }

    public final /* synthetic */ void accept(int i11) {
        C0314y0.k0();
        throw null;
    }

    public final /* synthetic */ void accept(long j11) {
        C0314y0.l0();
        throw null;
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    public void end() {
        this.f29177a.end();
    }

    public boolean h() {
        return this.f29177a.h();
    }
}
