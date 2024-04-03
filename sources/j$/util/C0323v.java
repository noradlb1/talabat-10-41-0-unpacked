package j$.util;

import j$.util.function.C0148d0;
import j$.util.function.Consumer;
import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* renamed from: j$.util.v  reason: case insensitive filesystem */
public final /* synthetic */ class C0323v implements PrimitiveIterator.OfLong {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PrimitiveIterator$OfLong f29298a;

    private /* synthetic */ C0323v(PrimitiveIterator$OfLong primitiveIterator$OfLong) {
        this.f29298a = primitiveIterator$OfLong;
    }

    public static /* synthetic */ PrimitiveIterator.OfLong a(PrimitiveIterator$OfLong primitiveIterator$OfLong) {
        if (primitiveIterator$OfLong == null) {
            return null;
        }
        return primitiveIterator$OfLong instanceof C0322u ? ((C0322u) primitiveIterator$OfLong).f29297a : new C0323v(primitiveIterator$OfLong);
    }

    public final /* synthetic */ boolean equals(Object obj) {
        PrimitiveIterator$OfLong primitiveIterator$OfLong = this.f29298a;
        if (obj instanceof C0323v) {
            obj = ((C0323v) obj).f29298a;
        }
        return primitiveIterator$OfLong.equals(obj);
    }

    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f29298a.forEachRemaining(obj);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f29298a.forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
        this.f29298a.b(C0148d0.a(longConsumer));
    }

    public final /* synthetic */ boolean hasNext() {
        return this.f29298a.hasNext();
    }

    public final /* synthetic */ int hashCode() {
        return this.f29298a.hashCode();
    }

    public final /* synthetic */ long nextLong() {
        return this.f29298a.nextLong();
    }

    public final /* synthetic */ void remove() {
        this.f29298a.remove();
    }
}
