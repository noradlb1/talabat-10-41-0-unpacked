package j$.util.concurrent;

import j$.util.C0189n;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import java.util.Comparator;

/* renamed from: j$.util.concurrent.g  reason: case insensitive filesystem */
final class C0121g extends N implements Spliterator {

    /* renamed from: i  reason: collision with root package name */
    final ConcurrentHashMap f28706i;

    /* renamed from: j  reason: collision with root package name */
    long f28707j;

    C0121g(E[] eArr, int i11, int i12, int i13, long j11, ConcurrentHashMap concurrentHashMap) {
        super(eArr, i11, i12, i13);
        this.f28706i = concurrentHashMap;
        this.f28707j = j11;
    }

    public final boolean a(Consumer consumer) {
        consumer.getClass();
        E f11 = f();
        if (f11 == null) {
            return false;
        }
        consumer.accept(new C0128n(f11.f28632b, f11.f28633c, this.f28706i));
        return true;
    }

    public final int characteristics() {
        return 4353;
    }

    public final long estimateSize() {
        return this.f28707j;
    }

    public final void forEachRemaining(Consumer consumer) {
        consumer.getClass();
        while (true) {
            E f11 = f();
            if (f11 != null) {
                consumer.accept(new C0128n(f11.f28632b, f11.f28633c, this.f28706i));
            } else {
                return;
            }
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
        int i11 = this.f28659f;
        int i12 = this.f28660g;
        int i13 = (i11 + i12) >>> 1;
        if (i13 <= i11) {
            return null;
        }
        E[] eArr = this.f28654a;
        int i14 = this.f28661h;
        this.f28660g = i13;
        long j11 = this.f28707j >>> 1;
        this.f28707j = j11;
        return new C0121g(eArr, i14, i13, i12, j11, this.f28706i);
    }
}
