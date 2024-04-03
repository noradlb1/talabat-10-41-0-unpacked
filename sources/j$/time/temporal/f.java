package j$.time.temporal;

import j$.time.h;

/* 'enum' modifier removed */
final class f extends g {
    f() {
        super("WEEK_BASED_YEAR", 3);
    }

    public final boolean f(m mVar) {
        return mVar.c(a.EPOCH_DAY) && i.a(mVar);
    }

    public final u g(m mVar) {
        if (f(mVar)) {
            return range();
        }
        throw new t("Unsupported field: WeekBasedYear");
    }

    public final long h(m mVar) {
        if (f(mVar)) {
            return (long) g.E(h.D(mVar));
        }
        throw new t("Unsupported field: WeekBasedYear");
    }

    public final l k(l lVar, long j11) {
        if (f(lVar)) {
            int a11 = range().a(j11, g.WEEK_BASED_YEAR);
            h D = h.D(lVar);
            a aVar = a.DAY_OF_WEEK;
            int f11 = D.f(aVar);
            int v11 = g.v(D);
            if (v11 == 53 && g.F(a11) == 52) {
                v11 = 52;
            }
            h M = h.M(a11, 1, 4);
            return lVar.g(M.Q((long) (((v11 - 1) * 7) + (f11 - M.f(aVar)))));
        }
        throw new t("Unsupported field: WeekBasedYear");
    }

    public final u range() {
        return a.YEAR.range();
    }

    public final String toString() {
        return "WeekBasedYear";
    }
}
