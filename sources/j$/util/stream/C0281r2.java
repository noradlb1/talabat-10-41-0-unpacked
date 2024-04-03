package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.IntFunction;

/* renamed from: j$.util.stream.r2  reason: case insensitive filesystem */
final class C0281r2 extends C0222f2 {

    /* renamed from: t  reason: collision with root package name */
    final /* synthetic */ long f29212t;

    /* renamed from: u  reason: collision with root package name */
    final /* synthetic */ long f29213u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0281r2(C0204c cVar, int i11, long j11, long j12) {
        super(cVar, i11);
        this.f29212t = j11;
        this.f29213u = j12;
    }

    static Spliterator A1(Spliterator spliterator, long j11, long j12, long j13) {
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
        return new L3(spliterator, j15, j14);
    }

    /* access modifiers changed from: package-private */
    public final H0 s1(Spliterator spliterator, IntFunction intFunction, C0204c cVar) {
        Spliterator spliterator2 = spliterator;
        IntFunction intFunction2 = intFunction;
        C0204c cVar2 = cVar;
        long N0 = cVar2.N0(spliterator2);
        if (N0 > 0 && spliterator2.hasCharacteristics(16384)) {
            return C0314y0.E0(cVar2, C0314y0.C0(cVar.o1(), spliterator, this.f29212t, this.f29213u), true, intFunction2);
        } else if (!C0213d3.ORDERED.k(cVar.T0())) {
            return C0314y0.E0(this, A1(cVar2.z1(spliterator2), this.f29212t, this.f29213u, N0), true, intFunction2);
        } else {
            return (H0) new C0320z2(this, cVar, spliterator, intFunction, this.f29212t, this.f29213u).invoke();
        }
    }

    /* access modifiers changed from: package-private */
    public final Spliterator t1(C0204c cVar, Spliterator spliterator) {
        long N0 = cVar.N0(spliterator);
        if (N0 > 0 && spliterator.hasCharacteristics(16384)) {
            Spliterator z12 = cVar.z1(spliterator);
            long j11 = this.f29212t;
            return new F3(z12, j11, C0314y0.B0(j11, this.f29213u));
        } else if (!C0213d3.ORDERED.k(cVar.T0())) {
            return A1(cVar.z1(spliterator), this.f29212t, this.f29213u, N0);
        } else {
            return ((H0) new C0320z2(this, cVar, spliterator, new C0199b(27), this.f29212t, this.f29213u).invoke()).spliterator();
        }
    }

    /* access modifiers changed from: package-private */
    public final C0272p2 v1(int i11, C0272p2 p2Var) {
        return new C0277q2(this, p2Var);
    }
}
