package j$.util.stream;

import j$.util.function.H;
import j$.util.function.K;
import java.util.Objects;

/* renamed from: j$.util.stream.h3  reason: case insensitive filesystem */
final class C0233h3 extends C0243j3 implements K {

    /* renamed from: c  reason: collision with root package name */
    final int[] f29156c;

    C0233h3(int i11) {
        this.f29156c = new int[i11];
    }

    public final void a(Object obj, long j11) {
        K k11 = (K) obj;
        for (int i11 = 0; ((long) i11) < j11; i11++) {
            k11.accept(this.f29156c[i11]);
        }
    }

    public final void accept(int i11) {
        int i12 = this.f29167b;
        this.f29167b = i12 + 1;
        this.f29156c[i12] = i11;
    }

    public final K n(K k11) {
        Objects.requireNonNull(k11);
        return new H(this, k11);
    }
}
