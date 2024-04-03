package org.threeten.bp;

import com.google.android.exoplayer2.C;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.threeten.bp.chrono.ChronoLocalDateTime;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

public final class LocalDateTime extends ChronoLocalDateTime<LocalDate> implements Serializable {
    public static final TemporalQuery<LocalDateTime> FROM = new TemporalQuery<LocalDateTime>() {
        public LocalDateTime queryFrom(TemporalAccessor temporalAccessor) {
            return LocalDateTime.from(temporalAccessor);
        }
    };
    public static final LocalDateTime MAX = of(LocalDate.MAX, LocalTime.MAX);
    public static final LocalDateTime MIN = of(LocalDate.MIN, LocalTime.MIN);
    private static final long serialVersionUID = 6207766400415563566L;
    private final LocalDate date;
    private final LocalTime time;

    /* renamed from: org.threeten.bp.LocalDateTime$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f63316a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.threeten.bp.temporal.ChronoUnit[] r0 = org.threeten.bp.temporal.ChronoUnit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f63316a = r0
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.NANOS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f63316a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.MICROS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f63316a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.MILLIS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f63316a     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.SECONDS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f63316a     // Catch:{ NoSuchFieldError -> 0x003e }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.MINUTES     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f63316a     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.HOURS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f63316a     // Catch:{ NoSuchFieldError -> 0x0054 }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.HALF_DAYS     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.LocalDateTime.AnonymousClass2.<clinit>():void");
        }
    }

    private LocalDateTime(LocalDate localDate, LocalTime localTime) {
        this.date = localDate;
        this.time = localTime;
    }

    public static LocalDateTime a(DataInput dataInput) throws IOException {
        return of(LocalDate.c(dataInput), LocalTime.b(dataInput));
    }

    private int compareTo0(LocalDateTime localDateTime) {
        int a11 = this.date.a(localDateTime.toLocalDate());
        if (a11 == 0) {
            return this.time.compareTo(localDateTime.toLocalTime());
        }
        return a11;
    }

    public static LocalDateTime from(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof LocalDateTime) {
            return (LocalDateTime) temporalAccessor;
        }
        if (temporalAccessor instanceof ZonedDateTime) {
            return ((ZonedDateTime) temporalAccessor).toLocalDateTime();
        }
        try {
            return new LocalDateTime(LocalDate.from(temporalAccessor), LocalTime.from(temporalAccessor));
        } catch (DateTimeException unused) {
            throw new DateTimeException("Unable to obtain LocalDateTime from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
        }
    }

    public static LocalDateTime now() {
        return now(Clock.systemDefaultZone());
    }

    public static LocalDateTime of(int i11, Month month, int i12, int i13, int i14) {
        return new LocalDateTime(LocalDate.of(i11, month, i12), LocalTime.of(i13, i14));
    }

    public static LocalDateTime ofEpochSecond(long j11, int i11, ZoneOffset zoneOffset) {
        Jdk8Methods.requireNonNull(zoneOffset, "offset");
        long totalSeconds = j11 + ((long) zoneOffset.getTotalSeconds());
        return new LocalDateTime(LocalDate.ofEpochDay(Jdk8Methods.floorDiv(totalSeconds, 86400)), LocalTime.a((long) Jdk8Methods.floorMod(totalSeconds, (int) RemoteMessageConst.DEFAULT_TTL), i11));
    }

    public static LocalDateTime ofInstant(Instant instant, ZoneId zoneId) {
        Jdk8Methods.requireNonNull(instant, "instant");
        Jdk8Methods.requireNonNull(zoneId, "zone");
        return ofEpochSecond(instant.getEpochSecond(), instant.getNano(), zoneId.getRules().getOffset(instant));
    }

    public static LocalDateTime parse(CharSequence charSequence) {
        return parse(charSequence, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    private LocalDateTime plusWithOverflow(LocalDate localDate, long j11, long j12, long j13, long j14, int i11) {
        LocalTime localTime;
        LocalDate localDate2 = localDate;
        if ((j11 | j12 | j13 | j14) == 0) {
            return with(localDate2, this.time);
        }
        long j15 = (long) i11;
        long j16 = (j14 % 86400000000000L) + ((j13 % 86400) * C.NANOS_PER_SECOND) + ((j12 % 1440) * 60000000000L) + ((j11 % 24) * 3600000000000L);
        long nanoOfDay = this.time.toNanoOfDay();
        long j17 = (j16 * j15) + nanoOfDay;
        long floorDiv = (((j14 / 86400000000000L) + (j13 / 86400) + (j12 / 1440) + (j11 / 24)) * j15) + Jdk8Methods.floorDiv(j17, 86400000000000L);
        long floorMod = Jdk8Methods.floorMod(j17, 86400000000000L);
        if (floorMod == nanoOfDay) {
            localTime = this.time;
        } else {
            localTime = LocalTime.ofNanoOfDay(floorMod);
        }
        return with(localDate2.plusDays(floorDiv), localTime);
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 4, this);
    }

    public Temporal adjustInto(Temporal temporal) {
        return super.adjustInto(temporal);
    }

    public OffsetDateTime atOffset(ZoneOffset zoneOffset) {
        return OffsetDateTime.of(this, zoneOffset);
    }

    public void b(DataOutput dataOutput) throws IOException {
        this.date.d(dataOutput);
        this.time.c(dataOutput);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalDateTime)) {
            return false;
        }
        LocalDateTime localDateTime = (LocalDateTime) obj;
        if (!this.date.equals(localDateTime.date) || !this.time.equals(localDateTime.time)) {
            return false;
        }
        return true;
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        return super.format(dateTimeFormatter);
    }

    public int get(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return super.get(temporalField);
        }
        if (temporalField.isTimeBased()) {
            return this.time.get(temporalField);
        }
        return this.date.get(temporalField);
    }

    public int getDayOfMonth() {
        return this.date.getDayOfMonth();
    }

    public DayOfWeek getDayOfWeek() {
        return this.date.getDayOfWeek();
    }

    public int getDayOfYear() {
        return this.date.getDayOfYear();
    }

    public int getHour() {
        return this.time.getHour();
    }

    public long getLong(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        if (temporalField.isTimeBased()) {
            return this.time.getLong(temporalField);
        }
        return this.date.getLong(temporalField);
    }

    public int getMinute() {
        return this.time.getMinute();
    }

    public Month getMonth() {
        return this.date.getMonth();
    }

    public int getMonthValue() {
        return this.date.getMonthValue();
    }

    public int getNano() {
        return this.time.getNano();
    }

    public int getSecond() {
        return this.time.getSecond();
    }

    public int getYear() {
        return this.date.getYear();
    }

    public int hashCode() {
        return this.date.hashCode() ^ this.time.hashCode();
    }

    public boolean isAfter(ChronoLocalDateTime<?> chronoLocalDateTime) {
        if (!(chronoLocalDateTime instanceof LocalDateTime)) {
            return super.isAfter(chronoLocalDateTime);
        }
        if (compareTo0((LocalDateTime) chronoLocalDateTime) > 0) {
            return true;
        }
        return false;
    }

    public boolean isBefore(ChronoLocalDateTime<?> chronoLocalDateTime) {
        if (!(chronoLocalDateTime instanceof LocalDateTime)) {
            return super.isBefore(chronoLocalDateTime);
        }
        if (compareTo0((LocalDateTime) chronoLocalDateTime) < 0) {
            return true;
        }
        return false;
    }

    public boolean isEqual(ChronoLocalDateTime<?> chronoLocalDateTime) {
        if (!(chronoLocalDateTime instanceof LocalDateTime)) {
            return super.isEqual(chronoLocalDateTime);
        }
        if (compareTo0((LocalDateTime) chronoLocalDateTime) == 0) {
            return true;
        }
        return false;
    }

    public boolean isSupported(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            if (temporalField.isDateBased() || temporalField.isTimeBased()) {
                return true;
            }
            return false;
        } else if (temporalField == null || !temporalField.isSupportedBy(this)) {
            return false;
        } else {
            return true;
        }
    }

    public LocalDateTime minusDays(long j11) {
        return j11 == Long.MIN_VALUE ? plusDays(Long.MAX_VALUE).plusDays(1) : plusDays(-j11);
    }

    public LocalDateTime minusHours(long j11) {
        return plusWithOverflow(this.date, j11, 0, 0, 0, -1);
    }

    public LocalDateTime minusMinutes(long j11) {
        return plusWithOverflow(this.date, 0, j11, 0, 0, -1);
    }

    public LocalDateTime minusMonths(long j11) {
        return j11 == Long.MIN_VALUE ? plusMonths(Long.MAX_VALUE).plusMonths(1) : plusMonths(-j11);
    }

    public LocalDateTime minusNanos(long j11) {
        return plusWithOverflow(this.date, 0, 0, 0, j11, -1);
    }

    public LocalDateTime minusSeconds(long j11) {
        return plusWithOverflow(this.date, 0, 0, j11, 0, -1);
    }

    public LocalDateTime minusWeeks(long j11) {
        return j11 == Long.MIN_VALUE ? plusWeeks(Long.MAX_VALUE).plusWeeks(1) : plusWeeks(-j11);
    }

    public LocalDateTime minusYears(long j11) {
        return j11 == Long.MIN_VALUE ? plusYears(Long.MAX_VALUE).plusYears(1) : plusYears(-j11);
    }

    public LocalDateTime plusDays(long j11) {
        return with(this.date.plusDays(j11), this.time);
    }

    public LocalDateTime plusHours(long j11) {
        return plusWithOverflow(this.date, j11, 0, 0, 0, 1);
    }

    public LocalDateTime plusMinutes(long j11) {
        return plusWithOverflow(this.date, 0, j11, 0, 0, 1);
    }

    public LocalDateTime plusMonths(long j11) {
        return with(this.date.plusMonths(j11), this.time);
    }

    public LocalDateTime plusNanos(long j11) {
        return plusWithOverflow(this.date, 0, 0, 0, j11, 1);
    }

    public LocalDateTime plusSeconds(long j11) {
        return plusWithOverflow(this.date, 0, 0, j11, 0, 1);
    }

    public LocalDateTime plusWeeks(long j11) {
        return with(this.date.plusWeeks(j11), this.time);
    }

    public LocalDateTime plusYears(long j11) {
        return with(this.date.plusYears(j11), this.time);
    }

    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.localDate()) {
            return toLocalDate();
        }
        return super.query(temporalQuery);
    }

    public ValueRange range(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.rangeRefinedBy(this);
        }
        if (temporalField.isTimeBased()) {
            return this.time.range(temporalField);
        }
        return this.date.range(temporalField);
    }

    public LocalTime toLocalTime() {
        return this.time;
    }

    public String toString() {
        return this.date.toString() + 'T' + this.time.toString();
    }

    public LocalDateTime truncatedTo(TemporalUnit temporalUnit) {
        return with(this.date, this.time.truncatedTo(temporalUnit));
    }

    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        LocalDateTime from = from(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.between(this, from);
        }
        ChronoUnit chronoUnit = (ChronoUnit) temporalUnit;
        if (chronoUnit.isTimeBased()) {
            long b11 = this.date.b(from.date);
            long nanoOfDay = from.time.toNanoOfDay() - this.time.toNanoOfDay();
            int i11 = (b11 > 0 ? 1 : (b11 == 0 ? 0 : -1));
            if (i11 > 0 && nanoOfDay < 0) {
                b11--;
                nanoOfDay += 86400000000000L;
            } else if (i11 < 0 && nanoOfDay > 0) {
                b11++;
                nanoOfDay -= 86400000000000L;
            }
            switch (AnonymousClass2.f63316a[chronoUnit.ordinal()]) {
                case 1:
                    return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(b11, 86400000000000L), nanoOfDay);
                case 2:
                    return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(b11, 86400000000L), nanoOfDay / 1000);
                case 3:
                    return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(b11, 86400000), nanoOfDay / 1000000);
                case 4:
                    return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(b11, (int) RemoteMessageConst.DEFAULT_TTL), nanoOfDay / C.NANOS_PER_SECOND);
                case 5:
                    return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(b11, 1440), nanoOfDay / 60000000000L);
                case 6:
                    return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(b11, 24), nanoOfDay / 3600000000000L);
                case 7:
                    return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(b11, 2), nanoOfDay / 43200000000000L);
                default:
                    throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
            }
        } else {
            LocalDate localDate = from.date;
            if (localDate.isAfter(this.date) && from.time.isBefore(this.time)) {
                localDate = localDate.minusDays(1);
            } else if (localDate.isBefore(this.date) && from.time.isAfter(this.time)) {
                localDate = localDate.plusDays(1);
            }
            return this.date.until(localDate, temporalUnit);
        }
    }

    public LocalDateTime withDayOfMonth(int i11) {
        return with(this.date.withDayOfMonth(i11), this.time);
    }

    public LocalDateTime withDayOfYear(int i11) {
        return with(this.date.withDayOfYear(i11), this.time);
    }

    public LocalDateTime withHour(int i11) {
        return with(this.date, this.time.withHour(i11));
    }

    public LocalDateTime withMinute(int i11) {
        return with(this.date, this.time.withMinute(i11));
    }

    public LocalDateTime withMonth(int i11) {
        return with(this.date.withMonth(i11), this.time);
    }

    public LocalDateTime withNano(int i11) {
        return with(this.date, this.time.withNano(i11));
    }

    public LocalDateTime withSecond(int i11) {
        return with(this.date, this.time.withSecond(i11));
    }

    public LocalDateTime withYear(int i11) {
        return with(this.date.withYear(i11), this.time);
    }

    public static LocalDateTime now(ZoneId zoneId) {
        return now(Clock.system(zoneId));
    }

    public static LocalDateTime parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.requireNonNull(dateTimeFormatter, "formatter");
        return (LocalDateTime) dateTimeFormatter.parse(charSequence, FROM);
    }

    public ZonedDateTime atZone(ZoneId zoneId) {
        return ZonedDateTime.of(this, zoneId);
    }

    public int compareTo(ChronoLocalDateTime<?> chronoLocalDateTime) {
        if (chronoLocalDateTime instanceof LocalDateTime) {
            return compareTo0((LocalDateTime) chronoLocalDateTime);
        }
        return super.compareTo(chronoLocalDateTime);
    }

    public LocalDate toLocalDate() {
        return this.date;
    }

    public static LocalDateTime now(Clock clock) {
        Jdk8Methods.requireNonNull(clock, "clock");
        Instant instant = clock.instant();
        return ofEpochSecond(instant.getEpochSecond(), instant.getNano(), clock.getZone().getRules().getOffset(instant));
    }

    public static LocalDateTime of(int i11, Month month, int i12, int i13, int i14, int i15) {
        return new LocalDateTime(LocalDate.of(i11, month, i12), LocalTime.of(i13, i14, i15));
    }

    public boolean isSupported(TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            if (temporalUnit.isDateBased() || temporalUnit.isTimeBased()) {
                return true;
            }
            return false;
        } else if (temporalUnit == null || !temporalUnit.isSupportedBy(this)) {
            return false;
        } else {
            return true;
        }
    }

    private LocalDateTime with(LocalDate localDate, LocalTime localTime) {
        if (this.date == localDate && this.time == localTime) {
            return this;
        }
        return new LocalDateTime(localDate, localTime);
    }

    public LocalDateTime minus(TemporalAmount temporalAmount) {
        return (LocalDateTime) temporalAmount.subtractFrom(this);
    }

    public LocalDateTime plus(TemporalAmount temporalAmount) {
        return (LocalDateTime) temporalAmount.addTo(this);
    }

    public LocalDateTime minus(long j11, TemporalUnit temporalUnit) {
        return j11 == Long.MIN_VALUE ? plus(Long.MAX_VALUE, temporalUnit).plus(1, temporalUnit) : plus(-j11, temporalUnit);
    }

    public LocalDateTime plus(long j11, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (LocalDateTime) temporalUnit.addTo(this, j11);
        }
        switch (AnonymousClass2.f63316a[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return plusNanos(j11);
            case 2:
                return plusDays(j11 / 86400000000L).plusNanos((j11 % 86400000000L) * 1000);
            case 3:
                return plusDays(j11 / 86400000).plusNanos((j11 % 86400000) * 1000000);
            case 4:
                return plusSeconds(j11);
            case 5:
                return plusMinutes(j11);
            case 6:
                return plusHours(j11);
            case 7:
                return plusDays(j11 / 256).plusHours((j11 % 256) * 12);
            default:
                return with(this.date.plus(j11, temporalUnit), this.time);
        }
    }

    public static LocalDateTime of(int i11, Month month, int i12, int i13, int i14, int i15, int i16) {
        return new LocalDateTime(LocalDate.of(i11, month, i12), LocalTime.of(i13, i14, i15, i16));
    }

    public LocalDateTime with(TemporalAdjuster temporalAdjuster) {
        if (temporalAdjuster instanceof LocalDate) {
            return with((LocalDate) temporalAdjuster, this.time);
        }
        if (temporalAdjuster instanceof LocalTime) {
            return with(this.date, (LocalTime) temporalAdjuster);
        }
        if (temporalAdjuster instanceof LocalDateTime) {
            return (LocalDateTime) temporalAdjuster;
        }
        return (LocalDateTime) temporalAdjuster.adjustInto(this);
    }

    public static LocalDateTime of(int i11, int i12, int i13, int i14, int i15) {
        return new LocalDateTime(LocalDate.of(i11, i12, i13), LocalTime.of(i14, i15));
    }

    public static LocalDateTime of(int i11, int i12, int i13, int i14, int i15, int i16) {
        return new LocalDateTime(LocalDate.of(i11, i12, i13), LocalTime.of(i14, i15, i16));
    }

    public LocalDateTime with(TemporalField temporalField, long j11) {
        if (!(temporalField instanceof ChronoField)) {
            return (LocalDateTime) temporalField.adjustInto(this, j11);
        }
        if (temporalField.isTimeBased()) {
            return with(this.date, this.time.with(temporalField, j11));
        }
        return with(this.date.with(temporalField, j11), this.time);
    }

    public static LocalDateTime of(int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        return new LocalDateTime(LocalDate.of(i11, i12, i13), LocalTime.of(i14, i15, i16, i17));
    }

    public static LocalDateTime of(LocalDate localDate, LocalTime localTime) {
        Jdk8Methods.requireNonNull(localDate, "date");
        Jdk8Methods.requireNonNull(localTime, "time");
        return new LocalDateTime(localDate, localTime);
    }
}
