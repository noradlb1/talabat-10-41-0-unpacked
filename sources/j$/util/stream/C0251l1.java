package j$.util.stream;

import j$.util.C0189n;
import j$.util.Spliterator;
import java.util.ArrayDeque;
import java.util.Comparator;

/* renamed from: j$.util.stream.l1  reason: case insensitive filesystem */
abstract class C0251l1 implements Spliterator {

    /* renamed from: a  reason: collision with root package name */
    H0 f29172a;

    /* renamed from: b  reason: collision with root package name */
    int f29173b;

    /* renamed from: c  reason: collision with root package name */
    Spliterator f29174c;

    /* renamed from: d  reason: collision with root package name */
    Spliterator f29175d;

    /* renamed from: e  reason: collision with root package name */
    ArrayDeque f29176e;

    C0251l1(H0 h02) {
        this.f29172a = h02;
    }

    protected static H0 f(ArrayDeque arrayDeque) {
        while (true) {
            H0 h02 = (H0) arrayDeque.pollFirst();
            if (h02 != null) {
                if (h02.j() != 0) {
                    int j11 = h02.j();
                    while (true) {
                        j11--;
                        if (j11 < 0) {
                            break;
                        }
                        arrayDeque.addFirst(h02.a(j11));
                    }
                } else if (h02.count() > 0) {
                    return h02;
                }
            } else {
                return null;
            }
        }
    }

    public final int characteristics() {
        return 64;
    }

    public final long estimateSize() {
        long j11 = 0;
        if (this.f29172a == null) {
            return 0;
        }
        Spliterator spliterator = this.f29174c;
        if (spliterator != null) {
            return spliterator.estimateSize();
        }
        for (int i11 = this.f29173b; i11 < this.f29172a.j(); i11++) {
            j11 += this.f29172a.a(i11).count();
        }
        return j11;
    }

    /* access modifiers changed from: protected */
    public final ArrayDeque g() {
        ArrayDeque arrayDeque = new ArrayDeque(8);
        int j11 = this.f29172a.j();
        while (true) {
            j11--;
            if (j11 < this.f29173b) {
                return arrayDeque;
            }
            arrayDeque.addFirst(this.f29172a.a(j11));
        }
    }

    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return C0189n.i(this);
    }

    /* access modifiers changed from: protected */
    public final boolean h() {
        if (this.f29172a == null) {
            return false;
        }
        if (this.f29175d != null) {
            return true;
        }
        Spliterator spliterator = this.f29174c;
        if (spliterator == null) {
            ArrayDeque g11 = g();
            this.f29176e = g11;
            H0 f11 = f(g11);
            if (f11 != null) {
                spliterator = f11.spliterator();
            } else {
                this.f29172a = null;
                return false;
            }
        }
        this.f29175d = spliterator;
        return true;
    }

    public final /* synthetic */ boolean hasCharacteristics(int i11) {
        return C0189n.k(this, i11);
    }

    public final Spliterator trySplit() {
        H0 h02 = this.f29172a;
        if (h02 == null || this.f29175d != null) {
            return null;
        }
        Spliterator spliterator = this.f29174c;
        if (spliterator != null) {
            return spliterator.trySplit();
        }
        if (this.f29173b < h02.j() - 1) {
            H0 h03 = this.f29172a;
            int i11 = this.f29173b;
            this.f29173b = i11 + 1;
            return h03.a(i11).spliterator();
        }
        H0 a11 = this.f29172a.a(this.f29173b);
        this.f29172a = a11;
        if (a11.j() == 0) {
            Spliterator spliterator2 = this.f29172a.spliterator();
            this.f29174c = spliterator2;
            return spliterator2.trySplit();
        }
        H0 h04 = this.f29172a;
        this.f29173b = 0 + 1;
        return h04.a(0).spliterator();
    }
}
