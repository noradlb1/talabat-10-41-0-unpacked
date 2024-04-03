package org.threeten.bp.chrono;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;

final class ChronoPeriodImpl extends ChronoPeriod implements Serializable {
    private static final long serialVersionUID = 275618735781L;
    private final Chronology chronology;
    private final int days;
    private final int months;
    private final int years;

    public ChronoPeriodImpl(Chronology chronology2, int i11, int i12, int i13) {
        this.chronology = chronology2;
        this.years = i11;
        this.months = i12;
        this.days = i13;
    }

    public Temporal addTo(Temporal temporal) {
        Jdk8Methods.requireNonNull(temporal, "temporal");
        Chronology chronology2 = (Chronology) temporal.query(TemporalQueries.chronology());
        if (chronology2 == null || this.chronology.equals(chronology2)) {
            int i11 = this.years;
            if (i11 != 0) {
                temporal = temporal.plus((long) i11, ChronoUnit.YEARS);
            }
            int i12 = this.months;
            if (i12 != 0) {
                temporal = temporal.plus((long) i12, ChronoUnit.MONTHS);
            }
            int i13 = this.days;
            if (i13 != 0) {
                return temporal.plus((long) i13, ChronoUnit.DAYS);
            }
            return temporal;
        }
        throw new DateTimeException("Invalid chronology, required: " + this.chronology.getId() + ", but was: " + chronology2.getId());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChronoPeriodImpl)) {
            return false;
        }
        ChronoPeriodImpl chronoPeriodImpl = (ChronoPeriodImpl) obj;
        if (this.years == chronoPeriodImpl.years && this.months == chronoPeriodImpl.months && this.days == chronoPeriodImpl.days && this.chronology.equals(chronoPeriodImpl.chronology)) {
            return true;
        }
        return false;
    }

    public long get(TemporalUnit temporalUnit) {
        int i11;
        if (temporalUnit == ChronoUnit.YEARS) {
            i11 = this.years;
        } else if (temporalUnit == ChronoUnit.MONTHS) {
            i11 = this.months;
        } else if (temporalUnit == ChronoUnit.DAYS) {
            i11 = this.days;
        } else {
            throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
        return (long) i11;
    }

    public Chronology getChronology() {
        return this.chronology;
    }

    public List<TemporalUnit> getUnits() {
        return Collections.unmodifiableList(Arrays.asList(new TemporalUnit[]{ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.DAYS}));
    }

    public int hashCode() {
        return this.chronology.hashCode() + Integer.rotateLeft(this.years, 16) + Integer.rotateLeft(this.months, 8) + this.days;
    }

    public ChronoPeriod minus(TemporalAmount temporalAmount) {
        if (temporalAmount instanceof ChronoPeriodImpl) {
            ChronoPeriodImpl chronoPeriodImpl = (ChronoPeriodImpl) temporalAmount;
            if (chronoPeriodImpl.getChronology().equals(getChronology())) {
                return new ChronoPeriodImpl(this.chronology, Jdk8Methods.safeSubtract(this.years, chronoPeriodImpl.years), Jdk8Methods.safeSubtract(this.months, chronoPeriodImpl.months), Jdk8Methods.safeSubtract(this.days, chronoPeriodImpl.days));
            }
        }
        throw new DateTimeException("Unable to subtract amount: " + temporalAmount);
    }

    public ChronoPeriod multipliedBy(int i11) {
        return new ChronoPeriodImpl(this.chronology, Jdk8Methods.safeMultiply(this.years, i11), Jdk8Methods.safeMultiply(this.months, i11), Jdk8Methods.safeMultiply(this.days, i11));
    }

    public ChronoPeriod normalized() {
        Chronology chronology2 = this.chronology;
        ChronoField chronoField = ChronoField.MONTH_OF_YEAR;
        if (!chronology2.range(chronoField).isFixed()) {
            return this;
        }
        long maximum = (this.chronology.range(chronoField).getMaximum() - this.chronology.range(chronoField).getMinimum()) + 1;
        long j11 = (((long) this.years) * maximum) + ((long) this.months);
        return new ChronoPeriodImpl(this.chronology, Jdk8Methods.safeToInt(j11 / maximum), Jdk8Methods.safeToInt(j11 % maximum), this.days);
    }

    public ChronoPeriod plus(TemporalAmount temporalAmount) {
        if (temporalAmount instanceof ChronoPeriodImpl) {
            ChronoPeriodImpl chronoPeriodImpl = (ChronoPeriodImpl) temporalAmount;
            if (chronoPeriodImpl.getChronology().equals(getChronology())) {
                return new ChronoPeriodImpl(this.chronology, Jdk8Methods.safeAdd(this.years, chronoPeriodImpl.years), Jdk8Methods.safeAdd(this.months, chronoPeriodImpl.months), Jdk8Methods.safeAdd(this.days, chronoPeriodImpl.days));
            }
        }
        throw new DateTimeException("Unable to add amount: " + temporalAmount);
    }

    public Temporal subtractFrom(Temporal temporal) {
        Jdk8Methods.requireNonNull(temporal, "temporal");
        Chronology chronology2 = (Chronology) temporal.query(TemporalQueries.chronology());
        if (chronology2 == null || this.chronology.equals(chronology2)) {
            int i11 = this.years;
            if (i11 != 0) {
                temporal = temporal.minus((long) i11, ChronoUnit.YEARS);
            }
            int i12 = this.months;
            if (i12 != 0) {
                temporal = temporal.minus((long) i12, ChronoUnit.MONTHS);
            }
            int i13 = this.days;
            if (i13 != 0) {
                return temporal.minus((long) i13, ChronoUnit.DAYS);
            }
            return temporal;
        }
        throw new DateTimeException("Invalid chronology, required: " + this.chronology.getId() + ", but was: " + chronology2.getId());
    }

    public String toString() {
        if (isZero()) {
            return this.chronology + " P0D";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.chronology);
        sb2.append(' ');
        sb2.append('P');
        int i11 = this.years;
        if (i11 != 0) {
            sb2.append(i11);
            sb2.append('Y');
        }
        int i12 = this.months;
        if (i12 != 0) {
            sb2.append(i12);
            sb2.append('M');
        }
        int i13 = this.days;
        if (i13 != 0) {
            sb2.append(i13);
            sb2.append('D');
        }
        return sb2.toString();
    }
}
