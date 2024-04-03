package org.threeten.bp.chrono;

import java.util.Comparator;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
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
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

public abstract class ChronoZonedDateTime<D extends ChronoLocalDate> extends DefaultInterfaceTemporal implements Comparable<ChronoZonedDateTime<?>> {
    private static Comparator<ChronoZonedDateTime<?>> INSTANT_COMPARATOR = new Comparator<ChronoZonedDateTime<?>>() {
        public int compare(ChronoZonedDateTime<?> chronoZonedDateTime, ChronoZonedDateTime<?> chronoZonedDateTime2) {
            int compareLongs = Jdk8Methods.compareLongs(chronoZonedDateTime.toEpochSecond(), chronoZonedDateTime2.toEpochSecond());
            return compareLongs == 0 ? Jdk8Methods.compareLongs(chronoZonedDateTime.toLocalTime().toNanoOfDay(), chronoZonedDateTime2.toLocalTime().toNanoOfDay()) : compareLongs;
        }
    };

    /* renamed from: org.threeten.bp.chrono.ChronoZonedDateTime$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f63333a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.threeten.bp.temporal.ChronoField[] r0 = org.threeten.bp.temporal.ChronoField.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f63333a = r0
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.INSTANT_SECONDS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f63333a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.OFFSET_SECONDS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.ChronoZonedDateTime.AnonymousClass2.<clinit>():void");
        }
    }

    public static ChronoZonedDateTime<?> from(TemporalAccessor temporalAccessor) {
        Jdk8Methods.requireNonNull(temporalAccessor, "temporal");
        if (temporalAccessor instanceof ChronoZonedDateTime) {
            return (ChronoZonedDateTime) temporalAccessor;
        }
        Chronology chronology = (Chronology) temporalAccessor.query(TemporalQueries.chronology());
        if (chronology != null) {
            return chronology.zonedDateTime(temporalAccessor);
        }
        throw new DateTimeException("No Chronology found to create ChronoZonedDateTime: " + temporalAccessor.getClass());
    }

    public static Comparator<ChronoZonedDateTime<?>> timeLineOrder() {
        return INSTANT_COMPARATOR;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChronoZonedDateTime)) {
            return false;
        }
        if (compareTo((ChronoZonedDateTime<?>) (ChronoZonedDateTime) obj) == 0) {
            return true;
        }
        return false;
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.format(this);
    }

    public int get(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return super.get(temporalField);
        }
        int i11 = AnonymousClass2.f63333a[((ChronoField) temporalField).ordinal()];
        if (i11 == 1) {
            throw new UnsupportedTemporalTypeException("Field too large for an int: " + temporalField);
        } else if (i11 != 2) {
            return toLocalDateTime().get(temporalField);
        } else {
            return getOffset().getTotalSeconds();
        }
    }

    public Chronology getChronology() {
        return toLocalDate().getChronology();
    }

    public long getLong(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        int i11 = AnonymousClass2.f63333a[((ChronoField) temporalField).ordinal()];
        if (i11 == 1) {
            return toEpochSecond();
        }
        if (i11 != 2) {
            return toLocalDateTime().getLong(temporalField);
        }
        return (long) getOffset().getTotalSeconds();
    }

    public abstract ZoneOffset getOffset();

    public abstract ZoneId getZone();

    public int hashCode() {
        return (toLocalDateTime().hashCode() ^ getOffset().hashCode()) ^ Integer.rotateLeft(getZone().hashCode(), 3);
    }

    public boolean isAfter(ChronoZonedDateTime<?> chronoZonedDateTime) {
        int i11 = (toEpochSecond() > chronoZonedDateTime.toEpochSecond() ? 1 : (toEpochSecond() == chronoZonedDateTime.toEpochSecond() ? 0 : -1));
        if (i11 > 0 || (i11 == 0 && toLocalTime().getNano() > chronoZonedDateTime.toLocalTime().getNano())) {
            return true;
        }
        return false;
    }

    public boolean isBefore(ChronoZonedDateTime<?> chronoZonedDateTime) {
        int i11 = (toEpochSecond() > chronoZonedDateTime.toEpochSecond() ? 1 : (toEpochSecond() == chronoZonedDateTime.toEpochSecond() ? 0 : -1));
        if (i11 < 0 || (i11 == 0 && toLocalTime().getNano() < chronoZonedDateTime.toLocalTime().getNano())) {
            return true;
        }
        return false;
    }

    public boolean isEqual(ChronoZonedDateTime<?> chronoZonedDateTime) {
        if (toEpochSecond() == chronoZonedDateTime.toEpochSecond() && toLocalTime().getNano() == chronoZonedDateTime.toLocalTime().getNano()) {
            return true;
        }
        return false;
    }

    public abstract ChronoZonedDateTime<D> plus(long j11, TemporalUnit temporalUnit);

    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.zoneId() || temporalQuery == TemporalQueries.zone()) {
            return getZone();
        }
        if (temporalQuery == TemporalQueries.chronology()) {
            return toLocalDate().getChronology();
        }
        if (temporalQuery == TemporalQueries.precision()) {
            return ChronoUnit.NANOS;
        }
        if (temporalQuery == TemporalQueries.offset()) {
            return getOffset();
        }
        if (temporalQuery == TemporalQueries.localDate()) {
            return LocalDate.ofEpochDay(toLocalDate().toEpochDay());
        }
        if (temporalQuery == TemporalQueries.localTime()) {
            return toLocalTime();
        }
        return super.query(temporalQuery);
    }

    public ValueRange range(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.rangeRefinedBy(this);
        }
        if (temporalField == ChronoField.INSTANT_SECONDS || temporalField == ChronoField.OFFSET_SECONDS) {
            return temporalField.range();
        }
        return toLocalDateTime().range(temporalField);
    }

    public long toEpochSecond() {
        return ((toLocalDate().toEpochDay() * 86400) + ((long) toLocalTime().toSecondOfDay())) - ((long) getOffset().getTotalSeconds());
    }

    public Instant toInstant() {
        return Instant.ofEpochSecond(toEpochSecond(), (long) toLocalTime().getNano());
    }

    public D toLocalDate() {
        return toLocalDateTime().toLocalDate();
    }

    public abstract ChronoLocalDateTime<D> toLocalDateTime();

    public LocalTime toLocalTime() {
        return toLocalDateTime().toLocalTime();
    }

    public String toString() {
        String str = toLocalDateTime().toString() + getOffset().toString();
        if (getOffset() == getZone()) {
            return str;
        }
        return str + '[' + getZone().toString() + AbstractJsonLexerKt.END_LIST;
    }

    public abstract ChronoZonedDateTime<D> with(TemporalField temporalField, long j11);

    public abstract ChronoZonedDateTime<D> withEarlierOffsetAtOverlap();

    public abstract ChronoZonedDateTime<D> withLaterOffsetAtOverlap();

    public abstract ChronoZonedDateTime<D> withZoneSameInstant(ZoneId zoneId);

    public abstract ChronoZonedDateTime<D> withZoneSameLocal(ZoneId zoneId);

    /* JADX WARNING: type inference failed for: r5v0, types: [org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.chrono.ChronoZonedDateTime<?>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int compareTo(org.threeten.bp.chrono.ChronoZonedDateTime<?> r5) {
        /*
            r4 = this;
            long r0 = r4.toEpochSecond()
            long r2 = r5.toEpochSecond()
            int r0 = org.threeten.bp.jdk8.Jdk8Methods.compareLongs(r0, r2)
            if (r0 != 0) goto L_0x0059
            org.threeten.bp.LocalTime r0 = r4.toLocalTime()
            int r0 = r0.getNano()
            org.threeten.bp.LocalTime r1 = r5.toLocalTime()
            int r1 = r1.getNano()
            int r0 = r0 - r1
            if (r0 != 0) goto L_0x0059
            org.threeten.bp.chrono.ChronoLocalDateTime r0 = r4.toLocalDateTime()
            org.threeten.bp.chrono.ChronoLocalDateTime r1 = r5.toLocalDateTime()
            int r0 = r0.compareTo((org.threeten.bp.chrono.ChronoLocalDateTime<?>) r1)
            if (r0 != 0) goto L_0x0059
            org.threeten.bp.ZoneId r0 = r4.getZone()
            java.lang.String r0 = r0.getId()
            org.threeten.bp.ZoneId r1 = r5.getZone()
            java.lang.String r1 = r1.getId()
            int r0 = r0.compareTo(r1)
            if (r0 != 0) goto L_0x0059
            org.threeten.bp.chrono.ChronoLocalDate r0 = r4.toLocalDate()
            org.threeten.bp.chrono.Chronology r0 = r0.getChronology()
            org.threeten.bp.chrono.ChronoLocalDate r5 = r5.toLocalDate()
            org.threeten.bp.chrono.Chronology r5 = r5.getChronology()
            int r0 = r0.compareTo((org.threeten.bp.chrono.Chronology) r5)
        L_0x0059:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.ChronoZonedDateTime.compareTo(org.threeten.bp.chrono.ChronoZonedDateTime):int");
    }

    public ChronoZonedDateTime<D> minus(TemporalAmount temporalAmount) {
        return toLocalDate().getChronology().c(super.minus(temporalAmount));
    }

    public ChronoZonedDateTime<D> plus(TemporalAmount temporalAmount) {
        return toLocalDate().getChronology().c(super.plus(temporalAmount));
    }

    public ChronoZonedDateTime<D> with(TemporalAdjuster temporalAdjuster) {
        return toLocalDate().getChronology().c(super.with(temporalAdjuster));
    }

    public ChronoZonedDateTime<D> minus(long j11, TemporalUnit temporalUnit) {
        return toLocalDate().getChronology().c(super.minus(j11, temporalUnit));
    }
}
