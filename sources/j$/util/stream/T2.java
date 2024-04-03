package j$.util.stream;

import j$.util.C0189n;
import j$.util.D;
import j$.util.J;
import j$.util.Spliterators;
import j$.util.function.Consumer;
import j$.util.function.K;

final class T2 extends X2 implements D {

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ U2 f29040g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    T2(U2 u22, int i11, int i12, int i13, int i14) {
        super(u22, i11, i12, i13, i14);
        this.f29040g = u22;
    }

    public final /* synthetic */ boolean a(Consumer consumer) {
        return C0189n.n(this, consumer);
    }

    /* access modifiers changed from: package-private */
    public final void f(int i11, Object obj, Object obj2) {
        ((K) obj2).accept(((int[]) obj)[i11]);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C0189n.g(this, consumer);
    }

    /* access modifiers changed from: package-private */
    public final J g(Object obj, int i11, int i12) {
        return Spliterators.k((int[]) obj, i11, i12 + i11);
    }

    /* access modifiers changed from: package-private */
    public final J h(int i11, int i12, int i13, int i14) {
        return new T2(this.f29040g, i11, i12, i13, i14);
    }
}
