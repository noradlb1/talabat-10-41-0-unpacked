package j$.util.stream;

import j$.util.function.C0146c0;
import j$.util.function.C0152f0;
import java.util.Objects;

/* renamed from: j$.util.stream.h0  reason: case insensitive filesystem */
public final /* synthetic */ class C0230h0 implements C0152f0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0272p2 f29155a;

    public /* synthetic */ C0230h0(C0272p2 p2Var) {
        this.f29155a = p2Var;
    }

    public final void accept(long j11) {
        this.f29155a.accept(j11);
    }

    public final C0152f0 i(C0152f0 f0Var) {
        Objects.requireNonNull(f0Var);
        return new C0146c0(this, f0Var);
    }
}
