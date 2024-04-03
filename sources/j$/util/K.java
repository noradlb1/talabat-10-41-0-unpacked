package j$.util;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import java.util.Comparator;
import java.util.Spliterator;

public final /* synthetic */ class K implements Spliterator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Spliterator f28551a;

    private /* synthetic */ K(Spliterator spliterator) {
        this.f28551a = spliterator;
    }

    public static /* synthetic */ Spliterator f(Spliterator spliterator) {
        if (spliterator == null) {
            return null;
        }
        return spliterator instanceof Spliterator.Wrapper ? Spliterator.this : spliterator instanceof Spliterator.OfPrimitive ? H.f((Spliterator.OfPrimitive) spliterator) : new K(spliterator);
    }

    public final /* synthetic */ boolean a(Consumer consumer) {
        return this.f28551a.tryAdvance(Consumer.Wrapper.convert(consumer));
    }

    public final /* synthetic */ int characteristics() {
        return this.f28551a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof K) {
            obj = ((K) obj).f28551a;
        }
        return this.f28551a.equals(obj);
    }

    public final /* synthetic */ long estimateSize() {
        return this.f28551a.estimateSize();
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f28551a.forEachRemaining(Consumer.Wrapper.convert(consumer));
    }

    public final /* synthetic */ Comparator getComparator() {
        return this.f28551a.getComparator();
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f28551a.getExactSizeIfKnown();
    }

    public final /* synthetic */ boolean hasCharacteristics(int i11) {
        return this.f28551a.hasCharacteristics(i11);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28551a.hashCode();
    }

    public final /* synthetic */ Spliterator trySplit() {
        return f(this.f28551a.trySplit());
    }
}
