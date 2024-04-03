package j$.util.stream;

import j$.util.function.C0159j;
import j$.util.function.C0165m;
import java.util.Objects;

/* renamed from: j$.util.stream.u  reason: case insensitive filesystem */
public final /* synthetic */ class C0293u implements C0165m {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0272p2 f29239a;

    public /* synthetic */ C0293u(C0272p2 p2Var) {
        this.f29239a = p2Var;
    }

    public final void accept(double d11) {
        this.f29239a.accept(d11);
    }

    public final C0165m m(C0165m mVar) {
        Objects.requireNonNull(mVar);
        return new C0159j(this, mVar);
    }
}
