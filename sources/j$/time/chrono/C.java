package j$.time.chrono;

import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.b;
import j$.time.h;
import j$.time.temporal.a;
import j$.time.temporal.m;
import j$.time.temporal.u;
import j$.time.x;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public final class C extends C0098a implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final C f28274d = new C();
    private static final long serialVersionUID = 1039765215346859963L;

    private C() {
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final boolean A(long j11) {
        return u.f28321d.A(j11 + 1911);
    }

    public final String e() {
        return "Minguo";
    }

    public final String j() {
        return "roc";
    }

    public final C0100c l(int i11) {
        return new E(h.M(i11 + 1911, 1, 1));
    }

    public final u n(a aVar) {
        int i11 = B.f28273a[aVar.ordinal()];
        if (i11 == 1) {
            u range = a.PROLEPTIC_MONTH.range();
            return u.j(range.e() - 22932, range.d() - 22932);
        } else if (i11 == 2) {
            u range2 = a.YEAR.range();
            return u.l(range2.d() - 1911, (-range2.e()) + 1 + 1911);
        } else if (i11 != 3) {
            return aVar.range();
        } else {
            u range3 = a.YEAR.range();
            return u.j(range3.e() - 1911, range3.d() - 1911);
        }
    }

    public final o o(int i11) {
        if (i11 == 0) {
            return F.BEFORE_ROC;
        }
        if (i11 == 1) {
            return F.ROC;
        }
        throw new b("Invalid era: " + i11);
    }

    public final C0100c q(m mVar) {
        return mVar instanceof E ? (E) mVar : new E(h.D(mVar));
    }

    public final C0103f r(LocalDateTime localDateTime) {
        return super.r(localDateTime);
    }

    /* access modifiers changed from: package-private */
    public Object writeReplace() {
        return new G((byte) 1, this);
    }

    public final C0108k x(Instant instant, x xVar) {
        return m.E(this, instant, xVar);
    }
}
