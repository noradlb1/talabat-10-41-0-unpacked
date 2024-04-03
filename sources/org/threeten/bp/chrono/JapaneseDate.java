package org.threeten.bp.chrono;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Calendar;
import org.threeten.bp.Clock;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Period;
import org.threeten.bp.ZoneId;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

public final class JapaneseDate extends ChronoDateImpl<JapaneseDate> {

    /* renamed from: b  reason: collision with root package name */
    public static final LocalDate f63339b = LocalDate.of(1873, 1, 1);
    private static final long serialVersionUID = -305327627230580483L;
    private transient JapaneseEra era;
    private final LocalDate isoDate;
    private transient int yearOfEra;

    /* renamed from: org.threeten.bp.chrono.JapaneseDate$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f63340a;

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
                org.threeten.bp.temporal.ChronoField[] r0 = org.threeten.bp.temporal.ChronoField.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f63340a = r0
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.DAY_OF_YEAR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f63340a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.YEAR_OF_ERA     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f63340a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f63340a     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f63340a     // Catch:{ NoSuchFieldError -> 0x003e }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ALIGNED_WEEK_OF_MONTH     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f63340a     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ALIGNED_WEEK_OF_YEAR     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f63340a     // Catch:{ NoSuchFieldError -> 0x0054 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ERA     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.JapaneseDate.AnonymousClass1.<clinit>():void");
        }
    }

    public JapaneseDate(LocalDate localDate) {
        if (!localDate.isBefore(f63339b)) {
            JapaneseEra b11 = JapaneseEra.b(localDate);
            this.era = b11;
            this.yearOfEra = localDate.getYear() - (b11.d().getYear() - 1);
            this.isoDate = localDate;
            return;
        }
        throw new DateTimeException("Minimum supported date is January 1st Meiji 6");
    }

    private ValueRange actualRange(int i11) {
        Calendar instance = Calendar.getInstance(JapaneseChronology.f63337b);
        instance.set(0, this.era.getValue() + 2);
        instance.set(this.yearOfEra, this.isoDate.getMonthValue() - 1, this.isoDate.getDayOfMonth());
        return ValueRange.of((long) instance.getActualMinimum(i11), (long) instance.getActualMaximum(i11));
    }

    public static JapaneseDate d(JapaneseEra japaneseEra, int i11, int i12) {
        Jdk8Methods.requireNonNull(japaneseEra, "era");
        if (i11 >= 1) {
            LocalDate d11 = japaneseEra.d();
            LocalDate a11 = japaneseEra.a();
            if (i11 != 1 || (i12 = i12 + (d11.getDayOfYear() - 1)) <= d11.lengthOfYear()) {
                LocalDate ofYearDay = LocalDate.ofYearDay((d11.getYear() - 1) + i11, i12);
                if (!ofYearDay.isBefore(d11) && !ofYearDay.isAfter(a11)) {
                    return new JapaneseDate(japaneseEra, i11, ofYearDay);
                }
                throw new DateTimeException("Requested date is outside bounds of era " + japaneseEra);
            }
            throw new DateTimeException("DayOfYear exceeds maximum allowed in the first year of era " + japaneseEra);
        }
        throw new DateTimeException("Invalid YearOfEra: " + i11);
    }

    public static JapaneseDate from(TemporalAccessor temporalAccessor) {
        return JapaneseChronology.INSTANCE.date(temporalAccessor);
    }

    private long getDayOfYear() {
        int dayOfYear;
        if (this.yearOfEra == 1) {
            dayOfYear = (this.isoDate.getDayOfYear() - this.era.d().getDayOfYear()) + 1;
        } else {
            dayOfYear = this.isoDate.getDayOfYear();
        }
        return (long) dayOfYear;
    }

    public static ChronoLocalDate h(DataInput dataInput) throws IOException {
        return JapaneseChronology.INSTANCE.date(dataInput.readInt(), (int) dataInput.readByte(), (int) dataInput.readByte());
    }

    public static JapaneseDate now() {
        return now(Clock.systemDefaultZone());
    }

    public static JapaneseDate of(JapaneseEra japaneseEra, int i11, int i12, int i13) {
        Jdk8Methods.requireNonNull(japaneseEra, "era");
        if (i11 >= 1) {
            LocalDate d11 = japaneseEra.d();
            LocalDate a11 = japaneseEra.a();
            LocalDate of2 = LocalDate.of((d11.getYear() - 1) + i11, i12, i13);
            if (!of2.isBefore(d11) && !of2.isAfter(a11)) {
                return new JapaneseDate(japaneseEra, i11, of2);
            }
            throw new DateTimeException("Requested date is outside bounds of era " + japaneseEra);
        }
        throw new DateTimeException("Invalid YearOfEra: " + i11);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        JapaneseEra b11 = JapaneseEra.b(this.isoDate);
        this.era = b11;
        this.yearOfEra = this.isoDate.getYear() - (b11.d().getYear() - 1);
    }

    private JapaneseDate withYear(JapaneseEra japaneseEra, int i11) {
        return with(this.isoDate.withYear(JapaneseChronology.INSTANCE.prolepticYear(japaneseEra, i11)));
    }

    private Object writeReplace() {
        return new Ser((byte) 1, this);
    }

    public final ChronoLocalDateTime<JapaneseDate> atTime(LocalTime localTime) {
        return super.atTime(localTime);
    }

    /* renamed from: e */
    public JapaneseDate a(long j11) {
        return with(this.isoDate.plusDays(j11));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof JapaneseDate) {
            return this.isoDate.equals(((JapaneseDate) obj).isoDate);
        }
        return false;
    }

    /* renamed from: f */
    public JapaneseDate b(long j11) {
        return with(this.isoDate.plusMonths(j11));
    }

    /* renamed from: g */
    public JapaneseDate c(long j11) {
        return with(this.isoDate.plusYears(j11));
    }

    public long getLong(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        switch (AnonymousClass1.f63340a[((ChronoField) temporalField).ordinal()]) {
            case 1:
                return getDayOfYear();
            case 2:
                return (long) this.yearOfEra;
            case 3:
            case 4:
            case 5:
            case 6:
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
            case 7:
                return (long) this.era.getValue();
            default:
                return this.isoDate.getLong(temporalField);
        }
    }

    public int hashCode() {
        return getChronology().getId().hashCode() ^ this.isoDate.hashCode();
    }

    public void i(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(get(ChronoField.YEAR));
        dataOutput.writeByte(get(ChronoField.MONTH_OF_YEAR));
        dataOutput.writeByte(get(ChronoField.DAY_OF_MONTH));
    }

    public boolean isSupported(TemporalField temporalField) {
        if (temporalField == ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH || temporalField == ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR || temporalField == ChronoField.ALIGNED_WEEK_OF_MONTH || temporalField == ChronoField.ALIGNED_WEEK_OF_YEAR) {
            return false;
        }
        return super.isSupported(temporalField);
    }

    public int lengthOfMonth() {
        return this.isoDate.lengthOfMonth();
    }

    public int lengthOfYear() {
        Calendar instance = Calendar.getInstance(JapaneseChronology.f63337b);
        instance.set(0, this.era.getValue() + 2);
        instance.set(this.yearOfEra, this.isoDate.getMonthValue() - 1, this.isoDate.getDayOfMonth());
        return instance.getActualMaximum(6);
    }

    public ValueRange range(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.rangeRefinedBy(this);
        }
        if (isSupported(temporalField)) {
            ChronoField chronoField = (ChronoField) temporalField;
            int i11 = AnonymousClass1.f63340a[chronoField.ordinal()];
            if (i11 == 1) {
                return actualRange(6);
            }
            if (i11 != 2) {
                return getChronology().range(chronoField);
            }
            return actualRange(1);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    public long toEpochDay() {
        return this.isoDate.toEpochDay();
    }

    public /* bridge */ /* synthetic */ long until(Temporal temporal, TemporalUnit temporalUnit) {
        return super.until(temporal, temporalUnit);
    }

    public static JapaneseDate now(ZoneId zoneId) {
        return now(Clock.system(zoneId));
    }

    public JapaneseChronology getChronology() {
        return JapaneseChronology.INSTANCE;
    }

    public JapaneseEra getEra() {
        return this.era;
    }

    public ChronoPeriod until(ChronoLocalDate chronoLocalDate) {
        Period until = this.isoDate.until(chronoLocalDate);
        return getChronology().period(until.getYears(), until.getMonths(), until.getDays());
    }

    public static JapaneseDate now(Clock clock) {
        return new JapaneseDate(LocalDate.now(clock));
    }

    private JapaneseDate withYear(int i11) {
        return withYear(getEra(), i11);
    }

    public JapaneseDate minus(TemporalAmount temporalAmount) {
        return (JapaneseDate) super.minus(temporalAmount);
    }

    public JapaneseDate with(TemporalAdjuster temporalAdjuster) {
        return (JapaneseDate) super.with(temporalAdjuster);
    }

    public JapaneseDate minus(long j11, TemporalUnit temporalUnit) {
        return (JapaneseDate) super.minus(j11, temporalUnit);
    }

    public JapaneseDate plus(TemporalAmount temporalAmount) {
        return (JapaneseDate) super.plus(temporalAmount);
    }

    public JapaneseDate with(TemporalField temporalField, long j11) {
        if (!(temporalField instanceof ChronoField)) {
            return (JapaneseDate) temporalField.adjustInto(this, j11);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        if (getLong(chronoField) == j11) {
            return this;
        }
        int[] iArr = AnonymousClass1.f63340a;
        int i11 = iArr[chronoField.ordinal()];
        if (i11 == 1 || i11 == 2 || i11 == 7) {
            int checkValidIntValue = getChronology().range(chronoField).checkValidIntValue(j11, chronoField);
            int i12 = iArr[chronoField.ordinal()];
            if (i12 == 1) {
                return with(this.isoDate.plusDays(((long) checkValidIntValue) - getDayOfYear()));
            }
            if (i12 == 2) {
                return withYear(checkValidIntValue);
            }
            if (i12 == 7) {
                return withYear(JapaneseEra.of(checkValidIntValue), this.yearOfEra);
            }
        }
        return with(this.isoDate.with(temporalField, j11));
    }

    public JapaneseDate plus(long j11, TemporalUnit temporalUnit) {
        return (JapaneseDate) super.plus(j11, temporalUnit);
    }

    public JapaneseDate(JapaneseEra japaneseEra, int i11, LocalDate localDate) {
        if (!localDate.isBefore(f63339b)) {
            this.era = japaneseEra;
            this.yearOfEra = i11;
            this.isoDate = localDate;
            return;
        }
        throw new DateTimeException("Minimum supported date is January 1st Meiji 6");
    }

    public static JapaneseDate of(int i11, int i12, int i13) {
        return new JapaneseDate(LocalDate.of(i11, i12, i13));
    }

    private JapaneseDate with(LocalDate localDate) {
        return localDate.equals(this.isoDate) ? this : new JapaneseDate(localDate);
    }
}
