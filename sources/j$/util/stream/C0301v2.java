package j$.util.stream;

import j$.util.G;
import j$.util.Spliterator;
import j$.util.function.IntFunction;

/* renamed from: j$.util.stream.v2  reason: case insensitive filesystem */
final class C0301v2 extends C0250l0 {

    /* renamed from: t  reason: collision with root package name */
    final /* synthetic */ long f29252t;

    /* renamed from: u  reason: collision with root package name */
    final /* synthetic */ long f29253u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0301v2(C0204c cVar, int i11, long j11, long j12) {
        super(cVar, i11);
        this.f29252t = j11;
        this.f29253u = j12;
    }

    static G C1(G g11, long j11, long j12, long j13) {
        long j14;
        long j15;
        if (j11 <= j13) {
            long j16 = j13 - j11;
            j14 = j12 >= 0 ? Math.min(j12, j16) : j16;
            j15 = 0;
        } else {
            j15 = j11;
            j14 = j12;
        }
        return new J3(g11, j15, j14);
    }

    /* access modifiers changed from: package-private */
    public final H0 s1(Spliterator spliterator, IntFunction intFunction, C0204c cVar) {
        Spliterator spliterator2 = spliterator;
        C0204c cVar2 = cVar;
        long N0 = cVar2.N0(spliterator);
        if (N0 > 0 && spliterator.hasCharacteristics(16384)) {
            return C0314y0.H0(cVar2, C0314y0.C0(cVar.o1(), spliterator, this.f29252t, this.f29253u), true);
        } else if (!C0213d3.ORDERED.k(cVar.T0())) {
            return C0314y0.H0(this, C1((G) cVar2.z1(spliterator), this.f29252t, this.f29253u, N0), true);
        } else {
            return (H0) new C0320z2(this, cVar, spliterator, intFunction, this.f29252t, this.f29253u).invoke();
        }
    }

    /* access modifiers changed from: package-private */
    public final Spliterator t1(C0204c cVar, Spliterator spliterator) {
        long N0 = cVar.N0(spliterator);
        if (N0 > 0 && spliterator.hasCharacteristics(16384)) {
            long j11 = this.f29252t;
            return new D3((G) cVar.z1(spliterator), j11, C0314y0.B0(j11, this.f29253u));
        } else if (!C0213d3.ORDERED.k(cVar.T0())) {
            return C1((G) cVar.z1(spliterator), this.f29252t, this.f29253u, N0);
        } else {
            return ((H0) new C0320z2(this, cVar, spliterator, new N0(3), this.f29252t, this.f29253u).invoke()).spliterator();
        }
    }

    /* access modifiers changed from: package-private */
    public final C0272p2 v1(int i11, C0272p2 p2Var) {
        return new C0296u2(this, p2Var);
    }
}
