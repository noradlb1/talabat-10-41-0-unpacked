package j$.util;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

class X implements Spliterator {

    /* renamed from: a  reason: collision with root package name */
    private final Collection f28589a;

    /* renamed from: b  reason: collision with root package name */
    private Iterator f28590b;

    /* renamed from: c  reason: collision with root package name */
    private final int f28591c;

    /* renamed from: d  reason: collision with root package name */
    private long f28592d;

    /* renamed from: e  reason: collision with root package name */
    private int f28593e;

    public X(int i11, Collection collection) {
        this.f28589a = collection;
        this.f28590b = null;
        this.f28591c = (i11 & 4096) == 0 ? i11 | 64 | 16384 : i11;
    }

    public X(Iterator it, int i11) {
        this.f28589a = null;
        this.f28590b = it;
        this.f28592d = Long.MAX_VALUE;
        this.f28591c = i11 & -16449;
    }

    public final boolean a(Consumer consumer) {
        consumer.getClass();
        if (this.f28590b == null) {
            Collection collection = this.f28589a;
            this.f28590b = collection.iterator();
            this.f28592d = (long) collection.size();
        }
        if (!this.f28590b.hasNext()) {
            return false;
        }
        consumer.accept(this.f28590b.next());
        return true;
    }

    public final int characteristics() {
        return this.f28591c;
    }

    public final long estimateSize() {
        if (this.f28590b != null) {
            return this.f28592d;
        }
        Collection collection = this.f28589a;
        this.f28590b = collection.iterator();
        long size = (long) collection.size();
        this.f28592d = size;
        return size;
    }

    public final void forEachRemaining(Consumer consumer) {
        consumer.getClass();
        Iterator it = this.f28590b;
        if (it == null) {
            Collection collection = this.f28589a;
            Iterator it2 = collection.iterator();
            this.f28590b = it2;
            this.f28592d = (long) collection.size();
            it = it2;
        }
        Iterator.EL.forEachRemaining(it, consumer);
    }

    public Comparator getComparator() {
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
        long j11;
        java.util.Iterator it = this.f28590b;
        if (it == null) {
            Collection collection = this.f28589a;
            java.util.Iterator it2 = collection.iterator();
            this.f28590b = it2;
            j11 = (long) collection.size();
            this.f28592d = j11;
            it = it2;
        } else {
            j11 = this.f28592d;
        }
        if (j11 <= 1 || !it.hasNext()) {
            return null;
        }
        int i11 = this.f28593e + 1024;
        if (((long) i11) > j11) {
            i11 = (int) j11;
        }
        if (i11 > 33554432) {
            i11 = 33554432;
        }
        Object[] objArr = new Object[i11];
        int i12 = 0;
        do {
            objArr[i12] = it.next();
            i12++;
            if (i12 >= i11 || !it.hasNext()) {
                this.f28593e = i12;
                long j12 = this.f28592d;
            }
            objArr[i12] = it.next();
            i12++;
            break;
        } while (!it.hasNext());
        this.f28593e = i12;
        long j122 = this.f28592d;
        if (j122 != Long.MAX_VALUE) {
            this.f28592d = j122 - ((long) i12);
        }
        return new P(objArr, 0, i12, this.f28591c);
    }
}
