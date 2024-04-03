package j$.util.stream;

import j$.util.C0189n;
import j$.util.G;
import j$.util.J;
import j$.util.Spliterators;
import j$.util.function.C0152f0;
import j$.util.function.Consumer;

final class V2 extends X2 implements G {

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ W2 f29055g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    V2(W2 w22, int i11, int i12, int i13, int i14) {
        super(w22, i11, i12, i13, i14);
        this.f29055g = w22;
    }

    public final /* synthetic */ boolean a(Consumer consumer) {
        return C0189n.p(this, consumer);
    }

    /* access modifiers changed from: package-private */
    public final void f(int i11, Object obj, Object obj2) {
        ((C0152f0) obj2).accept(((long[]) obj)[i11]);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C0189n.h(this, consumer);
    }

    /* access modifiers changed from: package-private */
    public final J g(Object obj, int i11, int i12) {
        return Spliterators.l((long[]) obj, i11, i12 + i11);
    }

    /* access modifiers changed from: package-private */
    public final J h(int i11, int i12, int i13, int i14) {
        return new V2(this.f29055g, i11, i12, i13, i14);
    }
}
