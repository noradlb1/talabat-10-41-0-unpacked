package org.threeten.bp;

import com.google.android.exoplayer2.C;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import com.talabat.talabatcommon.views.wallet.subscription.model.WalletSubscriptionMapperKt;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.SignStyle;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
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
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

public final class YearMonth extends DefaultInterfaceTemporalAccessor implements Temporal, TemporalAdjuster, Comparable<YearMonth>, Serializable {
    public static final TemporalQuery<YearMonth> FROM = new TemporalQuery<YearMonth>() {
        public YearMonth queryFrom(TemporalAccessor temporalAccessor) {
            return YearMonth.from(temporalAccessor);
        }
    };
    private static final DateTimeFormatter PARSER = new DateTimeFormatterBuilder().appendValue(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD).appendLiteral((char) SignatureVisitor.SUPER).appendValue(ChronoField.MONTH_OF_YEAR, 2).toFormatter();
    private static final long serialVersionUID = 4183400860270640070L;
    private final int month;
    private final int year;

    /* renamed from: org.threeten.bp.YearMonth$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f63325a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f63326b;

        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|(2:19|20)|21|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(25:0|1|2|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0078 */
        static {
            /*
                org.threeten.bp.temporal.ChronoUnit[] r0 = org.threeten.bp.temporal.ChronoUnit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f63326b = r0
                r1 = 1
                org.threeten.bp.temporal.ChronoUnit r2 = org.threeten.bp.temporal.ChronoUnit.MONTHS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f63326b     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.temporal.ChronoUnit r3 = org.threeten.bp.temporal.ChronoUnit.YEARS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f63326b     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.threeten.bp.temporal.ChronoUnit r4 = org.threeten.bp.temporal.ChronoUnit.DECADES     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f63326b     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.threeten.bp.temporal.ChronoUnit r5 = org.threeten.bp.temporal.ChronoUnit.CENTURIES     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = f63326b     // Catch:{ NoSuchFieldError -> 0x003e }
                org.threeten.bp.temporal.ChronoUnit r6 = org.threeten.bp.temporal.ChronoUnit.MILLENNIA     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r5 = f63326b     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.threeten.bp.temporal.ChronoUnit r6 = org.threeten.bp.temporal.ChronoUnit.ERAS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r7 = 6
                r5[r6] = r7     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                org.threeten.bp.temporal.ChronoField[] r5 = org.threeten.bp.temporal.ChronoField.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                f63325a = r5
                org.threeten.bp.temporal.ChronoField r6 = org.threeten.bp.temporal.ChronoField.MONTH_OF_YEAR     // Catch:{ NoSuchFieldError -> 0x005a }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r5[r6] = r1     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                int[] r1 = f63325a     // Catch:{ NoSuchFieldError -> 0x0064 }
                org.threeten.bp.temporal.ChronoField r5 = org.threeten.bp.temporal.ChronoField.PROLEPTIC_MONTH     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r1[r5] = r0     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                int[] r0 = f63325a     // Catch:{ NoSuchFieldError -> 0x006e }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.YEAR_OF_ERA     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                int[] r0 = f63325a     // Catch:{ NoSuchFieldError -> 0x0078 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.YEAR     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f63325a     // Catch:{ NoSuchFieldError -> 0x0082 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ERA     // Catch:{ NoSuchFieldError -> 0x0082 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0082 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.YearMonth.AnonymousClass2.<clinit>():void");
        }
    }

    private YearMonth(int i11, int i12) {
        this.year = i11;
        this.month = i12;
    }

    public static YearMonth a(DataInput dataInput) throws IOException {
        return of(dataInput.readInt(), (int) dataInput.readByte());
    }

    public static YearMonth from(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof YearMonth) {
            return (YearMonth) temporalAccessor;
        }
        try {
            if (!IsoChronology.INSTANCE.equals(Chronology.from(temporalAccessor))) {
                temporalAccessor = LocalDate.from(temporalAccessor);
            }
            return of(temporalAccessor.get(ChronoField.YEAR), temporalAccessor.get(ChronoField.MONTH_OF_YEAR));
        } catch (DateTimeException unused) {
            throw new DateTimeException("Unable to obtain YearMonth from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
        }
    }

    private long getProlepticMonth() {
        return (((long) this.year) * 12) + ((long) (this.month - 1));
    }

    public static YearMonth now() {
        return now(Clock.systemDefaultZone());
    }

    public static YearMonth of(int i11, Month month2) {
        Jdk8Methods.requireNonNull(month2, "month");
        return of(i11, month2.getValue());
    }

    public static YearMonth parse(CharSequence charSequence) {
        return parse(charSequence, PARSER);
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 68, this);
    }

    public Temporal adjustInto(Temporal temporal) {
        if (Chronology.from(temporal).equals(IsoChronology.INSTANCE)) {
            return temporal.with(ChronoField.PROLEPTIC_MONTH, getProlepticMonth());
        }
        throw new DateTimeException("Adjustment only supported on ISO date-time");
    }

    public LocalDate atDay(int i11) {
        return LocalDate.of(this.year, this.month, i11);
    }

    public LocalDate atEndOfMonth() {
        return LocalDate.of(this.year, this.month, lengthOfMonth());
    }

    public void b(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.year);
        dataOutput.writeByte(this.month);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof YearMonth)) {
            return false;
        }
        YearMonth yearMonth = (YearMonth) obj;
        if (this.year == yearMonth.year && this.month == yearMonth.month) {
            return true;
        }
        return false;
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.format(this);
    }

    public int get(TemporalField temporalField) {
        return range(temporalField).checkValidIntValue(getLong(temporalField), temporalField);
    }

    public long getLong(TemporalField temporalField) {
        int i11;
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        int i12 = AnonymousClass2.f63325a[((ChronoField) temporalField).ordinal()];
        int i13 = 1;
        if (i12 == 1) {
            i11 = this.month;
        } else if (i12 == 2) {
            return getProlepticMonth();
        } else {
            if (i12 == 3) {
                int i14 = this.year;
                if (i14 < 1) {
                    i14 = 1 - i14;
                }
                return (long) i14;
            } else if (i12 == 4) {
                i11 = this.year;
            } else if (i12 == 5) {
                if (this.year < 1) {
                    i13 = 0;
                }
                return (long) i13;
            } else {
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
            }
        }
        return (long) i11;
    }

    public Month getMonth() {
        return Month.of(this.month);
    }

    public int getMonthValue() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public int hashCode() {
        return this.year ^ (this.month << 27);
    }

    public boolean isAfter(YearMonth yearMonth) {
        return compareTo(yearMonth) > 0;
    }

    public boolean isBefore(YearMonth yearMonth) {
        return compareTo(yearMonth) < 0;
    }

    public boolean isLeapYear() {
        return IsoChronology.INSTANCE.isLeapYear((long) this.year);
    }

    public boolean isSupported(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            if (temporalField == ChronoField.YEAR || temporalField == ChronoField.MONTH_OF_YEAR || temporalField == ChronoField.PROLEPTIC_MONTH || temporalField == ChronoField.YEAR_OF_ERA || temporalField == ChronoField.ERA) {
                return true;
            }
            return false;
        } else if (temporalField == null || !temporalField.isSupportedBy(this)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isValidDay(int i11) {
        return i11 >= 1 && i11 <= lengthOfMonth();
    }

    public int lengthOfMonth() {
        return getMonth().length(isLeapYear());
    }

    public int lengthOfYear() {
        if (isLeapYear()) {
            return 366;
        }
        return WalletSubscriptionMapperKt.DAYS_IN_A_YEAR;
    }

    public YearMonth minusMonths(long j11) {
        return j11 == Long.MIN_VALUE ? plusMonths(Long.MAX_VALUE).plusMonths(1) : plusMonths(-j11);
    }

    public YearMonth minusYears(long j11) {
        return j11 == Long.MIN_VALUE ? plusYears(Long.MAX_VALUE).plusYears(1) : plusYears(-j11);
    }

    public YearMonth plusMonths(long j11) {
        if (j11 == 0) {
            return this;
        }
        long j12 = (((long) this.year) * 12) + ((long) (this.month - 1)) + j11;
        return with(ChronoField.YEAR.checkValidIntValue(Jdk8Methods.floorDiv(j12, 12)), Jdk8Methods.floorMod(j12, 12) + 1);
    }

    public YearMonth plusYears(long j11) {
        if (j11 == 0) {
            return this;
        }
        return with(ChronoField.YEAR.checkValidIntValue(((long) this.year) + j11), this.month);
    }

    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.chronology()) {
            return IsoChronology.INSTANCE;
        }
        if (temporalQuery == TemporalQueries.precision()) {
            return ChronoUnit.MONTHS;
        }
        if (temporalQuery == TemporalQueries.localDate() || temporalQuery == TemporalQueries.localTime() || temporalQuery == TemporalQueries.zone() || temporalQuery == TemporalQueries.zoneId() || temporalQuery == TemporalQueries.offset()) {
            return null;
        }
        return super.query(temporalQuery);
    }

    public ValueRange range(TemporalField temporalField) {
        long j11;
        if (temporalField != ChronoField.YEAR_OF_ERA) {
            return super.range(temporalField);
        }
        if (getYear() <= 0) {
            j11 = C.NANOS_PER_SECOND;
        } else {
            j11 = 999999999;
        }
        return ValueRange.of(1, j11);
    }

    public String toString() {
        String str;
        int abs = Math.abs(this.year);
        StringBuilder sb2 = new StringBuilder(9);
        if (abs < 1000) {
            int i11 = this.year;
            if (i11 < 0) {
                sb2.append(i11 - 10000);
                sb2.deleteCharAt(1);
            } else {
                sb2.append(i11 + 10000);
                sb2.deleteCharAt(0);
            }
        } else {
            sb2.append(this.year);
        }
        if (this.month < 10) {
            str = "-0";
        } else {
            str = SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE;
        }
        sb2.append(str);
        sb2.append(this.month);
        return sb2.toString();
    }

    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        YearMonth from = from(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.between(this, from);
        }
        long prolepticMonth = from.getProlepticMonth() - getProlepticMonth();
        switch (AnonymousClass2.f63326b[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return prolepticMonth;
            case 2:
                return prolepticMonth / 12;
            case 3:
                return prolepticMonth / 120;
            case 4:
                return prolepticMonth / 1200;
            case 5:
                return prolepticMonth / 12000;
            case 6:
                ChronoField chronoField = ChronoField.ERA;
                return from.getLong(chronoField) - getLong(chronoField);
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    public YearMonth withMonth(int i11) {
        ChronoField.MONTH_OF_YEAR.checkValidValue((long) i11);
        return with(this.year, i11);
    }

    public YearMonth withYear(int i11) {
        ChronoField.YEAR.checkValidValue((long) i11);
        return with(i11, this.month);
    }

    public static YearMonth now(ZoneId zoneId) {
        return now(Clock.system(zoneId));
    }

    public static YearMonth parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.requireNonNull(dateTimeFormatter, "formatter");
        return (YearMonth) dateTimeFormatter.parse(charSequence, FROM);
    }

    public int compareTo(YearMonth yearMonth) {
        int i11 = this.year - yearMonth.year;
        return i11 == 0 ? this.month - yearMonth.month : i11;
    }

    public static YearMonth now(Clock clock) {
        LocalDate now = LocalDate.now(clock);
        return of(now.getYear(), now.getMonth());
    }

    public static YearMonth of(int i11, int i12) {
        ChronoField.YEAR.checkValidValue((long) i11);
        ChronoField.MONTH_OF_YEAR.checkValidValue((long) i12);
        return new YearMonth(i11, i12);
    }

    private YearMonth with(int i11, int i12) {
        if (this.year == i11 && this.month == i12) {
            return this;
        }
        return new YearMonth(i11, i12);
    }

    public YearMonth minus(TemporalAmount temporalAmount) {
        return (YearMonth) temporalAmount.subtractFrom(this);
    }

    public YearMonth plus(TemporalAmount temporalAmount) {
        return (YearMonth) temporalAmount.addTo(this);
    }

    public boolean isSupported(TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            if (temporalUnit == ChronoUnit.MONTHS || temporalUnit == ChronoUnit.YEARS || temporalUnit == ChronoUnit.DECADES || temporalUnit == ChronoUnit.CENTURIES || temporalUnit == ChronoUnit.MILLENNIA || temporalUnit == ChronoUnit.ERAS) {
                return true;
            }
            return false;
        } else if (temporalUnit == null || !temporalUnit.isSupportedBy(this)) {
            return false;
        } else {
            return true;
        }
    }

    public YearMonth minus(long j11, TemporalUnit temporalUnit) {
        return j11 == Long.MIN_VALUE ? plus(Long.MAX_VALUE, temporalUnit).plus(1, temporalUnit) : plus(-j11, temporalUnit);
    }

    public YearMonth plus(long j11, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (YearMonth) temporalUnit.addTo(this, j11);
        }
        switch (AnonymousClass2.f63326b[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return plusMonths(j11);
            case 2:
                return plusYears(j11);
            case 3:
                return plusYears(Jdk8Methods.safeMultiply(j11, 10));
            case 4:
                return plusYears(Jdk8Methods.safeMultiply(j11, 100));
            case 5:
                return plusYears(Jdk8Methods.safeMultiply(j11, 1000));
            case 6:
                ChronoField chronoField = ChronoField.ERA;
                return with((TemporalField) chronoField, Jdk8Methods.safeAdd(getLong(chronoField), j11));
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    public YearMonth with(TemporalAdjuster temporalAdjuster) {
        return (YearMonth) temporalAdjuster.adjustInto(this);
    }

    public YearMonth with(TemporalField temporalField, long j11) {
        if (!(temporalField instanceof ChronoField)) {
            return (YearMonth) temporalField.adjustInto(this, j11);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        chronoField.checkValidValue(j11);
        int i11 = AnonymousClass2.f63325a[chronoField.ordinal()];
        if (i11 == 1) {
            return withMonth((int) j11);
        }
        if (i11 == 2) {
            return plusMonths(j11 - getLong(ChronoField.PROLEPTIC_MONTH));
        }
        if (i11 == 3) {
            if (this.year < 1) {
                j11 = 1 - j11;
            }
            return withYear((int) j11);
        } else if (i11 == 4) {
            return withYear((int) j11);
        } else {
            if (i11 == 5) {
                return getLong(ChronoField.ERA) == j11 ? this : withYear(1 - this.year);
            }
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
    }
}
