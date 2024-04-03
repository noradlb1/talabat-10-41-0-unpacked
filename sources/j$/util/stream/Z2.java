package j$.util.stream;

import j$.lang.Iterable;
import j$.util.Spliterator;
import j$.util.Spliterators;
import j$.util.function.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

class Z2 extends C0214e implements Consumer, Iterable, Iterable {

    /* renamed from: e  reason: collision with root package name */
    protected Object[] f29075e = new Object[(1 << 4)];

    /* renamed from: f  reason: collision with root package name */
    protected Object[][] f29076f;

    Z2() {
    }

    public void accept(Object obj) {
        long j11;
        int i11 = this.f29132b;
        Object[] objArr = this.f29075e;
        if (i11 == objArr.length) {
            if (this.f29076f == null) {
                Object[][] objArr2 = new Object[8][];
                this.f29076f = objArr2;
                this.f29134d = new long[8];
                objArr2[0] = objArr;
            }
            int i12 = this.f29133c;
            int i13 = i12 + 1;
            Object[][] objArr3 = this.f29076f;
            if (i13 >= objArr3.length || objArr3[i13] == null) {
                if (i12 == 0) {
                    j11 = (long) objArr.length;
                } else {
                    j11 = ((long) objArr3[i12].length) + this.f29134d[i12];
                }
                r(j11 + 1);
            }
            this.f29132b = 0;
            int i14 = this.f29133c + 1;
            this.f29133c = i14;
            this.f29075e = this.f29076f[i14];
        }
        Object[] objArr4 = this.f29075e;
        int i15 = this.f29132b;
        this.f29132b = i15 + 1;
        objArr4[i15] = obj;
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    public final void clear() {
        Object[][] objArr = this.f29076f;
        if (objArr != null) {
            this.f29075e = objArr[0];
            int i11 = 0;
            while (true) {
                Object[] objArr2 = this.f29075e;
                if (i11 >= objArr2.length) {
                    break;
                }
                objArr2[i11] = null;
                i11++;
            }
            this.f29076f = null;
            this.f29134d = null;
        } else {
            for (int i12 = 0; i12 < this.f29132b; i12++) {
                this.f29075e[i12] = null;
            }
        }
        this.f29132b = 0;
        this.f29133c = 0;
    }

    public void forEach(Consumer consumer) {
        for (int i11 = 0; i11 < this.f29133c; i11++) {
            for (Object accept : this.f29076f[i11]) {
                consumer.accept(accept);
            }
        }
        for (int i12 = 0; i12 < this.f29132b; i12++) {
            consumer.accept(this.f29075e[i12]);
        }
    }

    public final /* synthetic */ void forEach(java.util.function.Consumer consumer) {
        forEach(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final Iterator iterator() {
        return Spliterators.i(spliterator());
    }

    /* access modifiers changed from: protected */
    public final void r(long j11) {
        long j12;
        int i11 = this.f29133c;
        if (i11 == 0) {
            j12 = (long) this.f29075e.length;
        } else {
            j12 = ((long) this.f29076f[i11].length) + this.f29134d[i11];
        }
        if (j11 > j12) {
            if (this.f29076f == null) {
                Object[][] objArr = new Object[8][];
                this.f29076f = objArr;
                this.f29134d = new long[8];
                objArr[0] = this.f29075e;
            }
            while (true) {
                i11++;
                if (j11 > j12) {
                    Object[][] objArr2 = this.f29076f;
                    if (i11 >= objArr2.length) {
                        int length = objArr2.length * 2;
                        this.f29076f = (Object[][]) Arrays.copyOf(objArr2, length);
                        this.f29134d = Arrays.copyOf(this.f29134d, length);
                    }
                    int i12 = this.f29131a;
                    if (!(i11 == 0 || i11 == 1)) {
                        i12 = Math.min((i12 + i11) - 1, 30);
                    }
                    int i13 = 1 << i12;
                    Object[][] objArr3 = this.f29076f;
                    objArr3[i11] = new Object[i13];
                    long[] jArr = this.f29134d;
                    int i14 = i11 - 1;
                    jArr[i11] = jArr[i14] + ((long) objArr3[i14].length);
                    j12 += (long) i13;
                } else {
                    return;
                }
            }
        }
    }

    public Spliterator spliterator() {
        return new Q2(this, 0, this.f29133c, 0, this.f29132b);
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        forEach((Consumer) new C0194a(10, arrayList));
        String obj = arrayList.toString();
        return "SpinedBuffer:" + obj;
    }
}
