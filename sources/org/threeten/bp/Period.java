package org.threeten.bp;

import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.ChronoPeriod;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeParseException;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;

public final class Period extends ChronoPeriod implements Serializable {
    private static final Pattern PATTERN = Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?", 2);
    public static final Period ZERO = new Period(0, 0, 0);
    private static final long serialVersionUID = -8290556941213247973L;
    private final int days;
    private final int months;
    private final int years;

    private Period(int i11, int i12, int i13) {
        this.years = i11;
        this.months = i12;
        this.days = i13;
    }

    public static Period between(LocalDate localDate, LocalDate localDate2) {
        return localDate.until((ChronoLocalDate) localDate2);
    }

    private static Period create(int i11, int i12, int i13) {
        if ((i11 | i12 | i13) == 0) {
            return ZERO;
        }
        return new Period(i11, i12, i13);
    }

    public static Period from(TemporalAmount temporalAmount) {
        if (temporalAmount instanceof Period) {
            return (Period) temporalAmount;
        }
        if (!(temporalAmount instanceof ChronoPeriod) || IsoChronology.INSTANCE.equals(((ChronoPeriod) temporalAmount).getChronology())) {
            Jdk8Methods.requireNonNull(temporalAmount, "amount");
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            for (TemporalUnit next : temporalAmount.getUnits()) {
                long j11 = temporalAmount.get(next);
                if (next == ChronoUnit.YEARS) {
                    i11 = Jdk8Methods.safeToInt(j11);
                } else if (next == ChronoUnit.MONTHS) {
                    i12 = Jdk8Methods.safeToInt(j11);
                } else if (next == ChronoUnit.DAYS) {
                    i13 = Jdk8Methods.safeToInt(j11);
                } else {
                    throw new DateTimeException("Unit must be Years, Months or Days, but was " + next);
                }
            }
            return create(i11, i12, i13);
        }
        throw new DateTimeException("Period requires ISO chronology: " + temporalAmount);
    }

    public static Period of(int i11, int i12, int i13) {
        return create(i11, i12, i13);
    }

    public static Period ofDays(int i11) {
        return create(0, 0, i11);
    }

    public static Period ofMonths(int i11) {
        return create(0, i11, 0);
    }

    public static Period ofWeeks(int i11) {
        return create(0, 0, Jdk8Methods.safeMultiply(i11, 7));
    }

    public static Period ofYears(int i11) {
        return create(i11, 0, 0);
    }

    public static Period parse(CharSequence charSequence) {
        Jdk8Methods.requireNonNull(charSequence, "text");
        Matcher matcher = PATTERN.matcher(charSequence);
        if (matcher.matches()) {
            int i11 = 1;
            if (SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE.equals(matcher.group(1))) {
                i11 = -1;
            }
            String group = matcher.group(2);
            String group2 = matcher.group(3);
            String group3 = matcher.group(4);
            String group4 = matcher.group(5);
            if (!(group == null && group2 == null && group3 == null && group4 == null)) {
                try {
                    return create(parseNumber(charSequence, group, i11), parseNumber(charSequence, group2, i11), Jdk8Methods.safeAdd(parseNumber(charSequence, group4, i11), Jdk8Methods.safeMultiply(parseNumber(charSequence, group3, i11), 7)));
                } catch (NumberFormatException e11) {
                    throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Period", charSequence, 0).initCause(e11));
                }
            }
        }
        throw new DateTimeParseException("Text cannot be parsed to a Period", charSequence, 0);
    }

    private static int parseNumber(CharSequence charSequence, String str, int i11) {
        if (str == null) {
            return 0;
        }
        try {
            return Jdk8Methods.safeMultiply(Integer.parseInt(str), i11);
        } catch (ArithmeticException e11) {
            throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Period", charSequence, 0).initCause(e11));
        }
    }

    private Object readResolve() {
        if ((this.years | this.months | this.days) == 0) {
            return ZERO;
        }
        return this;
    }

    public Temporal addTo(Temporal temporal) {
        Jdk8Methods.requireNonNull(temporal, "temporal");
        int i11 = this.years;
        if (i11 == 0) {
            int i12 = this.months;
            if (i12 != 0) {
                temporal = temporal.plus((long) i12, ChronoUnit.MONTHS);
            }
        } else if (this.months != 0) {
            temporal = temporal.plus(toTotalMonths(), ChronoUnit.MONTHS);
        } else {
            temporal = temporal.plus((long) i11, ChronoUnit.YEARS);
        }
        int i13 = this.days;
        if (i13 != 0) {
            return temporal.plus((long) i13, ChronoUnit.DAYS);
        }
        return temporal;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Period)) {
            return false;
        }
        Period period = (Period) obj;
        if (this.years == period.years && this.months == period.months && this.days == period.days) {
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
        return IsoChronology.INSTANCE;
    }

    public int getDays() {
        return this.days;
    }

    public int getMonths() {
        return this.months;
    }

    public List<TemporalUnit> getUnits() {
        return Collections.unmodifiableList(Arrays.asList(new ChronoUnit[]{ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.DAYS}));
    }

    public int getYears() {
        return this.years;
    }

    public int hashCode() {
        return this.years + Integer.rotateLeft(this.months, 8) + Integer.rotateLeft(this.days, 16);
    }

    public boolean isNegative() {
        return this.years < 0 || this.months < 0 || this.days < 0;
    }

    public boolean isZero() {
        return this == ZERO;
    }

    public Period minusDays(long j11) {
        return j11 == Long.MIN_VALUE ? plusDays(Long.MAX_VALUE).plusDays(1) : plusDays(-j11);
    }

    public Period minusMonths(long j11) {
        return j11 == Long.MIN_VALUE ? plusMonths(Long.MAX_VALUE).plusMonths(1) : plusMonths(-j11);
    }

    public Period minusYears(long j11) {
        return j11 == Long.MIN_VALUE ? plusYears(Long.MAX_VALUE).plusYears(1) : plusYears(-j11);
    }

    public Period plusDays(long j11) {
        return j11 == 0 ? this : create(this.years, this.months, Jdk8Methods.safeToInt(Jdk8Methods.safeAdd((long) this.days, j11)));
    }

    public Period plusMonths(long j11) {
        return j11 == 0 ? this : create(this.years, Jdk8Methods.safeToInt(Jdk8Methods.safeAdd((long) this.months, j11)), this.days);
    }

    public Period plusYears(long j11) {
        return j11 == 0 ? this : create(Jdk8Methods.safeToInt(Jdk8Methods.safeAdd((long) this.years, j11)), this.months, this.days);
    }

    public Temporal subtractFrom(Temporal temporal) {
        Jdk8Methods.requireNonNull(temporal, "temporal");
        int i11 = this.years;
        if (i11 == 0) {
            int i12 = this.months;
            if (i12 != 0) {
                temporal = temporal.minus((long) i12, ChronoUnit.MONTHS);
            }
        } else if (this.months != 0) {
            temporal = temporal.minus(toTotalMonths(), ChronoUnit.MONTHS);
        } else {
            temporal = temporal.minus((long) i11, ChronoUnit.YEARS);
        }
        int i13 = this.days;
        if (i13 != 0) {
            return temporal.minus((long) i13, ChronoUnit.DAYS);
        }
        return temporal;
    }

    public String toString() {
        if (this == ZERO) {
            return "P0D";
        }
        StringBuilder sb2 = new StringBuilder();
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

    public long toTotalMonths() {
        return (((long) this.years) * 12) + ((long) this.months);
    }

    public Period withDays(int i11) {
        if (i11 == this.days) {
            return this;
        }
        return create(this.years, this.months, i11);
    }

    public Period withMonths(int i11) {
        if (i11 == this.months) {
            return this;
        }
        return create(this.years, i11, this.days);
    }

    public Period withYears(int i11) {
        if (i11 == this.years) {
            return this;
        }
        return create(i11, this.months, this.days);
    }

    public Period minus(TemporalAmount temporalAmount) {
        Period from = from(temporalAmount);
        return create(Jdk8Methods.safeSubtract(this.years, from.years), Jdk8Methods.safeSubtract(this.months, from.months), Jdk8Methods.safeSubtract(this.days, from.days));
    }

    public Period multipliedBy(int i11) {
        return (this == ZERO || i11 == 1) ? this : create(Jdk8Methods.safeMultiply(this.years, i11), Jdk8Methods.safeMultiply(this.months, i11), Jdk8Methods.safeMultiply(this.days, i11));
    }

    public Period negated() {
        return multipliedBy(-1);
    }

    public Period normalized() {
        long totalMonths = toTotalMonths();
        long j11 = totalMonths / 12;
        int i11 = (int) (totalMonths % 12);
        if (j11 == ((long) this.years) && i11 == this.months) {
            return this;
        }
        return create(Jdk8Methods.safeToInt(j11), i11, this.days);
    }

    public Period plus(TemporalAmount temporalAmount) {
        Period from = from(temporalAmount);
        return create(Jdk8Methods.safeAdd(this.years, from.years), Jdk8Methods.safeAdd(this.months, from.months), Jdk8Methods.safeAdd(this.days, from.days));
    }
}
