package j$.util;

import j$.util.function.Consumer;
import j$.util.function.J;
import j$.util.function.K;
import java.util.Comparator;
import java.util.Spliterator;

public final /* synthetic */ class B implements D {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Spliterator.OfInt f28540a;

    private /* synthetic */ B(Spliterator.OfInt ofInt) {
        this.f28540a = ofInt;
    }

    public static /* synthetic */ D f(Spliterator.OfInt ofInt) {
        if (ofInt == null) {
            return null;
        }
        return ofInt instanceof C ? ((C) ofInt).f28541a : new B(ofInt);
    }

    public final /* synthetic */ boolean a(Consumer consumer) {
        return this.f28540a.tryAdvance(Consumer.Wrapper.convert(consumer));
    }

    public final /* synthetic */ void c(K k11) {
        this.f28540a.forEachRemaining(J.a(k11));
    }

    public final /* synthetic */ int characteristics() {
        return this.f28540a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof B) {
            obj = ((B) obj).f28540a;
        }
        return this.f28540a.equals(obj);
    }

    public final /* synthetic */ long estimateSize() {
        return this.f28540a.estimateSize();
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f28540a.forEachRemaining(Consumer.Wrapper.convert(consumer));
    }

    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f28540a.forEachRemaining(obj);
    }

    public final /* synthetic */ Comparator getComparator() {
        return this.f28540a.getComparator();
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f28540a.getExactSizeIfKnown();
    }

    public final /* synthetic */ boolean hasCharacteristics(int i11) {
        return this.f28540a.hasCharacteristics(i11);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28540a.hashCode();
    }

    public final /* synthetic */ boolean j(K k11) {
        return this.f28540a.tryAdvance(J.a(k11));
    }

    public final /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f28540a.tryAdvance(obj);
    }
}
