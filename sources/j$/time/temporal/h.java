package j$.time.temporal;

import j$.lang.a;
import j$.time.Duration;

enum h implements TemporalUnit {
    WEEK_BASED_YEARS("WeekBasedYears", Duration.s(31556952)),
    QUARTER_YEARS("QuarterYears", Duration.s(7889238));
    

    /* renamed from: a  reason: collision with root package name */
    private final String f28452a;

    /* renamed from: b  reason: collision with root package name */
    private final Duration f28453b;

    private h(String str, Duration duration) {
        this.f28452a = str;
        this.f28453b = duration;
    }

    public final l f(l lVar, long j11) {
        int i11 = b.f28448a[ordinal()];
        if (i11 == 1) {
            q qVar = i.f28456c;
            return lVar.a(a.e((long) lVar.f(qVar), j11), qVar);
        } else if (i11 == 2) {
            return lVar.b(j11 / 4, ChronoUnit.YEARS).b((j11 % 4) * 3, ChronoUnit.MONTHS);
        } else {
            throw new IllegalStateException("Unreachable");
        }
    }

    public final Duration getDuration() {
        return this.f28453b;
    }

    public final boolean isDateBased() {
        return true;
    }

    public final boolean isDurationEstimated() {
        return true;
    }

    public final String toString() {
        return this.f28452a;
    }
}
