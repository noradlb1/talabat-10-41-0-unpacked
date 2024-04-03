package j$.util;

import j$.util.function.Consumer;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Objects;

/* renamed from: j$.util.a  reason: case insensitive filesystem */
final class C0112a implements Spliterator {

    /* renamed from: a  reason: collision with root package name */
    private final List f28598a;

    /* renamed from: b  reason: collision with root package name */
    private int f28599b;

    /* renamed from: c  reason: collision with root package name */
    private int f28600c;

    private C0112a(C0112a aVar, int i11, int i12) {
        this.f28598a = aVar.f28598a;
        this.f28599b = i11;
        this.f28600c = i12;
    }

    C0112a(List list) {
        this.f28598a = list;
        this.f28599b = 0;
        this.f28600c = -1;
    }

    private int f() {
        int i11 = this.f28600c;
        if (i11 >= 0) {
            return i11;
        }
        int size = this.f28598a.size();
        this.f28600c = size;
        return size;
    }

    public final boolean a(Consumer consumer) {
        consumer.getClass();
        int f11 = f();
        int i11 = this.f28599b;
        if (i11 >= f11) {
            return false;
        }
        this.f28599b = i11 + 1;
        try {
            consumer.accept(this.f28598a.get(i11));
            return true;
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public final int characteristics() {
        return 16464;
    }

    public final long estimateSize() {
        return (long) (f() - this.f28599b);
    }

    public final void forEachRemaining(Consumer consumer) {
        Objects.requireNonNull(consumer);
        int f11 = f();
        int i11 = this.f28599b;
        this.f28599b = f11;
        while (i11 < f11) {
            try {
                consumer.accept(this.f28598a.get(i11));
                i11++;
            } catch (IndexOutOfBoundsException unused) {
                throw new ConcurrentModificationException();
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
        int f11 = f();
        int i11 = this.f28599b;
        int i12 = (f11 + i11) >>> 1;
        if (i11 >= i12) {
            return null;
        }
        this.f28599b = i12;
        return new C0112a(this, i11, i12);
    }
}
