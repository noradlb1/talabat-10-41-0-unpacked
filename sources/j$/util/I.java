package j$.util;

import j$.util.function.Consumer;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;

public final /* synthetic */ class I implements Spliterator.OfPrimitive {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ J f28550a;

    private /* synthetic */ I(J j11) {
        this.f28550a = j11;
    }

    public static /* synthetic */ Spliterator.OfPrimitive a(J j11) {
        if (j11 == null) {
            return null;
        }
        return j11 instanceof H ? ((H) j11).f28549a : j11 instanceof A ? C0327z.a((A) j11) : j11 instanceof D ? C.a((D) j11) : j11 instanceof G ? F.a((G) j11) : new I(j11);
    }

    public final /* synthetic */ int characteristics() {
        return this.f28550a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        J j11 = this.f28550a;
        if (obj instanceof I) {
            obj = ((I) obj).f28550a;
        }
        return j11.equals(obj);
    }

    public final /* synthetic */ long estimateSize() {
        return this.f28550a.estimateSize();
    }

    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f28550a.forEachRemaining(obj);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f28550a.forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final /* synthetic */ Comparator getComparator() {
        return this.f28550a.getComparator();
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f28550a.getExactSizeIfKnown();
    }

    public final /* synthetic */ boolean hasCharacteristics(int i11) {
        return this.f28550a.hasCharacteristics(i11);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28550a.hashCode();
    }

    public final /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f28550a.tryAdvance(obj);
    }

    public final /* synthetic */ boolean tryAdvance(java.util.function.Consumer consumer) {
        return this.f28550a.a(Consumer.VivifiedWrapper.convert(consumer));
    }
}
