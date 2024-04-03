package j$.util;

import j$.util.function.C0159j;
import j$.util.function.C0165m;
import java.util.Objects;

/* renamed from: j$.util.f  reason: case insensitive filesystem */
public final class C0140f implements C0165m {

    /* renamed from: a  reason: collision with root package name */
    private double f28780a;

    /* renamed from: b  reason: collision with root package name */
    private double f28781b;
    private long count;
    private double max = Double.NEGATIVE_INFINITY;
    private double min = Double.POSITIVE_INFINITY;
    private double sum;

    public final void a(C0140f fVar) {
        this.count += fVar.count;
        this.f28781b += fVar.f28781b;
        double d11 = fVar.sum - this.f28780a;
        double d12 = this.sum;
        double d13 = d12 + d11;
        double d14 = (d13 - d12) - d11;
        this.f28780a = d14;
        double d15 = fVar.f28780a - d14;
        double d16 = d13 + d15;
        this.f28780a = (d16 - d13) - d15;
        this.sum = d16;
        this.min = Math.min(this.min, fVar.min);
        this.max = Math.max(this.max, fVar.max);
    }

    public final void accept(double d11) {
        this.count++;
        this.f28781b += d11;
        double d12 = d11 - this.f28780a;
        double d13 = this.sum;
        double d14 = d13 + d12;
        this.f28780a = (d14 - d13) - d12;
        this.sum = d14;
        this.min = Math.min(this.min, d11);
        this.max = Math.max(this.max, d11);
    }

    public final C0165m m(C0165m mVar) {
        Objects.requireNonNull(mVar);
        return new C0159j(this, mVar);
    }

    public final String toString() {
        double d11;
        Object[] objArr = new Object[6];
        objArr[0] = C0140f.class.getSimpleName();
        objArr[1] = Long.valueOf(this.count);
        double d12 = this.sum + this.f28780a;
        if (Double.isNaN(d12) && Double.isInfinite(this.f28781b)) {
            d12 = this.f28781b;
        }
        objArr[2] = Double.valueOf(d12);
        objArr[3] = Double.valueOf(this.min);
        if (this.count > 0) {
            double d13 = this.sum + this.f28780a;
            if (Double.isNaN(d13) && Double.isInfinite(this.f28781b)) {
                d13 = this.f28781b;
            }
            d11 = d13 / ((double) this.count);
        } else {
            d11 = 0.0d;
        }
        objArr[4] = Double.valueOf(d11);
        objArr[5] = Double.valueOf(this.max);
        return String.format("%s{count=%d, sum=%f, min=%f, average=%f, max=%f}", objArr);
    }
}
