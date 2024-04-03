package j$.time.temporal;

import j$.lang.a;
import j$.time.h;

/* 'enum' modifier removed */
final class e extends g {
    e() {
        super("WEEK_OF_WEEK_BASED_YEAR", 2);
    }

    public final boolean f(m mVar) {
        return mVar.c(a.EPOCH_DAY) && i.a(mVar);
    }

    public final u g(m mVar) {
        if (f(mVar)) {
            return g.D(h.D(mVar));
        }
        throw new t("Unsupported field: WeekOfWeekBasedYear");
    }

    public final long h(m mVar) {
        if (f(mVar)) {
            return (long) g.v(h.D(mVar));
        }
        throw new t("Unsupported field: WeekOfWeekBasedYear");
    }

    public final l k(l lVar, long j11) {
        range().b(j11, this);
        return lVar.b(a.g(j11, h(lVar)), ChronoUnit.WEEKS);
    }

    public final u range() {
        return u.l(52, 53);
    }

    public final String toString() {
        return "WeekOfWeekBasedYear";
    }
}
