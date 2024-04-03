package j$.time.chrono;

import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.h;
import j$.time.temporal.a;
import j$.time.temporal.m;
import j$.time.temporal.t;
import j$.time.temporal.u;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import org.threeten.bp.Year;

public final class x extends C0098a implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final x f28324d = new x();
    private static final long serialVersionUID = 459996390165777884L;

    private x() {
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final boolean A(long j11) {
        return u.f28321d.A(j11);
    }

    public final String e() {
        return "Japanese";
    }

    public final String j() {
        return "japanese";
    }

    public final C0100c l(int i11) {
        return new z(h.M(i11, 1, 1));
    }

    public final u n(a aVar) {
        switch (w.f28323a[aVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                throw new t("Unsupported field: " + aVar);
            case 5:
                return u.l(A.r(), (long) (Year.MAX_VALUE - A.j().l().I()));
            case 6:
                return u.l(A.q(), a.DAY_OF_YEAR.range().d());
            case 7:
                return u.j((long) z.f28326d.I(), 999999999);
            case 8:
                return u.j((long) A.f28268d.getValue(), (long) A.j().getValue());
            default:
                return aVar.range();
        }
    }

    public final o o(int i11) {
        return A.o(i11);
    }

    public final C0100c q(m mVar) {
        return mVar instanceof z ? (z) mVar : new z(h.D(mVar));
    }

    public final C0103f r(LocalDateTime localDateTime) {
        return super.r(localDateTime);
    }

    /* access modifiers changed from: package-private */
    public Object writeReplace() {
        return new G((byte) 1, this);
    }

    public final C0108k x(Instant instant, j$.time.x xVar) {
        return m.E(this, instant, xVar);
    }
}
