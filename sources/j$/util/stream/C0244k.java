package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.C0151f;
import j$.util.function.D;
import j$.util.function.I0;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/* renamed from: j$.util.stream.k  reason: case insensitive filesystem */
public final /* synthetic */ class C0244k implements Collector {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Collector f29168a;

    private /* synthetic */ C0244k(Collector collector) {
        this.f29168a = collector;
    }

    public static /* synthetic */ Collector a(Collector collector) {
        if (collector == null) {
            return null;
        }
        return collector instanceof C0239j ? ((C0239j) collector).f29162a : new C0244k(collector);
    }

    public final /* synthetic */ BiConsumer accumulator() {
        return BiConsumer.Wrapper.convert(this.f29168a.accumulator());
    }

    public final /* synthetic */ Set characteristics() {
        return this.f29168a.characteristics();
    }

    public final /* synthetic */ BinaryOperator combiner() {
        return C0151f.a(this.f29168a.combiner());
    }

    public final /* synthetic */ boolean equals(Object obj) {
        Collector collector = this.f29168a;
        if (obj instanceof C0244k) {
            obj = ((C0244k) obj).f29168a;
        }
        return collector.equals(obj);
    }

    public final /* synthetic */ Function finisher() {
        return D.a(this.f29168a.finisher());
    }

    public final /* synthetic */ int hashCode() {
        return this.f29168a.hashCode();
    }

    public final /* synthetic */ Supplier supplier() {
        return I0.a(this.f29168a.supplier());
    }
}
