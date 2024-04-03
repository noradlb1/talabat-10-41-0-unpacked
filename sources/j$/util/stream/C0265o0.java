package j$.util.stream;

import j$.util.C0183h;
import j$.util.C0184i;
import j$.util.C0185j;
import j$.util.C0187l;
import j$.util.function.BiConsumer;
import j$.util.function.C0;
import j$.util.function.C0142a0;
import j$.util.function.C0144b0;
import j$.util.function.C0150e0;
import j$.util.function.C0152f0;
import j$.util.function.C0156h0;
import j$.util.function.C0158i0;
import j$.util.function.C0162k0;
import j$.util.function.C0164l0;
import j$.util.function.C0168n0;
import j$.util.function.C0170o0;
import j$.util.function.D0;
import j$.util.function.I0;
import j$.util.function.Supplier;
import j$.util.function.q0;
import j$.util.function.r0;
import j$.util.function.t0;
import j$.util.function.u0;
import j$.util.stream.IntStream;
import java.util.stream.LongStream;

/* renamed from: j$.util.stream.o0  reason: case insensitive filesystem */
public final /* synthetic */ class C0265o0 implements LongStream {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LongStream f29190a;

    private /* synthetic */ C0265o0(LongStream longStream) {
        this.f29190a = longStream;
    }

    public static /* synthetic */ LongStream v(LongStream longStream) {
        if (longStream == null) {
            return null;
        }
        return longStream instanceof C0270p0 ? ((C0270p0) longStream).f29194a : new C0265o0(longStream);
    }

    public final /* synthetic */ void B(C0152f0 f0Var) {
        this.f29190a.forEach(C0150e0.a(f0Var));
    }

    public final /* synthetic */ DoubleStream F(C0170o0 o0Var) {
        return G.v(this.f29190a.mapToDouble(C0168n0.a(o0Var)));
    }

    public final /* synthetic */ LongStream H(u0 u0Var) {
        return v(this.f29190a.map(t0.a(u0Var)));
    }

    public final /* synthetic */ IntStream N(r0 r0Var) {
        return IntStream.VivifiedWrapper.convert(this.f29190a.mapToInt(q0.a(r0Var)));
    }

    public final /* synthetic */ Stream O(C0158i0 i0Var) {
        return C0198a3.v(this.f29190a.mapToObj(C0156h0.a(i0Var)));
    }

    public final /* synthetic */ boolean W(C0164l0 l0Var) {
        return this.f29190a.anyMatch(C0162k0.a(l0Var));
    }

    public final /* synthetic */ LongStream Y(C0164l0 l0Var) {
        return v(this.f29190a.filter(C0162k0.a(l0Var)));
    }

    public final /* synthetic */ boolean a(C0164l0 l0Var) {
        return this.f29190a.noneMatch(C0162k0.a(l0Var));
    }

    public final /* synthetic */ DoubleStream asDoubleStream() {
        return G.v(this.f29190a.asDoubleStream());
    }

    public final /* synthetic */ C0185j average() {
        return C0184i.b(this.f29190a.average());
    }

    public final /* synthetic */ Stream boxed() {
        return C0198a3.v(this.f29190a.boxed());
    }

    public final /* synthetic */ void close() {
        this.f29190a.close();
    }

    public final /* synthetic */ long count() {
        return this.f29190a.count();
    }

    public final /* synthetic */ LongStream distinct() {
        return v(this.f29190a.distinct());
    }

    public final /* synthetic */ C0187l e(C0144b0 b0Var) {
        return C0184i.d(this.f29190a.reduce(C0142a0.a(b0Var)));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof C0265o0) {
            obj = ((C0265o0) obj).f29190a;
        }
        return this.f29190a.equals(obj);
    }

    public final /* synthetic */ LongStream f(C0152f0 f0Var) {
        return v(this.f29190a.peek(C0150e0.a(f0Var)));
    }

    public final /* synthetic */ C0187l findAny() {
        return C0184i.d(this.f29190a.findAny());
    }

    public final /* synthetic */ C0187l findFirst() {
        return C0184i.d(this.f29190a.findFirst());
    }

    public final /* synthetic */ LongStream g(C0158i0 i0Var) {
        return v(this.f29190a.flatMap(C0156h0.a(i0Var)));
    }

    public final /* synthetic */ int hashCode() {
        return this.f29190a.hashCode();
    }

    public final /* synthetic */ boolean isParallel() {
        return this.f29190a.isParallel();
    }

    public final /* synthetic */ LongStream limit(long j11) {
        return v(this.f29190a.limit(j11));
    }

    public final /* synthetic */ long m(long j11, C0144b0 b0Var) {
        return this.f29190a.reduce(j11, C0142a0.a(b0Var));
    }

    public final /* synthetic */ C0187l max() {
        return C0184i.d(this.f29190a.max());
    }

    public final /* synthetic */ C0187l min() {
        return C0184i.d(this.f29190a.min());
    }

    public final /* synthetic */ BaseStream onClose(Runnable runnable) {
        return C0224g.v(this.f29190a.onClose(runnable));
    }

    public final /* synthetic */ LongStream skip(long j11) {
        return v(this.f29190a.skip(j11));
    }

    public final /* synthetic */ LongStream sorted() {
        return v(this.f29190a.sorted());
    }

    public final /* synthetic */ long sum() {
        return this.f29190a.sum();
    }

    public final C0183h summaryStatistics() {
        this.f29190a.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert from java.util.LongSummaryStatistics");
    }

    public final /* synthetic */ long[] toArray() {
        return this.f29190a.toArray();
    }

    public final /* synthetic */ BaseStream unordered() {
        return C0224g.v(this.f29190a.unordered());
    }

    public final /* synthetic */ void w(C0152f0 f0Var) {
        this.f29190a.forEachOrdered(C0150e0.a(f0Var));
    }

    public final /* synthetic */ Object x(Supplier supplier, D0 d02, BiConsumer biConsumer) {
        return this.f29190a.collect(I0.a(supplier), C0.a(d02), BiConsumer.Wrapper.convert(biConsumer));
    }

    public final /* synthetic */ boolean y(C0164l0 l0Var) {
        return this.f29190a.allMatch(C0162k0.a(l0Var));
    }
}
