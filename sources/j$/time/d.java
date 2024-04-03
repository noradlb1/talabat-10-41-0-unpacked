package j$.time;

import j$.time.temporal.ChronoUnit;
import j$.time.temporal.a;
import j$.time.temporal.l;
import j$.time.temporal.m;
import j$.time.temporal.n;
import j$.time.temporal.p;
import j$.time.temporal.q;
import j$.time.temporal.s;
import j$.time.temporal.t;
import j$.time.temporal.u;

public enum d implements m, n {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;
    

    /* renamed from: a  reason: collision with root package name */
    private static final d[] f28330a = null;

    static {
        f28330a = values();
    }

    public static d B(int i11) {
        if (i11 >= 1 && i11 <= 7) {
            return f28330a[i11 - 1];
        }
        throw new b("Invalid value for DayOfWeek: " + i11);
    }

    public final d C(long j11) {
        int i11 = ((int) (j11 % 7)) + 7;
        return f28330a[(i11 + ordinal()) % 7];
    }

    public final boolean c(q qVar) {
        return qVar instanceof a ? qVar == a.DAY_OF_WEEK : qVar != null && qVar.f(this);
    }

    public final int f(q qVar) {
        return qVar == a.DAY_OF_WEEK ? getValue() : p.a(this, qVar);
    }

    public final int getValue() {
        return ordinal() + 1;
    }

    public final u h(q qVar) {
        return qVar == a.DAY_OF_WEEK ? qVar.range() : p.d(this, qVar);
    }

    public final l k(l lVar) {
        return lVar.a((long) getValue(), a.DAY_OF_WEEK);
    }

    public final long s(q qVar) {
        if (qVar == a.DAY_OF_WEEK) {
            return (long) getValue();
        }
        if (!(qVar instanceof a)) {
            return qVar.h(this);
        }
        throw new t(c.a("Unsupported field: ", qVar));
    }

    public final Object v(s sVar) {
        return sVar == p.i() ? ChronoUnit.DAYS : p.c(this, sVar);
    }
}
