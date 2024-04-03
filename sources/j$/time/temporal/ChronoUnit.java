package j$.time.temporal;

import j$.time.Duration;

public enum ChronoUnit implements TemporalUnit {
    NANOS("Nanos", Duration.k(1)),
    MICROS("Micros", Duration.k(1000)),
    MILLIS("Millis", Duration.k(1000000)),
    SECONDS("Seconds", Duration.s(1)),
    MINUTES("Minutes", Duration.s(60)),
    HOURS("Hours", Duration.s(3600)),
    HALF_DAYS("HalfDays", Duration.s(43200)),
    DAYS("Days", Duration.s(86400)),
    WEEKS("Weeks", Duration.s(604800)),
    MONTHS("Months", Duration.s(2629746)),
    YEARS("Years", Duration.s(31556952)),
    DECADES("Decades", Duration.s(315569520)),
    CENTURIES("Centuries", Duration.s(3155695200L)),
    MILLENNIA("Millennia", Duration.s(31556952000L)),
    ERAS("Eras", Duration.s(31556952000000000L)),
    FOREVER("Forever", Duration.ofSeconds(Long.MAX_VALUE, 999999999));
    

    /* renamed from: a  reason: collision with root package name */
    private final String f28441a;

    /* renamed from: b  reason: collision with root package name */
    private final Duration f28442b;

    private ChronoUnit(String str, Duration duration) {
        this.f28441a = str;
        this.f28442b = duration;
    }

    public final l f(l lVar, long j11) {
        return lVar.b(j11, this);
    }

    public final Duration getDuration() {
        return this.f28442b;
    }

    public final boolean isDateBased() {
        return compareTo(DAYS) >= 0 && this != FOREVER;
    }

    public final boolean isDurationEstimated() {
        return compareTo(DAYS) >= 0;
    }

    public final String toString() {
        return this.f28441a;
    }
}
