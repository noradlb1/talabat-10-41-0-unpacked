package j$.util;

import j$.util.function.Consumer;
import java.util.Comparator;

final class P implements Spliterator {

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f28566a;

    /* renamed from: b  reason: collision with root package name */
    private int f28567b;

    /* renamed from: c  reason: collision with root package name */
    private final int f28568c;

    /* renamed from: d  reason: collision with root package name */
    private final int f28569d;

    public P(Object[] objArr, int i11, int i12, int i13) {
        this.f28566a = objArr;
        this.f28567b = i11;
        this.f28568c = i12;
        this.f28569d = i13 | 64 | 16384;
    }

    public final boolean a(Consumer consumer) {
        consumer.getClass();
        int i11 = this.f28567b;
        if (i11 < 0 || i11 >= this.f28568c) {
            return false;
        }
        this.f28567b = i11 + 1;
        consumer.accept(this.f28566a[i11]);
        return true;
    }

    public final int characteristics() {
        return this.f28569d;
    }

    public final long estimateSize() {
        return (long) (this.f28568c - this.f28567b);
    }

    public final void forEachRemaining(Consumer consumer) {
        int i11;
        consumer.getClass();
        Object[] objArr = this.f28566a;
        int length = objArr.length;
        int i12 = this.f28568c;
        if (length >= i12 && (i11 = this.f28567b) >= 0) {
            this.f28567b = i12;
            if (i11 < i12) {
                do {
                    consumer.accept(objArr[i11]);
                    i11++;
                } while (i11 < i12);
            }
        }
    }

    public final Comparator getComparator() {
        if (C0189n.k(this, 4)) {
            return null;
        }
        throw new IllegalStateException();
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return C0189n.i(this);
    }

    public final /* synthetic */ boolean hasCharacteristics(int i11) {
        return C0189n.k(this, i11);
    }

    public final Spliterator trySplit() {
        int i11 = this.f28567b;
        int i12 = (this.f28568c + i11) >>> 1;
        if (i11 >= i12) {
            return null;
        }
        this.f28567b = i12;
        return new P(this.f28566a, i11, i12, this.f28569d);
    }
}
