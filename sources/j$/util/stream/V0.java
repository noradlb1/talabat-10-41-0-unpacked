package j$.util.stream;

import j$.util.function.C0159j;
import j$.util.function.C0165m;
import j$.util.function.Consumer;
import java.util.Arrays;
import java.util.Objects;

final class V0 extends U0 implements C0318z0 {
    V0(long j11) {
        super(j11);
    }

    public final void accept(double d11) {
        int i11 = this.f29046b;
        double[] dArr = this.f29045a;
        if (i11 < dArr.length) {
            this.f29046b = i11 + 1;
            dArr[i11] = d11;
            return;
        }
        throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", new Object[]{Integer.valueOf(dArr.length)}));
    }

    public final /* synthetic */ void accept(int i11) {
        C0314y0.k0();
        throw null;
    }

    public final /* synthetic */ void accept(long j11) {
        C0314y0.l0();
        throw null;
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        p((Double) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    public final D0 build() {
        int i11 = this.f29046b;
        double[] dArr = this.f29045a;
        if (i11 >= dArr.length) {
            return this;
        }
        throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", new Object[]{Integer.valueOf(this.f29046b), Integer.valueOf(dArr.length)}));
    }

    public final void end() {
        int i11 = this.f29046b;
        double[] dArr = this.f29045a;
        if (i11 < dArr.length) {
            throw new IllegalStateException(String.format("End size %d is less than fixed size %d", new Object[]{Integer.valueOf(this.f29046b), Integer.valueOf(dArr.length)}));
        }
    }

    public final void f(long j11) {
        double[] dArr = this.f29045a;
        if (j11 == ((long) dArr.length)) {
            this.f29046b = 0;
        } else {
            throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", new Object[]{Long.valueOf(j11), Integer.valueOf(dArr.length)}));
        }
    }

    public final /* synthetic */ boolean h() {
        return false;
    }

    public final C0165m m(C0165m mVar) {
        Objects.requireNonNull(mVar);
        return new C0159j(this, mVar);
    }

    public final /* synthetic */ void p(Double d11) {
        C0314y0.e0(this, d11);
    }

    public final String toString() {
        double[] dArr = this.f29045a;
        return String.format("DoubleFixedNodeBuilder[%d][%s]", new Object[]{Integer.valueOf(dArr.length - this.f29046b), Arrays.toString(dArr)});
    }
}
