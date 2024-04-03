package j$.util;

import j$.util.function.C0150e0;
import j$.util.function.C0152f0;
import j$.util.function.Consumer;
import java.util.Comparator;
import java.util.Spliterator;

public final /* synthetic */ class E implements G {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Spliterator.OfLong f28547a;

    private /* synthetic */ E(Spliterator.OfLong ofLong) {
        this.f28547a = ofLong;
    }

    public static /* synthetic */ G f(Spliterator.OfLong ofLong) {
        if (ofLong == null) {
            return null;
        }
        return ofLong instanceof F ? ((F) ofLong).f28548a : new E(ofLong);
    }

    public final /* synthetic */ boolean a(Consumer consumer) {
        return this.f28547a.tryAdvance(Consumer.Wrapper.convert(consumer));
    }

    public final /* synthetic */ void b(C0152f0 f0Var) {
        this.f28547a.forEachRemaining(C0150e0.a(f0Var));
    }

    public final /* synthetic */ int characteristics() {
        return this.f28547a.characteristics();
    }

    public final /* synthetic */ boolean e(C0152f0 f0Var) {
        return this.f28547a.tryAdvance(C0150e0.a(f0Var));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof E) {
            obj = ((E) obj).f28547a;
        }
        return this.f28547a.equals(obj);
    }

    public final /* synthetic */ long estimateSize() {
        return this.f28547a.estimateSize();
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f28547a.forEachRemaining(Consumer.Wrapper.convert(consumer));
    }

    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f28547a.forEachRemaining(obj);
    }

    public final /* synthetic */ Comparator getComparator() {
        return this.f28547a.getComparator();
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f28547a.getExactSizeIfKnown();
    }

    public final /* synthetic */ boolean hasCharacteristics(int i11) {
        return this.f28547a.hasCharacteristics(i11);
    }

    public final /* synthetic */ int hashCode() {
        return this.f28547a.hashCode();
    }

    public final /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f28547a.tryAdvance(obj);
    }
}
