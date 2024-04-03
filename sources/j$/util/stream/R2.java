package j$.util.stream;

import j$.util.A;
import j$.util.C0189n;
import j$.util.J;
import j$.util.Spliterators;
import j$.util.function.C0165m;
import j$.util.function.Consumer;

final class R2 extends X2 implements A {

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ S2 f29028g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    R2(S2 s22, int i11, int i12, int i13, int i14) {
        super(s22, i11, i12, i13, i14);
        this.f29028g = s22;
    }

    public final /* synthetic */ boolean a(Consumer consumer) {
        return C0189n.m(this, consumer);
    }

    /* access modifiers changed from: package-private */
    public final void f(int i11, Object obj, Object obj2) {
        ((C0165m) obj2).accept(((double[]) obj)[i11]);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C0189n.f(this, consumer);
    }

    /* access modifiers changed from: package-private */
    public final J g(Object obj, int i11, int i12) {
        return Spliterators.j((double[]) obj, i11, i12 + i11);
    }

    /* access modifiers changed from: package-private */
    public final J h(int i11, int i12, int i13, int i14) {
        return new R2(this.f29028g, i11, i12, i13, i14);
    }
}
