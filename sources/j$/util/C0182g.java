package j$.util;

import j$.util.function.H;
import j$.util.function.K;
import java.util.Objects;

/* renamed from: j$.util.g  reason: case insensitive filesystem */
public final class C0182g implements K {
    private long count;
    private int max = Integer.MIN_VALUE;
    private int min = Integer.MAX_VALUE;
    private long sum;

    public final void a(C0182g gVar) {
        this.count += gVar.count;
        this.sum += gVar.sum;
        this.min = Math.min(this.min, gVar.min);
        this.max = Math.max(this.max, gVar.max);
    }

    public final void accept(int i11) {
        this.count++;
        this.sum += (long) i11;
        this.min = Math.min(this.min, i11);
        this.max = Math.max(this.max, i11);
    }

    public final K n(K k11) {
        Objects.requireNonNull(k11);
        return new H(this, k11);
    }

    public final String toString() {
        Object[] objArr = new Object[6];
        objArr[0] = C0182g.class.getSimpleName();
        objArr[1] = Long.valueOf(this.count);
        objArr[2] = Long.valueOf(this.sum);
        objArr[3] = Integer.valueOf(this.min);
        long j11 = this.count;
        objArr[4] = Double.valueOf(j11 > 0 ? ((double) this.sum) / ((double) j11) : 0.0d);
        objArr[5] = Integer.valueOf(this.max);
        return String.format("%s{count=%d, sum=%d, min=%d, average=%f, max=%d}", objArr);
    }
}
