package j$.util.stream;

import j$.util.function.Consumer;
import j$.util.function.H;
import j$.util.function.K;
import java.util.Arrays;
import java.util.Objects;

/* renamed from: j$.util.stream.e1  reason: case insensitive filesystem */
final class C0216e1 extends C0211d1 implements A0 {
    C0216e1(long j11) {
        super(j11);
    }

    public final /* synthetic */ void accept(double d11) {
        C0314y0.d0();
        throw null;
    }

    public final void accept(int i11) {
        int i12 = this.f29106b;
        int[] iArr = this.f29105a;
        if (i12 < iArr.length) {
            this.f29106b = i12 + 1;
            iArr[i12] = i11;
            return;
        }
        throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", new Object[]{Integer.valueOf(iArr.length)}));
    }

    public final /* synthetic */ void accept(long j11) {
        C0314y0.l0();
        throw null;
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        g((Integer) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    public final E0 build() {
        int i11 = this.f29106b;
        int[] iArr = this.f29105a;
        if (i11 >= iArr.length) {
            return this;
        }
        throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", new Object[]{Integer.valueOf(this.f29106b), Integer.valueOf(iArr.length)}));
    }

    public final void end() {
        int i11 = this.f29106b;
        int[] iArr = this.f29105a;
        if (i11 < iArr.length) {
            throw new IllegalStateException(String.format("End size %d is less than fixed size %d", new Object[]{Integer.valueOf(this.f29106b), Integer.valueOf(iArr.length)}));
        }
    }

    public final void f(long j11) {
        int[] iArr = this.f29105a;
        if (j11 == ((long) iArr.length)) {
            this.f29106b = 0;
        } else {
            throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", new Object[]{Long.valueOf(j11), Integer.valueOf(iArr.length)}));
        }
    }

    public final /* synthetic */ void g(Integer num) {
        C0314y0.g0(this, num);
    }

    public final /* synthetic */ boolean h() {
        return false;
    }

    public final K n(K k11) {
        Objects.requireNonNull(k11);
        return new H(this, k11);
    }

    public final String toString() {
        int[] iArr = this.f29105a;
        return String.format("IntFixedNodeBuilder[%d][%s]", new Object[]{Integer.valueOf(iArr.length - this.f29106b), Arrays.toString(iArr)});
    }
}
