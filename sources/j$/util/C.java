package j$.util;

import j$.util.function.Consumer;
import j$.util.function.I;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public final /* synthetic */ class C implements Spliterator.OfInt {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ D f28541a;

    private /* synthetic */ C(D d11) {
        this.f28541a = d11;
    }

    public static /* synthetic */ Spliterator.OfInt a(D d11) {
        if (d11 == null) {
            return null;
        }
        return d11 instanceof B ? ((B) d11).f28540a : new C(d11);
    }

    public final /* synthetic */ int characteristics() {
        return this.f28541a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        D d11 = this.f28541a;
        if (obj instanceof C) {
            obj = ((C) obj).f28541a;
        }
        return d11.equals(obj);
    }

    public final /* synthetic */ long estimateSize() {
        return this.f28541a.estimateSize();
    }

    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f28541a.forEachRemaining(obj);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f28541a.forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
        this.f28541a.c(I.a(intConsumer));
    }

    public final /* synthetic */ Comparator getComparator() {
        return this.f28541a.getComparator();
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f28541a.getExactSizeIfKnown();
    }

    public final /* synthetic */ boolean hasCharacteristics(int i11) {
        return this.f28541a.hasCharacteristics(i11);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28541a.hashCode();
    }

    public final /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f28541a.tryAdvance(obj);
    }

    public final /* synthetic */ boolean tryAdvance(java.util.function.Consumer consumer) {
        return this.f28541a.a(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final /* synthetic */ boolean tryAdvance(IntConsumer intConsumer) {
        return this.f28541a.j(I.a(intConsumer));
    }
}
