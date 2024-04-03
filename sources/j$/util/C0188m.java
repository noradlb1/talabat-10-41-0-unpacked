package j$.util;

import j$.util.function.C0159j;
import j$.util.function.C0165m;
import j$.util.function.Consumer;
import java.util.Objects;

/* renamed from: j$.util.m  reason: case insensitive filesystem */
public final /* synthetic */ class C0188m implements C0165m {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Consumer f28883a;

    public /* synthetic */ C0188m(Consumer consumer) {
        this.f28883a = consumer;
    }

    public final void accept(double d11) {
        this.f28883a.accept(Double.valueOf(d11));
    }

    public final C0165m m(C0165m mVar) {
        Objects.requireNonNull(mVar);
        return new C0159j(this, mVar);
    }
}
