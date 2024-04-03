package j$.util.stream;

import java.util.Arrays;

final class E2 extends A2 {

    /* renamed from: c  reason: collision with root package name */
    private S2 f28916c;

    E2(C0272p2 p2Var) {
        super(p2Var);
    }

    public final void accept(double d11) {
        this.f28916c.accept(d11);
    }

    public final void end() {
        double[] dArr = (double[]) this.f28916c.b();
        Arrays.sort(dArr);
        C0272p2 p2Var = this.f29160a;
        p2Var.f((long) dArr.length);
        int i11 = 0;
        if (!this.f28894b) {
            int length = dArr.length;
            while (i11 < length) {
                p2Var.accept(dArr[i11]);
                i11++;
            }
        } else {
            int length2 = dArr.length;
            while (i11 < length2) {
                double d11 = dArr[i11];
                if (p2Var.h()) {
                    break;
                }
                p2Var.accept(d11);
                i11++;
            }
        }
        p2Var.end();
    }

    public final void f(long j11) {
        if (j11 < 2147483639) {
            this.f28916c = j11 > 0 ? new S2((int) j11) : new S2();
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }
}
