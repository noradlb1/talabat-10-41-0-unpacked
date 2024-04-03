package org.threeten.bp.zone;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Month;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.TemporalAdjusters;

public final class ZoneOffsetTransitionRule implements Serializable {
    private static final int SECS_PER_DAY = 86400;
    private static final long serialVersionUID = 6889046316657758795L;
    private final int adjustDays;
    private final byte dom;
    private final DayOfWeek dow;
    private final Month month;
    private final ZoneOffset offsetAfter;
    private final ZoneOffset offsetBefore;
    private final ZoneOffset standardOffset;
    private final LocalTime time;
    private final TimeDefinition timeDefinition;

    /* renamed from: org.threeten.bp.zone.ZoneOffsetTransitionRule$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f63393a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.threeten.bp.zone.ZoneOffsetTransitionRule$TimeDefinition[] r0 = org.threeten.bp.zone.ZoneOffsetTransitionRule.TimeDefinition.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f63393a = r0
                org.threeten.bp.zone.ZoneOffsetTransitionRule$TimeDefinition r1 = org.threeten.bp.zone.ZoneOffsetTransitionRule.TimeDefinition.UTC     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f63393a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.zone.ZoneOffsetTransitionRule$TimeDefinition r1 = org.threeten.bp.zone.ZoneOffsetTransitionRule.TimeDefinition.STANDARD     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.zone.ZoneOffsetTransitionRule.AnonymousClass1.<clinit>():void");
        }
    }

    public enum TimeDefinition {
        UTC,
        WALL,
        STANDARD;

        public LocalDateTime createDateTime(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
            int i11 = AnonymousClass1.f63393a[ordinal()];
            if (i11 == 1) {
                return localDateTime.plusSeconds((long) (zoneOffset2.getTotalSeconds() - ZoneOffset.UTC.getTotalSeconds()));
            }
            if (i11 != 2) {
                return localDateTime;
            }
            return localDateTime.plusSeconds((long) (zoneOffset2.getTotalSeconds() - zoneOffset.getTotalSeconds()));
        }
    }

    public ZoneOffsetTransitionRule(Month month2, int i11, DayOfWeek dayOfWeek, LocalTime localTime, int i12, TimeDefinition timeDefinition2, ZoneOffset zoneOffset, ZoneOffset zoneOffset2, ZoneOffset zoneOffset3) {
        this.month = month2;
        this.dom = (byte) i11;
        this.dow = dayOfWeek;
        this.time = localTime;
        this.adjustDays = i12;
        this.timeDefinition = timeDefinition2;
        this.standardOffset = zoneOffset;
        this.offsetBefore = zoneOffset2;
        this.offsetAfter = zoneOffset3;
    }

    public static ZoneOffsetTransitionRule a(DataInput dataInput) throws IOException {
        DayOfWeek dayOfWeek;
        int i11;
        int i12;
        int i13;
        int i14;
        int readInt = dataInput.readInt();
        Month of2 = Month.of(readInt >>> 28);
        int i15 = ((264241152 & readInt) >>> 22) - 32;
        int i16 = (3670016 & readInt) >>> 19;
        if (i16 == 0) {
            dayOfWeek = null;
        } else {
            dayOfWeek = DayOfWeek.of(i16);
        }
        DayOfWeek dayOfWeek2 = dayOfWeek;
        int i17 = (507904 & readInt) >>> 14;
        TimeDefinition timeDefinition2 = TimeDefinition.values()[(readInt & 12288) >>> 12];
        int i18 = (readInt & 4080) >>> 4;
        int i19 = (readInt & 12) >>> 2;
        int i21 = readInt & 3;
        if (i17 == 31) {
            i11 = dataInput.readInt();
        } else {
            i11 = i17 * 3600;
        }
        if (i18 == 255) {
            i12 = dataInput.readInt();
        } else {
            i12 = (i18 - 128) * TypedValues.Custom.TYPE_INT;
        }
        ZoneOffset ofTotalSeconds = ZoneOffset.ofTotalSeconds(i12);
        if (i19 == 3) {
            i13 = dataInput.readInt();
        } else {
            i13 = ofTotalSeconds.getTotalSeconds() + (i19 * 1800);
        }
        ZoneOffset ofTotalSeconds2 = ZoneOffset.ofTotalSeconds(i13);
        if (i21 == 3) {
            i14 = dataInput.readInt();
        } else {
            i14 = ofTotalSeconds.getTotalSeconds() + (i21 * 1800);
        }
        ZoneOffset ofTotalSeconds3 = ZoneOffset.ofTotalSeconds(i14);
        if (i15 >= -28 && i15 <= 31 && i15 != 0) {
            return new ZoneOffsetTransitionRule(of2, i15, dayOfWeek2, LocalTime.ofSecondOfDay((long) Jdk8Methods.floorMod(i11, 86400)), Jdk8Methods.floorDiv(i11, 86400), timeDefinition2, ofTotalSeconds, ofTotalSeconds2, ofTotalSeconds3);
        }
        throw new IllegalArgumentException("Day of month indicator must be between -28 and 31 inclusive excluding zero");
    }

    private void appendZeroPad(StringBuilder sb2, long j11) {
        if (j11 < 10) {
            sb2.append(0);
        }
        sb2.append(j11);
    }

    public static ZoneOffsetTransitionRule of(Month month2, int i11, DayOfWeek dayOfWeek, LocalTime localTime, boolean z11, TimeDefinition timeDefinition2, ZoneOffset zoneOffset, ZoneOffset zoneOffset2, ZoneOffset zoneOffset3) {
        int i12 = i11;
        LocalTime localTime2 = localTime;
        Month month3 = month2;
        Jdk8Methods.requireNonNull(month2, "month");
        Jdk8Methods.requireNonNull(localTime, "time");
        Jdk8Methods.requireNonNull(timeDefinition2, "timeDefnition");
        Jdk8Methods.requireNonNull(zoneOffset, "standardOffset");
        Jdk8Methods.requireNonNull(zoneOffset2, "offsetBefore");
        Jdk8Methods.requireNonNull(zoneOffset3, "offsetAfter");
        if (i12 < -28 || i12 > 31 || i12 == 0) {
            throw new IllegalArgumentException("Day of month indicator must be between -28 and 31 inclusive excluding zero");
        } else if (!z11 || localTime.equals(LocalTime.MIDNIGHT)) {
            return new ZoneOffsetTransitionRule(month2, i11, dayOfWeek, localTime, z11 ? 1 : 0, timeDefinition2, zoneOffset, zoneOffset2, zoneOffset3);
        } else {
            throw new IllegalArgumentException("Time must be midnight when end of day flag is true");
        }
    }

    private Object writeReplace() {
        return new Ser((byte) 3, this);
    }

    public void b(DataOutput dataOutput) throws IOException {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int secondOfDay = this.time.toSecondOfDay() + (this.adjustDays * 86400);
        int totalSeconds = this.standardOffset.getTotalSeconds();
        int totalSeconds2 = this.offsetBefore.getTotalSeconds() - totalSeconds;
        int totalSeconds3 = this.offsetAfter.getTotalSeconds() - totalSeconds;
        if (secondOfDay % 3600 != 0 || secondOfDay > 86400) {
            i11 = 31;
        } else if (secondOfDay == 86400) {
            i11 = 24;
        } else {
            i11 = this.time.getHour();
        }
        if (totalSeconds % TypedValues.Custom.TYPE_INT == 0) {
            i12 = (totalSeconds / TypedValues.Custom.TYPE_INT) + 128;
        } else {
            i12 = 255;
        }
        if (totalSeconds2 == 0 || totalSeconds2 == 1800 || totalSeconds2 == 3600) {
            i13 = totalSeconds2 / 1800;
        } else {
            i13 = 3;
        }
        if (totalSeconds3 == 0 || totalSeconds3 == 1800 || totalSeconds3 == 3600) {
            i14 = totalSeconds3 / 1800;
        } else {
            i14 = 3;
        }
        DayOfWeek dayOfWeek = this.dow;
        if (dayOfWeek == null) {
            i15 = 0;
        } else {
            i15 = dayOfWeek.getValue();
        }
        dataOutput.writeInt((this.month.getValue() << 28) + ((this.dom + 32) << 22) + (i15 << 19) + (i11 << 14) + (this.timeDefinition.ordinal() << 12) + (i12 << 4) + (i13 << 2) + i14);
        if (i11 == 31) {
            dataOutput.writeInt(secondOfDay);
        }
        if (i12 == 255) {
            dataOutput.writeInt(totalSeconds);
        }
        if (i13 == 3) {
            dataOutput.writeInt(this.offsetBefore.getTotalSeconds());
        }
        if (i14 == 3) {
            dataOutput.writeInt(this.offsetAfter.getTotalSeconds());
        }
    }

    public ZoneOffsetTransition createTransition(int i11) {
        LocalDate localDate;
        byte b11 = this.dom;
        if (b11 < 0) {
            Month month2 = this.month;
            localDate = LocalDate.of(i11, month2, month2.length(IsoChronology.INSTANCE.isLeapYear((long) i11)) + 1 + this.dom);
            DayOfWeek dayOfWeek = this.dow;
            if (dayOfWeek != null) {
                localDate = localDate.with(TemporalAdjusters.previousOrSame(dayOfWeek));
            }
        } else {
            localDate = LocalDate.of(i11, this.month, (int) b11);
            DayOfWeek dayOfWeek2 = this.dow;
            if (dayOfWeek2 != null) {
                localDate = localDate.with(TemporalAdjusters.nextOrSame(dayOfWeek2));
            }
        }
        return new ZoneOffsetTransition(this.timeDefinition.createDateTime(LocalDateTime.of(localDate.plusDays((long) this.adjustDays), this.time), this.standardOffset, this.offsetBefore), this.offsetBefore, this.offsetAfter);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ZoneOffsetTransitionRule)) {
            return false;
        }
        ZoneOffsetTransitionRule zoneOffsetTransitionRule = (ZoneOffsetTransitionRule) obj;
        if (this.month == zoneOffsetTransitionRule.month && this.dom == zoneOffsetTransitionRule.dom && this.dow == zoneOffsetTransitionRule.dow && this.timeDefinition == zoneOffsetTransitionRule.timeDefinition && this.adjustDays == zoneOffsetTransitionRule.adjustDays && this.time.equals(zoneOffsetTransitionRule.time) && this.standardOffset.equals(zoneOffsetTransitionRule.standardOffset) && this.offsetBefore.equals(zoneOffsetTransitionRule.offsetBefore) && this.offsetAfter.equals(zoneOffsetTransitionRule.offsetAfter)) {
            return true;
        }
        return false;
    }

    public int getDayOfMonthIndicator() {
        return this.dom;
    }

    public DayOfWeek getDayOfWeek() {
        return this.dow;
    }

    public LocalTime getLocalTime() {
        return this.time;
    }

    public Month getMonth() {
        return this.month;
    }

    public ZoneOffset getOffsetAfter() {
        return this.offsetAfter;
    }

    public ZoneOffset getOffsetBefore() {
        return this.offsetBefore;
    }

    public ZoneOffset getStandardOffset() {
        return this.standardOffset;
    }

    public TimeDefinition getTimeDefinition() {
        return this.timeDefinition;
    }

    public int hashCode() {
        int i11;
        int secondOfDay = ((this.time.toSecondOfDay() + this.adjustDays) << 15) + (this.month.ordinal() << 11) + ((this.dom + 32) << 5);
        DayOfWeek dayOfWeek = this.dow;
        if (dayOfWeek == null) {
            i11 = 7;
        } else {
            i11 = dayOfWeek.ordinal();
        }
        return ((((secondOfDay + (i11 << 2)) + this.timeDefinition.ordinal()) ^ this.standardOffset.hashCode()) ^ this.offsetBefore.hashCode()) ^ this.offsetAfter.hashCode();
    }

    public boolean isMidnightEndOfDay() {
        return this.adjustDays == 1 && this.time.equals(LocalTime.MIDNIGHT);
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("TransitionRule[");
        if (this.offsetBefore.compareTo(this.offsetAfter) > 0) {
            str = "Gap ";
        } else {
            str = "Overlap ";
        }
        sb2.append(str);
        sb2.append(this.offsetBefore);
        sb2.append(" to ");
        sb2.append(this.offsetAfter);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        DayOfWeek dayOfWeek = this.dow;
        if (dayOfWeek != null) {
            byte b11 = this.dom;
            if (b11 == -1) {
                sb2.append(dayOfWeek.name());
                sb2.append(" on or before last day of ");
                sb2.append(this.month.name());
            } else if (b11 < 0) {
                sb2.append(dayOfWeek.name());
                sb2.append(" on or before last day minus ");
                sb2.append((-this.dom) - 1);
                sb2.append(" of ");
                sb2.append(this.month.name());
            } else {
                sb2.append(dayOfWeek.name());
                sb2.append(" on or after ");
                sb2.append(this.month.name());
                sb2.append(' ');
                sb2.append(this.dom);
            }
        } else {
            sb2.append(this.month.name());
            sb2.append(' ');
            sb2.append(this.dom);
        }
        sb2.append(" at ");
        if (this.adjustDays == 0) {
            sb2.append(this.time);
        } else {
            long secondOfDay = (long) ((this.time.toSecondOfDay() / 60) + (this.adjustDays * 24 * 60));
            appendZeroPad(sb2, Jdk8Methods.floorDiv(secondOfDay, 60));
            sb2.append(AbstractJsonLexerKt.COLON);
            appendZeroPad(sb2, (long) Jdk8Methods.floorMod(secondOfDay, 60));
        }
        sb2.append(" ");
        sb2.append(this.timeDefinition);
        sb2.append(", standard offset ");
        sb2.append(this.standardOffset);
        sb2.append(AbstractJsonLexerKt.END_LIST);
        return sb2.toString();
    }
}
