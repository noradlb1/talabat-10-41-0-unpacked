package org.threeten.bp.temporal;

import org.threeten.bp.DayOfWeek;
import org.threeten.bp.jdk8.Jdk8Methods;

public final class TemporalAdjusters {

    public static final class DayOfWeekInMonth implements TemporalAdjuster {
        private final int dowValue;
        private final int ordinal;

        public Temporal adjustInto(Temporal temporal) {
            if (this.ordinal >= 0) {
                Temporal with = temporal.with(ChronoField.DAY_OF_MONTH, 1);
                return with.plus((long) ((int) (((long) (((this.dowValue - with.get(ChronoField.DAY_OF_WEEK)) + 7) % 7)) + ((((long) this.ordinal) - 1) * 7))), ChronoUnit.DAYS);
            }
            ChronoField chronoField = ChronoField.DAY_OF_MONTH;
            Temporal with2 = temporal.with(chronoField, temporal.range(chronoField).getMaximum());
            int i11 = this.dowValue - with2.get(ChronoField.DAY_OF_WEEK);
            if (i11 == 0) {
                i11 = 0;
            } else if (i11 > 0) {
                i11 -= 7;
            }
            return with2.plus((long) ((int) (((long) i11) - ((((long) (-this.ordinal)) - 1) * 7))), ChronoUnit.DAYS);
        }

        private DayOfWeekInMonth(int i11, DayOfWeek dayOfWeek) {
            this.ordinal = i11;
            this.dowValue = dayOfWeek.getValue();
        }
    }

    public static class Impl implements TemporalAdjuster {
        /* access modifiers changed from: private */
        public static final Impl FIRST_DAY_OF_MONTH = new Impl(0);
        /* access modifiers changed from: private */
        public static final Impl FIRST_DAY_OF_NEXT_MONTH = new Impl(2);
        /* access modifiers changed from: private */
        public static final Impl FIRST_DAY_OF_NEXT_YEAR = new Impl(5);
        /* access modifiers changed from: private */
        public static final Impl FIRST_DAY_OF_YEAR = new Impl(3);
        /* access modifiers changed from: private */
        public static final Impl LAST_DAY_OF_MONTH = new Impl(1);
        /* access modifiers changed from: private */
        public static final Impl LAST_DAY_OF_YEAR = new Impl(4);
        private final int ordinal;

        private Impl(int i11) {
            this.ordinal = i11;
        }

        public Temporal adjustInto(Temporal temporal) {
            int i11 = this.ordinal;
            if (i11 == 0) {
                return temporal.with(ChronoField.DAY_OF_MONTH, 1);
            }
            if (i11 == 1) {
                ChronoField chronoField = ChronoField.DAY_OF_MONTH;
                return temporal.with(chronoField, temporal.range(chronoField).getMaximum());
            } else if (i11 == 2) {
                return temporal.with(ChronoField.DAY_OF_MONTH, 1).plus(1, ChronoUnit.MONTHS);
            } else {
                if (i11 == 3) {
                    return temporal.with(ChronoField.DAY_OF_YEAR, 1);
                }
                if (i11 == 4) {
                    ChronoField chronoField2 = ChronoField.DAY_OF_YEAR;
                    return temporal.with(chronoField2, temporal.range(chronoField2).getMaximum());
                } else if (i11 == 5) {
                    return temporal.with(ChronoField.DAY_OF_YEAR, 1).plus(1, ChronoUnit.YEARS);
                } else {
                    throw new IllegalStateException("Unreachable");
                }
            }
        }
    }

    public static final class RelativeDayOfWeek implements TemporalAdjuster {
        private final int dowValue;
        private final int relative;

        public Temporal adjustInto(Temporal temporal) {
            int i11;
            int i12;
            int i13 = temporal.get(ChronoField.DAY_OF_WEEK);
            int i14 = this.relative;
            if (i14 < 2 && i13 == this.dowValue) {
                return temporal;
            }
            if ((i14 & 1) == 0) {
                int i15 = i13 - this.dowValue;
                if (i15 >= 0) {
                    i12 = 7 - i15;
                } else {
                    i12 = -i15;
                }
                return temporal.plus((long) i12, ChronoUnit.DAYS);
            }
            int i16 = this.dowValue - i13;
            if (i16 >= 0) {
                i11 = 7 - i16;
            } else {
                i11 = -i16;
            }
            return temporal.minus((long) i11, ChronoUnit.DAYS);
        }

        private RelativeDayOfWeek(int i11, DayOfWeek dayOfWeek) {
            Jdk8Methods.requireNonNull(dayOfWeek, "dayOfWeek");
            this.relative = i11;
            this.dowValue = dayOfWeek.getValue();
        }
    }

    private TemporalAdjusters() {
    }

    public static TemporalAdjuster dayOfWeekInMonth(int i11, DayOfWeek dayOfWeek) {
        Jdk8Methods.requireNonNull(dayOfWeek, "dayOfWeek");
        return new DayOfWeekInMonth(i11, dayOfWeek);
    }

    public static TemporalAdjuster firstDayOfMonth() {
        return Impl.FIRST_DAY_OF_MONTH;
    }

    public static TemporalAdjuster firstDayOfNextMonth() {
        return Impl.FIRST_DAY_OF_NEXT_MONTH;
    }

    public static TemporalAdjuster firstDayOfNextYear() {
        return Impl.FIRST_DAY_OF_NEXT_YEAR;
    }

    public static TemporalAdjuster firstDayOfYear() {
        return Impl.FIRST_DAY_OF_YEAR;
    }

    public static TemporalAdjuster firstInMonth(DayOfWeek dayOfWeek) {
        Jdk8Methods.requireNonNull(dayOfWeek, "dayOfWeek");
        return new DayOfWeekInMonth(1, dayOfWeek);
    }

    public static TemporalAdjuster lastDayOfMonth() {
        return Impl.LAST_DAY_OF_MONTH;
    }

    public static TemporalAdjuster lastDayOfYear() {
        return Impl.LAST_DAY_OF_YEAR;
    }

    public static TemporalAdjuster lastInMonth(DayOfWeek dayOfWeek) {
        Jdk8Methods.requireNonNull(dayOfWeek, "dayOfWeek");
        return new DayOfWeekInMonth(-1, dayOfWeek);
    }

    public static TemporalAdjuster next(DayOfWeek dayOfWeek) {
        return new RelativeDayOfWeek(2, dayOfWeek);
    }

    public static TemporalAdjuster nextOrSame(DayOfWeek dayOfWeek) {
        return new RelativeDayOfWeek(0, dayOfWeek);
    }

    public static TemporalAdjuster previous(DayOfWeek dayOfWeek) {
        return new RelativeDayOfWeek(3, dayOfWeek);
    }

    public static TemporalAdjuster previousOrSame(DayOfWeek dayOfWeek) {
        return new RelativeDayOfWeek(1, dayOfWeek);
    }
}
