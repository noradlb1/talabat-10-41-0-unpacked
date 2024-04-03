package j$.util;

import j$.util.function.C0146c0;
import j$.util.function.C0152f0;
import j$.util.function.Consumer;
import java.util.Objects;

/* renamed from: j$.util.t  reason: case insensitive filesystem */
public final /* synthetic */ class C0321t implements C0152f0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Consumer f29296a;

    public /* synthetic */ C0321t(Consumer consumer) {
        this.f29296a = consumer;
    }

    public final void accept(long j11) {
        this.f29296a.accept(Long.valueOf(j11));
    }

    public final C0152f0 i(C0152f0 f0Var) {
        Objects.requireNonNull(f0Var);
        return new C0146c0(this, f0Var);
    }
}
