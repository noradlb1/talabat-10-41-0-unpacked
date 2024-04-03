package org.threeten.bp;

import com.google.android.exoplayer2.C;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.threeten.bp.format.DateTimeParseException;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;

public final class Duration implements TemporalAmount, Comparable<Duration>, Serializable {
    private static final BigInteger BI_NANOS_PER_SECOND = BigInteger.valueOf(C.NANOS_PER_SECOND);
    private static final int NANOS_PER_MILLI = 1000000;
    private static final int NANOS_PER_SECOND = 1000000000;
    private static final Pattern PATTERN = Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)D)?(T(?:([-+]?[0-9]+)H)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)(?:[.,]([0-9]{0,9}))?S)?)?", 2);
    public static final Duration ZERO = new Duration(0, 0);
    private static final long serialVersionUID = 3078945930695997490L;
    private final int nanos;
    private final long seconds;

    /* renamed from: org.threeten.bp.Duration$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f63311a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                org.threeten.bp.temporal.ChronoUnit[] r0 = org.threeten.bp.temporal.ChronoUnit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f63311a = r0
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.NANOS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f63311a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.MICROS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f63311a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.MILLIS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f63311a     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.SECONDS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.Duration.AnonymousClass1.<clinit>():void");
        }
    }

    private Duration(long j11, int i11) {
        this.seconds = j11;
        this.nanos = i11;
    }

    public static Duration a(DataInput dataInput) throws IOException {
        return ofSeconds(dataInput.readLong(), (long) dataInput.readInt());
    }

    public static Duration between(Temporal temporal, Temporal temporal2) {
        ChronoUnit chronoUnit = ChronoUnit.SECONDS;
        long until = temporal.until(temporal2, chronoUnit);
        ChronoField chronoField = ChronoField.NANO_OF_SECOND;
        long j11 = 0;
        if (temporal.isSupported(chronoField) && temporal2.isSupported(chronoField)) {
            try {
                long j12 = temporal.getLong(chronoField);
                long j13 = temporal2.getLong(chronoField) - j12;
                int i11 = (until > 0 ? 1 : (until == 0 ? 0 : -1));
                if (i11 > 0 && j13 < 0) {
                    j13 += C.NANOS_PER_SECOND;
                } else if (i11 < 0 && j13 > 0) {
                    j13 -= C.NANOS_PER_SECOND;
                } else if (i11 == 0 && j13 != 0) {
                    try {
                        until = temporal.until(temporal2.with(chronoField, j12), chronoUnit);
                    } catch (ArithmeticException | DateTimeException unused) {
                    }
                }
                j11 = j13;
            } catch (ArithmeticException | DateTimeException unused2) {
            }
        }
        return ofSeconds(until, j11);
    }

    private static Duration create(boolean z11, long j11, long j12, long j13, long j14, int i11) {
        long safeAdd = Jdk8Methods.safeAdd(j11, Jdk8Methods.safeAdd(j12, Jdk8Methods.safeAdd(j13, j14)));
        if (z11) {
            return ofSeconds(safeAdd, (long) i11).negated();
        }
        return ofSeconds(safeAdd, (long) i11);
    }

    public static Duration from(TemporalAmount temporalAmount) {
        Jdk8Methods.requireNonNull(temporalAmount, "amount");
        Duration duration = ZERO;
        for (TemporalUnit next : temporalAmount.getUnits()) {
            duration = duration.plus(temporalAmount.get(next), next);
        }
        return duration;
    }

    public static Duration of(long j11, TemporalUnit temporalUnit) {
        return ZERO.plus(j11, temporalUnit);
    }

    public static Duration ofDays(long j11) {
        return create(Jdk8Methods.safeMultiply(j11, (int) RemoteMessageConst.DEFAULT_TTL), 0);
    }

    public static Duration ofHours(long j11) {
        return create(Jdk8Methods.safeMultiply(j11, 3600), 0);
    }

    public static Duration ofMillis(long j11) {
        long j12 = j11 / 1000;
        int i11 = (int) (j11 % 1000);
        if (i11 < 0) {
            i11 += 1000;
            j12--;
        }
        return create(j12, i11 * 1000000);
    }

    public static Duration ofMinutes(long j11) {
        return create(Jdk8Methods.safeMultiply(j11, 60), 0);
    }

    public static Duration ofNanos(long j11) {
        long j12 = j11 / C.NANOS_PER_SECOND;
        int i11 = (int) (j11 % C.NANOS_PER_SECOND);
        if (i11 < 0) {
            i11 += 1000000000;
            j12--;
        }
        return create(j12, i11);
    }

    public static Duration ofSeconds(long j11) {
        return create(j11, 0);
    }

    public static Duration parse(CharSequence charSequence) {
        boolean z11;
        CharSequence charSequence2 = charSequence;
        Jdk8Methods.requireNonNull(charSequence2, "text");
        Matcher matcher = PATTERN.matcher(charSequence2);
        if (matcher.matches() && !"T".equals(matcher.group(3))) {
            int i11 = 1;
            boolean equals = SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE.equals(matcher.group(1));
            String group = matcher.group(2);
            String group2 = matcher.group(4);
            String group3 = matcher.group(5);
            String group4 = matcher.group(6);
            String group5 = matcher.group(7);
            if (!(group == null && group2 == null && group3 == null && group4 == null)) {
                long parseNumber = parseNumber(charSequence2, group, RemoteMessageConst.DEFAULT_TTL, "days");
                long parseNumber2 = parseNumber(charSequence2, group2, 3600, "hours");
                long parseNumber3 = parseNumber(charSequence2, group3, 60, "minutes");
                long parseNumber4 = parseNumber(charSequence2, group4, 1, "seconds");
                if (group4 == null || group4.charAt(0) != '-') {
                    z11 = false;
                } else {
                    z11 = true;
                }
                if (z11) {
                    i11 = -1;
                }
                try {
                    return create(equals, parseNumber, parseNumber2, parseNumber3, parseNumber4, parseFraction(charSequence2, group5, i11));
                } catch (ArithmeticException e11) {
                    throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Duration: overflow", charSequence2, 0).initCause(e11));
                }
            }
        }
        throw new DateTimeParseException("Text cannot be parsed to a Duration", charSequence2, 0);
    }

    private static int parseFraction(CharSequence charSequence, String str, int i11) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        try {
            return Integer.parseInt((str + "000000000").substring(0, 9)) * i11;
        } catch (NumberFormatException e11) {
            throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Duration: fraction", charSequence, 0).initCause(e11));
        } catch (ArithmeticException e12) {
            throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Duration: fraction", charSequence, 0).initCause(e12));
        }
    }

    private static long parseNumber(CharSequence charSequence, String str, int i11, String str2) {
        if (str == null) {
            return 0;
        }
        try {
            if (str.startsWith("+")) {
                str = str.substring(1);
            }
            return Jdk8Methods.safeMultiply(Long.parseLong(str), i11);
        } catch (NumberFormatException e11) {
            throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Duration: " + str2, charSequence, 0).initCause(e11));
        } catch (ArithmeticException e12) {
            throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Duration: " + str2, charSequence, 0).initCause(e12));
        }
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private BigDecimal toSeconds() {
        return BigDecimal.valueOf(this.seconds).add(BigDecimal.valueOf((long) this.nanos, 9));
    }

    private Object writeReplace() {
        return new Ser((byte) 1, this);
    }

    public Duration abs() {
        return isNegative() ? negated() : this;
    }

    public Temporal addTo(Temporal temporal) {
        long j11 = this.seconds;
        if (j11 != 0) {
            temporal = temporal.plus(j11, ChronoUnit.SECONDS);
        }
        int i11 = this.nanos;
        if (i11 != 0) {
            return temporal.plus((long) i11, ChronoUnit.NANOS);
        }
        return temporal;
    }

    public void b(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(this.seconds);
        dataOutput.writeInt(this.nanos);
    }

    public Duration dividedBy(long j11) {
        if (j11 == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        } else if (j11 == 1) {
            return this;
        } else {
            return create(toSeconds().divide(BigDecimal.valueOf(j11), RoundingMode.DOWN));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Duration)) {
            return false;
        }
        Duration duration = (Duration) obj;
        if (this.seconds == duration.seconds && this.nanos == duration.nanos) {
            return true;
        }
        return false;
    }

    public long get(TemporalUnit temporalUnit) {
        if (temporalUnit == ChronoUnit.SECONDS) {
            return this.seconds;
        }
        if (temporalUnit == ChronoUnit.NANOS) {
            return (long) this.nanos;
        }
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
    }

    public int getNano() {
        return this.nanos;
    }

    public long getSeconds() {
        return this.seconds;
    }

    public List<TemporalUnit> getUnits() {
        return Collections.unmodifiableList(Arrays.asList(new ChronoUnit[]{ChronoUnit.SECONDS, ChronoUnit.NANOS}));
    }

    public int hashCode() {
        long j11 = this.seconds;
        return ((int) (j11 ^ (j11 >>> 32))) + (this.nanos * 51);
    }

    public boolean isNegative() {
        return this.seconds < 0;
    }

    public boolean isZero() {
        return (this.seconds | ((long) this.nanos)) == 0;
    }

    public Duration minus(Duration duration) {
        long seconds2 = duration.getSeconds();
        int nano = duration.getNano();
        if (seconds2 == Long.MIN_VALUE) {
            return plus(Long.MAX_VALUE, (long) (-nano)).plus(1, 0);
        }
        return plus(-seconds2, (long) (-nano));
    }

    public Duration minusDays(long j11) {
        return j11 == Long.MIN_VALUE ? plusDays(Long.MAX_VALUE).plusDays(1) : plusDays(-j11);
    }

    public Duration minusHours(long j11) {
        return j11 == Long.MIN_VALUE ? plusHours(Long.MAX_VALUE).plusHours(1) : plusHours(-j11);
    }

    public Duration minusMillis(long j11) {
        return j11 == Long.MIN_VALUE ? plusMillis(Long.MAX_VALUE).plusMillis(1) : plusMillis(-j11);
    }

    public Duration minusMinutes(long j11) {
        return j11 == Long.MIN_VALUE ? plusMinutes(Long.MAX_VALUE).plusMinutes(1) : plusMinutes(-j11);
    }

    public Duration minusNanos(long j11) {
        return j11 == Long.MIN_VALUE ? plusNanos(Long.MAX_VALUE).plusNanos(1) : plusNanos(-j11);
    }

    public Duration minusSeconds(long j11) {
        return j11 == Long.MIN_VALUE ? plusSeconds(Long.MAX_VALUE).plusSeconds(1) : plusSeconds(-j11);
    }

    public Duration multipliedBy(long j11) {
        if (j11 == 0) {
            return ZERO;
        }
        if (j11 == 1) {
            return this;
        }
        return create(toSeconds().multiply(BigDecimal.valueOf(j11)));
    }

    public Duration negated() {
        return multipliedBy(-1);
    }

    public Duration plus(Duration duration) {
        return plus(duration.getSeconds(), (long) duration.getNano());
    }

    public Duration plusDays(long j11) {
        return plus(Jdk8Methods.safeMultiply(j11, (int) RemoteMessageConst.DEFAULT_TTL), 0);
    }

    public Duration plusHours(long j11) {
        return plus(Jdk8Methods.safeMultiply(j11, 3600), 0);
    }

    public Duration plusMillis(long j11) {
        return plus(j11 / 1000, (j11 % 1000) * 1000000);
    }

    public Duration plusMinutes(long j11) {
        return plus(Jdk8Methods.safeMultiply(j11, 60), 0);
    }

    public Duration plusNanos(long j11) {
        return plus(0, j11);
    }

    public Duration plusSeconds(long j11) {
        return plus(j11, 0);
    }

    public Temporal subtractFrom(Temporal temporal) {
        long j11 = this.seconds;
        if (j11 != 0) {
            temporal = temporal.minus(j11, ChronoUnit.SECONDS);
        }
        int i11 = this.nanos;
        if (i11 != 0) {
            return temporal.minus((long) i11, ChronoUnit.NANOS);
        }
        return temporal;
    }

    public long toDays() {
        return this.seconds / 86400;
    }

    public long toDaysPart() {
        return this.seconds / 86400;
    }

    public long toHours() {
        return this.seconds / 3600;
    }

    public int toHoursPart() {
        return (int) (toHours() % 24);
    }

    public long toMillis() {
        return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(this.seconds, 1000), (long) (this.nanos / 1000000));
    }

    public int toMillisPart() {
        return this.nanos / 1000000;
    }

    public long toMinutes() {
        return this.seconds / 60;
    }

    public int toMinutesPart() {
        return (int) (toMinutes() % 60);
    }

    public long toNanos() {
        return Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(this.seconds, 1000000000), (long) this.nanos);
    }

    public int toNanosPart() {
        return this.nanos;
    }

    public int toSecondsPart() {
        return (int) (this.seconds % 60);
    }

    public String toString() {
        if (this == ZERO) {
            return "PT0S";
        }
        long j11 = this.seconds;
        long j12 = j11 / 3600;
        int i11 = (int) ((j11 % 3600) / 60);
        int i12 = (int) (j11 % 60);
        StringBuilder sb2 = new StringBuilder(24);
        sb2.append("PT");
        if (j12 != 0) {
            sb2.append(j12);
            sb2.append('H');
        }
        if (i11 != 0) {
            sb2.append(i11);
            sb2.append('M');
        }
        if (i12 == 0 && this.nanos == 0 && sb2.length() > 2) {
            return sb2.toString();
        }
        if (i12 >= 0 || this.nanos <= 0) {
            sb2.append(i12);
        } else if (i12 == -1) {
            sb2.append("-0");
        } else {
            sb2.append(i12 + 1);
        }
        if (this.nanos > 0) {
            int length = sb2.length();
            if (i12 < 0) {
                sb2.append(2000000000 - this.nanos);
            } else {
                sb2.append(this.nanos + 1000000000);
            }
            while (sb2.charAt(sb2.length() - 1) == '0') {
                sb2.setLength(sb2.length() - 1);
            }
            sb2.setCharAt(length, '.');
        }
        sb2.append('S');
        return sb2.toString();
    }

    public Duration withNanos(int i11) {
        ChronoField.NANO_OF_SECOND.checkValidIntValue((long) i11);
        return create(this.seconds, i11);
    }

    public Duration withSeconds(long j11) {
        return create(j11, this.nanos);
    }

    public static Duration ofSeconds(long j11, long j12) {
        return create(Jdk8Methods.safeAdd(j11, Jdk8Methods.floorDiv(j12, (long) C.NANOS_PER_SECOND)), Jdk8Methods.floorMod(j12, 1000000000));
    }

    public int compareTo(Duration duration) {
        int compareLongs = Jdk8Methods.compareLongs(this.seconds, duration.seconds);
        if (compareLongs != 0) {
            return compareLongs;
        }
        return this.nanos - duration.nanos;
    }

    public Duration plus(long j11, TemporalUnit temporalUnit) {
        Jdk8Methods.requireNonNull(temporalUnit, "unit");
        if (temporalUnit == ChronoUnit.DAYS) {
            return plus(Jdk8Methods.safeMultiply(j11, (int) RemoteMessageConst.DEFAULT_TTL), 0);
        }
        if (temporalUnit.isDurationEstimated()) {
            throw new DateTimeException("Unit must not have an estimated duration");
        } else if (j11 == 0) {
            return this;
        } else {
            if (temporalUnit instanceof ChronoUnit) {
                int i11 = AnonymousClass1.f63311a[((ChronoUnit) temporalUnit).ordinal()];
                if (i11 == 1) {
                    return plusNanos(j11);
                }
                if (i11 == 2) {
                    return plusSeconds((j11 / C.NANOS_PER_SECOND) * 1000).plusNanos((j11 % C.NANOS_PER_SECOND) * 1000);
                }
                if (i11 == 3) {
                    return plusMillis(j11);
                }
                if (i11 != 4) {
                    return plusSeconds(Jdk8Methods.safeMultiply(temporalUnit.getDuration().seconds, j11));
                }
                return plusSeconds(j11);
            }
            Duration multipliedBy = temporalUnit.getDuration().multipliedBy(j11);
            return plusSeconds(multipliedBy.getSeconds()).plusNanos((long) multipliedBy.getNano());
        }
    }

    private static Duration create(long j11, int i11) {
        if ((((long) i11) | j11) == 0) {
            return ZERO;
        }
        return new Duration(j11, i11);
    }

    public Duration minus(long j11, TemporalUnit temporalUnit) {
        return j11 == Long.MIN_VALUE ? plus(Long.MAX_VALUE, temporalUnit).plus(1, temporalUnit) : plus(-j11, temporalUnit);
    }

    private static Duration create(BigDecimal bigDecimal) {
        BigInteger bigIntegerExact = bigDecimal.movePointRight(9).toBigIntegerExact();
        BigInteger[] divideAndRemainder = bigIntegerExact.divideAndRemainder(BI_NANOS_PER_SECOND);
        if (divideAndRemainder[0].bitLength() <= 63) {
            return ofSeconds(divideAndRemainder[0].longValue(), (long) divideAndRemainder[1].intValue());
        }
        throw new ArithmeticException("Exceeds capacity of Duration: " + bigIntegerExact);
    }

    private Duration plus(long j11, long j12) {
        if ((j11 | j12) == 0) {
            return this;
        }
        return ofSeconds(Jdk8Methods.safeAdd(Jdk8Methods.safeAdd(this.seconds, j11), j12 / C.NANOS_PER_SECOND), ((long) this.nanos) + (j12 % C.NANOS_PER_SECOND));
    }
}
