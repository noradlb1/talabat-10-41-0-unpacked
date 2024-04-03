package j$.util;

import j$.util.function.Consumer;
import j$.util.function.I;
import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* renamed from: j$.util.s  reason: case insensitive filesystem */
public final /* synthetic */ class C0193s implements PrimitiveIterator.OfInt {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PrimitiveIterator$OfInt f28888a;

    private /* synthetic */ C0193s(PrimitiveIterator$OfInt primitiveIterator$OfInt) {
        this.f28888a = primitiveIterator$OfInt;
    }

    public static /* synthetic */ PrimitiveIterator.OfInt a(PrimitiveIterator$OfInt primitiveIterator$OfInt) {
        if (primitiveIterator$OfInt == null) {
            return null;
        }
        return primitiveIterator$OfInt instanceof r ? ((r) primitiveIterator$OfInt).f28887a : new C0193s(primitiveIterator$OfInt);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        PrimitiveIterator$OfInt primitiveIterator$OfInt = this.f28888a;
        if (obj instanceof C0193s) {
            obj = ((C0193s) obj).f28888a;
        }
        return primitiveIterator$OfInt.equals(obj);
    }

    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f28888a.forEachRemaining(obj);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f28888a.forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
        this.f28888a.c(I.a(intConsumer));
    }

    public final /* synthetic */ boolean hasNext() {
        return this.f28888a.hasNext();
    }

    public final /* synthetic */ int hashCode() {
        return this.f28888a.hashCode();
    }

    public final /* synthetic */ int nextInt() {
        return this.f28888a.nextInt();
    }

    public final /* synthetic */ void remove() {
        this.f28888a.remove();
    }
}
