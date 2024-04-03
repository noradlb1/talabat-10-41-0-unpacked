package j$.time.temporal;

/* 'enum' modifier removed */
final class d extends g {
    d() {
        super("QUARTER_OF_YEAR", 1);
    }

    public final boolean f(m mVar) {
        return mVar.c(a.MONTH_OF_YEAR) && i.a(mVar);
    }

    public final u g(m mVar) {
        if (f(mVar)) {
            return range();
        }
        throw new t("Unsupported field: QuarterOfYear");
    }

    public final long h(m mVar) {
        if (f(mVar)) {
            return (mVar.s(a.MONTH_OF_YEAR) + 2) / 3;
        }
        throw new t("Unsupported field: QuarterOfYear");
    }

    public final l k(l lVar, long j11) {
        long h11 = h(lVar);
        range().b(j11, this);
        a aVar = a.MONTH_OF_YEAR;
        return lVar.a(((j11 - h11) * 3) + lVar.s(aVar), aVar);
    }

    public final u range() {
        return u.j(1, 4);
    }

    public final String toString() {
        return "QuarterOfYear";
    }
}
