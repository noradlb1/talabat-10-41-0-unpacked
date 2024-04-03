package j$.time.temporal;

import j$.time.chrono.u;

/* 'enum' modifier removed */
final class c extends g {
    c() {
        super("DAY_OF_QUARTER", 0);
    }

    public final boolean f(m mVar) {
        return mVar.c(a.DAY_OF_YEAR) && mVar.c(a.MONTH_OF_YEAR) && mVar.c(a.YEAR) && i.a(mVar);
    }

    public final u g(m mVar) {
        if (f(mVar)) {
            long s11 = mVar.s(g.QUARTER_OF_YEAR);
            if (s11 != 1) {
                return s11 == 2 ? u.j(1, 91) : (s11 == 3 || s11 == 4) ? u.j(1, 92) : range();
            }
            return u.f28321d.A(mVar.s(a.YEAR)) ? u.j(1, 91) : u.j(1, 90);
        }
        throw new t("Unsupported field: DayOfQuarter");
    }

    public final long h(m mVar) {
        if (f(mVar)) {
            return (long) (mVar.f(a.DAY_OF_YEAR) - g.f28449a[((mVar.f(a.MONTH_OF_YEAR) - 1) / 3) + (u.f28321d.A(mVar.s(a.YEAR)) ? 4 : 0)]);
        }
        throw new t("Unsupported field: DayOfQuarter");
    }

    public final l k(l lVar, long j11) {
        long h11 = h(lVar);
        range().b(j11, this);
        a aVar = a.DAY_OF_YEAR;
        return lVar.a((j11 - h11) + lVar.s(aVar), aVar);
    }

    public final u range() {
        return u.l(90, 92);
    }

    public final String toString() {
        return "DayOfQuarter";
    }
}
