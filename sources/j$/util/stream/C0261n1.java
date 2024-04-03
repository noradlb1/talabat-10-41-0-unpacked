package j$.util.stream;

import j$.util.function.C0146c0;
import j$.util.function.C0152f0;
import j$.util.function.Consumer;
import java.util.Arrays;
import java.util.Objects;

/* renamed from: j$.util.stream.n1  reason: case insensitive filesystem */
final class C0261n1 extends C0256m1 implements B0 {
    C0261n1(long j11) {
        super(j11);
    }

    public final /* synthetic */ void accept(double d11) {
        C0314y0.d0();
        throw null;
    }

    public final /* synthetic */ void accept(int i11) {
        C0314y0.k0();
        throw null;
    }

    public final void accept(long j11) {
        int i11 = this.f29183b;
        long[] jArr = this.f29182a;
        if (i11 < jArr.length) {
            this.f29183b = i11 + 1;
            jArr[i11] = j11;
            return;
        }
        throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", new Object[]{Integer.valueOf(jArr.length)}));
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        l((Long) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    public final F0 build() {
        int i11 = this.f29183b;
        long[] jArr = this.f29182a;
        if (i11 >= jArr.length) {
            return this;
        }
        throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", new Object[]{Integer.valueOf(this.f29183b), Integer.valueOf(jArr.length)}));
    }

    public final void end() {
        int i11 = this.f29183b;
        long[] jArr = this.f29182a;
        if (i11 < jArr.length) {
            throw new IllegalStateException(String.format("End size %d is less than fixed size %d", new Object[]{Integer.valueOf(this.f29183b), Integer.valueOf(jArr.length)}));
        }
    }

    public final void f(long j11) {
        long[] jArr = this.f29182a;
        if (j11 == ((long) jArr.length)) {
            this.f29183b = 0;
        } else {
            throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", new Object[]{Long.valueOf(j11), Integer.valueOf(jArr.length)}));
        }
    }

    public final /* synthetic */ boolean h() {
        return false;
    }

    public final C0152f0 i(C0152f0 f0Var) {
        Objects.requireNonNull(f0Var);
        return new C0146c0(this, f0Var);
    }

    public final /* synthetic */ void l(Long l11) {
        C0314y0.i0(this, l11);
    }

    public final String toString() {
        long[] jArr = this.f29182a;
        return String.format("LongFixedNodeBuilder[%d][%s]", new Object[]{Integer.valueOf(jArr.length - this.f29183b), Arrays.toString(jArr)});
    }
}
