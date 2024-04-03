package j$.util;

import j$.util.function.Consumer;
import java.util.Comparator;
import java.util.Spliterator;

public final /* synthetic */ class H implements J {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Spliterator.OfPrimitive f28549a;

    private /* synthetic */ H(Spliterator.OfPrimitive ofPrimitive) {
        this.f28549a = ofPrimitive;
    }

    public static /* synthetic */ J f(Spliterator.OfPrimitive ofPrimitive) {
        if (ofPrimitive == null) {
            return null;
        }
        return ofPrimitive instanceof I ? ((I) ofPrimitive).f28550a : ofPrimitive instanceof Spliterator.OfDouble ? C0326y.f((Spliterator.OfDouble) ofPrimitive) : ofPrimitive instanceof Spliterator.OfInt ? B.f((Spliterator.OfInt) ofPrimitive) : ofPrimitive instanceof Spliterator.OfLong ? E.f((Spliterator.OfLong) ofPrimitive) : new H(ofPrimitive);
    }

    public final /* synthetic */ boolean a(Consumer consumer) {
        return this.f28549a.tryAdvance(Consumer.Wrapper.convert(consumer));
    }

    public final /* synthetic */ int characteristics() {
        return this.f28549a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof H) {
            obj = ((H) obj).f28549a;
        }
        return this.f28549a.equals(obj);
    }

    public final /* synthetic */ long estimateSize() {
        return this.f28549a.estimateSize();
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f28549a.forEachRemaining(Consumer.Wrapper.convert(consumer));
    }

    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f28549a.forEachRemaining(obj);
    }

    public final /* synthetic */ Comparator getComparator() {
        return this.f28549a.getComparator();
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f28549a.getExactSizeIfKnown();
    }

    public final /* synthetic */ boolean hasCharacteristics(int i11) {
        return this.f28549a.hasCharacteristics(i11);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28549a.hashCode();
    }

    public final /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f28549a.tryAdvance(obj);
    }
}
