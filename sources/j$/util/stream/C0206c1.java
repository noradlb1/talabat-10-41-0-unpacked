package j$.util.stream;

import j$.util.function.Consumer;
import j$.util.function.IntFunction;
import java.util.Arrays;

/* renamed from: j$.util.stream.c1  reason: case insensitive filesystem */
final class C0206c1 extends K0 implements C0 {
    C0206c1(long j11, IntFunction intFunction) {
        super(j11, intFunction);
    }

    public final /* synthetic */ void accept(double d11) {
        C0314y0.d0();
        throw null;
    }

    public final /* synthetic */ void accept(int i11) {
        C0314y0.k0();
        throw null;
    }

    public final /* synthetic */ void accept(long j11) {
        C0314y0.l0();
        throw null;
    }

    public final void accept(Object obj) {
        int i11 = this.f28959b;
        Object[] objArr = this.f28958a;
        if (i11 < objArr.length) {
            this.f28959b = i11 + 1;
            objArr[i11] = obj;
            return;
        }
        throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", new Object[]{Integer.valueOf(objArr.length)}));
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    public final H0 build() {
        int i11 = this.f28959b;
        Object[] objArr = this.f28958a;
        if (i11 >= objArr.length) {
            return this;
        }
        throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", new Object[]{Integer.valueOf(this.f28959b), Integer.valueOf(objArr.length)}));
    }

    public final void end() {
        int i11 = this.f28959b;
        Object[] objArr = this.f28958a;
        if (i11 < objArr.length) {
            throw new IllegalStateException(String.format("End size %d is less than fixed size %d", new Object[]{Integer.valueOf(this.f28959b), Integer.valueOf(objArr.length)}));
        }
    }

    public final void f(long j11) {
        Object[] objArr = this.f28958a;
        if (j11 == ((long) objArr.length)) {
            this.f28959b = 0;
        } else {
            throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", new Object[]{Long.valueOf(j11), Integer.valueOf(objArr.length)}));
        }
    }

    public final /* synthetic */ boolean h() {
        return false;
    }

    public final String toString() {
        Object[] objArr = this.f28958a;
        return String.format("FixedNodeBuilder[%d][%s]", new Object[]{Integer.valueOf(objArr.length - this.f28959b), Arrays.toString(objArr)});
    }
}
