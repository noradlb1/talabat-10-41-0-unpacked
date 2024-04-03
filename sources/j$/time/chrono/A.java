package j$.time.chrono;

import j$.time.b;
import j$.time.h;
import j$.time.temporal.a;
import j$.time.temporal.l;
import j$.time.temporal.p;
import j$.time.temporal.q;
import j$.time.temporal.s;
import j$.time.temporal.u;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import org.threeten.bp.Year;

public final class A implements o, Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final A f28268d;

    /* renamed from: e  reason: collision with root package name */
    private static final A[] f28269e;
    private static final long serialVersionUID = 1466499369062886794L;

    /* renamed from: a  reason: collision with root package name */
    private final transient int f28270a;

    /* renamed from: b  reason: collision with root package name */
    private final transient h f28271b;

    /* renamed from: c  reason: collision with root package name */
    private final transient String f28272c;

    static {
        A a11 = new A(-1, h.M(1868, 1, 1), "Meiji");
        f28268d = a11;
        A a12 = new A(0, h.M(1912, 7, 30), "Taisho");
        A a13 = new A(1, h.M(1926, 12, 25), "Showa");
        A a14 = new A(2, h.M(1989, 1, 8), "Heisei");
        A a15 = new A(3, h.M(2019, 5, 1), "Reiwa");
        A[] aArr = new A[5];
        f28269e = aArr;
        aArr[0] = a11;
        aArr[1] = a12;
        aArr[2] = a13;
        aArr[3] = a14;
        aArr[4] = a15;
    }

    private A(int i11, h hVar, String str) {
        this.f28270a = i11;
        this.f28271b = hVar;
        this.f28272c = str;
    }

    static A e(h hVar) {
        A a11;
        if (!hVar.J(z.f28326d)) {
            A[] aArr = f28269e;
            int length = aArr.length;
            do {
                length--;
                if (length < 0) {
                    return null;
                }
                a11 = aArr[length];
            } while (hVar.compareTo(a11.f28271b) < 0);
            return a11;
        }
        throw new b("JapaneseDate before Meiji 6 are not supported");
    }

    static A j() {
        A[] aArr = f28269e;
        return aArr[aArr.length - 1];
    }

    public static A o(int i11) {
        int i12 = (i11 + 2) - 1;
        if (i12 >= 0) {
            A[] aArr = f28269e;
            if (i12 < aArr.length) {
                return aArr[i12];
            }
        }
        throw new b("Invalid era: " + i11);
    }

    static long q() {
        long f11 = a.DAY_OF_YEAR.range().f();
        for (A a11 : f28269e) {
            f11 = Math.min(f11, (long) ((a11.f28271b.y() - a11.f28271b.G()) + 1));
            if (a11.n() != null) {
                f11 = Math.min(f11, (long) (a11.n().f28271b.G() - 1));
            }
        }
        return f11;
    }

    static long r() {
        int I = (Year.MAX_VALUE - j().f28271b.I()) + 1;
        A[] aArr = f28269e;
        int I2 = aArr[0].f28271b.I();
        for (int i11 = 1; i11 < aArr.length; i11++) {
            A a11 = aArr[i11];
            I = Math.min(I, (a11.f28271b.I() - I2) + 1);
            I2 = a11.f28271b.I();
        }
        return (long) I;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new G((byte) 5, this);
    }

    public final /* synthetic */ boolean c(q qVar) {
        return C0099b.k(this, qVar);
    }

    public final /* synthetic */ int f(q qVar) {
        return C0099b.h(this, (a) qVar);
    }

    public final int getValue() {
        return this.f28270a;
    }

    public final u h(q qVar) {
        a aVar = a.ERA;
        return qVar == aVar ? x.f28324d.n(aVar) : p.d(this, qVar);
    }

    public final /* synthetic */ l k(l lVar) {
        return C0099b.c(this, lVar);
    }

    /* access modifiers changed from: package-private */
    public final h l() {
        return this.f28271b;
    }

    /* access modifiers changed from: package-private */
    public final A n() {
        if (this == j()) {
            return null;
        }
        return o(this.f28270a + 1);
    }

    public final /* synthetic */ long s(q qVar) {
        return C0099b.i(this, qVar);
    }

    public final String toString() {
        return this.f28272c;
    }

    public final /* synthetic */ Object v(s sVar) {
        return C0099b.o(this, sVar);
    }

    /* access modifiers changed from: package-private */
    public final void x(DataOutput dataOutput) {
        dataOutput.writeByte(this.f28270a);
    }
}
