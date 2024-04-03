package j$.util;

import j$.util.function.C0163l;
import j$.util.function.C0165m;
import j$.util.function.Consumer;
import java.util.Comparator;
import java.util.Spliterator;

/* renamed from: j$.util.y  reason: case insensitive filesystem */
public final /* synthetic */ class C0326y implements A {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Spliterator.OfDouble f29300a;

    private /* synthetic */ C0326y(Spliterator.OfDouble ofDouble) {
        this.f29300a = ofDouble;
    }

    public static /* synthetic */ A f(Spliterator.OfDouble ofDouble) {
        if (ofDouble == null) {
            return null;
        }
        return ofDouble instanceof C0327z ? ((C0327z) ofDouble).f29301a : new C0326y(ofDouble);
    }

    public final /* synthetic */ boolean a(Consumer consumer) {
        return this.f29300a.tryAdvance(Consumer.Wrapper.convert(consumer));
    }

    public final /* synthetic */ int characteristics() {
        return this.f29300a.characteristics();
    }

    public final /* synthetic */ void d(C0165m mVar) {
        this.f29300a.forEachRemaining(C0163l.a(mVar));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof C0326y) {
            obj = ((C0326y) obj).f29300a;
        }
        return this.f29300a.equals(obj);
    }

    public final /* synthetic */ long estimateSize() {
        return this.f29300a.estimateSize();
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f29300a.forEachRemaining(Consumer.Wrapper.convert(consumer));
    }

    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f29300a.forEachRemaining(obj);
    }

    public final /* synthetic */ Comparator getComparator() {
        return this.f29300a.getComparator();
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f29300a.getExactSizeIfKnown();
    }

    public final /* synthetic */ boolean hasCharacteristics(int i11) {
        return this.f29300a.hasCharacteristics(i11);
    }

    public final /* synthetic */ int hashCode() {
        return this.f29300a.hashCode();
    }

    public final /* synthetic */ boolean o(C0165m mVar) {
        return this.f29300a.tryAdvance(C0163l.a(mVar));
    }

    public final /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f29300a.tryAdvance(obj);
    }
}
