package org.threeten.bp.chrono;

import java.util.Comparator;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.jdk8.DefaultInterfaceTemporal;
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

public abstract class ChronoLocalDateTime<D extends ChronoLocalDate> extends DefaultInterfaceTemporal implements TemporalAdjuster, Comparable<ChronoLocalDateTime<?>> {
    private static final Comparator<ChronoLocalDateTime<?>> DATE_TIME_COMPARATOR = new Comparator<ChronoLocalDateTime<?>>() {
        /* JADX WARNING: type inference failed for: r5v0, types: [org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.chrono.ChronoLocalDateTime<?>] */
        /* JADX WARNING: type inference failed for: r6v0, types: [org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.chrono.ChronoLocalDateTime<?>] */
        /* JADX WARNING: Unknown variable types count: 2 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int compare(org.threeten.bp.chrono.ChronoLocalDateTime<?> r5, org.threeten.bp.chrono.ChronoLocalDateTime<?> r6) {
            /*
                r4 = this;
                org.threeten.bp.chrono.ChronoLocalDate r0 = r5.toLocalDate()
                long r0 = r0.toEpochDay()
                org.threeten.bp.chrono.ChronoLocalDate r2 = r6.toLocalDate()
                long r2 = r2.toEpochDay()
                int r0 = org.threeten.bp.jdk8.Jdk8Methods.compareLongs(r0, r2)
                if (r0 != 0) goto L_0x002a
                org.threeten.bp.LocalTime r5 = r5.toLocalTime()
                long r0 = r5.toNanoOfDay()
                org.threeten.bp.LocalTime r5 = r6.toLocalTime()
                long r5 = r5.toNanoOfDay()
                int r0 = org.threeten.bp.jdk8.Jdk8Methods.compareLongs(r0, r5)
            L_0x002a:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.ChronoLocalDateTime.AnonymousClass1.compare(org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.chrono.ChronoLocalDateTime):int");
        }
    };

    public static ChronoLocalDateTime<?> from(TemporalAccessor temporalAccessor) {
        Jdk8Methods.requireNonNull(temporalAccessor, "temporal");
        if (temporalAccessor instanceof ChronoLocalDateTime) {
            return (ChronoLocalDateTime) temporalAccessor;
        }
        Chronology chronology = (Chronology) temporalAccessor.query(TemporalQueries.chronology());
        if (chronology != null) {
            return chronology.localDateTime(temporalAccessor);
        }
        throw new DateTimeException("No Chronology found to create ChronoLocalDateTime: " + temporalAccessor.getClass());
    }

    public static Comparator<ChronoLocalDateTime<?>> timeLineOrder() {
        return DATE_TIME_COMPARATOR;
    }

    public Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.EPOCH_DAY, toLocalDate().toEpochDay()).with(ChronoField.NANO_OF_DAY, toLocalTime().toNanoOfDay());
    }

    public abstract ChronoZonedDateTime<D> atZone(ZoneId zoneId);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChronoLocalDateTime)) {
            return false;
        }
        if (compareTo((ChronoLocalDateTime<?>) (ChronoLocalDateTime) obj) == 0) {
            return true;
        }
        return false;
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.format(this);
    }

    public Chronology getChronology() {
        return toLocalDate().getChronology();
    }

    public int hashCode() {
        return toLocalDate().hashCode() ^ toLocalTime().hashCode();
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.chrono.ChronoLocalDateTime<?>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isAfter(org.threeten.bp.chrono.ChronoLocalDateTime<?> r5) {
        /*
            r4 = this;
            org.threeten.bp.chrono.ChronoLocalDate r0 = r4.toLocalDate()
            long r0 = r0.toEpochDay()
            org.threeten.bp.chrono.ChronoLocalDate r2 = r5.toLocalDate()
            long r2 = r2.toEpochDay()
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x002d
            if (r0 != 0) goto L_0x002b
            org.threeten.bp.LocalTime r0 = r4.toLocalTime()
            long r0 = r0.toNanoOfDay()
            org.threeten.bp.LocalTime r5 = r5.toLocalTime()
            long r2 = r5.toNanoOfDay()
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 <= 0) goto L_0x002b
            goto L_0x002d
        L_0x002b:
            r5 = 0
            goto L_0x002e
        L_0x002d:
            r5 = 1
        L_0x002e:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.ChronoLocalDateTime.isAfter(org.threeten.bp.chrono.ChronoLocalDateTime):boolean");
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.chrono.ChronoLocalDateTime<?>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isBefore(org.threeten.bp.chrono.ChronoLocalDateTime<?> r5) {
        /*
            r4 = this;
            org.threeten.bp.chrono.ChronoLocalDate r0 = r4.toLocalDate()
            long r0 = r0.toEpochDay()
            org.threeten.bp.chrono.ChronoLocalDate r2 = r5.toLocalDate()
            long r2 = r2.toEpochDay()
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L_0x002d
            if (r0 != 0) goto L_0x002b
            org.threeten.bp.LocalTime r0 = r4.toLocalTime()
            long r0 = r0.toNanoOfDay()
            org.threeten.bp.LocalTime r5 = r5.toLocalTime()
            long r2 = r5.toNanoOfDay()
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 >= 0) goto L_0x002b
            goto L_0x002d
        L_0x002b:
            r5 = 0
            goto L_0x002e
        L_0x002d:
            r5 = 1
        L_0x002e:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.ChronoLocalDateTime.isBefore(org.threeten.bp.chrono.ChronoLocalDateTime):boolean");
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.chrono.ChronoLocalDateTime<?>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isEqual(org.threeten.bp.chrono.ChronoLocalDateTime<?> r5) {
        /*
            r4 = this;
            org.threeten.bp.LocalTime r0 = r4.toLocalTime()
            long r0 = r0.toNanoOfDay()
            org.threeten.bp.LocalTime r2 = r5.toLocalTime()
            long r2 = r2.toNanoOfDay()
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x002a
            org.threeten.bp.chrono.ChronoLocalDate r0 = r4.toLocalDate()
            long r0 = r0.toEpochDay()
            org.threeten.bp.chrono.ChronoLocalDate r5 = r5.toLocalDate()
            long r2 = r5.toEpochDay()
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 != 0) goto L_0x002a
            r5 = 1
            goto L_0x002b
        L_0x002a:
            r5 = 0
        L_0x002b:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.ChronoLocalDateTime.isEqual(org.threeten.bp.chrono.ChronoLocalDateTime):boolean");
    }

    public abstract ChronoLocalDateTime<D> plus(long j11, TemporalUnit temporalUnit);

    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.chronology()) {
            return getChronology();
        }
        if (temporalQuery == TemporalQueries.precision()) {
            return ChronoUnit.NANOS;
        }
        if (temporalQuery == TemporalQueries.localDate()) {
            return LocalDate.ofEpochDay(toLocalDate().toEpochDay());
        }
        if (temporalQuery == TemporalQueries.localTime()) {
            return toLocalTime();
        }
        if (temporalQuery == TemporalQueries.zone() || temporalQuery == TemporalQueries.zoneId() || temporalQuery == TemporalQueries.offset()) {
            return null;
        }
        return super.query(temporalQuery);
    }

    public long toEpochSecond(ZoneOffset zoneOffset) {
        Jdk8Methods.requireNonNull(zoneOffset, "offset");
        return ((toLocalDate().toEpochDay() * 86400) + ((long) toLocalTime().toSecondOfDay())) - ((long) zoneOffset.getTotalSeconds());
    }

    public Instant toInstant(ZoneOffset zoneOffset) {
        return Instant.ofEpochSecond(toEpochSecond(zoneOffset), (long) toLocalTime().getNano());
    }

    public abstract D toLocalDate();

    public abstract LocalTime toLocalTime();

    public String toString() {
        return toLocalDate().toString() + 'T' + toLocalTime().toString();
    }

    public abstract ChronoLocalDateTime<D> with(TemporalField temporalField, long j11);

    /* JADX WARNING: type inference failed for: r3v0, types: [org.threeten.bp.chrono.ChronoLocalDateTime, org.threeten.bp.chrono.ChronoLocalDateTime<?>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int compareTo(org.threeten.bp.chrono.ChronoLocalDateTime<?> r3) {
        /*
            r2 = this;
            org.threeten.bp.chrono.ChronoLocalDate r0 = r2.toLocalDate()
            org.threeten.bp.chrono.ChronoLocalDate r1 = r3.toLocalDate()
            int r0 = r0.compareTo((org.threeten.bp.chrono.ChronoLocalDate) r1)
            if (r0 != 0) goto L_0x0028
            org.threeten.bp.LocalTime r0 = r2.toLocalTime()
            org.threeten.bp.LocalTime r1 = r3.toLocalTime()
            int r0 = r0.compareTo((org.threeten.bp.LocalTime) r1)
            if (r0 != 0) goto L_0x0028
            org.threeten.bp.chrono.Chronology r0 = r2.getChronology()
            org.threeten.bp.chrono.Chronology r3 = r3.getChronology()
            int r0 = r0.compareTo((org.threeten.bp.chrono.Chronology) r3)
        L_0x0028:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.ChronoLocalDateTime.compareTo(org.threeten.bp.chrono.ChronoLocalDateTime):int");
    }

    public ChronoLocalDateTime<D> minus(TemporalAmount temporalAmount) {
        return toLocalDate().getChronology().b(super.minus(temporalAmount));
    }

    public ChronoLocalDateTime<D> plus(TemporalAmount temporalAmount) {
        return toLocalDate().getChronology().b(super.plus(temporalAmount));
    }

    public ChronoLocalDateTime<D> with(TemporalAdjuster temporalAdjuster) {
        return toLocalDate().getChronology().b(super.with(temporalAdjuster));
    }

    public ChronoLocalDateTime<D> minus(long j11, TemporalUnit temporalUnit) {
        return toLocalDate().getChronology().b(super.minus(j11, temporalUnit));
    }
}
