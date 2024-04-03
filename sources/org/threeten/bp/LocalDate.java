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
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.Era;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatter;
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
import org.threeten.bp.zone.ZoneOffsetTransition;

public final class LocalDate extends ChronoLocalDate implements Serializable {
    private static final int DAYS_PER_CYCLE = 146097;
    public static final TemporalQuery<LocalDate> FROM = new TemporalQuery<LocalDate>() {
        public LocalDate queryFrom(TemporalAccessor temporalAccessor) {
            return LocalDate.from(temporalAccessor);
        }
    };
    public static final LocalDate MAX = of((int) Year.MAX_VALUE, 12, 31);
    public static final LocalDate MIN = of((int) Year.MIN_VALUE, 1, 1);
    private static final long serialVersionUID = 2942565459149668126L;
    private final short day;
    private final short month;
    private final int year;

    /* renamed from: org.threeten.bp.LocalDate$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f63314a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f63315b;

        /* JADX WARNING: Can't wrap try/catch for region: R(46:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|(2:17|18)|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|60) */
        /* JADX WARNING: Can't wrap try/catch for region: R(49:0|(2:1|2)|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|21|22|23|(2:25|26)|27|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|60) */
        /* JADX WARNING: Can't wrap try/catch for region: R(52:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|60) */
        /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0071 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x007b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0085 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x008f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x0099 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00a3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00ad */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00b7 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00c3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00cf */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00db */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00e7 */
        static {
            /*
                org.threeten.bp.temporal.ChronoUnit[] r0 = org.threeten.bp.temporal.ChronoUnit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f63315b = r0
                r1 = 1
                org.threeten.bp.temporal.ChronoUnit r2 = org.threeten.bp.temporal.ChronoUnit.DAYS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f63315b     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.temporal.ChronoUnit r3 = org.threeten.bp.temporal.ChronoUnit.WEEKS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f63315b     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.threeten.bp.temporal.ChronoUnit r4 = org.threeten.bp.temporal.ChronoUnit.MONTHS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f63315b     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.threeten.bp.temporal.ChronoUnit r5 = org.threeten.bp.temporal.ChronoUnit.YEARS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = f63315b     // Catch:{ NoSuchFieldError -> 0x003e }
                org.threeten.bp.temporal.ChronoUnit r6 = org.threeten.bp.temporal.ChronoUnit.DECADES     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                r5 = 6
                int[] r6 = f63315b     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.threeten.bp.temporal.ChronoUnit r7 = org.threeten.bp.temporal.ChronoUnit.CENTURIES     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                r6 = 7
                int[] r7 = f63315b     // Catch:{ NoSuchFieldError -> 0x0054 }
                org.threeten.bp.temporal.ChronoUnit r8 = org.threeten.bp.temporal.ChronoUnit.MILLENNIA     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r7[r8] = r6     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                r7 = 8
                int[] r8 = f63315b     // Catch:{ NoSuchFieldError -> 0x0060 }
                org.threeten.bp.temporal.ChronoUnit r9 = org.threeten.bp.temporal.ChronoUnit.ERAS     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r8[r9] = r7     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                org.threeten.bp.temporal.ChronoField[] r8 = org.threeten.bp.temporal.ChronoField.values()
                int r8 = r8.length
                int[] r8 = new int[r8]
                f63314a = r8
                org.threeten.bp.temporal.ChronoField r9 = org.threeten.bp.temporal.ChronoField.DAY_OF_MONTH     // Catch:{ NoSuchFieldError -> 0x0071 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x0071 }
                r8[r9] = r1     // Catch:{ NoSuchFieldError -> 0x0071 }
            L_0x0071:
                int[] r1 = f63314a     // Catch:{ NoSuchFieldError -> 0x007b }
                org.threeten.bp.temporal.ChronoField r8 = org.threeten.bp.temporal.ChronoField.DAY_OF_YEAR     // Catch:{ NoSuchFieldError -> 0x007b }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x007b }
                r1[r8] = r0     // Catch:{ NoSuchFieldError -> 0x007b }
            L_0x007b:
                int[] r0 = f63314a     // Catch:{ NoSuchFieldError -> 0x0085 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ALIGNED_WEEK_OF_MONTH     // Catch:{ NoSuchFieldError -> 0x0085 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0085 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0085 }
            L_0x0085:
                int[] r0 = f63314a     // Catch:{ NoSuchFieldError -> 0x008f }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.YEAR_OF_ERA     // Catch:{ NoSuchFieldError -> 0x008f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008f }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x008f }
            L_0x008f:
                int[] r0 = f63314a     // Catch:{ NoSuchFieldError -> 0x0099 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.DAY_OF_WEEK     // Catch:{ NoSuchFieldError -> 0x0099 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0099 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0099 }
            L_0x0099:
                int[] r0 = f63314a     // Catch:{ NoSuchFieldError -> 0x00a3 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH     // Catch:{ NoSuchFieldError -> 0x00a3 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a3 }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x00a3 }
            L_0x00a3:
                int[] r0 = f63314a     // Catch:{ NoSuchFieldError -> 0x00ad }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR     // Catch:{ NoSuchFieldError -> 0x00ad }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ad }
                r0[r1] = r6     // Catch:{ NoSuchFieldError -> 0x00ad }
            L_0x00ad:
                int[] r0 = f63314a     // Catch:{ NoSuchFieldError -> 0x00b7 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.EPOCH_DAY     // Catch:{ NoSuchFieldError -> 0x00b7 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b7 }
                r0[r1] = r7     // Catch:{ NoSuchFieldError -> 0x00b7 }
            L_0x00b7:
                int[] r0 = f63314a     // Catch:{ NoSuchFieldError -> 0x00c3 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ALIGNED_WEEK_OF_YEAR     // Catch:{ NoSuchFieldError -> 0x00c3 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c3 }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c3 }
            L_0x00c3:
                int[] r0 = f63314a     // Catch:{ NoSuchFieldError -> 0x00cf }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.MONTH_OF_YEAR     // Catch:{ NoSuchFieldError -> 0x00cf }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cf }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cf }
            L_0x00cf:
                int[] r0 = f63314a     // Catch:{ NoSuchFieldError -> 0x00db }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.PROLEPTIC_MONTH     // Catch:{ NoSuchFieldError -> 0x00db }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00db }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00db }
            L_0x00db:
                int[] r0 = f63314a     // Catch:{ NoSuchFieldError -> 0x00e7 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.YEAR     // Catch:{ NoSuchFieldError -> 0x00e7 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e7 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e7 }
            L_0x00e7:
                int[] r0 = f63314a     // Catch:{ NoSuchFieldError -> 0x00f3 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.ERA     // Catch:{ NoSuchFieldError -> 0x00f3 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f3 }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f3 }
            L_0x00f3:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.LocalDate.AnonymousClass2.<clinit>():void");
        }
    }

    private LocalDate(int i11, int i12, int i13) {
        this.year = i11;
        this.month = (short) i12;
        this.day = (short) i13;
    }

    public static LocalDate c(DataInput dataInput) throws IOException {
        return of(dataInput.readInt(), (int) dataInput.readByte(), (int) dataInput.readByte());
    }

    private static LocalDate create(int i11, Month month2, int i12) {
        if (i12 <= 28 || i12 <= month2.length(IsoChronology.INSTANCE.isLeapYear((long) i11))) {
            return new LocalDate(i11, month2.getValue(), i12);
        }
        if (i12 == 29) {
            throw new DateTimeException("Invalid date 'February 29' as '" + i11 + "' is not a leap year");
        }
        throw new DateTimeException("Invalid date '" + month2.name() + " " + i12 + "'");
    }

    public static LocalDate from(TemporalAccessor temporalAccessor) {
        LocalDate localDate = (LocalDate) temporalAccessor.query(TemporalQueries.localDate());
        if (localDate != null) {
            return localDate;
        }
        throw new DateTimeException("Unable to obtain LocalDate from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
    }

    private int get0(TemporalField temporalField) {
        switch (AnonymousClass2.f63314a[((ChronoField) temporalField).ordinal()]) {
            case 1:
                return this.day;
            case 2:
                return getDayOfYear();
            case 3:
                return ((this.day - 1) / 7) + 1;
            case 4:
                int i11 = this.year;
                if (i11 >= 1) {
                    return i11;
                }
                return 1 - i11;
            case 5:
                return getDayOfWeek().getValue();
            case 6:
                return ((this.day - 1) % 7) + 1;
            case 7:
                return ((getDayOfYear() - 1) % 7) + 1;
            case 8:
                throw new DateTimeException("Field too large for an int: " + temporalField);
            case 9:
                return ((getDayOfYear() - 1) / 7) + 1;
            case 10:
                return this.month;
            case 11:
                throw new DateTimeException("Field too large for an int: " + temporalField);
            case 12:
                return this.year;
            case 13:
                if (this.year >= 1) {
                    return 1;
                }
                return 0;
            default:
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
    }

    private long getProlepticMonth() {
        return (((long) this.year) * 12) + ((long) (this.month - 1));
    }

    private long monthsUntil(LocalDate localDate) {
        return (((localDate.getProlepticMonth() * 32) + ((long) localDate.getDayOfMonth())) - ((getProlepticMonth() * 32) + ((long) getDayOfMonth()))) / 32;
    }

    public static LocalDate now() {
        return now(Clock.systemDefaultZone());
    }

    public static LocalDate of(int i11, Month month2, int i12) {
        ChronoField.YEAR.checkValidValue((long) i11);
        Jdk8Methods.requireNonNull(month2, "month");
        ChronoField.DAY_OF_MONTH.checkValidValue((long) i12);
        return create(i11, month2, i12);
    }

    public static LocalDate ofEpochDay(long j11) {
        long j12;
        long j13 = j11;
        ChronoField.EPOCH_DAY.checkValidValue(j13);
        long j14 = (j13 + 719528) - 60;
        if (j14 < 0) {
            long j15 = ((j14 + 1) / 146097) - 1;
            j12 = j15 * 400;
            j14 += (-j15) * 146097;
        } else {
            j12 = 0;
        }
        long j16 = ((j14 * 400) + 591) / 146097;
        long j17 = j14 - ((((j16 * 365) + (j16 / 4)) - (j16 / 100)) + (j16 / 400));
        if (j17 < 0) {
            j16--;
            j17 = j14 - ((((365 * j16) + (j16 / 4)) - (j16 / 100)) + (j16 / 400));
        }
        int i11 = (int) j17;
        int i12 = ((i11 * 5) + 2) / Opcodes.IFEQ;
        return new LocalDate(ChronoField.YEAR.checkValidIntValue(j16 + j12 + ((long) (i12 / 10))), ((i12 + 2) % 12) + 1, (i11 - (((i12 * 306) + 5) / 10)) + 1);
    }

    public static LocalDate ofYearDay(int i11, int i12) {
        long j11 = (long) i11;
        ChronoField.YEAR.checkValidValue(j11);
        ChronoField.DAY_OF_YEAR.checkValidValue((long) i12);
        boolean isLeapYear = IsoChronology.INSTANCE.isLeapYear(j11);
        if (i12 != 366 || isLeapYear) {
            Month of2 = Month.of(((i12 - 1) / 31) + 1);
            if (i12 > (of2.firstDayOfYear(isLeapYear) + of2.length(isLeapYear)) - 1) {
                of2 = of2.plus(1);
            }
            return create(i11, of2, (i12 - of2.firstDayOfYear(isLeapYear)) + 1);
        }
        throw new DateTimeException("Invalid date 'DayOfYear 366' as '" + i11 + "' is not a leap year");
    }

    public static LocalDate parse(CharSequence charSequence) {
        return parse(charSequence, DateTimeFormatter.ISO_LOCAL_DATE);
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private static LocalDate resolvePreviousValid(int i11, int i12, int i13) {
        int i14;
        if (i12 == 2) {
            if (IsoChronology.INSTANCE.isLeapYear((long) i11)) {
                i14 = 29;
            } else {
                i14 = 28;
            }
            i13 = Math.min(i13, i14);
        } else if (i12 == 4 || i12 == 6 || i12 == 9 || i12 == 11) {
            i13 = Math.min(i13, 30);
        }
        return of(i11, i12, i13);
    }

    private Object writeReplace() {
        return new Ser((byte) 3, this);
    }

    public int a(LocalDate localDate) {
        int i11 = this.year - localDate.year;
        if (i11 != 0) {
            return i11;
        }
        int i12 = this.month - localDate.month;
        if (i12 == 0) {
            return this.day - localDate.day;
        }
        return i12;
    }

    public Temporal adjustInto(Temporal temporal) {
        return super.adjustInto(temporal);
    }

    public LocalDateTime atStartOfDay() {
        return LocalDateTime.of(this, LocalTime.MIDNIGHT);
    }

    public long b(LocalDate localDate) {
        return localDate.toEpochDay() - toEpochDay();
    }

    public void d(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.year);
        dataOutput.writeByte(this.month);
        dataOutput.writeByte(this.day);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalDate)) {
            return false;
        }
        if (a((LocalDate) obj) == 0) {
            return true;
        }
        return false;
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        return super.format(dateTimeFormatter);
    }

    public int get(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return get0(temporalField);
        }
        return super.get(temporalField);
    }

    public int getDayOfMonth() {
        return this.day;
    }

    public DayOfWeek getDayOfWeek() {
        return DayOfWeek.of(Jdk8Methods.floorMod(toEpochDay() + 3, 7) + 1);
    }

    public int getDayOfYear() {
        return (getMonth().firstDayOfYear(isLeapYear()) + this.day) - 1;
    }

    public Era getEra() {
        return super.getEra();
    }

    public long getLong(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        if (temporalField == ChronoField.EPOCH_DAY) {
            return toEpochDay();
        }
        if (temporalField == ChronoField.PROLEPTIC_MONTH) {
            return getProlepticMonth();
        }
        return (long) get0(temporalField);
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
        int i11 = this.year;
        return (((i11 << 11) + (this.month << 6)) + this.day) ^ (i11 & -2048);
    }

    public boolean isAfter(ChronoLocalDate chronoLocalDate) {
        if (!(chronoLocalDate instanceof LocalDate)) {
            return super.isAfter(chronoLocalDate);
        }
        if (a((LocalDate) chronoLocalDate) > 0) {
            return true;
        }
        return false;
    }

    public boolean isBefore(ChronoLocalDate chronoLocalDate) {
        if (!(chronoLocalDate instanceof LocalDate)) {
            return super.isBefore(chronoLocalDate);
        }
        if (a((LocalDate) chronoLocalDate) < 0) {
            return true;
        }
        return false;
    }

    public boolean isEqual(ChronoLocalDate chronoLocalDate) {
        if (!(chronoLocalDate instanceof LocalDate)) {
            return super.isEqual(chronoLocalDate);
        }
        if (a((LocalDate) chronoLocalDate) == 0) {
            return true;
        }
        return false;
    }

    public boolean isLeapYear() {
        return IsoChronology.INSTANCE.isLeapYear((long) this.year);
    }

    public boolean isSupported(TemporalField temporalField) {
        return super.isSupported(temporalField);
    }

    public int lengthOfMonth() {
        short s11 = this.month;
        if (s11 != 2) {
            if (s11 == 4 || s11 == 6 || s11 == 9 || s11 == 11) {
                return 30;
            }
            return 31;
        } else if (isLeapYear()) {
            return 29;
        } else {
            return 28;
        }
    }

    public int lengthOfYear() {
        if (isLeapYear()) {
            return 366;
        }
        return WalletSubscriptionMapperKt.DAYS_IN_A_YEAR;
    }

    public LocalDate minusDays(long j11) {
        return j11 == Long.MIN_VALUE ? plusDays(Long.MAX_VALUE).plusDays(1) : plusDays(-j11);
    }

    public LocalDate minusMonths(long j11) {
        return j11 == Long.MIN_VALUE ? plusMonths(Long.MAX_VALUE).plusMonths(1) : plusMonths(-j11);
    }

    public LocalDate minusWeeks(long j11) {
        return j11 == Long.MIN_VALUE ? plusWeeks(Long.MAX_VALUE).plusWeeks(1) : plusWeeks(-j11);
    }

    public LocalDate minusYears(long j11) {
        return j11 == Long.MIN_VALUE ? plusYears(Long.MAX_VALUE).plusYears(1) : plusYears(-j11);
    }

    public LocalDate plusDays(long j11) {
        if (j11 == 0) {
            return this;
        }
        return ofEpochDay(Jdk8Methods.safeAdd(toEpochDay(), j11));
    }

    public LocalDate plusMonths(long j11) {
        if (j11 == 0) {
            return this;
        }
        long j12 = (((long) this.year) * 12) + ((long) (this.month - 1)) + j11;
        return resolvePreviousValid(ChronoField.YEAR.checkValidIntValue(Jdk8Methods.floorDiv(j12, 12)), Jdk8Methods.floorMod(j12, 12) + 1, this.day);
    }

    public LocalDate plusWeeks(long j11) {
        return plusDays(Jdk8Methods.safeMultiply(j11, 7));
    }

    public LocalDate plusYears(long j11) {
        if (j11 == 0) {
            return this;
        }
        return resolvePreviousValid(ChronoField.YEAR.checkValidIntValue(((long) this.year) + j11), this.month, this.day);
    }

    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.localDate()) {
            return this;
        }
        return super.query(temporalQuery);
    }

    public ValueRange range(TemporalField temporalField) {
        long j11;
        long j12;
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.rangeRefinedBy(this);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        if (chronoField.isDateBased()) {
            int i11 = AnonymousClass2.f63314a[chronoField.ordinal()];
            if (i11 == 1) {
                return ValueRange.of(1, (long) lengthOfMonth());
            }
            if (i11 == 2) {
                return ValueRange.of(1, (long) lengthOfYear());
            }
            if (i11 == 3) {
                if (getMonth() != Month.FEBRUARY || isLeapYear()) {
                    j11 = 5;
                } else {
                    j11 = 4;
                }
                return ValueRange.of(1, j11);
            } else if (i11 != 4) {
                return temporalField.range();
            } else {
                if (getYear() <= 0) {
                    j12 = C.NANOS_PER_SECOND;
                } else {
                    j12 = 999999999;
                }
                return ValueRange.of(1, j12);
            }
        } else {
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
    }

    public long toEpochDay() {
        long j11;
        long j12 = (long) this.year;
        long j13 = (long) this.month;
        long j14 = (365 * j12) + 0;
        if (j12 >= 0) {
            j11 = j14 + (((3 + j12) / 4) - ((99 + j12) / 100)) + ((j12 + 399) / 400);
        } else {
            j11 = j14 - (((j12 / -4) - (j12 / -100)) + (j12 / -400));
        }
        long j15 = j11 + (((367 * j13) - 362) / 12) + ((long) (this.day - 1));
        if (j13 > 2) {
            j15--;
            if (!isLeapYear()) {
                j15--;
            }
        }
        return j15 - 719528;
    }

    public String toString() {
        int i11 = this.year;
        short s11 = this.month;
        short s12 = this.day;
        int abs = Math.abs(i11);
        StringBuilder sb2 = new StringBuilder(10);
        if (abs >= 1000) {
            if (i11 > 9999) {
                sb2.append(SignatureVisitor.EXTENDS);
            }
            sb2.append(i11);
        } else if (i11 < 0) {
            sb2.append(i11 - 10000);
            sb2.deleteCharAt(1);
        } else {
            sb2.append(i11 + 10000);
            sb2.deleteCharAt(0);
        }
        String str = "-0";
        sb2.append(s11 < 10 ? str : SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE);
        sb2.append(s11);
        if (s12 >= 10) {
            str = SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE;
        }
        sb2.append(str);
        sb2.append(s12);
        return sb2.toString();
    }

    public LocalDate withDayOfMonth(int i11) {
        if (this.day == i11) {
            return this;
        }
        return of(this.year, (int) this.month, i11);
    }

    public LocalDate withDayOfYear(int i11) {
        if (getDayOfYear() == i11) {
            return this;
        }
        return ofYearDay(this.year, i11);
    }

    public LocalDate withMonth(int i11) {
        if (this.month == i11) {
            return this;
        }
        ChronoField.MONTH_OF_YEAR.checkValidValue((long) i11);
        return resolvePreviousValid(this.year, i11, this.day);
    }

    public LocalDate withYear(int i11) {
        if (this.year == i11) {
            return this;
        }
        ChronoField.YEAR.checkValidValue((long) i11);
        return resolvePreviousValid(i11, this.month, this.day);
    }

    public static LocalDate now(ZoneId zoneId) {
        return now(Clock.system(zoneId));
    }

    public static LocalDate parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.requireNonNull(dateTimeFormatter, "formatter");
        return (LocalDate) dateTimeFormatter.parse(charSequence, FROM);
    }

    public ZonedDateTime atStartOfDay(ZoneId zoneId) {
        ZoneOffsetTransition transition;
        Jdk8Methods.requireNonNull(zoneId, "zone");
        LocalDateTime atTime = atTime(LocalTime.MIDNIGHT);
        if (!(zoneId instanceof ZoneOffset) && (transition = zoneId.getRules().getTransition(atTime)) != null && transition.isGap()) {
            atTime = transition.getDateTimeAfter();
        }
        return ZonedDateTime.of(atTime, zoneId);
    }

    public LocalDateTime atTime(LocalTime localTime) {
        return LocalDateTime.of(this, localTime);
    }

    public int compareTo(ChronoLocalDate chronoLocalDate) {
        if (chronoLocalDate instanceof LocalDate) {
            return a((LocalDate) chronoLocalDate);
        }
        return super.compareTo(chronoLocalDate);
    }

    public IsoChronology getChronology() {
        return IsoChronology.INSTANCE;
    }

    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        LocalDate from = from(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.between(this, from);
        }
        switch (AnonymousClass2.f63315b[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return b(from);
            case 2:
                return b(from) / 7;
            case 3:
                return monthsUntil(from);
            case 4:
                return monthsUntil(from) / 12;
            case 5:
                return monthsUntil(from) / 120;
            case 6:
                return monthsUntil(from) / 1200;
            case 7:
                return monthsUntil(from) / 12000;
            case 8:
                ChronoField chronoField = ChronoField.ERA;
                return from.getLong(chronoField) - getLong(chronoField);
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    public static LocalDate now(Clock clock) {
        Jdk8Methods.requireNonNull(clock, "clock");
        Instant instant = clock.instant();
        return ofEpochDay(Jdk8Methods.floorDiv(instant.getEpochSecond() + ((long) clock.getZone().getRules().getOffset(instant).getTotalSeconds()), 86400));
    }

    public LocalDateTime atTime(int i11, int i12) {
        return atTime(LocalTime.of(i11, i12));
    }

    public LocalDateTime atTime(int i11, int i12, int i13) {
        return atTime(LocalTime.of(i11, i12, i13));
    }

    public static LocalDate of(int i11, int i12, int i13) {
        ChronoField.YEAR.checkValidValue((long) i11);
        ChronoField.MONTH_OF_YEAR.checkValidValue((long) i12);
        ChronoField.DAY_OF_MONTH.checkValidValue((long) i13);
        return create(i11, Month.of(i12), i13);
    }

    public LocalDateTime atTime(int i11, int i12, int i13, int i14) {
        return atTime(LocalTime.of(i11, i12, i13, i14));
    }

    public LocalDate minus(TemporalAmount temporalAmount) {
        return (LocalDate) temporalAmount.subtractFrom(this);
    }

    public LocalDate plus(TemporalAmount temporalAmount) {
        return (LocalDate) temporalAmount.addTo(this);
    }

    public LocalDate with(TemporalAdjuster temporalAdjuster) {
        if (temporalAdjuster instanceof LocalDate) {
            return (LocalDate) temporalAdjuster;
        }
        return (LocalDate) temporalAdjuster.adjustInto(this);
    }

    public OffsetDateTime atTime(OffsetTime offsetTime) {
        return OffsetDateTime.of(LocalDateTime.of(this, offsetTime.toLocalTime()), offsetTime.getOffset());
    }

    public LocalDate minus(long j11, TemporalUnit temporalUnit) {
        return j11 == Long.MIN_VALUE ? plus(Long.MAX_VALUE, temporalUnit).plus(1, temporalUnit) : plus(-j11, temporalUnit);
    }

    public LocalDate plus(long j11, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (LocalDate) temporalUnit.addTo(this, j11);
        }
        switch (AnonymousClass2.f63315b[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return plusDays(j11);
            case 2:
                return plusWeeks(j11);
            case 3:
                return plusMonths(j11);
            case 4:
                return plusYears(j11);
            case 5:
                return plusYears(Jdk8Methods.safeMultiply(j11, 10));
            case 6:
                return plusYears(Jdk8Methods.safeMultiply(j11, 100));
            case 7:
                return plusYears(Jdk8Methods.safeMultiply(j11, 1000));
            case 8:
                ChronoField chronoField = ChronoField.ERA;
                return with((TemporalField) chronoField, Jdk8Methods.safeAdd(getLong(chronoField), j11));
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    public LocalDate with(TemporalField temporalField, long j11) {
        if (!(temporalField instanceof ChronoField)) {
            return (LocalDate) temporalField.adjustInto(this, j11);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        chronoField.checkValidValue(j11);
        switch (AnonymousClass2.f63314a[chronoField.ordinal()]) {
            case 1:
                return withDayOfMonth((int) j11);
            case 2:
                return withDayOfYear((int) j11);
            case 3:
                return plusWeeks(j11 - getLong(ChronoField.ALIGNED_WEEK_OF_MONTH));
            case 4:
                if (this.year < 1) {
                    j11 = 1 - j11;
                }
                return withYear((int) j11);
            case 5:
                return plusDays(j11 - ((long) getDayOfWeek().getValue()));
            case 6:
                return plusDays(j11 - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 7:
                return plusDays(j11 - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 8:
                return ofEpochDay(j11);
            case 9:
                return plusWeeks(j11 - getLong(ChronoField.ALIGNED_WEEK_OF_YEAR));
            case 10:
                return withMonth((int) j11);
            case 11:
                return plusMonths(j11 - getLong(ChronoField.PROLEPTIC_MONTH));
            case 12:
                return withYear((int) j11);
            case 13:
                return getLong(ChronoField.ERA) == j11 ? this : withYear(1 - this.year);
            default:
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
    }

    public Period until(ChronoLocalDate chronoLocalDate) {
        LocalDate from = from(chronoLocalDate);
        long prolepticMonth = from.getProlepticMonth() - getProlepticMonth();
        int i11 = from.day - this.day;
        int i12 = (prolepticMonth > 0 ? 1 : (prolepticMonth == 0 ? 0 : -1));
        if (i12 > 0 && i11 < 0) {
            prolepticMonth--;
            i11 = (int) (from.toEpochDay() - plusMonths(prolepticMonth).toEpochDay());
        } else if (i12 < 0 && i11 > 0) {
            prolepticMonth++;
            i11 -= from.lengthOfMonth();
        }
        return Period.of(Jdk8Methods.safeToInt(prolepticMonth / 12), (int) (prolepticMonth % 12), i11);
    }
}
