package j$.time.temporal;

import com.google.android.exoplayer2.C;

public enum a implements q {
    NANO_OF_SECOND("NanoOfSecond", r12, r21, u.j(0, 999999999)),
    NANO_OF_DAY("NanoOfDay", r12, r3, u.j(0, 86399999999999L)),
    MICRO_OF_SECOND("MicroOfSecond", r26, r18, u.j(0, 999999)),
    MICRO_OF_DAY("MicroOfDay", r26, r27, u.j(0, 86399999999L)),
    MILLI_OF_SECOND("MilliOfSecond", r26, r18, u.j(0, 999)),
    MILLI_OF_DAY("MilliOfDay", r26, r27, u.j(0, 86399999)),
    SECOND_OF_MINUTE("SecondOfMinute", r17, r12, u.j(0, 59), 0),
    SECOND_OF_DAY("SecondOfDay", r17, r3, u.j(0, 86399)),
    MINUTE_OF_HOUR("MinuteOfHour", r26, r30, u.j(0, 59), 0),
    MINUTE_OF_DAY("MinuteOfDay", r26, r27, u.j(0, 1439)),
    HOUR_OF_AMPM("HourOfAmPm", r17, r18, u.j(0, 11)),
    CLOCK_HOUR_OF_AMPM("ClockHourOfAmPm", r17, r18, u.j(1, 12)),
    HOUR_OF_DAY("HourOfDay", r26, r27, u.j(0, 23), 0),
    CLOCK_HOUR_OF_DAY("ClockHourOfDay", r26, r27, u.j(1, 24)),
    AMPM_OF_DAY("AmPmOfDay", r31, r27, u.j(0, 1), 0),
    DAY_OF_WEEK("DayOfWeek", r26, r27, u.j(1, 7), 0),
    ALIGNED_DAY_OF_WEEK_IN_MONTH("AlignedDayOfWeekInMonth", r26, r27, u.j(1, 7)),
    ALIGNED_DAY_OF_WEEK_IN_YEAR("AlignedDayOfWeekInYear", r26, r27, u.j(1, 7)),
    DAY_OF_MONTH("DayOfMonth", r26, r14, u.l(28, 31), 0),
    DAY_OF_YEAR("DayOfYear", r26, r2, u.l(365, 366)),
    EPOCH_DAY("EpochDay", r26, r6, u.j(-365243219162L, 365241780471L)),
    ALIGNED_WEEK_OF_MONTH("AlignedWeekOfMonth", r40, r14, u.l(4, 5)),
    ALIGNED_WEEK_OF_YEAR("AlignedWeekOfYear", r40, r2, u.j(1, 53)),
    MONTH_OF_YEAR("MonthOfYear", r14, r2, u.j(1, 12), 0),
    PROLEPTIC_MONTH("ProlepticMonth", r14, r41, u.j(-11999999988L, 11999999999L)),
    YEAR_OF_ERA("YearOfEra", r2, r41, u.l(999999999, C.NANOS_PER_SECOND)),
    YEAR("Year", r2, r50, u.j(-999999999, 999999999), 0),
    ERA("Era", ChronoUnit.ERAS, r50, u.j(0, 1), 0),
    INSTANT_SECONDS("InstantSeconds", r17, r18, u.j(Long.MIN_VALUE, Long.MAX_VALUE)),
    OFFSET_SECONDS("OffsetSeconds", r17, r18, u.j(-64800, 64800));
    

    /* renamed from: a  reason: collision with root package name */
    private final String f28444a;

    /* renamed from: b  reason: collision with root package name */
    private final TemporalUnit f28445b;

    /* renamed from: c  reason: collision with root package name */
    private final TemporalUnit f28446c;

    /* renamed from: d  reason: collision with root package name */
    private final u f28447d;

    private a(String str, ChronoUnit chronoUnit, ChronoUnit chronoUnit2, u uVar) {
        this.f28444a = str;
        this.f28445b = chronoUnit;
        this.f28446c = chronoUnit2;
        this.f28447d = uVar;
    }

    private a(String str, ChronoUnit chronoUnit, ChronoUnit chronoUnit2, u uVar, int i11) {
        this.f28444a = str;
        this.f28445b = chronoUnit;
        this.f28446c = chronoUnit2;
        this.f28447d = uVar;
    }

    public final boolean f(m mVar) {
        return mVar.c(this);
    }

    public final u g(m mVar) {
        return mVar.h(this);
    }

    public final long h(m mVar) {
        return mVar.s(this);
    }

    public final boolean isDateBased() {
        return ordinal() >= DAY_OF_WEEK.ordinal() && ordinal() <= ERA.ordinal();
    }

    public final boolean isTimeBased() {
        return ordinal() < DAY_OF_WEEK.ordinal();
    }

    public final l k(l lVar, long j11) {
        return lVar.a(j11, this);
    }

    public final u range() {
        return this.f28447d;
    }

    public final int s(long j11) {
        return this.f28447d.a(j11, this);
    }

    public final String toString() {
        return this.f28444a;
    }

    public final void v(long j11) {
        this.f28447d.b(j11, this);
    }
}
