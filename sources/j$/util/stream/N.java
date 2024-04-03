package j$.util.stream;

import j$.util.function.Consumer;

abstract class N implements V3 {

    /* renamed from: a  reason: collision with root package name */
    boolean f28982a;

    /* renamed from: b  reason: collision with root package name */
    Object f28983b;

    N() {
    }

    public /* synthetic */ void accept(double d11) {
        C0314y0.d0();
        throw null;
    }

    public /* synthetic */ void accept(int i11) {
        C0314y0.k0();
        throw null;
    }

    public /* synthetic */ void accept(long j11) {
        C0314y0.l0();
        throw null;
    }

    /* renamed from: accept */
    public final void p(Object obj) {
        if (!this.f28982a) {
            this.f28982a = true;
            this.f28983b = obj;
        }
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ void end() {
    }

    public final /* synthetic */ void f(long j11) {
    }

    public final boolean h() {
        return this.f28982a;
    }
}
