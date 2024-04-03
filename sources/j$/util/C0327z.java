package j$.util;

import j$.util.function.C0161k;
import j$.util.function.Consumer;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* renamed from: j$.util.z  reason: case insensitive filesystem */
public final /* synthetic */ class C0327z implements Spliterator.OfDouble {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ A f29301a;

    private /* synthetic */ C0327z(A a11) {
        this.f29301a = a11;
    }

    public static /* synthetic */ Spliterator.OfDouble a(A a11) {
        if (a11 == null) {
            return null;
        }
        return a11 instanceof C0326y ? ((C0326y) a11).f29300a : new C0327z(a11);
    }

    public final /* synthetic */ int characteristics() {
        return this.f29301a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        A a11 = this.f29301a;
        if (obj instanceof C0327z) {
            obj = ((C0327z) obj).f29301a;
        }
        return a11.equals(obj);
    }

    public final /* synthetic */ long estimateSize() {
        return this.f29301a.estimateSize();
    }

    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f29301a.forEachRemaining(obj);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f29301a.forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
        this.f29301a.d(C0161k.a(doubleConsumer));
    }

    public final /* synthetic */ Comparator getComparator() {
        return this.f29301a.getComparator();
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f29301a.getExactSizeIfKnown();
    }

    public final /* synthetic */ boolean hasCharacteristics(int i11) {
        return this.f29301a.hasCharacteristics(i11);
    }

    public final /* synthetic */ int hashCode() {
        return this.f29301a.hashCode();
    }

    public final /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f29301a.tryAdvance(obj);
    }

    public final /* synthetic */ boolean tryAdvance(java.util.function.Consumer consumer) {
        return this.f29301a.a(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final /* synthetic */ boolean tryAdvance(DoubleConsumer doubleConsumer) {
        return this.f29301a.o(C0161k.a(doubleConsumer));
    }
}
