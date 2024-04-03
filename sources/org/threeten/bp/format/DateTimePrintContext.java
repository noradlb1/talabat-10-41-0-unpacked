package org.threeten.bp.format;

import java.util.Locale;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.ValueRange;

final class DateTimePrintContext {
    private Locale locale;
    private int optional;
    private DecimalStyle symbols;
    private TemporalAccessor temporal;

    public DateTimePrintContext(TemporalAccessor temporalAccessor, DateTimeFormatter dateTimeFormatter) {
        this.temporal = adjust(temporalAccessor, dateTimeFormatter);
        this.locale = dateTimeFormatter.getLocale();
        this.symbols = dateTimeFormatter.getDecimalStyle();
    }

    private static TemporalAccessor adjust(final TemporalAccessor temporalAccessor, DateTimeFormatter dateTimeFormatter) {
        final Chronology chronology;
        Chronology chronology2 = dateTimeFormatter.getChronology();
        ZoneId zone = dateTimeFormatter.getZone();
        if (chronology2 == null && zone == null) {
            return temporalAccessor;
        }
        Chronology chronology3 = (Chronology) temporalAccessor.query(TemporalQueries.chronology());
        final ZoneId zoneId = (ZoneId) temporalAccessor.query(TemporalQueries.zoneId());
        final ChronoLocalDate chronoLocalDate = null;
        if (Jdk8Methods.equals(chronology3, chronology2)) {
            chronology2 = null;
        }
        if (Jdk8Methods.equals(zoneId, zone)) {
            zone = null;
        }
        if (chronology2 == null && zone == null) {
            return temporalAccessor;
        }
        if (chronology2 != null) {
            chronology = chronology2;
        } else {
            chronology = chronology3;
        }
        if (zone != null) {
            zoneId = zone;
        }
        if (zone != null) {
            if (temporalAccessor.isSupported(ChronoField.INSTANT_SECONDS)) {
                if (chronology == null) {
                    chronology = IsoChronology.INSTANCE;
                }
                return chronology.zonedDateTime(Instant.from(temporalAccessor), zone);
            }
            ZoneId normalized = zone.normalized();
            ZoneOffset zoneOffset = (ZoneOffset) temporalAccessor.query(TemporalQueries.offset());
            if ((normalized instanceof ZoneOffset) && zoneOffset != null && !normalized.equals(zoneOffset)) {
                throw new DateTimeException("Invalid override zone for temporal: " + zone + " " + temporalAccessor);
            }
        }
        if (chronology2 != null) {
            if (temporalAccessor.isSupported(ChronoField.EPOCH_DAY)) {
                chronoLocalDate = chronology.date(temporalAccessor);
            } else if (!(chronology2 == IsoChronology.INSTANCE && chronology3 == null)) {
                ChronoField[] values = ChronoField.values();
                int length = values.length;
                int i11 = 0;
                while (i11 < length) {
                    ChronoField chronoField = values[i11];
                    if (!chronoField.isDateBased() || !temporalAccessor.isSupported(chronoField)) {
                        i11++;
                    } else {
                        throw new DateTimeException("Invalid override chronology for temporal: " + chronology2 + " " + temporalAccessor);
                    }
                }
            }
        }
        return new DefaultInterfaceTemporalAccessor() {
            public long getLong(TemporalField temporalField) {
                if (ChronoLocalDate.this == null || !temporalField.isDateBased()) {
                    return temporalAccessor.getLong(temporalField);
                }
                return ChronoLocalDate.this.getLong(temporalField);
            }

            public boolean isSupported(TemporalField temporalField) {
                if (ChronoLocalDate.this == null || !temporalField.isDateBased()) {
                    return temporalAccessor.isSupported(temporalField);
                }
                return ChronoLocalDate.this.isSupported(temporalField);
            }

            public <R> R query(TemporalQuery<R> temporalQuery) {
                if (temporalQuery == TemporalQueries.chronology()) {
                    return chronology;
                }
                if (temporalQuery == TemporalQueries.zoneId()) {
                    return zoneId;
                }
                if (temporalQuery == TemporalQueries.precision()) {
                    return temporalAccessor.query(temporalQuery);
                }
                return temporalQuery.queryFrom(this);
            }

            public ValueRange range(TemporalField temporalField) {
                if (ChronoLocalDate.this == null || !temporalField.isDateBased()) {
                    return temporalAccessor.range(temporalField);
                }
                return ChronoLocalDate.this.range(temporalField);
            }
        };
    }

    public void a() {
        this.optional--;
    }

    public Locale b() {
        return this.locale;
    }

    public DecimalStyle c() {
        return this.symbols;
    }

    public TemporalAccessor d() {
        return this.temporal;
    }

    public Long e(TemporalField temporalField) {
        try {
            return Long.valueOf(this.temporal.getLong(temporalField));
        } catch (DateTimeException e11) {
            if (this.optional > 0) {
                return null;
            }
            throw e11;
        }
    }

    public <R> R f(TemporalQuery<R> temporalQuery) {
        R query = this.temporal.query(temporalQuery);
        if (query != null || this.optional != 0) {
            return query;
        }
        throw new DateTimeException("Unable to extract value: " + this.temporal.getClass());
    }

    public void g() {
        this.optional++;
    }

    public String toString() {
        return this.temporal.toString();
    }
}
