package j$.util.stream;

import java.util.Arrays;

final class M2 extends A2 {

    /* renamed from: c  reason: collision with root package name */
    private double[] f28979c;

    /* renamed from: d  reason: collision with root package name */
    private int f28980d;

    M2(C0272p2 p2Var) {
        super(p2Var);
    }

    public final void accept(double d11) {
        double[] dArr = this.f28979c;
        int i11 = this.f28980d;
        this.f28980d = i11 + 1;
        dArr[i11] = d11;
    }

    public final void end() {
        int i11 = 0;
        Arrays.sort(this.f28979c, 0, this.f28980d);
        C0272p2 p2Var = this.f29160a;
        p2Var.f((long) this.f28980d);
        if (!this.f28894b) {
            while (i11 < this.f28980d) {
                p2Var.accept(this.f28979c[i11]);
                i11++;
            }
        } else {
            while (i11 < this.f28980d && !p2Var.h()) {
                p2Var.accept(this.f28979c[i11]);
                i11++;
            }
        }
        p2Var.end();
        this.f28979c = null;
    }

    public final void f(long j11) {
        if (j11 < 2147483639) {
            this.f28979c = new double[((int) j11)];
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }
}
