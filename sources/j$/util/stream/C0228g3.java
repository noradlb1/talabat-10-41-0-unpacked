package j$.util.stream;

import j$.util.function.C0159j;
import j$.util.function.C0165m;
import java.util.Objects;

/* renamed from: j$.util.stream.g3  reason: case insensitive filesystem */
final class C0228g3 extends C0243j3 implements C0165m {

    /* renamed from: c  reason: collision with root package name */
    final double[] f29153c;

    C0228g3(int i11) {
        this.f29153c = new double[i11];
    }

    /* access modifiers changed from: package-private */
    public final void a(Object obj, long j11) {
        C0165m mVar = (C0165m) obj;
        for (int i11 = 0; ((long) i11) < j11; i11++) {
            mVar.accept(this.f29153c[i11]);
        }
    }

    public final void accept(double d11) {
        int i11 = this.f29167b;
        this.f29167b = i11 + 1;
        this.f29153c[i11] = d11;
    }

    public final C0165m m(C0165m mVar) {
        Objects.requireNonNull(mVar);
        return new C0159j(this, mVar);
    }
}
