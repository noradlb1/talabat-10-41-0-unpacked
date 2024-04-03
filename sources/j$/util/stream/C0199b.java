package j$.util.stream;

import j$.util.function.A0;
import j$.util.function.BiConsumer;
import j$.util.function.C0158i0;
import j$.util.function.D0;
import j$.util.function.Function;
import j$.util.function.IntFunction;
import j$.util.function.Supplier;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import j$.util.function.x0;
import java.util.Set;

/* renamed from: j$.util.stream.b  reason: case insensitive filesystem */
public final /* synthetic */ class C0199b implements IntFunction, Function, Supplier, x0, BiConsumer, ToDoubleFunction, ToIntFunction, A0, ToLongFunction, D0, C0158i0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f29083a;

    public /* synthetic */ C0199b(int i11) {
        this.f29083a = i11;
    }

    public final void accept(Object obj, double d11) {
        switch (this.f29083a) {
            case 5:
                double[] dArr = (double[]) obj;
                Collectors.a(dArr, d11);
                dArr[2] = dArr[2] + d11;
                return;
            default:
                double[] dArr2 = (double[]) obj;
                dArr2[2] = dArr2[2] + 1.0d;
                Collectors.a(dArr2, d11);
                dArr2[3] = dArr2[3] + d11;
                return;
        }
    }

    public final void accept(Object obj, int i11) {
        long[] jArr = (long[]) obj;
        jArr[0] = jArr[0] + 1;
        jArr[1] = jArr[1] + ((long) i11);
    }

    public final void accept(Object obj, long j11) {
        long[] jArr = (long[]) obj;
        jArr[0] = jArr[0] + 1;
        jArr[1] = jArr[1] + j11;
    }

    public final void accept(Object obj, Object obj2) {
        switch (this.f29083a) {
            case 6:
                double[] dArr = (double[]) obj;
                double[] dArr2 = (double[]) obj2;
                Collectors.a(dArr, dArr2[0]);
                Collectors.a(dArr, dArr2[1]);
                dArr[2] = dArr[2] + dArr2[2];
                return;
            case 9:
                double[] dArr3 = (double[]) obj;
                double[] dArr4 = (double[]) obj2;
                Collectors.a(dArr3, dArr4[0]);
                Collectors.a(dArr3, dArr4[1]);
                dArr3[2] = dArr3[2] + dArr4[2];
                dArr3[3] = dArr3[3] + dArr4[3];
                return;
            case 20:
                long[] jArr = (long[]) obj;
                long[] jArr2 = (long[]) obj2;
                jArr[0] = jArr[0] + jArr2[0];
                jArr[1] = jArr[1] + jArr2[1];
                return;
            default:
                long[] jArr3 = (long[]) obj;
                long[] jArr4 = (long[]) obj2;
                jArr3[0] = jArr3[0] + jArr4[0];
                jArr3[1] = jArr3[1] + jArr4[1];
                return;
        }
    }

    public final /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        switch (this.f29083a) {
            case 6:
                return BiConsumer.CC.$default$andThen(this, biConsumer);
            case 9:
                return BiConsumer.CC.$default$andThen(this, biConsumer);
            case 20:
                return BiConsumer.CC.$default$andThen(this, biConsumer);
            default:
                return BiConsumer.CC.$default$andThen(this, biConsumer);
        }
    }

    public final /* synthetic */ Function andThen(Function function) {
        switch (this.f29083a) {
            case 1:
                return Function.CC.$default$andThen(this, function);
            default:
                return Function.CC.$default$andThen(this, function);
        }
    }

    public final Object apply(int i11) {
        switch (this.f29083a) {
            case 0:
                return new Object[i11];
            case 4:
                return new Double[i11];
            case 16:
                int i12 = V.f29047h;
                return new Object[i11];
            case 21:
                return new Integer[i11];
            case 23:
                return new Long[i11];
            default:
                return new Object[i11];
        }
    }

    public final Object apply(long j11) {
        switch (this.f29083a) {
            case 28:
                return C0314y0.L0(j11);
            default:
                return C0314y0.U0(j11);
        }
    }

    public final Object apply(Object obj) {
        switch (this.f29083a) {
            case 1:
                Set set = Collectors.f28907a;
                return obj;
            default:
                Set set2 = Collectors.f28907a;
                return Long.valueOf(((long[]) obj)[0]);
        }
    }

    public final double applyAsDouble(Object obj) {
        return ((Double) obj).doubleValue();
    }

    public final int applyAsInt(Object obj) {
        return ((Integer) obj).intValue();
    }

    public final long applyAsLong(Object obj) {
        return ((Long) obj).longValue();
    }

    public final /* synthetic */ Function compose(Function function) {
        switch (this.f29083a) {
            case 1:
                return Function.CC.$default$compose(this, function);
            default:
                return Function.CC.$default$compose(this, function);
        }
    }

    public final Object get() {
        switch (this.f29083a) {
            case 2:
                Set set = Collectors.f28907a;
                return new long[1];
            case 7:
                return new double[4];
            case 11:
                return new double[3];
            case 12:
                return new J();
            case 13:
                return new K();
            case 14:
                return new L();
            case 15:
                return new M();
            case 18:
                return new long[2];
            default:
                return new long[2];
        }
    }
}
