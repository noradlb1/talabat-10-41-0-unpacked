package j$.util;

import j$.util.function.C0163l;
import j$.util.function.C0165m;
import j$.util.function.Consumer;
import java.util.PrimitiveIterator;

/* renamed from: j$.util.o  reason: case insensitive filesystem */
public final /* synthetic */ class C0190o implements PrimitiveIterator$OfDouble, Iterator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PrimitiveIterator.OfDouble f28884a;

    private /* synthetic */ C0190o(PrimitiveIterator.OfDouble ofDouble) {
        this.f28884a = ofDouble;
    }

    public static /* synthetic */ PrimitiveIterator$OfDouble a(PrimitiveIterator.OfDouble ofDouble) {
        if (ofDouble == null) {
            return null;
        }
        return ofDouble instanceof C0191p ? ((C0191p) ofDouble).f28885a : new C0190o(ofDouble);
    }

    public final /* synthetic */ void d(C0165m mVar) {
        this.f28884a.forEachRemaining(C0163l.a(mVar));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof C0190o) {
            obj = ((C0190o) obj).f28884a;
        }
        return this.f28884a.equals(obj);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f28884a.forEachRemaining(Consumer.Wrapper.convert(consumer));
    }

    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f28884a.forEachRemaining(obj);
    }

    public final /* synthetic */ boolean hasNext() {
        return this.f28884a.hasNext();
    }

    public final /* synthetic */ int hashCode() {
        return this.f28884a.hashCode();
    }

    public final /* synthetic */ double nextDouble() {
        return this.f28884a.nextDouble();
    }

    public final /* synthetic */ void remove() {
        this.f28884a.remove();
    }
}
