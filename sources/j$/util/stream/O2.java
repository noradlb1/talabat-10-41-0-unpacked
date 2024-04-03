package j$.util.stream;

import java.util.Arrays;

final class O2 extends C2 {

    /* renamed from: c  reason: collision with root package name */
    private long[] f29002c;

    /* renamed from: d  reason: collision with root package name */
    private int f29003d;

    O2(C0272p2 p2Var) {
        super(p2Var);
    }

    public final void accept(long j11) {
        long[] jArr = this.f29002c;
        int i11 = this.f29003d;
        this.f29003d = i11 + 1;
        jArr[i11] = j11;
    }

    public final void end() {
        int i11 = 0;
        Arrays.sort(this.f29002c, 0, this.f29003d);
        C0272p2 p2Var = this.f29169a;
        p2Var.f((long) this.f29003d);
        if (!this.f28905b) {
            while (i11 < this.f29003d) {
                p2Var.accept(this.f29002c[i11]);
                i11++;
            }
        } else {
            while (i11 < this.f29003d && !p2Var.h()) {
                p2Var.accept(this.f29002c[i11]);
                i11++;
            }
        }
        p2Var.end();
        this.f29002c = null;
    }

    public final void f(long j11) {
        if (j11 < 2147483639) {
            this.f29002c = new long[((int) j11)];
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }
}
