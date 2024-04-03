package j$.util.stream;

import j$.util.C0189n;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.Supplier;
import java.util.Comparator;

/* renamed from: j$.util.stream.q3  reason: case insensitive filesystem */
class C0278q3 implements Spliterator {

    /* renamed from: a  reason: collision with root package name */
    private final Supplier f29206a;

    /* renamed from: b  reason: collision with root package name */
    private Spliterator f29207b;

    C0278q3(Supplier supplier) {
        this.f29206a = supplier;
    }

    public final boolean a(Consumer consumer) {
        return f().a(consumer);
    }

    public final int characteristics() {
        return f().characteristics();
    }

    public final long estimateSize() {
        return f().estimateSize();
    }

    /* access modifiers changed from: package-private */
    public final Spliterator f() {
        if (this.f29207b == null) {
            this.f29207b = (Spliterator) this.f29206a.get();
        }
        return this.f29207b;
    }

    public final void forEachRemaining(Consumer consumer) {
        f().forEachRemaining(consumer);
    }

    public final Comparator getComparator() {
        return f().getComparator();
    }

    public final long getExactSizeIfKnown() {
        return f().getExactSizeIfKnown();
    }

    public final /* synthetic */ boolean hasCharacteristics(int i11) {
        return C0189n.k(this, i11);
    }

    public final String toString() {
        String name2 = getClass().getName();
        Spliterator f11 = f();
        return name2 + "[" + f11 + "]";
    }

    public final Spliterator trySplit() {
        return f().trySplit();
    }
}
