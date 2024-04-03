package j$.util;

import j$.util.function.C0150e0;
import j$.util.function.C0152f0;
import j$.util.function.Consumer;
import java.util.PrimitiveIterator;

/* renamed from: j$.util.u  reason: case insensitive filesystem */
public final /* synthetic */ class C0322u implements PrimitiveIterator$OfLong, Iterator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PrimitiveIterator.OfLong f29297a;

    private /* synthetic */ C0322u(PrimitiveIterator.OfLong ofLong) {
        this.f29297a = ofLong;
    }

    public static /* synthetic */ PrimitiveIterator$OfLong a(PrimitiveIterator.OfLong ofLong) {
        if (ofLong == null) {
            return null;
        }
        return ofLong instanceof C0323v ? ((C0323v) ofLong).f29298a : new C0322u(ofLong);
    }

    public final /* synthetic */ void b(C0152f0 f0Var) {
        this.f29297a.forEachRemaining(C0150e0.a(f0Var));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof C0322u) {
            obj = ((C0322u) obj).f29297a;
        }
        return this.f29297a.equals(obj);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f29297a.forEachRemaining(Consumer.Wrapper.convert(consumer));
    }

    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f29297a.forEachRemaining(obj);
    }

    public final /* synthetic */ boolean hasNext() {
        return this.f29297a.hasNext();
    }

    public final /* synthetic */ int hashCode() {
        return this.f29297a.hashCode();
    }

    public final /* synthetic */ long nextLong() {
        return this.f29297a.nextLong();
    }

    public final /* synthetic */ void remove() {
        this.f29297a.remove();
    }
}
