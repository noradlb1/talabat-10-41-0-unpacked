package j$.util;

import j$.util.function.Consumer;
import j$.util.function.J;
import j$.util.function.K;
import java.util.PrimitiveIterator;

public final /* synthetic */ class r implements PrimitiveIterator$OfInt, Iterator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PrimitiveIterator.OfInt f28887a;

    private /* synthetic */ r(PrimitiveIterator.OfInt ofInt) {
        this.f28887a = ofInt;
    }

    public static /* synthetic */ PrimitiveIterator$OfInt a(PrimitiveIterator.OfInt ofInt) {
        if (ofInt == null) {
            return null;
        }
        return ofInt instanceof C0193s ? ((C0193s) ofInt).f28888a : new r(ofInt);
    }

    public final /* synthetic */ void c(K k11) {
        this.f28887a.forEachRemaining(J.a(k11));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof r) {
            obj = ((r) obj).f28887a;
        }
        return this.f28887a.equals(obj);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f28887a.forEachRemaining(Consumer.Wrapper.convert(consumer));
    }

    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f28887a.forEachRemaining(obj);
    }

    public final /* synthetic */ boolean hasNext() {
        return this.f28887a.hasNext();
    }

    public final /* synthetic */ int hashCode() {
        return this.f28887a.hashCode();
    }

    public final /* synthetic */ int nextInt() {
        return this.f28887a.nextInt();
    }

    public final /* synthetic */ void remove() {
        this.f28887a.remove();
    }
}
