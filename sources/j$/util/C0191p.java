package j$.util;

import j$.util.function.C0161k;
import j$.util.function.Consumer;
import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* renamed from: j$.util.p  reason: case insensitive filesystem */
public final /* synthetic */ class C0191p implements PrimitiveIterator.OfDouble {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PrimitiveIterator$OfDouble f28885a;

    private /* synthetic */ C0191p(PrimitiveIterator$OfDouble primitiveIterator$OfDouble) {
        this.f28885a = primitiveIterator$OfDouble;
    }

    public static /* synthetic */ PrimitiveIterator.OfDouble a(PrimitiveIterator$OfDouble primitiveIterator$OfDouble) {
        if (primitiveIterator$OfDouble == null) {
            return null;
        }
        return primitiveIterator$OfDouble instanceof C0190o ? ((C0190o) primitiveIterator$OfDouble).f28884a : new C0191p(primitiveIterator$OfDouble);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        PrimitiveIterator$OfDouble primitiveIterator$OfDouble = this.f28885a;
        if (obj instanceof C0191p) {
            obj = ((C0191p) obj).f28885a;
        }
        return primitiveIterator$OfDouble.equals(obj);
    }

    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f28885a.forEachRemaining(obj);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f28885a.forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
        this.f28885a.d(C0161k.a(doubleConsumer));
    }

    public final /* synthetic */ boolean hasNext() {
        return this.f28885a.hasNext();
    }

    public final /* synthetic */ int hashCode() {
        return this.f28885a.hashCode();
    }

    public final /* synthetic */ double nextDouble() {
        return this.f28885a.nextDouble();
    }

    public final /* synthetic */ void remove() {
        this.f28885a.remove();
    }
}
