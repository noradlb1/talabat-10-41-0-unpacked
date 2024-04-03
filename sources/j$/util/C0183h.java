package j$.util;

import j$.util.function.C0146c0;
import j$.util.function.C0152f0;
import j$.util.function.H;
import j$.util.function.K;
import java.util.Objects;

/* renamed from: j$.util.h  reason: case insensitive filesystem */
public final class C0183h implements C0152f0, K {
    private long count;
    private long max = Long.MIN_VALUE;
    private long min = Long.MAX_VALUE;
    private long sum;

    public final void a(C0183h hVar) {
        this.count += hVar.count;
        this.sum += hVar.sum;
        this.min = Math.min(this.min, hVar.min);
        this.max = Math.max(this.max, hVar.max);
    }

    public final void accept(int i11) {
        accept((long) i11);
    }

    public final void accept(long j11) {
        this.count++;
        this.sum += j11;
        this.min = Math.min(this.min, j11);
        this.max = Math.max(this.max, j11);
    }

    public final C0152f0 i(C0152f0 f0Var) {
        Objects.requireNonNull(f0Var);
        return new C0146c0(this, f0Var);
    }

    public final K n(K k11) {
        Objects.requireNonNull(k11);
        return new H(this, k11);
    }

    public final String toString() {
        Object[] objArr = new Object[6];
        objArr[0] = C0183h.class.getSimpleName();
        objArr[1] = Long.valueOf(this.count);
        objArr[2] = Long.valueOf(this.sum);
        objArr[3] = Long.valueOf(this.min);
        long j11 = this.count;
        objArr[4] = Double.valueOf(j11 > 0 ? ((double) this.sum) / ((double) j11) : 0.0d);
        objArr[5] = Long.valueOf(this.max);
        return String.format("%s{count=%d, sum=%d, min=%d, average=%f, max=%d}", objArr);
    }
}
