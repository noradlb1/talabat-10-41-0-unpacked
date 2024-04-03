package j$.util.stream;

import j$.util.A;
import j$.util.D;
import j$.util.G;
import j$.util.Spliterator;
import j$.util.function.C0152f0;
import j$.util.function.C0164l0;
import j$.util.function.C0165m;
import j$.util.function.C0174s;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;
import j$.util.function.IntPredicate;
import j$.util.function.K;
import j$.util.function.Predicate;
import java.util.Objects;

/* renamed from: j$.util.stream.y0  reason: case insensitive filesystem */
public abstract /* synthetic */ class C0314y0 implements U3 {

    /* renamed from: a  reason: collision with root package name */
    private static final C0196a1 f29274a = new C0196a1();

    /* renamed from: b  reason: collision with root package name */
    private static final E0 f29275b = new Y0();

    /* renamed from: c  reason: collision with root package name */
    private static final F0 f29276c = new Z0();

    /* renamed from: d  reason: collision with root package name */
    private static final D0 f29277d = new X0();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f29278e = new int[0];
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final long[] f29279f = new long[0];
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final double[] f29280g = new double[0];

    public /* synthetic */ C0314y0() {
    }

    public /* synthetic */ C0314y0(C0218e3 e3Var) {
    }

    static long A0(long j11, long j12, long j13) {
        if (j11 >= 0) {
            return Math.max(-1, Math.min(j11 - j12, j13));
        }
        return -1;
    }

    static long B0(long j11, long j12) {
        long j13 = j12 >= 0 ? j11 + j12 : Long.MAX_VALUE;
        if (j13 >= 0) {
            return j13;
        }
        return Long.MAX_VALUE;
    }

    static Spliterator C0(C0218e3 e3Var, Spliterator spliterator, long j11, long j12) {
        long j13 = j12 >= 0 ? j11 + j12 : Long.MAX_VALUE;
        long j14 = j13 >= 0 ? j13 : Long.MAX_VALUE;
        int i11 = C0316y2.f29283a[e3Var.ordinal()];
        if (i11 == 1) {
            return new F3(spliterator, j11, j14);
        }
        if (i11 == 2) {
            return new B3((D) spliterator, j11, j14);
        }
        if (i11 == 3) {
            return new D3((G) spliterator, j11, j14);
        }
        if (i11 == 4) {
            return new z3((A) spliterator, j11, j14);
        }
        StringBuilder sb2 = new StringBuilder("Unknown shape ");
        C0218e3 e3Var2 = e3Var;
        sb2.append(e3Var);
        throw new IllegalStateException(sb2.toString());
    }

    static C0 D0(long j11, IntFunction intFunction) {
        return (j11 < 0 || j11 >= 2147483639) ? new C0295u1() : new C0206c1(j11, intFunction);
    }

    public static H0 E0(C0314y0 y0Var, Spliterator spliterator, boolean z11, IntFunction intFunction) {
        long N0 = y0Var.N0(spliterator);
        if (N0 < 0 || !spliterator.hasCharacteristics(16384)) {
            H0 h02 = (H0) new M0(spliterator, intFunction, y0Var).invoke();
            return z11 ? P0(h02, intFunction) : h02;
        } else if (N0 < 2147483639) {
            Object[] objArr = (Object[]) intFunction.apply((int) N0);
            new C0285s1(spliterator, y0Var, objArr).invoke();
            return new K0(objArr);
        } else {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
    }

    public static D0 F0(C0314y0 y0Var, Spliterator spliterator, boolean z11) {
        long N0 = y0Var.N0(spliterator);
        if (N0 < 0 || !spliterator.hasCharacteristics(16384)) {
            D0 d02 = (D0) new M0(0, spliterator, y0Var).invoke();
            return z11 ? Q0(d02) : d02;
        } else if (N0 < 2147483639) {
            double[] dArr = new double[((int) N0)];
            new C0271p1(spliterator, y0Var, dArr).invoke();
            return new U0(dArr);
        } else {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
    }

    public static E0 G0(C0314y0 y0Var, Spliterator spliterator, boolean z11) {
        long N0 = y0Var.N0(spliterator);
        if (N0 < 0 || !spliterator.hasCharacteristics(16384)) {
            E0 e02 = (E0) new M0(1, spliterator, y0Var).invoke();
            return z11 ? R0(e02) : e02;
        } else if (N0 < 2147483639) {
            int[] iArr = new int[((int) N0)];
            new C0276q1(spliterator, y0Var, iArr).invoke();
            return new C0211d1(iArr);
        } else {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
    }

    public static F0 H0(C0314y0 y0Var, Spliterator spliterator, boolean z11) {
        long N0 = y0Var.N0(spliterator);
        if (N0 < 0 || !spliterator.hasCharacteristics(16384)) {
            F0 f02 = (F0) new M0(2, spliterator, y0Var).invoke();
            return z11 ? S0(f02) : f02;
        } else if (N0 < 2147483639) {
            long[] jArr = new long[((int) N0)];
            new C0280r1(spliterator, y0Var, jArr).invoke();
            return new C0256m1(jArr);
        } else {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
    }

    static J0 I0(C0218e3 e3Var, H0 h02, H0 h03) {
        int i11 = I0.f28939a[e3Var.ordinal()];
        if (i11 == 1) {
            return new T0(h02, h03);
        }
        if (i11 == 2) {
            return new Q0((E0) h02, (E0) h03);
        }
        if (i11 == 3) {
            return new R0((F0) h02, (F0) h03);
        }
        if (i11 == 4) {
            return new P0((D0) h02, (D0) h03);
        }
        throw new IllegalStateException("Unknown shape " + e3Var);
    }

    static C0318z0 L0(long j11) {
        return (j11 < 0 || j11 >= 2147483639) ? new W0() : new V0(j11);
    }

    static C0201b1 M0(C0218e3 e3Var) {
        Object obj;
        int i11 = I0.f28939a[e3Var.ordinal()];
        if (i11 == 1) {
            return f29274a;
        }
        if (i11 == 2) {
            obj = f29275b;
        } else if (i11 == 3) {
            obj = f29276c;
        } else if (i11 == 4) {
            obj = f29277d;
        } else {
            throw new IllegalStateException("Unknown shape " + e3Var);
        }
        return (C0201b1) obj;
    }

    private static int O0(long j11) {
        return (j11 != -1 ? C0213d3.f29124u : 0) | C0213d3.f29123t;
    }

    public static H0 P0(H0 h02, IntFunction intFunction) {
        if (h02.j() <= 0) {
            return h02;
        }
        long count = h02.count();
        if (count < 2147483639) {
            Object[] objArr = (Object[]) intFunction.apply((int) count);
            new C0305w1(h02, objArr).invoke();
            return new K0(objArr);
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public static D0 Q0(D0 d02) {
        if (d02.j() <= 0) {
            return d02;
        }
        long count = d02.count();
        if (count < 2147483639) {
            double[] dArr = new double[((int) count)];
            new C0300v1(d02, dArr).invoke();
            return new U0(dArr);
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public static E0 R0(E0 e02) {
        if (e02.j() <= 0) {
            return e02;
        }
        long count = e02.count();
        if (count < 2147483639) {
            int[] iArr = new int[((int) count)];
            new C0300v1(e02, iArr).invoke();
            return new C0211d1(iArr);
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public static F0 S0(F0 f02) {
        if (f02.j() <= 0) {
            return f02;
        }
        long count = f02.count();
        if (count < 2147483639) {
            long[] jArr = new long[((int) count)];
            new C0300v1(f02, jArr).invoke();
            return new C0256m1(jArr);
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    static A0 U0(long j11) {
        return (j11 < 0 || j11 >= 2147483639) ? new C0221f1() : new C0216e1(j11);
    }

    static B0 V0(long j11) {
        return (j11 < 0 || j11 >= 2147483639) ? new C0266o1() : new C0261n1(j11);
    }

    public static DoubleStream W0(C0204c cVar, long j11, long j12) {
        if (j11 >= 0) {
            return new C0311x2(cVar, O0(j12), j11, j12);
        }
        throw new IllegalArgumentException("Skip must be non-negative: " + j11);
    }

    public static C0304w0 X0(C0174s sVar, C0299v0 v0Var) {
        Objects.requireNonNull(sVar);
        Objects.requireNonNull(v0Var);
        return new C0304w0(C0218e3.DOUBLE_VALUE, v0Var, new C0269p(3, v0Var, sVar));
    }

    public static IntStream Y0(C0204c cVar, long j11, long j12) {
        if (j11 >= 0) {
            return new C0291t2(cVar, O0(j12), j11, j12);
        }
        throw new IllegalArgumentException("Skip must be non-negative: " + j11);
    }

    public static C0304w0 Z0(IntPredicate intPredicate, C0299v0 v0Var) {
        Objects.requireNonNull(intPredicate);
        Objects.requireNonNull(v0Var);
        return new C0304w0(C0218e3.INT_VALUE, v0Var, new C0269p(1, v0Var, intPredicate));
    }

    public static LongStream a1(C0204c cVar, long j11, long j12) {
        if (j11 >= 0) {
            return new C0301v2(cVar, O0(j12), j11, j12);
        }
        throw new IllegalArgumentException("Skip must be non-negative: " + j11);
    }

    public static C0304w0 b1(C0164l0 l0Var, C0299v0 v0Var) {
        Objects.requireNonNull(l0Var);
        Objects.requireNonNull(v0Var);
        return new C0304w0(C0218e3.LONG_VALUE, v0Var, new C0269p(4, v0Var, l0Var));
    }

    public static void d0() {
        throw new IllegalStateException("called wrong accept method");
    }

    public static C0304w0 d1(Predicate predicate, C0299v0 v0Var) {
        Objects.requireNonNull(predicate);
        Objects.requireNonNull(v0Var);
        return new C0304w0(C0218e3.REFERENCE, v0Var, new C0269p(2, v0Var, predicate));
    }

    public static void e0(C0257m2 m2Var, Double d11) {
        if (!X3.f29067a) {
            m2Var.accept(d11.doubleValue());
        } else {
            X3.a(m2Var.getClass(), "{0} calling Sink.OfDouble.accept(Double)");
            throw null;
        }
    }

    public static Stream e1(C0204c cVar, long j11, long j12) {
        if (j11 >= 0) {
            return new C0281r2(cVar, O0(j12), j11, j12);
        }
        throw new IllegalArgumentException("Skip must be non-negative: " + j11);
    }

    public static void g0(C0262n2 n2Var, Integer num) {
        if (!X3.f29067a) {
            n2Var.accept(num.intValue());
        } else {
            X3.a(n2Var.getClass(), "{0} calling Sink.OfInt.accept(Integer)");
            throw null;
        }
    }

    public static void i0(C0267o2 o2Var, Long l11) {
        if (!X3.f29067a) {
            o2Var.accept(l11.longValue());
        } else {
            X3.a(o2Var.getClass(), "{0} calling Sink.OfLong.accept(Long)");
            throw null;
        }
    }

    public static void k0() {
        throw new IllegalStateException("called wrong accept method");
    }

    public static void l0() {
        throw new IllegalStateException("called wrong accept method");
    }

    public static Object[] m0(G0 g02, IntFunction intFunction) {
        if (X3.f29067a) {
            X3.a(g02.getClass(), "{0} calling Node.OfPrimitive.asArray");
            throw null;
        } else if (g02.count() < 2147483639) {
            Object[] objArr = (Object[]) intFunction.apply((int) g02.count());
            g02.e(objArr, 0);
            return objArr;
        } else {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
    }

    public static void n0(D0 d02, Double[] dArr, int i11) {
        if (!X3.f29067a) {
            double[] dArr2 = (double[]) d02.b();
            for (int i12 = 0; i12 < dArr2.length; i12++) {
                dArr[i11 + i12] = Double.valueOf(dArr2[i12]);
            }
            return;
        }
        X3.a(d02.getClass(), "{0} calling Node.OfDouble.copyInto(Double[], int)");
        throw null;
    }

    public static void o0(E0 e02, Integer[] numArr, int i11) {
        if (!X3.f29067a) {
            int[] iArr = (int[]) e02.b();
            for (int i12 = 0; i12 < iArr.length; i12++) {
                numArr[i11 + i12] = Integer.valueOf(iArr[i12]);
            }
            return;
        }
        X3.a(e02.getClass(), "{0} calling Node.OfInt.copyInto(Integer[], int)");
        throw null;
    }

    public static void p0(F0 f02, Long[] lArr, int i11) {
        if (!X3.f29067a) {
            long[] jArr = (long[]) f02.b();
            for (int i12 = 0; i12 < jArr.length; i12++) {
                lArr[i11 + i12] = Long.valueOf(jArr[i12]);
            }
            return;
        }
        X3.a(f02.getClass(), "{0} calling Node.OfInt.copyInto(Long[], int)");
        throw null;
    }

    public static void q0(D0 d02, Consumer consumer) {
        if (consumer instanceof C0165m) {
            d02.d((C0165m) consumer);
        } else if (!X3.f29067a) {
            ((A) d02.spliterator()).forEachRemaining(consumer);
        } else {
            X3.a(d02.getClass(), "{0} calling Node.OfLong.forEachRemaining(Consumer)");
            throw null;
        }
    }

    public static void r0(E0 e02, Consumer consumer) {
        if (consumer instanceof K) {
            e02.d((K) consumer);
        } else if (!X3.f29067a) {
            ((D) e02.spliterator()).forEachRemaining(consumer);
        } else {
            X3.a(e02.getClass(), "{0} calling Node.OfInt.forEachRemaining(Consumer)");
            throw null;
        }
    }

    public static void s0(F0 f02, Consumer consumer) {
        if (consumer instanceof C0152f0) {
            f02.d((C0152f0) consumer);
        } else if (!X3.f29067a) {
            ((G) f02.spliterator()).forEachRemaining(consumer);
        } else {
            X3.a(f02.getClass(), "{0} calling Node.OfLong.forEachRemaining(Consumer)");
            throw null;
        }
    }

    public static D0 t0(D0 d02, long j11, long j12) {
        if (j11 == 0 && j12 == d02.count()) {
            return d02;
        }
        long j13 = j12 - j11;
        A a11 = (A) d02.spliterator();
        C0318z0 L0 = L0(j13);
        L0.f(j13);
        for (int i11 = 0; ((long) i11) < j11 && a11.o(new y3(1)); i11++) {
        }
        if (j12 == d02.count()) {
            a11.d(L0);
        } else {
            for (int i12 = 0; ((long) i12) < j13 && a11.o(L0); i12++) {
            }
        }
        L0.end();
        return L0.build();
    }

    public static E0 u0(E0 e02, long j11, long j12) {
        if (j11 == 0 && j12 == e02.count()) {
            return e02;
        }
        long j13 = j12 - j11;
        D d11 = (D) e02.spliterator();
        A0 U0 = U0(j13);
        U0.f(j13);
        for (int i11 = 0; ((long) i11) < j11 && d11.j(new A3(1)); i11++) {
        }
        if (j12 == e02.count()) {
            d11.c(U0);
        } else {
            for (int i12 = 0; ((long) i12) < j13 && d11.j(U0); i12++) {
            }
        }
        U0.end();
        return U0.build();
    }

    public static F0 v0(F0 f02, long j11, long j12) {
        if (j11 == 0 && j12 == f02.count()) {
            return f02;
        }
        long j13 = j12 - j11;
        G g11 = (G) f02.spliterator();
        B0 V0 = V0(j13);
        V0.f(j13);
        for (int i11 = 0; ((long) i11) < j11 && g11.e(new C3(1)); i11++) {
        }
        if (j12 == f02.count()) {
            g11.b(V0);
        } else {
            for (int i12 = 0; ((long) i12) < j13 && g11.e(V0); i12++) {
            }
        }
        V0.end();
        return V0.build();
    }

    public static H0 w0(H0 h02, long j11, long j12, IntFunction intFunction) {
        if (j11 == 0 && j12 == h02.count()) {
            return h02;
        }
        Spliterator spliterator = h02.spliterator();
        long j13 = j12 - j11;
        C0 D0 = D0(j13, intFunction);
        D0.f(j13);
        for (int i11 = 0; ((long) i11) < j11 && spliterator.a(new X(11)); i11++) {
        }
        if (j12 == h02.count()) {
            spliterator.forEachRemaining(D0);
        } else {
            for (int i12 = 0; ((long) i12) < j13 && spliterator.a(D0); i12++) {
            }
        }
        D0.end();
        return D0.build();
    }

    public /* synthetic */ int G() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public abstract void J0(Spliterator spliterator, C0272p2 p2Var);

    /* access modifiers changed from: package-private */
    public abstract boolean K0(Spliterator spliterator, C0272p2 p2Var);

    /* access modifiers changed from: package-private */
    public abstract long N0(Spliterator spliterator);

    /* access modifiers changed from: package-private */
    public abstract int T0();

    public Object b0(C0314y0 y0Var, Spliterator spliterator) {
        S1 f12 = f1();
        y0Var.g1(spliterator, f12);
        return f12.get();
    }

    /* access modifiers changed from: package-private */
    public abstract C0 c1(long j11, IntFunction intFunction);

    public abstract S1 f1();

    /* access modifiers changed from: package-private */
    public abstract C0272p2 g1(Spliterator spliterator, C0272p2 p2Var);

    /* access modifiers changed from: package-private */
    public abstract C0272p2 h1(C0272p2 p2Var);

    public Object v(C0314y0 y0Var, Spliterator spliterator) {
        return ((S1) new Z1(this, y0Var, spliterator).invoke()).get();
    }
}
