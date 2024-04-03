package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.BinaryOperator;
import j$.util.function.C0149e;
import j$.util.function.Function;
import j$.util.function.H0;
import j$.util.function.Supplier;
import java.util.Set;
import java.util.stream.Collector;

/* renamed from: j$.util.stream.j  reason: case insensitive filesystem */
public final /* synthetic */ class C0239j implements Collector {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Collector f29162a;

    private /* synthetic */ C0239j(Collector collector) {
        this.f29162a = collector;
    }

    public static /* synthetic */ Collector a(Collector collector) {
        if (collector == null) {
            return null;
        }
        return collector instanceof C0244k ? ((C0244k) collector).f29168a : new C0239j(collector);
    }

    public final /* synthetic */ BiConsumer accumulator() {
        return BiConsumer.VivifiedWrapper.convert(this.f29162a.accumulator());
    }

    public final /* synthetic */ Set characteristics() {
        return this.f29162a.characteristics();
    }

    public final /* synthetic */ BinaryOperator combiner() {
        return C0149e.a(this.f29162a.combiner());
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof C0239j) {
            obj = ((C0239j) obj).f29162a;
        }
        return this.f29162a.equals(obj);
    }

    public final /* synthetic */ Function finisher() {
        return Function.VivifiedWrapper.convert(this.f29162a.finisher());
    }

    public final /* synthetic */ int hashCode() {
        return this.f29162a.hashCode();
    }

    public final /* synthetic */ Supplier supplier() {
        return H0.a(this.f29162a.supplier());
    }
}
