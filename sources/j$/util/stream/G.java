package j$.util.stream;

import j$.util.C0140f;
import j$.util.C0184i;
import j$.util.C0185j;
import j$.util.function.A;
import j$.util.function.B;
import j$.util.function.BiConsumer;
import j$.util.function.C0155h;
import j$.util.function.C0157i;
import j$.util.function.C0163l;
import j$.util.function.C0165m;
import j$.util.function.C0169o;
import j$.util.function.C0171p;
import j$.util.function.C0174s;
import j$.util.function.C0176u;
import j$.util.function.C0177v;
import j$.util.function.C0179x;
import j$.util.function.C0180y;
import j$.util.function.I0;
import j$.util.function.Supplier;
import j$.util.function.r;
import j$.util.function.w0;
import j$.util.function.x0;
import j$.util.stream.IntStream;
import java.util.stream.DoubleStream;

public final /* synthetic */ class G implements DoubleStream {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DoubleStream f28921a;

    private /* synthetic */ G(DoubleStream doubleStream) {
        this.f28921a = doubleStream;
    }

    public static /* synthetic */ DoubleStream v(DoubleStream doubleStream) {
        if (doubleStream == null) {
            return null;
        }
        return doubleStream instanceof H ? ((H) doubleStream).f28930a : new G(doubleStream);
    }

    public final /* synthetic */ IntStream A(C0177v vVar) {
        return IntStream.VivifiedWrapper.convert(this.f28921a.mapToInt(C0176u.a(vVar)));
    }

    public final /* synthetic */ void D(C0165m mVar) {
        this.f28921a.forEach(C0163l.a(mVar));
    }

    public final /* synthetic */ C0185j I(C0157i iVar) {
        return C0184i.b(this.f28921a.reduce(C0155h.a(iVar)));
    }

    public final /* synthetic */ double K(double d11, C0157i iVar) {
        return this.f28921a.reduce(d11, C0155h.a(iVar));
    }

    public final /* synthetic */ boolean L(C0174s sVar) {
        return this.f28921a.noneMatch(r.a(sVar));
    }

    public final /* synthetic */ boolean P(C0174s sVar) {
        return this.f28921a.allMatch(r.a(sVar));
    }

    public final /* synthetic */ void a0(C0165m mVar) {
        this.f28921a.forEachOrdered(C0163l.a(mVar));
    }

    public final /* synthetic */ C0185j average() {
        return C0184i.b(this.f28921a.average());
    }

    public final /* synthetic */ DoubleStream b(C0165m mVar) {
        return v(this.f28921a.peek(C0163l.a(mVar)));
    }

    public final /* synthetic */ Stream boxed() {
        return C0198a3.v(this.f28921a.boxed());
    }

    public final /* synthetic */ void close() {
        this.f28921a.close();
    }

    public final /* synthetic */ long count() {
        return this.f28921a.count();
    }

    public final /* synthetic */ DoubleStream distinct() {
        return v(this.f28921a.distinct());
    }

    public final /* synthetic */ boolean equals(Object obj) {
        if (obj instanceof G) {
            obj = ((G) obj).f28921a;
        }
        return this.f28921a.equals(obj);
    }

    public final /* synthetic */ C0185j findAny() {
        return C0184i.b(this.f28921a.findAny());
    }

    public final /* synthetic */ C0185j findFirst() {
        return C0184i.b(this.f28921a.findFirst());
    }

    public final /* synthetic */ DoubleStream h(C0174s sVar) {
        return v(this.f28921a.filter(r.a(sVar)));
    }

    public final /* synthetic */ int hashCode() {
        return this.f28921a.hashCode();
    }

    public final /* synthetic */ DoubleStream i(C0171p pVar) {
        return v(this.f28921a.flatMap(C0169o.a(pVar)));
    }

    public final /* synthetic */ boolean isParallel() {
        return this.f28921a.isParallel();
    }

    public final /* synthetic */ LongStream j(C0180y yVar) {
        return C0265o0.v(this.f28921a.mapToLong(C0179x.a(yVar)));
    }

    public final /* synthetic */ DoubleStream limit(long j11) {
        return v(this.f28921a.limit(j11));
    }

    public final /* synthetic */ C0185j max() {
        return C0184i.b(this.f28921a.max());
    }

    public final /* synthetic */ C0185j min() {
        return C0184i.b(this.f28921a.min());
    }

    public final /* synthetic */ Object o(Supplier supplier, x0 x0Var, BiConsumer biConsumer) {
        return this.f28921a.collect(I0.a(supplier), w0.a(x0Var), BiConsumer.Wrapper.convert(biConsumer));
    }

    public final /* synthetic */ BaseStream onClose(Runnable runnable) {
        return C0224g.v(this.f28921a.onClose(runnable));
    }

    public final /* synthetic */ DoubleStream p(B b11) {
        return v(this.f28921a.map(A.a(b11)));
    }

    public final /* synthetic */ Stream q(C0171p pVar) {
        return C0198a3.v(this.f28921a.mapToObj(C0169o.a(pVar)));
    }

    public final /* synthetic */ DoubleStream skip(long j11) {
        return v(this.f28921a.skip(j11));
    }

    public final /* synthetic */ DoubleStream sorted() {
        return v(this.f28921a.sorted());
    }

    public final /* synthetic */ double sum() {
        return this.f28921a.sum();
    }

    public final C0140f summaryStatistics() {
        this.f28921a.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert from java.util.DoubleSummaryStatistics");
    }

    public final /* synthetic */ double[] toArray() {
        return this.f28921a.toArray();
    }

    public final /* synthetic */ boolean u(C0174s sVar) {
        return this.f28921a.anyMatch(r.a(sVar));
    }

    public final /* synthetic */ BaseStream unordered() {
        return C0224g.v(this.f28921a.unordered());
    }
}
