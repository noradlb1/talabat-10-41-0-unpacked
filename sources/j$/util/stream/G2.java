package j$.util.stream;

import java.util.Arrays;

final class G2 extends C2 {

    /* renamed from: c  reason: collision with root package name */
    private W2 f28924c;

    G2(C0272p2 p2Var) {
        super(p2Var);
    }

    public final void accept(long j11) {
        this.f28924c.accept(j11);
    }

    public final void end() {
        long[] jArr = (long[]) this.f28924c.b();
        Arrays.sort(jArr);
        C0272p2 p2Var = this.f29169a;
        p2Var.f((long) jArr.length);
        int i11 = 0;
        if (!this.f28905b) {
            int length = jArr.length;
            while (i11 < length) {
                p2Var.accept(jArr[i11]);
                i11++;
            }
        } else {
            int length2 = jArr.length;
            while (i11 < length2) {
                long j11 = jArr[i11];
                if (p2Var.h()) {
                    break;
                }
                p2Var.accept(j11);
                i11++;
            }
        }
        p2Var.end();
    }

    public final void f(long j11) {
        if (j11 < 2147483639) {
            this.f28924c = j11 > 0 ? new W2((int) j11) : new W2();
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }
}
