package org.threeten.bp.chrono;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.ValueRange;

final class ChronoLocalDateTimeImpl<D extends ChronoLocalDate> extends ChronoLocalDateTime<D> implements Serializable {
    private static final int HOURS_PER_DAY = 24;
    private static final long MICROS_PER_DAY = 86400000000L;
    private static final long MILLIS_PER_DAY = 86400000;
    private static final int MINUTES_PER_DAY = 1440;
    private static final int MINUTES_PER_HOUR = 60;
    private static final long NANOS_PER_DAY = 86400000000000L;
    private static final long NANOS_PER_HOUR = 3600000000000L;
    private static final long NANOS_PER_MINUTE = 60000000000L;
    private static final long NANOS_PER_SECOND = 1000000000;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static final long serialVersionUID = 4556003607393004514L;
    private final D date;
    private final LocalTime time;

    /* renamed from: org.threeten.bp.chrono.ChronoLocalDateTimeImpl$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f63332a;

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
                f63332a = r0
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.NANOS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f63332a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.MICROS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f63332a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.MILLIS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f63332a     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.SECONDS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f63332a     // Catch:{ NoSuchFieldError -> 0x003e }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.MINUTES     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f63332a     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.HOURS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f63332a     // Catch:{ NoSuchFieldError -> 0x0054 }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.HALF_DAYS     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.ChronoLocalDateTimeImpl.AnonymousClass1.<clinit>():void");
        }
    }

    private ChronoLocalDateTimeImpl(D d11, LocalTime localTime) {
        Jdk8Methods.requireNonNull(d11, "date");
        Jdk8Methods.requireNonNull(localTime, "time");
        this.date = d11;
        this.time = localTime;
    }

    public static <R extends ChronoLocalDate> ChronoLocalDateTimeImpl<R> a(R r11, LocalTime localTime) {
        return new ChronoLocalDateTimeImpl<>(r11, localTime);
    }

    public static ChronoLocalDateTime<?> c(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        return ((ChronoLocalDate) objectInput.readObject()).atTime((LocalTime) objectInput.readObject());
    }

    private ChronoLocalDateTimeImpl<D> plusDays(long j11) {
        return with((Temporal) this.date.plus(j11, (TemporalUnit) ChronoUnit.DAYS), this.time);
    }

    private ChronoLocalDateTimeImpl<D> plusHours(long j11) {
        return plusWithOverflow(this.date, j11, 0, 0, 0);
    }

    private ChronoLocalDateTimeImpl<D> plusMinutes(long j11) {
        return plusWithOverflow(this.date, 0, j11, 0, 0);
    }

    private ChronoLocalDateTimeImpl<D> plusNanos(long j11) {
        return plusWithOverflow(this.date, 0, 0, 0, j11);
    }

    private ChronoLocalDateTimeImpl<D> plusWithOverflow(D d11, long j11, long j12, long j13, long j14) {
        LocalTime localTime;
        D d12 = d11;
        if ((j11 | j12 | j13 | j14) == 0) {
            return with((Temporal) d12, this.time);
        }
        long j15 = (j14 / NANOS_PER_DAY) + (j13 / 86400) + (j12 / 1440) + (j11 / 24);
        long j16 = (j14 % NANOS_PER_DAY) + ((j13 % 86400) * 1000000000) + ((j12 % 1440) * NANOS_PER_MINUTE) + ((j11 % 24) * NANOS_PER_HOUR);
        long nanoOfDay = this.time.toNanoOfDay();
        long j17 = j16 + nanoOfDay;
        long floorDiv = j15 + Jdk8Methods.floorDiv(j17, (long) NANOS_PER_DAY);
        long floorMod = Jdk8Methods.floorMod(j17, (long) NANOS_PER_DAY);
        if (floorMod == nanoOfDay) {
            localTime = this.time;
        } else {
            localTime = LocalTime.ofNanoOfDay(floorMod);
        }
        return with((Temporal) d12.plus(floorDiv, (TemporalUnit) ChronoUnit.DAYS), localTime);
    }

    private Object writeReplace() {
        return new Ser((byte) 12, this);
    }

    public ChronoZonedDateTime<D> atZone(ZoneId zoneId) {
        return ChronoZonedDateTimeImpl.a(this, zoneId, (ZoneOffset) null);
    }

    public ChronoLocalDateTimeImpl<D> b(long j11) {
        return plusWithOverflow(this.date, 0, 0, j11, 0);
    }

    public int get(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return range(temporalField).checkValidIntValue(getLong(temporalField), temporalField);
        }
        if (temporalField.isTimeBased()) {
            return this.time.get(temporalField);
        }
        return this.date.get(temporalField);
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

    public ValueRange range(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.rangeRefinedBy(this);
        }
        if (temporalField.isTimeBased()) {
            return this.time.range(temporalField);
        }
        return this.date.range(temporalField);
    }

    public D toLocalDate() {
        return this.date;
    }

    public LocalTime toLocalTime() {
        return this.time;
    }

    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        ChronoLocalDateTime localDateTime = toLocalDate().getChronology().localDateTime(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.between(this, localDateTime);
        }
        ChronoUnit chronoUnit = (ChronoUnit) temporalUnit;
        if (chronoUnit.isTimeBased()) {
            ChronoField chronoField = ChronoField.EPOCH_DAY;
            long j11 = localDateTime.getLong(chronoField) - this.date.getLong(chronoField);
            switch (AnonymousClass1.f63332a[chronoUnit.ordinal()]) {
                case 1:
                    j11 = Jdk8Methods.safeMultiply(j11, (long) NANOS_PER_DAY);
                    break;
                case 2:
                    j11 = Jdk8Methods.safeMultiply(j11, (long) MICROS_PER_DAY);
                    break;
                case 3:
                    j11 = Jdk8Methods.safeMultiply(j11, 86400000);
                    break;
                case 4:
                    j11 = Jdk8Methods.safeMultiply(j11, 86400);
                    break;
                case 5:
                    j11 = Jdk8Methods.safeMultiply(j11, (int) MINUTES_PER_DAY);
                    break;
                case 6:
                    j11 = Jdk8Methods.safeMultiply(j11, 24);
                    break;
                case 7:
                    j11 = Jdk8Methods.safeMultiply(j11, 2);
                    break;
            }
            return Jdk8Methods.safeAdd(j11, this.time.until(localDateTime.toLocalTime(), temporalUnit));
        }
        ChronoLocalDate localDate = localDateTime.toLocalDate();
        if (localDateTime.toLocalTime().isBefore(this.time)) {
            localDate = localDate.minus(1, (TemporalUnit) ChronoUnit.DAYS);
        }
        return this.date.until(localDate, temporalUnit);
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeObject(this.date);
        objectOutput.writeObject(this.time);
    }

    public ChronoLocalDateTimeImpl<D> plus(long j11, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return this.date.getChronology().b(temporalUnit.addTo(this, j11));
        }
        switch (AnonymousClass1.f63332a[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return plusNanos(j11);
            case 2:
                return plusDays(j11 / MICROS_PER_DAY).plusNanos((j11 % MICROS_PER_DAY) * 1000);
            case 3:
                return plusDays(j11 / 86400000).plusNanos((j11 % 86400000) * 1000000);
            case 4:
                return b(j11);
            case 5:
                return plusMinutes(j11);
            case 6:
                return plusHours(j11);
            case 7:
                return plusDays(j11 / 256).plusHours((j11 % 256) * 12);
            default:
                return with((Temporal) this.date.plus(j11, temporalUnit), this.time);
        }
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

    private ChronoLocalDateTimeImpl<D> with(Temporal temporal, LocalTime localTime) {
        D d11 = this.date;
        if (d11 == temporal && this.time == localTime) {
            return this;
        }
        return new ChronoLocalDateTimeImpl<>(d11.getChronology().a(temporal), localTime);
    }

    public ChronoLocalDateTimeImpl<D> with(TemporalAdjuster temporalAdjuster) {
        if (temporalAdjuster instanceof ChronoLocalDate) {
            return with((Temporal) (ChronoLocalDate) temporalAdjuster, this.time);
        }
        if (temporalAdjuster instanceof LocalTime) {
            return with((Temporal) this.date, (LocalTime) temporalAdjuster);
        }
        if (temporalAdjuster instanceof ChronoLocalDateTimeImpl) {
            return this.date.getChronology().b((ChronoLocalDateTimeImpl) temporalAdjuster);
        }
        return this.date.getChronology().b((ChronoLocalDateTimeImpl) temporalAdjuster.adjustInto(this));
    }

    public ChronoLocalDateTimeImpl<D> with(TemporalField temporalField, long j11) {
        if (!(temporalField instanceof ChronoField)) {
            return this.date.getChronology().b(temporalField.adjustInto(this, j11));
        }
        if (temporalField.isTimeBased()) {
            return with((Temporal) this.date, this.time.with(temporalField, j11));
        }
        return with((Temporal) this.date.with(temporalField, j11), this.time);
    }
}
