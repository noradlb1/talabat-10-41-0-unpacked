package org.threeten.bp.temporal;

import java.util.Locale;
import java.util.Map;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.jdk8.Jdk8Methods;

public final class JulianFields {
    public static final TemporalField JULIAN_DAY = Field.JULIAN_DAY;
    public static final TemporalField MODIFIED_JULIAN_DAY = Field.MODIFIED_JULIAN_DAY;
    public static final TemporalField RATA_DIE = Field.RATA_DIE;

    public enum Field implements TemporalField {
        JULIAN_DAY("JulianDay", r17, r18, 2440588),
        MODIFIED_JULIAN_DAY("ModifiedJulianDay", r13, r14, 40587),
        RATA_DIE("RataDie", r13, r14, 719163);
        
        private final TemporalUnit baseUnit;

        /* renamed from: name  reason: collision with root package name */
        private final String f63384name;
        private final long offset;
        private final ValueRange range;
        private final TemporalUnit rangeUnit;

        private Field(String str, TemporalUnit temporalUnit, TemporalUnit temporalUnit2, long j11) {
            this.f63384name = str;
            this.baseUnit = temporalUnit;
            this.rangeUnit = temporalUnit2;
            this.range = ValueRange.of(-365243219162L + j11, 365241780471L + j11);
            this.offset = j11;
        }

        public <R extends Temporal> R adjustInto(R r11, long j11) {
            if (range().isValidValue(j11)) {
                return r11.with(ChronoField.EPOCH_DAY, Jdk8Methods.safeSubtract(j11, this.offset));
            }
            throw new DateTimeException("Invalid value: " + this.f63384name + " " + j11);
        }

        public TemporalUnit getBaseUnit() {
            return this.baseUnit;
        }

        public String getDisplayName(Locale locale) {
            Jdk8Methods.requireNonNull(locale, "locale");
            return toString();
        }

        public long getFrom(TemporalAccessor temporalAccessor) {
            return temporalAccessor.getLong(ChronoField.EPOCH_DAY) + this.offset;
        }

        public TemporalUnit getRangeUnit() {
            return this.rangeUnit;
        }

        public boolean isDateBased() {
            return true;
        }

        public boolean isSupportedBy(TemporalAccessor temporalAccessor) {
            return temporalAccessor.isSupported(ChronoField.EPOCH_DAY);
        }

        public boolean isTimeBased() {
            return false;
        }

        public ValueRange range() {
            return this.range;
        }

        public ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
            if (isSupportedBy(temporalAccessor)) {
                return range();
            }
            throw new UnsupportedTemporalTypeException("Unsupported field: " + this);
        }

        public TemporalAccessor resolve(Map<TemporalField, Long> map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
            return Chronology.from(temporalAccessor).dateEpochDay(Jdk8Methods.safeSubtract(map.remove(this).longValue(), this.offset));
        }

        public String toString() {
            return this.f63384name;
        }
    }
}
