package org.threeten.bp.jdk8;

import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalUnit;

public abstract class DefaultInterfaceTemporal extends DefaultInterfaceTemporalAccessor implements Temporal {
    public Temporal minus(TemporalAmount temporalAmount) {
        return temporalAmount.subtractFrom(this);
    }

    public Temporal plus(TemporalAmount temporalAmount) {
        return temporalAmount.addTo(this);
    }

    public Temporal with(TemporalAdjuster temporalAdjuster) {
        return temporalAdjuster.adjustInto(this);
    }

    public Temporal minus(long j11, TemporalUnit temporalUnit) {
        return j11 == Long.MIN_VALUE ? plus(Long.MAX_VALUE, temporalUnit).plus(1, temporalUnit) : plus(-j11, temporalUnit);
    }
}
