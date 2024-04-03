package org.threeten.bp.chrono;

import com.talabat.sidemenu.SideMenuRewardViewHolder;
import com.talabat.talabatcommon.views.wallet.subscription.model.WalletSubscriptionMapperKt;
import java.util.Comparator;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
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

public abstract class ChronoLocalDate extends DefaultInterfaceTemporal implements TemporalAdjuster, Comparable<ChronoLocalDate> {
    private static final Comparator<ChronoLocalDate> DATE_COMPARATOR = new Comparator<ChronoLocalDate>() {
        public int compare(ChronoLocalDate chronoLocalDate, ChronoLocalDate chronoLocalDate2) {
            return Jdk8Methods.compareLongs(chronoLocalDate.toEpochDay(), chronoLocalDate2.toEpochDay());
        }
    };

    public static ChronoLocalDate from(TemporalAccessor temporalAccessor) {
        Jdk8Methods.requireNonNull(temporalAccessor, "temporal");
        if (temporalAccessor instanceof ChronoLocalDate) {
            return (ChronoLocalDate) temporalAccessor;
        }
        Chronology chronology = (Chronology) temporalAccessor.query(TemporalQueries.chronology());
        if (chronology != null) {
            return chronology.date(temporalAccessor);
        }
        throw new DateTimeException("No Chronology found to create ChronoLocalDate: " + temporalAccessor.getClass());
    }

    public static Comparator<ChronoLocalDate> timeLineOrder() {
        return DATE_COMPARATOR;
    }

    public Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.EPOCH_DAY, toEpochDay());
    }

    public ChronoLocalDateTime<?> atTime(LocalTime localTime) {
        return ChronoLocalDateTimeImpl.a(this, localTime);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChronoLocalDate)) {
            return false;
        }
        if (compareTo((ChronoLocalDate) obj) == 0) {
            return true;
        }
        return false;
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.format(this);
    }

    public abstract Chronology getChronology();

    public Era getEra() {
        return getChronology().eraOf(get(ChronoField.ERA));
    }

    public int hashCode() {
        long epochDay = toEpochDay();
        return ((int) (epochDay ^ (epochDay >>> 32))) ^ getChronology().hashCode();
    }

    public boolean isAfter(ChronoLocalDate chronoLocalDate) {
        return toEpochDay() > chronoLocalDate.toEpochDay();
    }

    public boolean isBefore(ChronoLocalDate chronoLocalDate) {
        return toEpochDay() < chronoLocalDate.toEpochDay();
    }

    public boolean isEqual(ChronoLocalDate chronoLocalDate) {
        return toEpochDay() == chronoLocalDate.toEpochDay();
    }

    public boolean isLeapYear() {
        return getChronology().isLeapYear(getLong(ChronoField.YEAR));
    }

    public boolean isSupported(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return temporalField.isDateBased();
        }
        return temporalField != null && temporalField.isSupportedBy(this);
    }

    public abstract int lengthOfMonth();

    public int lengthOfYear() {
        if (isLeapYear()) {
            return 366;
        }
        return WalletSubscriptionMapperKt.DAYS_IN_A_YEAR;
    }

    public abstract ChronoLocalDate plus(long j11, TemporalUnit temporalUnit);

    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.chronology()) {
            return getChronology();
        }
        if (temporalQuery == TemporalQueries.precision()) {
            return ChronoUnit.DAYS;
        }
        if (temporalQuery == TemporalQueries.localDate()) {
            return LocalDate.ofEpochDay(toEpochDay());
        }
        if (temporalQuery == TemporalQueries.localTime() || temporalQuery == TemporalQueries.zone() || temporalQuery == TemporalQueries.zoneId() || temporalQuery == TemporalQueries.offset()) {
            return null;
        }
        return super.query(temporalQuery);
    }

    public long toEpochDay() {
        return getLong(ChronoField.EPOCH_DAY);
    }

    public String toString() {
        long j11 = getLong(ChronoField.YEAR_OF_ERA);
        long j12 = getLong(ChronoField.MONTH_OF_YEAR);
        long j13 = getLong(ChronoField.DAY_OF_MONTH);
        StringBuilder sb2 = new StringBuilder(30);
        sb2.append(getChronology().toString());
        sb2.append(" ");
        sb2.append(getEra());
        sb2.append(" ");
        sb2.append(j11);
        String str = "-0";
        sb2.append(j12 < 10 ? str : SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE);
        sb2.append(j12);
        if (j13 >= 10) {
            str = SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE;
        }
        sb2.append(str);
        sb2.append(j13);
        return sb2.toString();
    }

    public abstract ChronoPeriod until(ChronoLocalDate chronoLocalDate);

    public abstract ChronoLocalDate with(TemporalField temporalField, long j11);

    public int compareTo(ChronoLocalDate chronoLocalDate) {
        int compareLongs = Jdk8Methods.compareLongs(toEpochDay(), chronoLocalDate.toEpochDay());
        return compareLongs == 0 ? getChronology().compareTo(chronoLocalDate.getChronology()) : compareLongs;
    }

    public ChronoLocalDate minus(TemporalAmount temporalAmount) {
        return getChronology().a(super.minus(temporalAmount));
    }

    public ChronoLocalDate plus(TemporalAmount temporalAmount) {
        return getChronology().a(super.plus(temporalAmount));
    }

    public ChronoLocalDate with(TemporalAdjuster temporalAdjuster) {
        return getChronology().a(super.with(temporalAdjuster));
    }

    public boolean isSupported(TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            return temporalUnit.isDateBased();
        }
        return temporalUnit != null && temporalUnit.isSupportedBy(this);
    }

    public ChronoLocalDate minus(long j11, TemporalUnit temporalUnit) {
        return getChronology().a(super.minus(j11, temporalUnit));
    }
}
