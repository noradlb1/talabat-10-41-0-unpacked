package org.threeten.bp.chrono;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.threeten.bp.Clock;
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

public final class MinguoDate extends ChronoDateImpl<MinguoDate> {
    private static final long serialVersionUID = 1300372329181994526L;
    private final LocalDate isoDate;

    /* renamed from: org.threeten.bp.chrono.MinguoDate$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f63343a;

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
                f63343a = r0
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.DAY_OF_MONTH     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f63343a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.DAY_OF_YEAR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f63343a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ALIGNED_WEEK_OF_MONTH     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f63343a     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.YEAR_OF_ERA     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f63343a     // Catch:{ NoSuchFieldError -> 0x003e }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.PROLEPTIC_MONTH     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f63343a     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.YEAR     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f63343a     // Catch:{ NoSuchFieldError -> 0x0054 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ERA     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.MinguoDate.AnonymousClass1.<clinit>():void");
        }
    }

    public MinguoDate(LocalDate localDate) {
        Jdk8Methods.requireNonNull(localDate, "date");
        this.isoDate = localDate;
    }

    public static MinguoDate from(TemporalAccessor temporalAccessor) {
        return MinguoChronology.INSTANCE.date(temporalAccessor);
    }

    public static ChronoLocalDate g(DataInput dataInput) throws IOException {
        return MinguoChronology.INSTANCE.date(dataInput.readInt(), (int) dataInput.readByte(), (int) dataInput.readByte());
    }

    private long getProlepticMonth() {
        return ((((long) getProlepticYear()) * 12) + ((long) this.isoDate.getMonthValue())) - 1;
    }

    private int getProlepticYear() {
        return this.isoDate.getYear() - 1911;
    }

    public static MinguoDate now() {
        return now(Clock.systemDefaultZone());
    }

    public static MinguoDate of(int i11, int i12, int i13) {
        return MinguoChronology.INSTANCE.date(i11, i12, i13);
    }

    private Object writeReplace() {
        return new Ser((byte) 5, this);
    }

    public final ChronoLocalDateTime<MinguoDate> atTime(LocalTime localTime) {
        return super.atTime(localTime);
    }

    /* renamed from: d */
    public MinguoDate a(long j11) {
        return with(this.isoDate.plusDays(j11));
    }

    /* renamed from: e */
    public MinguoDate b(long j11) {
        return with(this.isoDate.plusMonths(j11));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MinguoDate) {
            return this.isoDate.equals(((MinguoDate) obj).isoDate);
        }
        return false;
    }

    /* renamed from: f */
    public MinguoDate c(long j11) {
        return with(this.isoDate.plusYears(j11));
    }

    public long getLong(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        int i11 = AnonymousClass1.f63343a[((ChronoField) temporalField).ordinal()];
        int i12 = 1;
        if (i11 == 4) {
            int prolepticYear = getProlepticYear();
            if (prolepticYear < 1) {
                prolepticYear = 1 - prolepticYear;
            }
            return (long) prolepticYear;
        } else if (i11 == 5) {
            return getProlepticMonth();
        } else {
            if (i11 == 6) {
                return (long) getProlepticYear();
            }
            if (i11 != 7) {
                return this.isoDate.getLong(temporalField);
            }
            if (getProlepticYear() < 1) {
                i12 = 0;
            }
            return (long) i12;
        }
    }

    public void h(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(get(ChronoField.YEAR));
        dataOutput.writeByte(get(ChronoField.MONTH_OF_YEAR));
        dataOutput.writeByte(get(ChronoField.DAY_OF_MONTH));
    }

    public int hashCode() {
        return getChronology().getId().hashCode() ^ this.isoDate.hashCode();
    }

    public int lengthOfMonth() {
        return this.isoDate.lengthOfMonth();
    }

    public ValueRange range(TemporalField temporalField) {
        long j11;
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.rangeRefinedBy(this);
        }
        if (isSupported(temporalField)) {
            ChronoField chronoField = (ChronoField) temporalField;
            int i11 = AnonymousClass1.f63343a[chronoField.ordinal()];
            if (i11 == 1 || i11 == 2 || i11 == 3) {
                return this.isoDate.range(temporalField);
            }
            if (i11 != 4) {
                return getChronology().range(chronoField);
            }
            ValueRange range = ChronoField.YEAR.range();
            if (getProlepticYear() <= 0) {
                j11 = (-range.getMinimum()) + 1 + 1911;
            } else {
                j11 = range.getMaximum() - 1911;
            }
            return ValueRange.of(1, j11);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    public long toEpochDay() {
        return this.isoDate.toEpochDay();
    }

    public /* bridge */ /* synthetic */ long until(Temporal temporal, TemporalUnit temporalUnit) {
        return super.until(temporal, temporalUnit);
    }

    public static MinguoDate now(ZoneId zoneId) {
        return now(Clock.system(zoneId));
    }

    public MinguoChronology getChronology() {
        return MinguoChronology.INSTANCE;
    }

    public MinguoEra getEra() {
        return (MinguoEra) super.getEra();
    }

    public ChronoPeriod until(ChronoLocalDate chronoLocalDate) {
        Period until = this.isoDate.until(chronoLocalDate);
        return getChronology().period(until.getYears(), until.getMonths(), until.getDays());
    }

    public static MinguoDate now(Clock clock) {
        return new MinguoDate(LocalDate.now(clock));
    }

    public MinguoDate minus(TemporalAmount temporalAmount) {
        return (MinguoDate) super.minus(temporalAmount);
    }

    public MinguoDate with(TemporalAdjuster temporalAdjuster) {
        return (MinguoDate) super.with(temporalAdjuster);
    }

    public MinguoDate minus(long j11, TemporalUnit temporalUnit) {
        return (MinguoDate) super.minus(j11, temporalUnit);
    }

    public MinguoDate plus(TemporalAmount temporalAmount) {
        return (MinguoDate) super.plus(temporalAmount);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
        if (r2 != 7) goto L_0x0053;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.threeten.bp.chrono.MinguoDate with(org.threeten.bp.temporal.TemporalField r8, long r9) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof org.threeten.bp.temporal.ChronoField
            if (r0 == 0) goto L_0x0094
            r0 = r8
            org.threeten.bp.temporal.ChronoField r0 = (org.threeten.bp.temporal.ChronoField) r0
            long r1 = r7.getLong(r0)
            int r1 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r1 != 0) goto L_0x0010
            return r7
        L_0x0010:
            int[] r1 = org.threeten.bp.chrono.MinguoDate.AnonymousClass1.f63343a
            int r2 = r0.ordinal()
            r2 = r1[r2]
            r3 = 7
            r4 = 6
            r5 = 4
            if (r2 == r5) goto L_0x003a
            r6 = 5
            if (r2 == r6) goto L_0x0025
            if (r2 == r4) goto L_0x003a
            if (r2 == r3) goto L_0x003a
            goto L_0x0053
        L_0x0025:
            org.threeten.bp.chrono.MinguoChronology r8 = r7.getChronology()
            org.threeten.bp.temporal.ValueRange r8 = r8.range(r0)
            r8.checkValidValue(r9, r0)
            long r0 = r7.getProlepticMonth()
            long r9 = r9 - r0
            org.threeten.bp.chrono.MinguoDate r8 = r7.b(r9)
            return r8
        L_0x003a:
            org.threeten.bp.chrono.MinguoChronology r2 = r7.getChronology()
            org.threeten.bp.temporal.ValueRange r2 = r2.range(r0)
            int r2 = r2.checkValidIntValue(r9, r0)
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            if (r0 == r5) goto L_0x007d
            if (r0 == r4) goto L_0x0070
            if (r0 == r3) goto L_0x005e
        L_0x0053:
            org.threeten.bp.LocalDate r0 = r7.isoDate
            org.threeten.bp.LocalDate r8 = r0.with((org.threeten.bp.temporal.TemporalField) r8, (long) r9)
            org.threeten.bp.chrono.MinguoDate r8 = r7.with((org.threeten.bp.LocalDate) r8)
            return r8
        L_0x005e:
            org.threeten.bp.LocalDate r8 = r7.isoDate
            int r9 = r7.getProlepticYear()
            int r1 = r1 - r9
            int r1 = r1 + 1911
            org.threeten.bp.LocalDate r8 = r8.withYear(r1)
            org.threeten.bp.chrono.MinguoDate r8 = r7.with((org.threeten.bp.LocalDate) r8)
            return r8
        L_0x0070:
            org.threeten.bp.LocalDate r8 = r7.isoDate
            int r2 = r2 + 1911
            org.threeten.bp.LocalDate r8 = r8.withYear(r2)
            org.threeten.bp.chrono.MinguoDate r8 = r7.with((org.threeten.bp.LocalDate) r8)
            return r8
        L_0x007d:
            org.threeten.bp.LocalDate r8 = r7.isoDate
            int r9 = r7.getProlepticYear()
            if (r9 < r1) goto L_0x0088
            int r2 = r2 + 1911
            goto L_0x008b
        L_0x0088:
            int r1 = r1 - r2
            int r2 = r1 + 1911
        L_0x008b:
            org.threeten.bp.LocalDate r8 = r8.withYear(r2)
            org.threeten.bp.chrono.MinguoDate r8 = r7.with((org.threeten.bp.LocalDate) r8)
            return r8
        L_0x0094:
            org.threeten.bp.temporal.Temporal r8 = r8.adjustInto(r7, r9)
            org.threeten.bp.chrono.MinguoDate r8 = (org.threeten.bp.chrono.MinguoDate) r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.MinguoDate.with(org.threeten.bp.temporal.TemporalField, long):org.threeten.bp.chrono.MinguoDate");
    }

    public MinguoDate plus(long j11, TemporalUnit temporalUnit) {
        return (MinguoDate) super.plus(j11, temporalUnit);
    }

    private MinguoDate with(LocalDate localDate) {
        return localDate.equals(this.isoDate) ? this : new MinguoDate(localDate);
    }
}
