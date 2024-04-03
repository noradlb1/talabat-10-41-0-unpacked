package org.threeten.bp.temporal;

import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.Chronology;

public final class TemporalQueries {

    /* renamed from: a  reason: collision with root package name */
    public static final TemporalQuery<ZoneId> f63385a = new TemporalQuery<ZoneId>() {
        public ZoneId queryFrom(TemporalAccessor temporalAccessor) {
            return (ZoneId) temporalAccessor.query(this);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public static final TemporalQuery<Chronology> f63386b = new TemporalQuery<Chronology>() {
        public Chronology queryFrom(TemporalAccessor temporalAccessor) {
            return (Chronology) temporalAccessor.query(this);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public static final TemporalQuery<TemporalUnit> f63387c = new TemporalQuery<TemporalUnit>() {
        public TemporalUnit queryFrom(TemporalAccessor temporalAccessor) {
            return (TemporalUnit) temporalAccessor.query(this);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public static final TemporalQuery<ZoneId> f63388d = new TemporalQuery<ZoneId>() {
        public ZoneId queryFrom(TemporalAccessor temporalAccessor) {
            ZoneId zoneId = (ZoneId) temporalAccessor.query(TemporalQueries.f63385a);
            return zoneId != null ? zoneId : (ZoneId) temporalAccessor.query(TemporalQueries.f63389e);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public static final TemporalQuery<ZoneOffset> f63389e = new TemporalQuery<ZoneOffset>() {
        public ZoneOffset queryFrom(TemporalAccessor temporalAccessor) {
            ChronoField chronoField = ChronoField.OFFSET_SECONDS;
            if (temporalAccessor.isSupported(chronoField)) {
                return ZoneOffset.ofTotalSeconds(temporalAccessor.get(chronoField));
            }
            return null;
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public static final TemporalQuery<LocalDate> f63390f = new TemporalQuery<LocalDate>() {
        public LocalDate queryFrom(TemporalAccessor temporalAccessor) {
            ChronoField chronoField = ChronoField.EPOCH_DAY;
            if (temporalAccessor.isSupported(chronoField)) {
                return LocalDate.ofEpochDay(temporalAccessor.getLong(chronoField));
            }
            return null;
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public static final TemporalQuery<LocalTime> f63391g = new TemporalQuery<LocalTime>() {
        public LocalTime queryFrom(TemporalAccessor temporalAccessor) {
            ChronoField chronoField = ChronoField.NANO_OF_DAY;
            if (temporalAccessor.isSupported(chronoField)) {
                return LocalTime.ofNanoOfDay(temporalAccessor.getLong(chronoField));
            }
            return null;
        }
    };

    private TemporalQueries() {
    }

    public static final TemporalQuery<Chronology> chronology() {
        return f63386b;
    }

    public static final TemporalQuery<LocalDate> localDate() {
        return f63390f;
    }

    public static final TemporalQuery<LocalTime> localTime() {
        return f63391g;
    }

    public static final TemporalQuery<ZoneOffset> offset() {
        return f63389e;
    }

    public static final TemporalQuery<TemporalUnit> precision() {
        return f63387c;
    }

    public static final TemporalQuery<ZoneId> zone() {
        return f63388d;
    }

    public static final TemporalQuery<ZoneId> zoneId() {
        return f63385a;
    }
}
