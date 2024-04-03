package j$.util.stream;

import java.util.Arrays;
import java.util.Comparator;

final class P2 extends D2 {

    /* renamed from: d  reason: collision with root package name */
    private Object[] f29010d;

    /* renamed from: e  reason: collision with root package name */
    private int f29011e;

    P2(C0272p2 p2Var, Comparator comparator) {
        super(p2Var, comparator);
    }

    public final void accept(Object obj) {
        Object[] objArr = this.f29010d;
        int i11 = this.f29011e;
        this.f29011e = i11 + 1;
        objArr[i11] = obj;
    }

    public final void end() {
        int i11 = 0;
        Arrays.sort(this.f29010d, 0, this.f29011e, this.f28913b);
        C0272p2 p2Var = this.f29177a;
        p2Var.f((long) this.f29011e);
        if (!this.f28914c) {
            while (i11 < this.f29011e) {
                p2Var.accept(this.f29010d[i11]);
                i11++;
            }
        } else {
            while (i11 < this.f29011e && !p2Var.h()) {
                p2Var.accept(this.f29010d[i11]);
                i11++;
            }
        }
        p2Var.end();
        this.f29010d = null;
    }

    public final void f(long j11) {
        if (j11 < 2147483639) {
            this.f29010d = new Object[((int) j11)];
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }
}
