package j$.util.stream;

import java.util.Arrays;

final class F2 extends B2 {

    /* renamed from: c  reason: collision with root package name */
    private U2 f28920c;

    F2(C0272p2 p2Var) {
        super(p2Var);
    }

    public final void accept(int i11) {
        this.f28920c.accept(i11);
    }

    public final void end() {
        int[] iArr = (int[]) this.f28920c.b();
        Arrays.sort(iArr);
        C0272p2 p2Var = this.f29166a;
        p2Var.f((long) iArr.length);
        int i11 = 0;
        if (!this.f28900b) {
            int length = iArr.length;
            while (i11 < length) {
                p2Var.accept(iArr[i11]);
                i11++;
            }
        } else {
            int length2 = iArr.length;
            while (i11 < length2) {
                int i12 = iArr[i11];
                if (p2Var.h()) {
                    break;
                }
                p2Var.accept(i12);
                i11++;
            }
        }
        p2Var.end();
    }

    public final void f(long j11) {
        if (j11 < 2147483639) {
            this.f28920c = j11 > 0 ? new U2((int) j11) : new U2();
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }
}
