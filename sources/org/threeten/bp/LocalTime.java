package org.threeten.bp;

import com.facebook.internal.security.CertificateUtil;
import com.google.android.exoplayer2.C;
import com.google.common.base.Ascii;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.threeten.bp.format.DateTimeFormatter;
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

public final class LocalTime extends DefaultInterfaceTemporalAccessor implements Temporal, TemporalAdjuster, Comparable<LocalTime>, Serializable {
    public static final TemporalQuery<LocalTime> FROM = new TemporalQuery<LocalTime>() {
        public LocalTime queryFrom(TemporalAccessor temporalAccessor) {
            return LocalTime.from(temporalAccessor);
        }
    };
    private static final LocalTime[] HOURS = new LocalTime[24];
    public static final LocalTime MAX = new LocalTime(23, 59, 59, Year.MAX_VALUE);
    public static final LocalTime MIDNIGHT;
    public static final LocalTime MIN;
    public static final LocalTime NOON;
    private static final long serialVersionUID = 6414437269572265201L;
    private final byte hour;
    private final byte minute;
    private final int nano;
    private final byte second;

    /* renamed from: org.threeten.bp.LocalTime$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f63317a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f63318b;

        /* JADX WARNING: Can't wrap try/catch for region: R(46:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|(2:17|18)|19|21|22|23|(2:25|26)|27|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|(3:57|58|60)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(50:0|(2:1|2)|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|21|22|23|(2:25|26)|27|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|60) */
        /* JADX WARNING: Can't wrap try/catch for region: R(52:0|1|2|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|21|22|23|25|26|27|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|60) */
        /* JADX WARNING: Can't wrap try/catch for region: R(53:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|60) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0065 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x006f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0079 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0083 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x008d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x0097 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00a1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00ad */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00b9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00c5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00d1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00dd */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00e9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00f5 */
        static {
            /*
                org.threeten.bp.temporal.ChronoUnit[] r0 = org.threeten.bp.temporal.ChronoUnit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f63318b = r0
                r1 = 1
                org.threeten.bp.temporal.ChronoUnit r2 = org.threeten.bp.temporal.ChronoUnit.NANOS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f63318b     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.temporal.ChronoUnit r3 = org.threeten.bp.temporal.ChronoUnit.MICROS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f63318b     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.threeten.bp.temporal.ChronoUnit r4 = org.threeten.bp.temporal.ChronoUnit.MILLIS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f63318b     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.threeten.bp.temporal.ChronoUnit r5 = org.threeten.bp.temporal.ChronoUnit.SECONDS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = f63318b     // Catch:{ NoSuchFieldError -> 0x003e }
                org.threeten.bp.temporal.ChronoUnit r6 = org.threeten.bp.temporal.ChronoUnit.MINUTES     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                r5 = 6
                int[] r6 = f63318b     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.threeten.bp.temporal.ChronoUnit r7 = org.threeten.bp.temporal.ChronoUnit.HOURS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                r6 = 7
                int[] r7 = f63318b     // Catch:{ NoSuchFieldError -> 0x0054 }
                org.threeten.bp.temporal.ChronoUnit r8 = org.threeten.bp.temporal.ChronoUnit.HALF_DAYS     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r7[r8] = r6     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                org.threeten.bp.temporal.ChronoField[] r7 = org.threeten.bp.temporal.ChronoField.values()
                int r7 = r7.length
                int[] r7 = new int[r7]
                f63317a = r7
                org.threeten.bp.temporal.ChronoField r8 = org.threeten.bp.temporal.ChronoField.NANO_OF_SECOND     // Catch:{ NoSuchFieldError -> 0x0065 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0065 }
                r7[r8] = r1     // Catch:{ NoSuchFieldError -> 0x0065 }
            L_0x0065:
                int[] r1 = f63317a     // Catch:{ NoSuchFieldError -> 0x006f }
                org.threeten.bp.temporal.ChronoField r7 = org.threeten.bp.temporal.ChronoField.NANO_OF_DAY     // Catch:{ NoSuchFieldError -> 0x006f }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x006f }
                r1[r7] = r0     // Catch:{ NoSuchFieldError -> 0x006f }
            L_0x006f:
                int[] r0 = f63317a     // Catch:{ NoSuchFieldError -> 0x0079 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.MICRO_OF_SECOND     // Catch:{ NoSuchFieldError -> 0x0079 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0079 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0079 }
            L_0x0079:
                int[] r0 = f63317a     // Catch:{ NoSuchFieldError -> 0x0083 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.MICRO_OF_DAY     // Catch:{ NoSuchFieldError -> 0x0083 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0083 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0083 }
            L_0x0083:
                int[] r0 = f63317a     // Catch:{ NoSuchFieldError -> 0x008d }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.MILLI_OF_SECOND     // Catch:{ NoSuchFieldError -> 0x008d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008d }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x008d }
            L_0x008d:
                int[] r0 = f63317a     // Catch:{ NoSuchFieldError -> 0x0097 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.MILLI_OF_DAY     // Catch:{ NoSuchFieldError -> 0x0097 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0097 }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x0097 }
            L_0x0097:
                int[] r0 = f63317a     // Catch:{ NoSuchFieldError -> 0x00a1 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.SECOND_OF_MINUTE     // Catch:{ NoSuchFieldError -> 0x00a1 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a1 }
                r0[r1] = r6     // Catch:{ NoSuchFieldError -> 0x00a1 }
            L_0x00a1:
                int[] r0 = f63317a     // Catch:{ NoSuchFieldError -> 0x00ad }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.SECOND_OF_DAY     // Catch:{ NoSuchFieldError -> 0x00ad }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ad }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00ad }
            L_0x00ad:
                int[] r0 = f63317a     // Catch:{ NoSuchFieldError -> 0x00b9 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.MINUTE_OF_HOUR     // Catch:{ NoSuchFieldError -> 0x00b9 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b9 }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b9 }
            L_0x00b9:
                int[] r0 = f63317a     // Catch:{ NoSuchFieldError -> 0x00c5 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.MINUTE_OF_DAY     // Catch:{ NoSuchFieldError -> 0x00c5 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c5 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c5 }
            L_0x00c5:
                int[] r0 = f63317a     // Catch:{ NoSuchFieldError -> 0x00d1 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.HOUR_OF_AMPM     // Catch:{ NoSuchFieldError -> 0x00d1 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d1 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d1 }
            L_0x00d1:
                int[] r0 = f63317a     // Catch:{ NoSuchFieldError -> 0x00dd }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.CLOCK_HOUR_OF_AMPM     // Catch:{ NoSuchFieldError -> 0x00dd }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00dd }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00dd }
            L_0x00dd:
                int[] r0 = f63317a     // Catch:{ NoSuchFieldError -> 0x00e9 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.HOUR_OF_DAY     // Catch:{ NoSuchFieldError -> 0x00e9 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e9 }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e9 }
            L_0x00e9:
                int[] r0 = f63317a     // Catch:{ NoSuchFieldError -> 0x00f5 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.CLOCK_HOUR_OF_DAY     // Catch:{ NoSuchFieldError -> 0x00f5 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f5 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f5 }
            L_0x00f5:
                int[] r0 = f63317a     // Catch:{ NoSuchFieldError -> 0x0101 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.AMPM_OF_DAY     // Catch:{ NoSuchFieldError -> 0x0101 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0101 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0101 }
            L_0x0101:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.LocalTime.AnonymousClass2.<clinit>():void");
        }
    }

    static {
        int i11 = 0;
        while (true) {
            LocalTime[] localTimeArr = HOURS;
            if (i11 < localTimeArr.length) {
                localTimeArr[i11] = new LocalTime(i11, 0, 0, 0);
                i11++;
            } else {
                LocalTime localTime = localTimeArr[0];
                MIDNIGHT = localTime;
                NOON = localTimeArr[12];
                MIN = localTime;
                return;
            }
        }
    }

    private LocalTime(int i11, int i12, int i13, int i14) {
        this.hour = (byte) i11;
        this.minute = (byte) i12;
        this.second = (byte) i13;
        this.nano = i14;
    }

    public static LocalTime a(long j11, int i11) {
        ChronoField.SECOND_OF_DAY.checkValidValue(j11);
        ChronoField.NANO_OF_SECOND.checkValidValue((long) i11);
        int i12 = (int) (j11 / 3600);
        long j12 = j11 - ((long) (i12 * 3600));
        int i13 = (int) (j12 / 60);
        return create(i12, i13, (int) (j12 - ((long) (i13 * 60))), i11);
    }

    public static LocalTime b(DataInput dataInput) throws IOException {
        int i11;
        int i12;
        int readByte = dataInput.readByte();
        int i13 = 0;
        if (readByte < 0) {
            readByte = ~readByte;
            i11 = 0;
            i12 = 0;
        } else {
            byte readByte2 = dataInput.readByte();
            if (readByte2 < 0) {
                int i14 = ~readByte2;
                i12 = 0;
                i13 = i14;
                i11 = 0;
            } else {
                byte readByte3 = dataInput.readByte();
                if (readByte3 < 0) {
                    i11 = ~readByte3;
                } else {
                    i13 = dataInput.readInt();
                    i11 = readByte3;
                }
                byte b11 = readByte2;
                i12 = i13;
                i13 = b11;
            }
        }
        return of(readByte, i13, i11, i12);
    }

    private static LocalTime create(int i11, int i12, int i13, int i14) {
        if ((i12 | i13 | i14) == 0) {
            return HOURS[i11];
        }
        return new LocalTime(i11, i12, i13, i14);
    }

    public static LocalTime from(TemporalAccessor temporalAccessor) {
        LocalTime localTime = (LocalTime) temporalAccessor.query(TemporalQueries.localTime());
        if (localTime != null) {
            return localTime;
        }
        throw new DateTimeException("Unable to obtain LocalTime from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
    }

    private int get0(TemporalField temporalField) {
        switch (AnonymousClass2.f63317a[((ChronoField) temporalField).ordinal()]) {
            case 1:
                return this.nano;
            case 2:
                throw new DateTimeException("Field too large for an int: " + temporalField);
            case 3:
                return this.nano / 1000;
            case 4:
                throw new DateTimeException("Field too large for an int: " + temporalField);
            case 5:
                return this.nano / 1000000;
            case 6:
                return (int) (toNanoOfDay() / 1000000);
            case 7:
                return this.second;
            case 8:
                return toSecondOfDay();
            case 9:
                return this.minute;
            case 10:
                return (this.hour * 60) + this.minute;
            case 11:
                return this.hour % 12;
            case 12:
                int i11 = this.hour % 12;
                if (i11 % 12 == 0) {
                    return 12;
                }
                return i11;
            case 13:
                return this.hour;
            case 14:
                byte b11 = this.hour;
                if (b11 == 0) {
                    return 24;
                }
                return b11;
            case 15:
                return this.hour / 12;
            default:
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
    }

    public static LocalTime now() {
        return now(Clock.systemDefaultZone());
    }

    public static LocalTime of(int i11, int i12) {
        ChronoField.HOUR_OF_DAY.checkValidValue((long) i11);
        if (i12 == 0) {
            return HOURS[i11];
        }
        ChronoField.MINUTE_OF_HOUR.checkValidValue((long) i12);
        return new LocalTime(i11, i12, 0, 0);
    }

    public static LocalTime ofNanoOfDay(long j11) {
        ChronoField.NANO_OF_DAY.checkValidValue(j11);
        int i11 = (int) (j11 / 3600000000000L);
        long j12 = j11 - (((long) i11) * 3600000000000L);
        int i12 = (int) (j12 / 60000000000L);
        long j13 = j12 - (((long) i12) * 60000000000L);
        int i13 = (int) (j13 / C.NANOS_PER_SECOND);
        return create(i11, i12, i13, (int) (j13 - (((long) i13) * C.NANOS_PER_SECOND)));
    }

    public static LocalTime ofSecondOfDay(long j11) {
        ChronoField.SECOND_OF_DAY.checkValidValue(j11);
        int i11 = (int) (j11 / 3600);
        long j12 = j11 - ((long) (i11 * 3600));
        int i12 = (int) (j12 / 60);
        return create(i11, i12, (int) (j12 - ((long) (i12 * 60))), 0);
    }

    public static LocalTime parse(CharSequence charSequence) {
        return parse(charSequence, DateTimeFormatter.ISO_LOCAL_TIME);
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 5, this);
    }

    public Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.NANO_OF_DAY, toNanoOfDay());
    }

    public LocalDateTime atDate(LocalDate localDate) {
        return LocalDateTime.of(localDate, this);
    }

    public OffsetTime atOffset(ZoneOffset zoneOffset) {
        return OffsetTime.of(this, zoneOffset);
    }

    public void c(DataOutput dataOutput) throws IOException {
        if (this.nano != 0) {
            dataOutput.writeByte(this.hour);
            dataOutput.writeByte(this.minute);
            dataOutput.writeByte(this.second);
            dataOutput.writeInt(this.nano);
        } else if (this.second != 0) {
            dataOutput.writeByte(this.hour);
            dataOutput.writeByte(this.minute);
            dataOutput.writeByte(~this.second);
        } else if (this.minute == 0) {
            dataOutput.writeByte(~this.hour);
        } else {
            dataOutput.writeByte(this.hour);
            dataOutput.writeByte(~this.minute);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalTime)) {
            return false;
        }
        LocalTime localTime = (LocalTime) obj;
        if (this.hour == localTime.hour && this.minute == localTime.minute && this.second == localTime.second && this.nano == localTime.nano) {
            return true;
        }
        return false;
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.format(this);
    }

    public int get(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return get0(temporalField);
        }
        return super.get(temporalField);
    }

    public int getHour() {
        return this.hour;
    }

    public long getLong(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        if (temporalField == ChronoField.NANO_OF_DAY) {
            return toNanoOfDay();
        }
        if (temporalField == ChronoField.MICRO_OF_DAY) {
            return toNanoOfDay() / 1000;
        }
        return (long) get0(temporalField);
    }

    public int getMinute() {
        return this.minute;
    }

    public int getNano() {
        return this.nano;
    }

    public int getSecond() {
        return this.second;
    }

    public int hashCode() {
        long nanoOfDay = toNanoOfDay();
        return (int) (nanoOfDay ^ (nanoOfDay >>> 32));
    }

    public boolean isAfter(LocalTime localTime) {
        return compareTo(localTime) > 0;
    }

    public boolean isBefore(LocalTime localTime) {
        return compareTo(localTime) < 0;
    }

    public boolean isSupported(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return temporalField.isTimeBased();
        }
        return temporalField != null && temporalField.isSupportedBy(this);
    }

    public LocalTime minusHours(long j11) {
        return plusHours(-(j11 % 24));
    }

    public LocalTime minusMinutes(long j11) {
        return plusMinutes(-(j11 % 1440));
    }

    public LocalTime minusNanos(long j11) {
        return plusNanos(-(j11 % 86400000000000L));
    }

    public LocalTime minusSeconds(long j11) {
        return plusSeconds(-(j11 % 86400));
    }

    public LocalTime plusHours(long j11) {
        if (j11 == 0) {
            return this;
        }
        return create(((((int) (j11 % 24)) + this.hour) + 24) % 24, this.minute, this.second, this.nano);
    }

    public LocalTime plusMinutes(long j11) {
        if (j11 == 0) {
            return this;
        }
        int i11 = (this.hour * 60) + this.minute;
        int i12 = ((((int) (j11 % 1440)) + i11) + 1440) % 1440;
        if (i11 == i12) {
            return this;
        }
        return create(i12 / 60, i12 % 60, this.second, this.nano);
    }

    public LocalTime plusNanos(long j11) {
        if (j11 == 0) {
            return this;
        }
        long nanoOfDay = toNanoOfDay();
        long j12 = (((j11 % 86400000000000L) + nanoOfDay) + 86400000000000L) % 86400000000000L;
        if (nanoOfDay == j12) {
            return this;
        }
        return create((int) (j12 / 3600000000000L), (int) ((j12 / 60000000000L) % 60), (int) ((j12 / C.NANOS_PER_SECOND) % 60), (int) (j12 % C.NANOS_PER_SECOND));
    }

    public LocalTime plusSeconds(long j11) {
        if (j11 == 0) {
            return this;
        }
        int i11 = (this.hour * Ascii.DLE) + (this.minute * 60) + this.second;
        int i12 = ((((int) (j11 % 86400)) + i11) + RemoteMessageConst.DEFAULT_TTL) % RemoteMessageConst.DEFAULT_TTL;
        if (i11 == i12) {
            return this;
        }
        return create(i12 / 3600, (i12 / 60) % 60, i12 % 60, this.nano);
    }

    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.precision()) {
            return ChronoUnit.NANOS;
        }
        if (temporalQuery == TemporalQueries.localTime()) {
            return this;
        }
        if (temporalQuery == TemporalQueries.chronology() || temporalQuery == TemporalQueries.zoneId() || temporalQuery == TemporalQueries.zone() || temporalQuery == TemporalQueries.offset() || temporalQuery == TemporalQueries.localDate()) {
            return null;
        }
        return temporalQuery.queryFrom(this);
    }

    public ValueRange range(TemporalField temporalField) {
        return super.range(temporalField);
    }

    public long toNanoOfDay() {
        return (((long) this.hour) * 3600000000000L) + (((long) this.minute) * 60000000000L) + (((long) this.second) * C.NANOS_PER_SECOND) + ((long) this.nano);
    }

    public int toSecondOfDay() {
        return (this.hour * Ascii.DLE) + (this.minute * 60) + this.second;
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder(18);
        byte b11 = this.hour;
        byte b12 = this.minute;
        byte b13 = this.second;
        int i11 = this.nano;
        if (b11 < 10) {
            str = "0";
        } else {
            str = "";
        }
        sb2.append(str);
        sb2.append(b11);
        String str2 = ":0";
        sb2.append(b12 < 10 ? str2 : CertificateUtil.DELIMITER);
        sb2.append(b12);
        if (b13 > 0 || i11 > 0) {
            if (b13 >= 10) {
                str2 = CertificateUtil.DELIMITER;
            }
            sb2.append(str2);
            sb2.append(b13);
            if (i11 > 0) {
                sb2.append('.');
                if (i11 % 1000000 == 0) {
                    sb2.append(Integer.toString((i11 / 1000000) + 1000).substring(1));
                } else if (i11 % 1000 == 0) {
                    sb2.append(Integer.toString((i11 / 1000) + 1000000).substring(1));
                } else {
                    sb2.append(Integer.toString(i11 + 1000000000).substring(1));
                }
            }
        }
        return sb2.toString();
    }

    public LocalTime truncatedTo(TemporalUnit temporalUnit) {
        if (temporalUnit == ChronoUnit.NANOS) {
            return this;
        }
        Duration duration = temporalUnit.getDuration();
        if (duration.getSeconds() <= 86400) {
            long nanos = duration.toNanos();
            if (86400000000000L % nanos == 0) {
                return ofNanoOfDay((toNanoOfDay() / nanos) * nanos);
            }
            throw new DateTimeException("Unit must divide into a standard day without remainder");
        }
        throw new DateTimeException("Unit is too large to be used for truncation");
    }

    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        LocalTime from = from(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.between(this, from);
        }
        long nanoOfDay = from.toNanoOfDay() - toNanoOfDay();
        switch (AnonymousClass2.f63318b[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return nanoOfDay;
            case 2:
                return nanoOfDay / 1000;
            case 3:
                return nanoOfDay / 1000000;
            case 4:
                return nanoOfDay / C.NANOS_PER_SECOND;
            case 5:
                return nanoOfDay / 60000000000L;
            case 6:
                return nanoOfDay / 3600000000000L;
            case 7:
                return nanoOfDay / 43200000000000L;
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    public LocalTime withHour(int i11) {
        if (this.hour == i11) {
            return this;
        }
        ChronoField.HOUR_OF_DAY.checkValidValue((long) i11);
        return create(i11, this.minute, this.second, this.nano);
    }

    public LocalTime withMinute(int i11) {
        if (this.minute == i11) {
            return this;
        }
        ChronoField.MINUTE_OF_HOUR.checkValidValue((long) i11);
        return create(this.hour, i11, this.second, this.nano);
    }

    public LocalTime withNano(int i11) {
        if (this.nano == i11) {
            return this;
        }
        ChronoField.NANO_OF_SECOND.checkValidValue((long) i11);
        return create(this.hour, this.minute, this.second, i11);
    }

    public LocalTime withSecond(int i11) {
        if (this.second == i11) {
            return this;
        }
        ChronoField.SECOND_OF_MINUTE.checkValidValue((long) i11);
        return create(this.hour, this.minute, i11, this.nano);
    }

    public static LocalTime now(ZoneId zoneId) {
        return now(Clock.system(zoneId));
    }

    public static LocalTime parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.requireNonNull(dateTimeFormatter, "formatter");
        return (LocalTime) dateTimeFormatter.parse(charSequence, FROM);
    }

    public int compareTo(LocalTime localTime) {
        int compareInts = Jdk8Methods.compareInts(this.hour, localTime.hour);
        if (compareInts != 0) {
            return compareInts;
        }
        int compareInts2 = Jdk8Methods.compareInts(this.minute, localTime.minute);
        if (compareInts2 != 0) {
            return compareInts2;
        }
        int compareInts3 = Jdk8Methods.compareInts(this.second, localTime.second);
        return compareInts3 == 0 ? Jdk8Methods.compareInts(this.nano, localTime.nano) : compareInts3;
    }

    public static LocalTime now(Clock clock) {
        Jdk8Methods.requireNonNull(clock, "clock");
        Instant instant = clock.instant();
        long epochSecond = ((instant.getEpochSecond() % 86400) + ((long) clock.getZone().getRules().getOffset(instant).getTotalSeconds())) % 86400;
        if (epochSecond < 0) {
            epochSecond += 86400;
        }
        return a(epochSecond, instant.getNano());
    }

    public LocalTime minus(TemporalAmount temporalAmount) {
        return (LocalTime) temporalAmount.subtractFrom(this);
    }

    public LocalTime plus(TemporalAmount temporalAmount) {
        return (LocalTime) temporalAmount.addTo(this);
    }

    public LocalTime with(TemporalAdjuster temporalAdjuster) {
        if (temporalAdjuster instanceof LocalTime) {
            return (LocalTime) temporalAdjuster;
        }
        return (LocalTime) temporalAdjuster.adjustInto(this);
    }

    public boolean isSupported(TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            return temporalUnit.isTimeBased();
        }
        return temporalUnit != null && temporalUnit.isSupportedBy(this);
    }

    public LocalTime minus(long j11, TemporalUnit temporalUnit) {
        return j11 == Long.MIN_VALUE ? plus(Long.MAX_VALUE, temporalUnit).plus(1, temporalUnit) : plus(-j11, temporalUnit);
    }

    public LocalTime plus(long j11, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (LocalTime) temporalUnit.addTo(this, j11);
        }
        switch (AnonymousClass2.f63318b[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return plusNanos(j11);
            case 2:
                return plusNanos((j11 % 86400000000L) * 1000);
            case 3:
                return plusNanos((j11 % 86400000) * 1000000);
            case 4:
                return plusSeconds(j11);
            case 5:
                return plusMinutes(j11);
            case 6:
                return plusHours(j11);
            case 7:
                return plusHours((j11 % 2) * 12);
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    public static LocalTime of(int i11, int i12, int i13) {
        ChronoField.HOUR_OF_DAY.checkValidValue((long) i11);
        if ((i12 | i13) == 0) {
            return HOURS[i11];
        }
        ChronoField.MINUTE_OF_HOUR.checkValidValue((long) i12);
        ChronoField.SECOND_OF_MINUTE.checkValidValue((long) i13);
        return new LocalTime(i11, i12, i13, 0);
    }

    public LocalTime with(TemporalField temporalField, long j11) {
        if (!(temporalField instanceof ChronoField)) {
            return (LocalTime) temporalField.adjustInto(this, j11);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        chronoField.checkValidValue(j11);
        switch (AnonymousClass2.f63317a[chronoField.ordinal()]) {
            case 1:
                return withNano((int) j11);
            case 2:
                return ofNanoOfDay(j11);
            case 3:
                return withNano(((int) j11) * 1000);
            case 4:
                return ofNanoOfDay(j11 * 1000);
            case 5:
                return withNano(((int) j11) * 1000000);
            case 6:
                return ofNanoOfDay(j11 * 1000000);
            case 7:
                return withSecond((int) j11);
            case 8:
                return plusSeconds(j11 - ((long) toSecondOfDay()));
            case 9:
                return withMinute((int) j11);
            case 10:
                return plusMinutes(j11 - ((long) ((this.hour * 60) + this.minute)));
            case 11:
                return plusHours(j11 - ((long) (this.hour % 12)));
            case 12:
                if (j11 == 12) {
                    j11 = 0;
                }
                return plusHours(j11 - ((long) (this.hour % 12)));
            case 13:
                return withHour((int) j11);
            case 14:
                if (j11 == 24) {
                    j11 = 0;
                }
                return withHour((int) j11);
            case 15:
                return plusHours((j11 - ((long) (this.hour / 12))) * 12);
            default:
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
    }

    public static LocalTime of(int i11, int i12, int i13, int i14) {
        ChronoField.HOUR_OF_DAY.checkValidValue((long) i11);
        ChronoField.MINUTE_OF_HOUR.checkValidValue((long) i12);
        ChronoField.SECOND_OF_MINUTE.checkValidValue((long) i13);
        ChronoField.NANO_OF_SECOND.checkValidValue((long) i14);
        return create(i11, i12, i13, i14);
    }
}
