package j$.util.stream;

import j$.util.C0189n;
import j$.util.Spliterator;
import j$.util.Spliterators;
import j$.util.function.Consumer;
import java.util.Comparator;
import java.util.Objects;

final class Q2 implements Spliterator {

    /* renamed from: a  reason: collision with root package name */
    int f29016a;

    /* renamed from: b  reason: collision with root package name */
    final int f29017b;

    /* renamed from: c  reason: collision with root package name */
    int f29018c;

    /* renamed from: d  reason: collision with root package name */
    final int f29019d;

    /* renamed from: e  reason: collision with root package name */
    Object[] f29020e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ Z2 f29021f;

    Q2(Z2 z22, int i11, int i12, int i13, int i14) {
        this.f29021f = z22;
        this.f29016a = i11;
        this.f29017b = i12;
        this.f29018c = i13;
        this.f29019d = i14;
        Object[][] objArr = z22.f29076f;
        this.f29020e = objArr == null ? z22.f29075e : objArr[i11];
    }

    public final boolean a(Consumer consumer) {
        Objects.requireNonNull(consumer);
        int i11 = this.f29016a;
        int i12 = this.f29017b;
        if (i11 >= i12 && (i11 != i12 || this.f29018c >= this.f29019d)) {
            return false;
        }
        Object[] objArr = this.f29020e;
        int i13 = this.f29018c;
        this.f29018c = i13 + 1;
        consumer.accept(objArr[i13]);
        if (this.f29018c == this.f29020e.length) {
            this.f29018c = 0;
            int i14 = this.f29016a + 1;
            this.f29016a = i14;
            Object[][] objArr2 = this.f29021f.f29076f;
            if (objArr2 != null && i14 <= i12) {
                this.f29020e = objArr2[i14];
            }
        }
        return true;
    }

    public final int characteristics() {
        return 16464;
    }

    public final long estimateSize() {
        int i11 = this.f29016a;
        int i12 = this.f29019d;
        int i13 = this.f29017b;
        if (i11 == i13) {
            return ((long) i12) - ((long) this.f29018c);
        }
        long[] jArr = this.f29021f.f29134d;
        return ((jArr[i13] + ((long) i12)) - jArr[i11]) - ((long) this.f29018c);
    }

    public final void forEachRemaining(Consumer consumer) {
        Z2 z22;
        Objects.requireNonNull(consumer);
        int i11 = this.f29016a;
        int i12 = this.f29019d;
        int i13 = this.f29017b;
        if (i11 < i13 || (i11 == i13 && this.f29018c < i12)) {
            int i14 = this.f29018c;
            while (true) {
                z22 = this.f29021f;
                if (i11 >= i13) {
                    break;
                }
                Object[] objArr = z22.f29076f[i11];
                while (i14 < objArr.length) {
                    consumer.accept(objArr[i14]);
                    i14++;
                }
                i11++;
                i14 = 0;
            }
            Object[] objArr2 = this.f29016a == i13 ? this.f29020e : z22.f29076f[i13];
            while (i14 < i12) {
                consumer.accept(objArr2[i14]);
                i14++;
            }
            this.f29016a = i13;
            this.f29018c = i12;
        }
    }

    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return C0189n.i(this);
    }

    public final /* synthetic */ boolean hasCharacteristics(int i11) {
        return C0189n.k(this, i11);
    }

    public final Spliterator trySplit() {
        int i11 = this.f29016a;
        int i12 = this.f29017b;
        if (i11 < i12) {
            int i13 = i12 - 1;
            int i14 = this.f29018c;
            Z2 z22 = this.f29021f;
            Q2 q22 = new Q2(z22, i11, i13, i14, z22.f29076f[i13].length);
            this.f29016a = i12;
            this.f29018c = 0;
            this.f29020e = z22.f29076f[i12];
            return q22;
        } else if (i11 != i12) {
            return null;
        } else {
            int i15 = this.f29018c;
            int i16 = (this.f29019d - i15) / 2;
            if (i16 == 0) {
                return null;
            }
            Spliterator m11 = Spliterators.m(this.f29020e, i15, i15 + i16);
            this.f29018c += i16;
            return m11;
        }
    }
}
