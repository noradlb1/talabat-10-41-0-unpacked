package j$.util;

import j$.util.function.C0148d0;
import j$.util.function.Consumer;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

public final /* synthetic */ class F implements Spliterator.OfLong {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ G f28548a;

    private /* synthetic */ F(G g11) {
        this.f28548a = g11;
    }

    public static /* synthetic */ Spliterator.OfLong a(G g11) {
        if (g11 == null) {
            return null;
        }
        return g11 instanceof E ? ((E) g11).f28547a : new F(g11);
    }

    public final /* synthetic */ int characteristics() {
        return this.f28548a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        G g11 = this.f28548a;
        if (obj instanceof F) {
            obj = ((F) obj).f28548a;
        }
        return g11.equals(obj);
    }

    public final /* synthetic */ long estimateSize() {
        return this.f28548a.estimateSize();
    }

    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f28548a.forEachRemaining(obj);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f28548a.forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
        this.f28548a.b(C0148d0.a(longConsumer));
    }

    public final /* synthetic */ Comparator getComparator() {
        return this.f28548a.getComparator();
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f28548a.getExactSizeIfKnown();
    }

    public final /* synthetic */ boolean hasCharacteristics(int i11) {
        return this.f28548a.hasCharacteristics(i11);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28548a.hashCode();
    }

    public final /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f28548a.tryAdvance(obj);
    }

    public final /* synthetic */ boolean tryAdvance(java.util.function.Consumer consumer) {
        return this.f28548a.a(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final /* synthetic */ boolean tryAdvance(LongConsumer longConsumer) {
        return this.f28548a.e(C0148d0.a(longConsumer));
    }
}
