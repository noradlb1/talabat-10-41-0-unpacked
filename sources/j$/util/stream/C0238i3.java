package j$.util.stream;

import j$.util.function.C0146c0;
import j$.util.function.C0152f0;
import java.util.Objects;

/* renamed from: j$.util.stream.i3  reason: case insensitive filesystem */
final class C0238i3 extends C0243j3 implements C0152f0 {

    /* renamed from: c  reason: collision with root package name */
    final long[] f29161c;

    C0238i3(int i11) {
        this.f29161c = new long[i11];
    }

    public final void a(Object obj, long j11) {
        C0152f0 f0Var = (C0152f0) obj;
        for (int i11 = 0; ((long) i11) < j11; i11++) {
            f0Var.accept(this.f29161c[i11]);
        }
    }

    public final void accept(long j11) {
        int i11 = this.f29167b;
        this.f29167b = i11 + 1;
        this.f29161c[i11] = j11;
    }

    public final C0152f0 i(C0152f0 f0Var) {
        Objects.requireNonNull(f0Var);
        return new C0146c0(this, f0Var);
    }
}
