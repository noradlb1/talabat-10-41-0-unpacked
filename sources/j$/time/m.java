package j$.time;

import j$.time.chrono.C0098a;
import j$.time.chrono.C0099b;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.a;
import j$.time.temporal.l;
import j$.time.temporal.n;
import j$.time.temporal.p;
import j$.time.temporal.q;
import j$.time.temporal.s;
import j$.time.temporal.t;
import j$.time.temporal.u;

public enum m implements j$.time.temporal.m, n {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;
    

    /* renamed from: a  reason: collision with root package name */
    private static final m[] f28424a = null;

    static {
        f28424a = values();
    }

    public static m E(int i11) {
        if (i11 >= 1 && i11 <= 12) {
            return f28424a[i11 - 1];
        }
        throw new b("Invalid value for MonthOfYear: " + i11);
    }

    public final int B(boolean z11) {
        switch (l.f28423a[ordinal()]) {
            case 1:
                return 32;
            case 2:
                return (z11 ? 1 : 0) + true;
            case 3:
                return z11 + true;
            case 4:
                return z11 + true;
            case 5:
                return z11 + true;
            case 6:
                return 1;
            case 7:
                return z11 + true;
            case 8:
                return z11 + true;
            case 9:
                return z11 + true;
            case 10:
                return z11 + true;
            case 11:
                return z11 + true;
            default:
                return z11 + true;
        }
    }

    public final int C(boolean z11) {
        int i11 = l.f28423a[ordinal()];
        return i11 != 1 ? (i11 == 2 || i11 == 3 || i11 == 4 || i11 == 5) ? 30 : 31 : z11 ? 29 : 28;
    }

    public final int D() {
        int i11 = l.f28423a[ordinal()];
        if (i11 != 1) {
            return (i11 == 2 || i11 == 3 || i11 == 4 || i11 == 5) ? 30 : 31;
        }
        return 29;
    }

    public final m F() {
        int i11 = ((int) 1) + 12;
        return f28424a[(i11 + ordinal()) % 12];
    }

    public final boolean c(q qVar) {
        return qVar instanceof a ? qVar == a.MONTH_OF_YEAR : qVar != null && qVar.f(this);
    }

    public final int f(q qVar) {
        return qVar == a.MONTH_OF_YEAR ? getValue() : p.a(this, qVar);
    }

    public final int getValue() {
        return ordinal() + 1;
    }

    public final u h(q qVar) {
        return qVar == a.MONTH_OF_YEAR ? qVar.range() : p.d(this, qVar);
    }

    public final l k(l lVar) {
        if (((C0098a) C0099b.r(lVar)).equals(j$.time.chrono.u.f28321d)) {
            return lVar.a((long) getValue(), a.MONTH_OF_YEAR);
        }
        throw new b("Adjustment only supported on ISO date-time");
    }

    public final long s(q qVar) {
        if (qVar == a.MONTH_OF_YEAR) {
            return (long) getValue();
        }
        if (!(qVar instanceof a)) {
            return qVar.h(this);
        }
        throw new t(c.a("Unsupported field: ", qVar));
    }

    public final Object v(s sVar) {
        return sVar == p.e() ? j$.time.chrono.u.f28321d : sVar == p.i() ? ChronoUnit.MONTHS : p.c(this, sVar);
    }
}
