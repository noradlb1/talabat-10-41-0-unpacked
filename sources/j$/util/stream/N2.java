package j$.util.stream;

import java.util.Arrays;

final class N2 extends B2 {

    /* renamed from: c  reason: collision with root package name */
    private int[] f28987c;

    /* renamed from: d  reason: collision with root package name */
    private int f28988d;

    N2(C0272p2 p2Var) {
        super(p2Var);
    }

    public final void accept(int i11) {
        int[] iArr = this.f28987c;
        int i12 = this.f28988d;
        this.f28988d = i12 + 1;
        iArr[i12] = i11;
    }

    public final void end() {
        int i11 = 0;
        Arrays.sort(this.f28987c, 0, this.f28988d);
        C0272p2 p2Var = this.f29166a;
        p2Var.f((long) this.f28988d);
        if (!this.f28900b) {
            while (i11 < this.f28988d) {
                p2Var.accept(this.f28987c[i11]);
                i11++;
            }
        } else {
            while (i11 < this.f28988d && !p2Var.h()) {
                p2Var.accept(this.f28987c[i11]);
                i11++;
            }
        }
        p2Var.end();
        this.f28987c = null;
    }

    public final void f(long j11) {
        if (j11 < 2147483639) {
            this.f28987c = new int[((int) j11)];
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }
}
