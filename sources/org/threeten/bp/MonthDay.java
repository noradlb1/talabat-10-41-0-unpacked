package org.threeten.bp;

import com.google.common.primitives.SignedBytes;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
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
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

public final class MonthDay extends DefaultInterfaceTemporalAccessor implements TemporalAdjuster, Comparable<MonthDay>, Serializable {
    public static final TemporalQuery<MonthDay> FROM = new TemporalQuery<MonthDay>() {
        public MonthDay queryFrom(TemporalAccessor temporalAccessor) {
            return MonthDay.from(temporalAccessor);
        }
    };
    private static final DateTimeFormatter PARSER = new DateTimeFormatterBuilder().appendLiteral("--").appendValue(ChronoField.MONTH_OF_YEAR, 2).appendLiteral((char) SignatureVisitor.SUPER).appendValue(ChronoField.DAY_OF_MONTH, 2).toFormatter();
    private static final long serialVersionUID = -939150713474957432L;
    private final int day;
    private final int month;

    /* renamed from: org.threeten.bp.MonthDay$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f63320a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.threeten.bp.temporal.ChronoField[] r0 = org.threeten.bp.temporal.ChronoField.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f63320a = r0
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.DAY_OF_MONTH     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f63320a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.MONTH_OF_YEAR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.MonthDay.AnonymousClass2.<clinit>():void");
        }
    }

    private MonthDay(int i11, int i12) {
        this.month = i11;
        this.day = i12;
    }

    public static MonthDay a(DataInput dataInput) throws IOException {
        return of((int) dataInput.readByte(), (int) dataInput.readByte());
    }

    public static MonthDay from(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof MonthDay) {
            return (MonthDay) temporalAccessor;
        }
        try {
            if (!IsoChronology.INSTANCE.equals(Chronology.from(temporalAccessor))) {
                temporalAccessor = LocalDate.from(temporalAccessor);
            }
            return of(temporalAccessor.get(ChronoField.MONTH_OF_YEAR), temporalAccessor.get(ChronoField.DAY_OF_MONTH));
        } catch (DateTimeException unused) {
            throw new DateTimeException("Unable to obtain MonthDay from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
        }
    }

    public static MonthDay now() {
        return now(Clock.systemDefaultZone());
    }

    public static MonthDay of(Month month2, int i11) {
        Jdk8Methods.requireNonNull(month2, "month");
        ChronoField.DAY_OF_MONTH.checkValidValue((long) i11);
        if (i11 <= month2.maxLength()) {
            return new MonthDay(month2.getValue(), i11);
        }
        throw new DateTimeException("Illegal value for DayOfMonth field, value " + i11 + " is not valid for month " + month2.name());
    }

    public static MonthDay parse(CharSequence charSequence) {
        return parse(charSequence, PARSER);
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser(SignedBytes.MAX_POWER_OF_TWO, this);
    }

    public Temporal adjustInto(Temporal temporal) {
        if (Chronology.from(temporal).equals(IsoChronology.INSTANCE)) {
            Temporal with = temporal.with(ChronoField.MONTH_OF_YEAR, (long) this.month);
            ChronoField chronoField = ChronoField.DAY_OF_MONTH;
            return with.with(chronoField, Math.min(with.range(chronoField).getMaximum(), (long) this.day));
        }
        throw new DateTimeException("Adjustment only supported on ISO date-time");
    }

    public LocalDate atYear(int i11) {
        return LocalDate.of(i11, this.month, isValidYear(i11) ? this.day : 28);
    }

    public void b(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(this.month);
        dataOutput.writeByte(this.day);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MonthDay)) {
            return false;
        }
        MonthDay monthDay = (MonthDay) obj;
        if (this.month == monthDay.month && this.day == monthDay.day) {
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

    public int getDayOfMonth() {
        return this.day;
    }

    public long getLong(TemporalField temporalField) {
        int i11;
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        int i12 = AnonymousClass2.f63320a[((ChronoField) temporalField).ordinal()];
        if (i12 == 1) {
            i11 = this.day;
        } else if (i12 == 2) {
            i11 = this.month;
        } else {
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
        return (long) i11;
    }

    public Month getMonth() {
        return Month.of(this.month);
    }

    public int getMonthValue() {
        return this.month;
    }

    public int hashCode() {
        return (this.month << 6) + this.day;
    }

    public boolean isAfter(MonthDay monthDay) {
        return compareTo(monthDay) > 0;
    }

    public boolean isBefore(MonthDay monthDay) {
        return compareTo(monthDay) < 0;
    }

    public boolean isSupported(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            if (temporalField == ChronoField.MONTH_OF_YEAR || temporalField == ChronoField.DAY_OF_MONTH) {
                return true;
            }
            return false;
        } else if (temporalField == null || !temporalField.isSupportedBy(this)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isValidYear(int i11) {
        return !(this.day == 29 && this.month == 2 && !Year.isLeap((long) i11));
    }

    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.chronology()) {
            return IsoChronology.INSTANCE;
        }
        return super.query(temporalQuery);
    }

    public ValueRange range(TemporalField temporalField) {
        if (temporalField == ChronoField.MONTH_OF_YEAR) {
            return temporalField.range();
        }
        if (temporalField == ChronoField.DAY_OF_MONTH) {
            return ValueRange.of(1, (long) getMonth().minLength(), (long) getMonth().maxLength());
        }
        return super.range(temporalField);
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder sb2 = new StringBuilder(10);
        sb2.append("--");
        if (this.month < 10) {
            str = "0";
        } else {
            str = "";
        }
        sb2.append(str);
        sb2.append(this.month);
        if (this.day < 10) {
            str2 = "-0";
        } else {
            str2 = SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE;
        }
        sb2.append(str2);
        sb2.append(this.day);
        return sb2.toString();
    }

    public MonthDay with(Month month2) {
        Jdk8Methods.requireNonNull(month2, "month");
        if (month2.getValue() == this.month) {
            return this;
        }
        return new MonthDay(month2.getValue(), Math.min(this.day, month2.maxLength()));
    }

    public MonthDay withDayOfMonth(int i11) {
        if (i11 == this.day) {
            return this;
        }
        return of(this.month, i11);
    }

    public MonthDay withMonth(int i11) {
        return with(Month.of(i11));
    }

    public static MonthDay now(ZoneId zoneId) {
        return now(Clock.system(zoneId));
    }

    public static MonthDay parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.requireNonNull(dateTimeFormatter, "formatter");
        return (MonthDay) dateTimeFormatter.parse(charSequence, FROM);
    }

    public int compareTo(MonthDay monthDay) {
        int i11 = this.month - monthDay.month;
        return i11 == 0 ? this.day - monthDay.day : i11;
    }

    public static MonthDay now(Clock clock) {
        LocalDate now = LocalDate.now(clock);
        return of(now.getMonth(), now.getDayOfMonth());
    }

    public static MonthDay of(int i11, int i12) {
        return of(Month.of(i11), i12);
    }
}
