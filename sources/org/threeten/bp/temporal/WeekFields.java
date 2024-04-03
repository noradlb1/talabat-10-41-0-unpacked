package org.threeten.bp.temporal;

import com.talabat.talabatcommon.views.wallet.subscription.model.WalletSubscriptionMapperKt;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.Year;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.jdk8.Jdk8Methods;

public final class WeekFields implements Serializable {
    private static final ConcurrentMap<String, WeekFields> CACHE = new ConcurrentHashMap(4, 0.75f, 2);
    public static final WeekFields ISO = new WeekFields(DayOfWeek.MONDAY, 4);
    public static final WeekFields SUNDAY_START = of(DayOfWeek.SUNDAY, 1);
    private static final long serialVersionUID = -1177360819670808121L;
    private final transient TemporalField dayOfWeek = ComputedDayOfField.a(this);
    private final DayOfWeek firstDayOfWeek;
    private final int minimalDays;
    private final transient TemporalField weekBasedYear = ComputedDayOfField.b(this);
    private final transient TemporalField weekOfMonth = ComputedDayOfField.c(this);
    /* access modifiers changed from: private */
    public final transient TemporalField weekOfWeekBasedYear = ComputedDayOfField.d(this);
    private final transient TemporalField weekOfYear = ComputedDayOfField.e(this);

    public static class ComputedDayOfField implements TemporalField {
        private static final ValueRange DAY_OF_WEEK_RANGE = ValueRange.of(1, 7);
        private static final ValueRange WEEK_BASED_YEAR_RANGE = ChronoField.YEAR.range();
        private static final ValueRange WEEK_OF_MONTH_RANGE = ValueRange.of(0, 1, 4, 6);
        private static final ValueRange WEEK_OF_WEEK_BASED_YEAR_RANGE = ValueRange.of(1, 52, 53);
        private static final ValueRange WEEK_OF_YEAR_RANGE = ValueRange.of(0, 1, 52, 54);
        private final TemporalUnit baseUnit;

        /* renamed from: name  reason: collision with root package name */
        private final String f63392name;
        private final ValueRange range;
        private final TemporalUnit rangeUnit;
        private final WeekFields weekDef;

        private ComputedDayOfField(String str, WeekFields weekFields, TemporalUnit temporalUnit, TemporalUnit temporalUnit2, ValueRange valueRange) {
            this.f63392name = str;
            this.weekDef = weekFields;
            this.baseUnit = temporalUnit;
            this.rangeUnit = temporalUnit2;
            this.range = valueRange;
        }

        public static ComputedDayOfField a(WeekFields weekFields) {
            return new ComputedDayOfField("DayOfWeek", weekFields, ChronoUnit.DAYS, ChronoUnit.WEEKS, DAY_OF_WEEK_RANGE);
        }

        public static ComputedDayOfField b(WeekFields weekFields) {
            return new ComputedDayOfField("WeekBasedYear", weekFields, IsoFields.WEEK_BASED_YEARS, ChronoUnit.FOREVER, WEEK_BASED_YEAR_RANGE);
        }

        public static ComputedDayOfField c(WeekFields weekFields) {
            return new ComputedDayOfField("WeekOfMonth", weekFields, ChronoUnit.WEEKS, ChronoUnit.MONTHS, WEEK_OF_MONTH_RANGE);
        }

        private int computeWeek(int i11, int i12) {
            return ((i11 + 7) + (i12 - 1)) / 7;
        }

        public static ComputedDayOfField d(WeekFields weekFields) {
            return new ComputedDayOfField("WeekOfWeekBasedYear", weekFields, ChronoUnit.WEEKS, IsoFields.WEEK_BASED_YEARS, WEEK_OF_WEEK_BASED_YEAR_RANGE);
        }

        public static ComputedDayOfField e(WeekFields weekFields) {
            return new ComputedDayOfField("WeekOfYear", weekFields, ChronoUnit.WEEKS, ChronoUnit.YEARS, WEEK_OF_YEAR_RANGE);
        }

        private int localizedDayOfWeek(TemporalAccessor temporalAccessor, int i11) {
            return Jdk8Methods.floorMod(temporalAccessor.get(ChronoField.DAY_OF_WEEK) - i11, 7) + 1;
        }

        private int localizedWBY(TemporalAccessor temporalAccessor) {
            int i11;
            int floorMod = Jdk8Methods.floorMod(temporalAccessor.get(ChronoField.DAY_OF_WEEK) - this.weekDef.getFirstDayOfWeek().getValue(), 7) + 1;
            int i12 = temporalAccessor.get(ChronoField.YEAR);
            long localizedWeekOfYear = localizedWeekOfYear(temporalAccessor, floorMod);
            if (localizedWeekOfYear == 0) {
                return i12 - 1;
            }
            if (localizedWeekOfYear < 53) {
                return i12;
            }
            int startOfWeekOffset = startOfWeekOffset(temporalAccessor.get(ChronoField.DAY_OF_YEAR), floorMod);
            if (Year.isLeap((long) i12)) {
                i11 = 366;
            } else {
                i11 = WalletSubscriptionMapperKt.DAYS_IN_A_YEAR;
            }
            if (localizedWeekOfYear >= ((long) computeWeek(startOfWeekOffset, i11 + this.weekDef.getMinimalDaysInFirstWeek()))) {
                return i12 + 1;
            }
            return i12;
        }

        private int localizedWOWBY(TemporalAccessor temporalAccessor) {
            int i11;
            int floorMod = Jdk8Methods.floorMod(temporalAccessor.get(ChronoField.DAY_OF_WEEK) - this.weekDef.getFirstDayOfWeek().getValue(), 7) + 1;
            long localizedWeekOfYear = localizedWeekOfYear(temporalAccessor, floorMod);
            if (localizedWeekOfYear == 0) {
                return ((int) localizedWeekOfYear(Chronology.from(temporalAccessor).date(temporalAccessor).minus(1, (TemporalUnit) ChronoUnit.WEEKS), floorMod)) + 1;
            }
            if (localizedWeekOfYear >= 53) {
                int startOfWeekOffset = startOfWeekOffset(temporalAccessor.get(ChronoField.DAY_OF_YEAR), floorMod);
                if (Year.isLeap((long) temporalAccessor.get(ChronoField.YEAR))) {
                    i11 = 366;
                } else {
                    i11 = WalletSubscriptionMapperKt.DAYS_IN_A_YEAR;
                }
                int computeWeek = computeWeek(startOfWeekOffset, i11 + this.weekDef.getMinimalDaysInFirstWeek());
                if (localizedWeekOfYear >= ((long) computeWeek)) {
                    return (int) (localizedWeekOfYear - ((long) (computeWeek - 1)));
                }
            }
            return (int) localizedWeekOfYear;
        }

        private long localizedWeekOfMonth(TemporalAccessor temporalAccessor, int i11) {
            int i12 = temporalAccessor.get(ChronoField.DAY_OF_MONTH);
            return (long) computeWeek(startOfWeekOffset(i12, i11), i12);
        }

        private long localizedWeekOfYear(TemporalAccessor temporalAccessor, int i11) {
            int i12 = temporalAccessor.get(ChronoField.DAY_OF_YEAR);
            return (long) computeWeek(startOfWeekOffset(i12, i11), i12);
        }

        private ValueRange rangeWOWBY(TemporalAccessor temporalAccessor) {
            int i11;
            int floorMod = Jdk8Methods.floorMod(temporalAccessor.get(ChronoField.DAY_OF_WEEK) - this.weekDef.getFirstDayOfWeek().getValue(), 7) + 1;
            long localizedWeekOfYear = localizedWeekOfYear(temporalAccessor, floorMod);
            if (localizedWeekOfYear == 0) {
                return rangeWOWBY(Chronology.from(temporalAccessor).date(temporalAccessor).minus(2, (TemporalUnit) ChronoUnit.WEEKS));
            }
            int startOfWeekOffset = startOfWeekOffset(temporalAccessor.get(ChronoField.DAY_OF_YEAR), floorMod);
            if (Year.isLeap((long) temporalAccessor.get(ChronoField.YEAR))) {
                i11 = 366;
            } else {
                i11 = WalletSubscriptionMapperKt.DAYS_IN_A_YEAR;
            }
            int computeWeek = computeWeek(startOfWeekOffset, i11 + this.weekDef.getMinimalDaysInFirstWeek());
            if (localizedWeekOfYear >= ((long) computeWeek)) {
                return rangeWOWBY(Chronology.from(temporalAccessor).date(temporalAccessor).plus(2, (TemporalUnit) ChronoUnit.WEEKS));
            }
            return ValueRange.of(1, (long) (computeWeek - 1));
        }

        private int startOfWeekOffset(int i11, int i12) {
            int floorMod = Jdk8Methods.floorMod(i11 - i12, 7);
            int i13 = -floorMod;
            if (floorMod + 1 > this.weekDef.getMinimalDaysInFirstWeek()) {
                return 7 - floorMod;
            }
            return i13;
        }

        public <R extends Temporal> R adjustInto(R r11, long j11) {
            int checkValidIntValue = this.range.checkValidIntValue(j11, this);
            int i11 = r11.get(this);
            if (checkValidIntValue == i11) {
                return r11;
            }
            if (this.rangeUnit != ChronoUnit.FOREVER) {
                return r11.plus((long) (checkValidIntValue - i11), this.baseUnit);
            }
            int i12 = r11.get(this.weekDef.weekOfWeekBasedYear);
            ChronoUnit chronoUnit = ChronoUnit.WEEKS;
            Temporal plus = r11.plus((long) (((double) (j11 - ((long) i11))) * 52.1775d), chronoUnit);
            if (plus.get(this) > checkValidIntValue) {
                return plus.minus((long) plus.get(this.weekDef.weekOfWeekBasedYear), chronoUnit);
            }
            if (plus.get(this) < checkValidIntValue) {
                plus = plus.plus(2, chronoUnit);
            }
            R plus2 = plus.plus((long) (i12 - plus.get(this.weekDef.weekOfWeekBasedYear)), chronoUnit);
            if (plus2.get(this) > checkValidIntValue) {
                return plus2.minus(1, chronoUnit);
            }
            return plus2;
        }

        public TemporalUnit getBaseUnit() {
            return this.baseUnit;
        }

        public String getDisplayName(Locale locale) {
            Jdk8Methods.requireNonNull(locale, "locale");
            if (this.rangeUnit == ChronoUnit.YEARS) {
                return "Week";
            }
            return toString();
        }

        public long getFrom(TemporalAccessor temporalAccessor) {
            int localizedWBY;
            int floorMod = Jdk8Methods.floorMod(temporalAccessor.get(ChronoField.DAY_OF_WEEK) - this.weekDef.getFirstDayOfWeek().getValue(), 7) + 1;
            TemporalUnit temporalUnit = this.rangeUnit;
            if (temporalUnit == ChronoUnit.WEEKS) {
                return (long) floorMod;
            }
            if (temporalUnit == ChronoUnit.MONTHS) {
                int i11 = temporalAccessor.get(ChronoField.DAY_OF_MONTH);
                localizedWBY = computeWeek(startOfWeekOffset(i11, floorMod), i11);
            } else if (temporalUnit == ChronoUnit.YEARS) {
                int i12 = temporalAccessor.get(ChronoField.DAY_OF_YEAR);
                localizedWBY = computeWeek(startOfWeekOffset(i12, floorMod), i12);
            } else if (temporalUnit == IsoFields.WEEK_BASED_YEARS) {
                localizedWBY = localizedWOWBY(temporalAccessor);
            } else if (temporalUnit == ChronoUnit.FOREVER) {
                localizedWBY = localizedWBY(temporalAccessor);
            } else {
                throw new IllegalStateException("unreachable");
            }
            return (long) localizedWBY;
        }

        public TemporalUnit getRangeUnit() {
            return this.rangeUnit;
        }

        public boolean isDateBased() {
            return true;
        }

        public boolean isSupportedBy(TemporalAccessor temporalAccessor) {
            if (!temporalAccessor.isSupported(ChronoField.DAY_OF_WEEK)) {
                return false;
            }
            TemporalUnit temporalUnit = this.rangeUnit;
            if (temporalUnit == ChronoUnit.WEEKS) {
                return true;
            }
            if (temporalUnit == ChronoUnit.MONTHS) {
                return temporalAccessor.isSupported(ChronoField.DAY_OF_MONTH);
            }
            if (temporalUnit == ChronoUnit.YEARS) {
                return temporalAccessor.isSupported(ChronoField.DAY_OF_YEAR);
            }
            if (temporalUnit == IsoFields.WEEK_BASED_YEARS) {
                return temporalAccessor.isSupported(ChronoField.EPOCH_DAY);
            }
            if (temporalUnit == ChronoUnit.FOREVER) {
                return temporalAccessor.isSupported(ChronoField.EPOCH_DAY);
            }
            return false;
        }

        public boolean isTimeBased() {
            return false;
        }

        public ValueRange range() {
            return this.range;
        }

        public ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
            ChronoField chronoField;
            TemporalUnit temporalUnit = this.rangeUnit;
            if (temporalUnit == ChronoUnit.WEEKS) {
                return this.range;
            }
            if (temporalUnit == ChronoUnit.MONTHS) {
                chronoField = ChronoField.DAY_OF_MONTH;
            } else if (temporalUnit == ChronoUnit.YEARS) {
                chronoField = ChronoField.DAY_OF_YEAR;
            } else if (temporalUnit == IsoFields.WEEK_BASED_YEARS) {
                return rangeWOWBY(temporalAccessor);
            } else {
                if (temporalUnit == ChronoUnit.FOREVER) {
                    return temporalAccessor.range(ChronoField.YEAR);
                }
                throw new IllegalStateException("unreachable");
            }
            int value = this.weekDef.getFirstDayOfWeek().getValue();
            int startOfWeekOffset = startOfWeekOffset(temporalAccessor.get(chronoField), Jdk8Methods.floorMod(temporalAccessor.get(ChronoField.DAY_OF_WEEK) - value, 7) + 1);
            ValueRange range2 = temporalAccessor.range(chronoField);
            return ValueRange.of((long) computeWeek(startOfWeekOffset, (int) range2.getMinimum()), (long) computeWeek(startOfWeekOffset, (int) range2.getMaximum()));
        }

        public TemporalAccessor resolve(Map<TemporalField, Long> map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
            long j11;
            long j12;
            int i11;
            long j13;
            ChronoLocalDate chronoLocalDate;
            long j14;
            long j15;
            ChronoLocalDate chronoLocalDate2;
            int i12;
            Map<TemporalField, Long> map2 = map;
            ResolverStyle resolverStyle2 = resolverStyle;
            int value = this.weekDef.getFirstDayOfWeek().getValue();
            if (this.rangeUnit == ChronoUnit.WEEKS) {
                map2.put(ChronoField.DAY_OF_WEEK, Long.valueOf((long) (Jdk8Methods.floorMod((value - 1) + (this.range.checkValidIntValue(map2.remove(this).longValue(), this) - 1), 7) + 1)));
                return null;
            }
            ChronoField chronoField = ChronoField.DAY_OF_WEEK;
            if (!map2.containsKey(chronoField)) {
                return null;
            }
            if (this.rangeUnit != ChronoUnit.FOREVER) {
                ChronoField chronoField2 = ChronoField.YEAR;
                if (!map2.containsKey(chronoField2)) {
                    return null;
                }
                int floorMod = Jdk8Methods.floorMod(chronoField.checkValidIntValue(map2.get(chronoField).longValue()) - value, 7) + 1;
                int checkValidIntValue = chronoField2.checkValidIntValue(map2.get(chronoField2).longValue());
                Chronology from = Chronology.from(temporalAccessor);
                TemporalUnit temporalUnit = this.rangeUnit;
                ChronoUnit chronoUnit = ChronoUnit.MONTHS;
                if (temporalUnit == chronoUnit) {
                    ChronoField chronoField3 = ChronoField.MONTH_OF_YEAR;
                    if (!map2.containsKey(chronoField3)) {
                        return null;
                    }
                    long longValue = map2.remove(this).longValue();
                    if (resolverStyle2 == ResolverStyle.LENIENT) {
                        chronoLocalDate = from.date(checkValidIntValue, 1, 1).plus(map2.get(chronoField3).longValue() - 1, (TemporalUnit) chronoUnit);
                        int localizedDayOfWeek = localizedDayOfWeek(chronoLocalDate, value);
                        j13 = ((longValue - localizedWeekOfMonth(chronoLocalDate, localizedDayOfWeek)) * 7) + ((long) (floorMod - localizedDayOfWeek));
                    } else {
                        chronoLocalDate = from.date(checkValidIntValue, chronoField3.checkValidIntValue(map2.get(chronoField3).longValue()), 8);
                        int localizedDayOfWeek2 = localizedDayOfWeek(chronoLocalDate, value);
                        j13 = ((long) (floorMod - localizedDayOfWeek2)) + ((((long) this.range.checkValidIntValue(longValue, this)) - localizedWeekOfMonth(chronoLocalDate, localizedDayOfWeek2)) * 7);
                    }
                    ChronoLocalDate plus = chronoLocalDate.plus(j13, (TemporalUnit) ChronoUnit.DAYS);
                    if (resolverStyle2 != ResolverStyle.STRICT || plus.getLong(chronoField3) == map2.get(chronoField3).longValue()) {
                        map2.remove(this);
                        map2.remove(chronoField2);
                        map2.remove(chronoField3);
                        map2.remove(chronoField);
                        return plus;
                    }
                    throw new DateTimeException("Strict mode rejected date parsed to a different month");
                } else if (temporalUnit == ChronoUnit.YEARS) {
                    long longValue2 = map2.remove(this).longValue();
                    ChronoLocalDate date = from.date(checkValidIntValue, 1, 1);
                    if (resolverStyle2 == ResolverStyle.LENIENT) {
                        i11 = localizedDayOfWeek(date, value);
                        j11 = longValue2 - localizedWeekOfYear(date, i11);
                        j12 = 7;
                    } else {
                        j12 = 7;
                        i11 = localizedDayOfWeek(date, value);
                        j11 = ((long) this.range.checkValidIntValue(longValue2, this)) - localizedWeekOfYear(date, i11);
                    }
                    ChronoLocalDate plus2 = date.plus((j11 * j12) + ((long) (floorMod - i11)), (TemporalUnit) ChronoUnit.DAYS);
                    if (resolverStyle2 != ResolverStyle.STRICT || plus2.getLong(chronoField2) == map2.get(chronoField2).longValue()) {
                        map2.remove(this);
                        map2.remove(chronoField2);
                        map2.remove(chronoField);
                        return plus2;
                    }
                    throw new DateTimeException("Strict mode rejected date parsed to a different year");
                } else {
                    throw new IllegalStateException("unreachable");
                }
            } else if (!map2.containsKey(this.weekDef.weekOfWeekBasedYear)) {
                return null;
            } else {
                Chronology from2 = Chronology.from(temporalAccessor);
                int floorMod2 = Jdk8Methods.floorMod(chronoField.checkValidIntValue(map2.get(chronoField).longValue()) - value, 7) + 1;
                int checkValidIntValue2 = range().checkValidIntValue(map2.get(this).longValue(), this);
                if (resolverStyle2 == ResolverStyle.LENIENT) {
                    chronoLocalDate2 = from2.date(checkValidIntValue2, 1, this.weekDef.getMinimalDaysInFirstWeek());
                    j15 = map2.get(this.weekDef.weekOfWeekBasedYear).longValue();
                    i12 = localizedDayOfWeek(chronoLocalDate2, value);
                    j14 = localizedWeekOfYear(chronoLocalDate2, i12);
                } else {
                    chronoLocalDate2 = from2.date(checkValidIntValue2, 1, this.weekDef.getMinimalDaysInFirstWeek());
                    j15 = (long) this.weekDef.weekOfWeekBasedYear.range().checkValidIntValue(map2.get(this.weekDef.weekOfWeekBasedYear).longValue(), this.weekDef.weekOfWeekBasedYear);
                    i12 = localizedDayOfWeek(chronoLocalDate2, value);
                    j14 = localizedWeekOfYear(chronoLocalDate2, i12);
                }
                ChronoLocalDate plus3 = chronoLocalDate2.plus(((j15 - j14) * 7) + ((long) (floorMod2 - i12)), (TemporalUnit) ChronoUnit.DAYS);
                if (resolverStyle2 != ResolverStyle.STRICT || plus3.getLong(this) == map2.get(this).longValue()) {
                    map2.remove(this);
                    map2.remove(this.weekDef.weekOfWeekBasedYear);
                    map2.remove(chronoField);
                    return plus3;
                }
                throw new DateTimeException("Strict mode rejected date parsed to a different year");
            }
        }

        public String toString() {
            return this.f63392name + "[" + this.weekDef.toString() + "]";
        }
    }

    private WeekFields(DayOfWeek dayOfWeek2, int i11) {
        Jdk8Methods.requireNonNull(dayOfWeek2, "firstDayOfWeek");
        if (i11 < 1 || i11 > 7) {
            throw new IllegalArgumentException("Minimal number of days is invalid");
        }
        this.firstDayOfWeek = dayOfWeek2;
        this.minimalDays = i11;
    }

    public static WeekFields of(Locale locale) {
        Jdk8Methods.requireNonNull(locale, "locale");
        GregorianCalendar gregorianCalendar = new GregorianCalendar(new Locale(locale.getLanguage(), locale.getCountry()));
        return of(DayOfWeek.SUNDAY.plus((long) (gregorianCalendar.getFirstDayOfWeek() - 1)), gregorianCalendar.getMinimalDaysInFirstWeek());
    }

    private Object readResolve() throws InvalidObjectException {
        try {
            return of(this.firstDayOfWeek, this.minimalDays);
        } catch (IllegalArgumentException e11) {
            throw new InvalidObjectException("Invalid WeekFields" + e11.getMessage());
        }
    }

    public TemporalField dayOfWeek() {
        return this.dayOfWeek;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WeekFields)) {
            return false;
        }
        if (hashCode() == obj.hashCode()) {
            return true;
        }
        return false;
    }

    public DayOfWeek getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    public int getMinimalDaysInFirstWeek() {
        return this.minimalDays;
    }

    public int hashCode() {
        return (this.firstDayOfWeek.ordinal() * 7) + this.minimalDays;
    }

    public String toString() {
        return "WeekFields[" + this.firstDayOfWeek + AbstractJsonLexerKt.COMMA + this.minimalDays + AbstractJsonLexerKt.END_LIST;
    }

    public TemporalField weekBasedYear() {
        return this.weekBasedYear;
    }

    public TemporalField weekOfMonth() {
        return this.weekOfMonth;
    }

    public TemporalField weekOfWeekBasedYear() {
        return this.weekOfWeekBasedYear;
    }

    public TemporalField weekOfYear() {
        return this.weekOfYear;
    }

    public static WeekFields of(DayOfWeek dayOfWeek2, int i11) {
        String str = dayOfWeek2.toString() + i11;
        ConcurrentMap<String, WeekFields> concurrentMap = CACHE;
        WeekFields weekFields = concurrentMap.get(str);
        if (weekFields != null) {
            return weekFields;
        }
        concurrentMap.putIfAbsent(str, new WeekFields(dayOfWeek2, i11));
        return concurrentMap.get(str);
    }
}
