package j$.time.temporal;

import j$.lang.a;
import j$.time.b;

enum j implements q {
    JULIAN_DAY("JulianDay", r17, r18, 2440588),
    MODIFIED_JULIAN_DAY("ModifiedJulianDay", r13, r14, 40587),
    RATA_DIE("RataDie", r13, r14, 719163);
    
    private static final long serialVersionUID = -7501623920830201812L;

    /* renamed from: a  reason: collision with root package name */
    private final transient String f28459a;

    /* renamed from: b  reason: collision with root package name */
    private final transient TemporalUnit f28460b;

    /* renamed from: c  reason: collision with root package name */
    private final transient TemporalUnit f28461c;

    /* renamed from: d  reason: collision with root package name */
    private final transient u f28462d;

    /* renamed from: e  reason: collision with root package name */
    private final transient long f28463e;

    private j(String str, ChronoUnit chronoUnit, ChronoUnit chronoUnit2, long j11) {
        this.f28459a = str;
        this.f28460b = chronoUnit;
        this.f28461c = chronoUnit2;
        this.f28462d = u.j(-365243219162L + j11, 365241780471L + j11);
        this.f28463e = j11;
    }

    public final boolean f(m mVar) {
        return mVar.c(a.EPOCH_DAY);
    }

    public final u g(m mVar) {
        if (f(mVar)) {
            return this.f28462d;
        }
        throw new b("Unsupported field: " + this);
    }

    public final long h(m mVar) {
        return mVar.s(a.EPOCH_DAY) + this.f28463e;
    }

    public final boolean isDateBased() {
        return true;
    }

    public final boolean isTimeBased() {
        return false;
    }

    public final l k(l lVar, long j11) {
        if (this.f28462d.i(j11)) {
            return lVar.a(a.g(j11, this.f28463e), a.EPOCH_DAY);
        }
        throw new b("Invalid value: " + this.f28459a + " " + j11);
    }

    public final u range() {
        return this.f28462d;
    }

    public final String toString() {
        return this.f28459a;
    }
}
