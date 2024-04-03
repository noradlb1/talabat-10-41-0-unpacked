package org.threeten.bp.format;

import com.facebook.internal.security.CertificateUtil;
import com.huawei.hms.flutter.map.constants.Param;
import com.huawei.hms.framework.common.ExceptionCode;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import j$.util.DesugarTimeZone;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.format.SimpleDateTimeTextProvider;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.IsoFields;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.temporal.WeekFields;
import org.threeten.bp.zone.ZoneRulesProvider;

public final class DateTimeFormatterBuilder {
    private static final Map<Character, TemporalField> FIELD_MAP;
    private static final TemporalQuery<ZoneId> QUERY_REGION_ONLY = new TemporalQuery<ZoneId>() {
        public ZoneId queryFrom(TemporalAccessor temporalAccessor) {
            ZoneId zoneId = (ZoneId) temporalAccessor.query(TemporalQueries.zoneId());
            if (zoneId == null || (zoneId instanceof ZoneOffset)) {
                return null;
            }
            return zoneId;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public static final Comparator<String> f63353a = new Comparator<String>() {
        public int compare(String str, String str2) {
            return str.length() == str2.length() ? str.compareTo(str2) : str.length() - str2.length();
        }
    };
    private DateTimeFormatterBuilder active;
    private final boolean optional;
    private char padNextChar;
    private int padNextWidth;
    private final DateTimeFormatterBuilder parent;
    private final List<DateTimePrinterParser> printerParsers;
    private int valueParserIndex;

    /* renamed from: org.threeten.bp.format.DateTimeFormatterBuilder$4  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f63356a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                org.threeten.bp.format.SignStyle[] r0 = org.threeten.bp.format.SignStyle.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f63356a = r0
                org.threeten.bp.format.SignStyle r1 = org.threeten.bp.format.SignStyle.EXCEEDS_PAD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f63356a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.format.SignStyle r1 = org.threeten.bp.format.SignStyle.ALWAYS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f63356a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.threeten.bp.format.SignStyle r1 = org.threeten.bp.format.SignStyle.NORMAL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f63356a     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.threeten.bp.format.SignStyle r1 = org.threeten.bp.format.SignStyle.NOT_NEGATIVE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.format.DateTimeFormatterBuilder.AnonymousClass4.<clinit>():void");
        }
    }

    public static final class CharLiteralPrinterParser implements DateTimePrinterParser {
        private final char literal;

        public CharLiteralPrinterParser(char c11) {
            this.literal = c11;
        }

        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i11) {
            if (i11 == charSequence.length()) {
                return ~i11;
            }
            if (!dateTimeParseContext.c(this.literal, charSequence.charAt(i11))) {
                return ~i11;
            }
            return i11 + 1;
        }

        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb2) {
            sb2.append(this.literal);
            return true;
        }

        public String toString() {
            if (this.literal == '\'') {
                return "''";
            }
            return "'" + this.literal + "'";
        }
    }

    public static final class ChronoPrinterParser implements DateTimePrinterParser {
        private final TextStyle textStyle;

        public ChronoPrinterParser(TextStyle textStyle2) {
            this.textStyle = textStyle2;
        }

        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i11) {
            if (i11 < 0 || i11 > charSequence.length()) {
                throw new IndexOutOfBoundsException();
            }
            Chronology chronology = null;
            int i12 = -1;
            for (Chronology next : Chronology.getAvailableChronologies()) {
                String id2 = next.getId();
                int length = id2.length();
                if (length > i12 && dateTimeParseContext.t(charSequence, i11, id2, 0, length)) {
                    chronology = next;
                    i12 = length;
                }
            }
            if (chronology == null) {
                return ~i11;
            }
            dateTimeParseContext.o(chronology);
            return i11 + i12;
        }

        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb2) {
            Chronology chronology = (Chronology) dateTimePrintContext.f(TemporalQueries.chronology());
            if (chronology == null) {
                return false;
            }
            if (this.textStyle == null) {
                sb2.append(chronology.getId());
                return true;
            }
            try {
                sb2.append(ResourceBundle.getBundle("org.threeten.bp.format.ChronologyText", dateTimePrintContext.b(), DateTimeFormatterBuilder.class.getClassLoader()).getString(chronology.getId()));
                return true;
            } catch (MissingResourceException unused) {
                sb2.append(chronology.getId());
                return true;
            }
        }
    }

    public static final class CompositePrinterParser implements DateTimePrinterParser {
        private final boolean optional;
        private final DateTimePrinterParser[] printerParsers;

        public CompositePrinterParser(List<DateTimePrinterParser> list, boolean z11) {
            this((DateTimePrinterParser[]) list.toArray(new DateTimePrinterParser[list.size()]), z11);
        }

        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i11) {
            if (this.optional) {
                dateTimeParseContext.s();
                int i12 = i11;
                for (DateTimePrinterParser parse : this.printerParsers) {
                    i12 = parse.parse(dateTimeParseContext, charSequence, i12);
                    if (i12 < 0) {
                        dateTimeParseContext.f(false);
                        return i11;
                    }
                }
                dateTimeParseContext.f(true);
                return i12;
            }
            for (DateTimePrinterParser parse2 : this.printerParsers) {
                i11 = parse2.parse(dateTimeParseContext, charSequence, i11);
                if (i11 < 0) {
                    break;
                }
            }
            return i11;
        }

        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb2) {
            int length = sb2.length();
            if (this.optional) {
                dateTimePrintContext.g();
            }
            try {
                for (DateTimePrinterParser print : this.printerParsers) {
                    if (!print.print(dateTimePrintContext, sb2)) {
                        sb2.setLength(length);
                        return true;
                    }
                }
                if (this.optional) {
                    dateTimePrintContext.a();
                }
                return true;
            } finally {
                if (this.optional) {
                    dateTimePrintContext.a();
                }
            }
        }

        public String toString() {
            String str;
            String str2;
            StringBuilder sb2 = new StringBuilder();
            if (this.printerParsers != null) {
                if (this.optional) {
                    str = "[";
                } else {
                    str = "(";
                }
                sb2.append(str);
                for (DateTimePrinterParser append : this.printerParsers) {
                    sb2.append(append);
                }
                if (this.optional) {
                    str2 = "]";
                } else {
                    str2 = ")";
                }
                sb2.append(str2);
            }
            return sb2.toString();
        }

        public CompositePrinterParser withOptional(boolean z11) {
            if (z11 == this.optional) {
                return this;
            }
            return new CompositePrinterParser(this.printerParsers, z11);
        }

        public CompositePrinterParser(DateTimePrinterParser[] dateTimePrinterParserArr, boolean z11) {
            this.printerParsers = dateTimePrinterParserArr;
            this.optional = z11;
        }
    }

    public interface DateTimePrinterParser {
        int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i11);

        boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb2);
    }

    public static class DefaultingParser implements DateTimePrinterParser {
        private final TemporalField field;
        private final long value;

        public DefaultingParser(TemporalField temporalField, long j11) {
            this.field = temporalField;
            this.value = j11;
        }

        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i11) {
            if (dateTimeParseContext.i(this.field) == null) {
                dateTimeParseContext.p(this.field, this.value, i11, i11);
            }
            return i11;
        }

        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb2) {
            return true;
        }
    }

    public static final class FractionPrinterParser implements DateTimePrinterParser {
        private final boolean decimalPoint;
        private final TemporalField field;
        private final int maxWidth;
        private final int minWidth;

        public FractionPrinterParser(TemporalField temporalField, int i11, int i12, boolean z11) {
            Jdk8Methods.requireNonNull(temporalField, "field");
            if (!temporalField.range().isFixed()) {
                throw new IllegalArgumentException("Field must have a fixed set of values: " + temporalField);
            } else if (i11 < 0 || i11 > 9) {
                throw new IllegalArgumentException("Minimum width must be from 0 to 9 inclusive but was " + i11);
            } else if (i12 < 1 || i12 > 9) {
                throw new IllegalArgumentException("Maximum width must be from 1 to 9 inclusive but was " + i12);
            } else if (i12 >= i11) {
                this.field = temporalField;
                this.minWidth = i11;
                this.maxWidth = i12;
                this.decimalPoint = z11;
            } else {
                throw new IllegalArgumentException("Maximum width must exceed or equal the minimum width but " + i12 + " < " + i11);
            }
        }

        private long convertFromFraction(BigDecimal bigDecimal) {
            ValueRange range = this.field.range();
            BigDecimal valueOf = BigDecimal.valueOf(range.getMinimum());
            return bigDecimal.multiply(BigDecimal.valueOf(range.getMaximum()).subtract(valueOf).add(BigDecimal.ONE)).setScale(0, RoundingMode.FLOOR).add(valueOf).longValueExact();
        }

        private BigDecimal convertToFraction(long j11) {
            ValueRange range = this.field.range();
            range.checkValidValue(j11, this.field);
            BigDecimal valueOf = BigDecimal.valueOf(range.getMinimum());
            BigDecimal divide = BigDecimal.valueOf(j11).subtract(valueOf).divide(BigDecimal.valueOf(range.getMaximum()).subtract(valueOf).add(BigDecimal.ONE), 9, RoundingMode.FLOOR);
            if (divide.compareTo(BigDecimal.ZERO) == 0) {
                return BigDecimal.ZERO;
            }
            return divide.stripTrailingZeros();
        }

        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i11) {
            int i12;
            int i13;
            int i14;
            int i15 = 0;
            if (dateTimeParseContext.l()) {
                i12 = this.minWidth;
            } else {
                i12 = 0;
            }
            if (dateTimeParseContext.l()) {
                i13 = this.maxWidth;
            } else {
                i13 = 9;
            }
            int length = charSequence.length();
            if (i11 != length) {
                if (this.decimalPoint) {
                    if (charSequence.charAt(i11) == dateTimeParseContext.j().getDecimalSeparator()) {
                        i11++;
                    } else if (i12 > 0) {
                        return ~i11;
                    } else {
                        return i11;
                    }
                }
                int i16 = i11;
                int i17 = i12 + i16;
                if (i17 > length) {
                    return ~i16;
                }
                int min = Math.min(i13 + i16, length);
                int i18 = i16;
                while (true) {
                    if (i18 >= min) {
                        i14 = i18;
                        break;
                    }
                    int i19 = i18 + 1;
                    int b11 = dateTimeParseContext.j().b(charSequence.charAt(i18));
                    if (b11 >= 0) {
                        i15 = (i15 * 10) + b11;
                        i18 = i19;
                    } else if (i19 < i17) {
                        return ~i16;
                    } else {
                        i14 = i19 - 1;
                    }
                }
                return dateTimeParseContext.p(this.field, convertFromFraction(new BigDecimal(i15).movePointLeft(i14 - i16)), i16, i14);
            } else if (i12 > 0) {
                return ~i11;
            } else {
                return i11;
            }
        }

        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb2) {
            Long e11 = dateTimePrintContext.e(this.field);
            if (e11 == null) {
                return false;
            }
            DecimalStyle c11 = dateTimePrintContext.c();
            BigDecimal convertToFraction = convertToFraction(e11.longValue());
            if (convertToFraction.scale() != 0) {
                String a11 = c11.a(convertToFraction.setScale(Math.min(Math.max(convertToFraction.scale(), this.minWidth), this.maxWidth), RoundingMode.FLOOR).toPlainString().substring(2));
                if (this.decimalPoint) {
                    sb2.append(c11.getDecimalSeparator());
                }
                sb2.append(a11);
                return true;
            } else if (this.minWidth <= 0) {
                return true;
            } else {
                if (this.decimalPoint) {
                    sb2.append(c11.getDecimalSeparator());
                }
                for (int i11 = 0; i11 < this.minWidth; i11++) {
                    sb2.append(c11.getZeroDigit());
                }
                return true;
            }
        }

        public String toString() {
            String str;
            if (this.decimalPoint) {
                str = ",DecimalPoint";
            } else {
                str = "";
            }
            return "Fraction(" + this.field + "," + this.minWidth + "," + this.maxWidth + str + ")";
        }
    }

    public static final class InstantPrinterParser implements DateTimePrinterParser {
        private static final long SECONDS_0000_TO_1970 = 62167219200L;
        private static final long SECONDS_PER_10000_YEARS = 315569520000L;
        private final int fractionalDigits;

        public InstantPrinterParser(int i11) {
            this.fractionalDigits = i11;
        }

        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i11) {
            int i12;
            int i13;
            int i14;
            int i15;
            int i16;
            int i17 = i11;
            DateTimeParseContext e11 = dateTimeParseContext.e();
            int i18 = this.fractionalDigits;
            int i19 = 0;
            if (i18 < 0) {
                i12 = 0;
            } else {
                i12 = i18;
            }
            if (i18 < 0) {
                i18 = 9;
            }
            DateTimeFormatterBuilder appendLiteral = new DateTimeFormatterBuilder().append(DateTimeFormatter.ISO_LOCAL_DATE).appendLiteral('T');
            ChronoField chronoField = ChronoField.HOUR_OF_DAY;
            DateTimeFormatterBuilder appendLiteral2 = appendLiteral.appendValue(chronoField, 2).appendLiteral((char) AbstractJsonLexerKt.COLON);
            ChronoField chronoField2 = ChronoField.MINUTE_OF_HOUR;
            DateTimeFormatterBuilder appendLiteral3 = appendLiteral2.appendValue(chronoField2, 2).appendLiteral((char) AbstractJsonLexerKt.COLON);
            ChronoField chronoField3 = ChronoField.SECOND_OF_MINUTE;
            DateTimeFormatterBuilder appendValue = appendLiteral3.appendValue(chronoField3, 2);
            ChronoField chronoField4 = ChronoField.NANO_OF_SECOND;
            int parse = appendValue.appendFraction(chronoField4, i12, i18, true).appendLiteral('Z').toFormatter().c(false).parse(e11, charSequence, i17);
            if (parse < 0) {
                return parse;
            }
            long longValue = e11.i(ChronoField.YEAR).longValue();
            int intValue = e11.i(ChronoField.MONTH_OF_YEAR).intValue();
            int intValue2 = e11.i(ChronoField.DAY_OF_MONTH).intValue();
            int intValue3 = e11.i(chronoField).intValue();
            int intValue4 = e11.i(chronoField2).intValue();
            Long i21 = e11.i(chronoField3);
            Long i22 = e11.i(chronoField4);
            if (i21 != null) {
                i13 = i21.intValue();
            } else {
                i13 = 0;
            }
            if (i22 != null) {
                i14 = i22.intValue();
            } else {
                i14 = 0;
            }
            int i23 = ((int) longValue) % 10000;
            if (intValue3 == 24 && intValue4 == 0 && i13 == 0 && i14 == 0) {
                i16 = 0;
                i15 = i13;
                i19 = 1;
            } else if (intValue3 == 23 && intValue4 == 59 && i13 == 60) {
                dateTimeParseContext.q();
                i15 = 59;
                i16 = intValue3;
            } else {
                i16 = intValue3;
                i15 = i13;
            }
            try {
                DateTimeParseContext dateTimeParseContext2 = dateTimeParseContext;
                int i24 = i11;
                return dateTimeParseContext2.p(chronoField4, (long) i14, i24, dateTimeParseContext2.p(ChronoField.INSTANT_SECONDS, Jdk8Methods.safeMultiply(longValue / 10000, (long) SECONDS_PER_10000_YEARS) + LocalDateTime.of(i23, intValue, intValue2, i16, intValue4, i15, 0).plusDays((long) i19).toEpochSecond(ZoneOffset.UTC), i24, parse));
            } catch (RuntimeException unused) {
                return ~i17;
            }
        }

        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb2) {
            StringBuilder sb3 = sb2;
            Long e11 = dateTimePrintContext.e(ChronoField.INSTANT_SECONDS);
            Long l11 = 0L;
            TemporalAccessor d11 = dateTimePrintContext.d();
            ChronoField chronoField = ChronoField.NANO_OF_SECOND;
            if (d11.isSupported(chronoField)) {
                l11 = Long.valueOf(dateTimePrintContext.d().getLong(chronoField));
            }
            int i11 = 0;
            if (e11 == null) {
                return false;
            }
            long longValue = e11.longValue();
            int checkValidIntValue = chronoField.checkValidIntValue(l11.longValue());
            if (longValue >= -62167219200L) {
                long j11 = (longValue - SECONDS_PER_10000_YEARS) + SECONDS_0000_TO_1970;
                long floorDiv = 1 + Jdk8Methods.floorDiv(j11, (long) SECONDS_PER_10000_YEARS);
                LocalDateTime ofEpochSecond = LocalDateTime.ofEpochSecond(Jdk8Methods.floorMod(j11, (long) SECONDS_PER_10000_YEARS) - SECONDS_0000_TO_1970, 0, ZoneOffset.UTC);
                if (floorDiv > 0) {
                    sb3.append(SignatureVisitor.EXTENDS);
                    sb3.append(floorDiv);
                }
                sb3.append(ofEpochSecond);
                if (ofEpochSecond.getSecond() == 0) {
                    sb3.append(":00");
                }
            } else {
                long j12 = longValue + SECONDS_0000_TO_1970;
                long j13 = j12 / SECONDS_PER_10000_YEARS;
                long j14 = j12 % SECONDS_PER_10000_YEARS;
                LocalDateTime ofEpochSecond2 = LocalDateTime.ofEpochSecond(j14 - SECONDS_0000_TO_1970, 0, ZoneOffset.UTC);
                int length = sb2.length();
                sb3.append(ofEpochSecond2);
                if (ofEpochSecond2.getSecond() == 0) {
                    sb3.append(":00");
                }
                if (j13 < 0) {
                    if (ofEpochSecond2.getYear() == -10000) {
                        sb3.replace(length, length + 2, Long.toString(j13 - 1));
                    } else if (j14 == 0) {
                        sb3.insert(length, j13);
                    } else {
                        sb3.insert(length + 1, Math.abs(j13));
                    }
                }
            }
            int i12 = this.fractionalDigits;
            if (i12 == -2) {
                if (checkValidIntValue != 0) {
                    sb3.append('.');
                    if (checkValidIntValue % 1000000 == 0) {
                        sb3.append(Integer.toString((checkValidIntValue / 1000000) + 1000).substring(1));
                    } else if (checkValidIntValue % 1000 == 0) {
                        sb3.append(Integer.toString((checkValidIntValue / 1000) + 1000000).substring(1));
                    } else {
                        sb3.append(Integer.toString(checkValidIntValue + 1000000000).substring(1));
                    }
                }
            } else if (i12 > 0 || (i12 == -1 && checkValidIntValue > 0)) {
                sb3.append('.');
                int i13 = 100000000;
                while (true) {
                    int i14 = this.fractionalDigits;
                    if ((i14 != -1 || checkValidIntValue <= 0) && i11 >= i14) {
                        break;
                    }
                    int i15 = checkValidIntValue / i13;
                    sb3.append((char) (i15 + 48));
                    checkValidIntValue -= i15 * i13;
                    i13 /= 10;
                    i11++;
                }
            }
            sb3.append('Z');
            return true;
        }

        public String toString() {
            return "Instant()";
        }
    }

    public static final class LocalizedOffsetPrinterParser implements DateTimePrinterParser {
        private final TextStyle style;

        public LocalizedOffsetPrinterParser(TextStyle textStyle) {
            this.style = textStyle;
        }

        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i11) {
            int i12;
            char charAt;
            CharSequence charSequence2 = charSequence;
            int i13 = i11;
            if (!dateTimeParseContext.t(charSequence, i11, "GMT", 0, 3)) {
                return ~i13;
            }
            int i14 = i13 + 3;
            if (this.style == TextStyle.FULL) {
                DateTimeParseContext dateTimeParseContext2 = dateTimeParseContext;
                return new OffsetIdPrinterParser("", "+HH:MM:ss").parse(dateTimeParseContext, charSequence2, i14);
            }
            DateTimeParseContext dateTimeParseContext3 = dateTimeParseContext;
            int length = charSequence.length();
            if (i14 == length) {
                return dateTimeParseContext.p(ChronoField.OFFSET_SECONDS, 0, i14, i14);
            }
            char charAt2 = charSequence2.charAt(i14);
            if (charAt2 != '+' && charAt2 != '-') {
                return dateTimeParseContext.p(ChronoField.OFFSET_SECONDS, 0, i14, i14);
            }
            if (charAt2 == '-') {
                i12 = -1;
            } else {
                i12 = 1;
            }
            if (i14 == length) {
                return ~i14;
            }
            int i15 = i14 + 1;
            char charAt3 = charSequence2.charAt(i15);
            if (charAt3 < '0' || charAt3 > '9') {
                return ~i15;
            }
            int i16 = i15 + 1;
            int i17 = charAt3 - '0';
            if (i16 != length && (charAt = charSequence2.charAt(i16)) >= '0' && charAt <= '9') {
                i17 = (i17 * 10) + (charAt - '0');
                if (i17 > 23) {
                    return ~i16;
                }
                i16++;
            }
            int i18 = i16;
            if (i18 == length || charSequence2.charAt(i18) != ':') {
                return dateTimeParseContext.p(ChronoField.OFFSET_SECONDS, (long) (i12 * 3600 * i17), i18, i18);
            }
            int i19 = i18 + 1;
            int i21 = length - 2;
            if (i19 > i21) {
                return ~i19;
            }
            char charAt4 = charSequence2.charAt(i19);
            if (charAt4 < '0' || charAt4 > '9') {
                return ~i19;
            }
            int i22 = i19 + 1;
            int i23 = charAt4 - '0';
            char charAt5 = charSequence2.charAt(i22);
            if (charAt5 < '0' || charAt5 > '9') {
                return ~i22;
            }
            int i24 = i22 + 1;
            int i25 = (i23 * 10) + (charAt5 - '0');
            if (i25 > 59) {
                return ~i24;
            }
            if (i24 == length || charSequence2.charAt(i24) != ':') {
                return dateTimeParseContext.p(ChronoField.OFFSET_SECONDS, (long) (i12 * ((i17 * 3600) + (i25 * 60))), i24, i24);
            }
            int i26 = i24 + 1;
            if (i26 > i21) {
                return ~i26;
            }
            char charAt6 = charSequence2.charAt(i26);
            if (charAt6 < '0' || charAt6 > '9') {
                return ~i26;
            }
            int i27 = i26 + 1;
            int i28 = charAt6 - '0';
            char charAt7 = charSequence2.charAt(i27);
            if (charAt7 < '0' || charAt7 > '9') {
                return ~i27;
            }
            int i29 = i27 + 1;
            int i31 = (i28 * 10) + (charAt7 - '0');
            if (i31 > 59) {
                return ~i29;
            }
            return dateTimeParseContext.p(ChronoField.OFFSET_SECONDS, (long) (i12 * ((i17 * 3600) + (i25 * 60) + i31)), i29, i29);
        }

        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb2) {
            String str;
            Long e11 = dateTimePrintContext.e(ChronoField.OFFSET_SECONDS);
            if (e11 == null) {
                return false;
            }
            sb2.append("GMT");
            if (this.style == TextStyle.FULL) {
                return new OffsetIdPrinterParser("", "+HH:MM:ss").print(dateTimePrintContext, sb2);
            }
            int safeToInt = Jdk8Methods.safeToInt(e11.longValue());
            if (safeToInt == 0) {
                return true;
            }
            int abs = Math.abs((safeToInt / 3600) % 100);
            int abs2 = Math.abs((safeToInt / 60) % 60);
            int abs3 = Math.abs(safeToInt % 60);
            if (safeToInt < 0) {
                str = SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE;
            } else {
                str = "+";
            }
            sb2.append(str);
            sb2.append(abs);
            if (abs2 <= 0 && abs3 <= 0) {
                return true;
            }
            sb2.append(CertificateUtil.DELIMITER);
            sb2.append((char) ((abs2 / 10) + 48));
            sb2.append((char) ((abs2 % 10) + 48));
            if (abs3 <= 0) {
                return true;
            }
            sb2.append(CertificateUtil.DELIMITER);
            sb2.append((char) ((abs3 / 10) + 48));
            sb2.append((char) ((abs3 % 10) + 48));
            return true;
        }
    }

    public static final class LocalizedPrinterParser implements DateTimePrinterParser {
        private final FormatStyle dateStyle;
        private final FormatStyle timeStyle;

        public LocalizedPrinterParser(FormatStyle formatStyle, FormatStyle formatStyle2) {
            this.dateStyle = formatStyle;
            this.timeStyle = formatStyle2;
        }

        private DateTimeFormatter formatter(Locale locale, Chronology chronology) {
            return DateTimeFormatStyleProvider.a().getFormatter(this.dateStyle, this.timeStyle, chronology, locale);
        }

        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i11) {
            return formatter(dateTimeParseContext.h(), dateTimeParseContext.g()).c(false).parse(dateTimeParseContext, charSequence, i11);
        }

        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb2) {
            return formatter(dateTimePrintContext.b(), Chronology.from(dateTimePrintContext.d())).c(false).print(dateTimePrintContext, sb2);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Localized(");
            Object obj = this.dateStyle;
            Object obj2 = "";
            if (obj == null) {
                obj = obj2;
            }
            sb2.append(obj);
            sb2.append(",");
            Object obj3 = this.timeStyle;
            if (obj3 != null) {
                obj2 = obj3;
            }
            sb2.append(obj2);
            sb2.append(")");
            return sb2.toString();
        }
    }

    public static class NumberPrinterParser implements DateTimePrinterParser {

        /* renamed from: g  reason: collision with root package name */
        public static final int[] f63357g = {0, 10, 100, 1000, 10000, 100000, 1000000, ExceptionCode.CRASH_EXCEPTION, 100000000, 1000000000};

        /* renamed from: b  reason: collision with root package name */
        public final TemporalField f63358b;

        /* renamed from: c  reason: collision with root package name */
        public final int f63359c;

        /* renamed from: d  reason: collision with root package name */
        public final int f63360d;

        /* renamed from: e  reason: collision with root package name */
        public final SignStyle f63361e;

        /* renamed from: f  reason: collision with root package name */
        public final int f63362f;

        public long a(DateTimePrintContext dateTimePrintContext, long j11) {
            return j11;
        }

        public boolean b(DateTimeParseContext dateTimeParseContext) {
            int i11 = this.f63362f;
            return i11 == -1 || (i11 > 0 && this.f63359c == this.f63360d && this.f63361e == SignStyle.NOT_NEGATIVE);
        }

        public int c(DateTimeParseContext dateTimeParseContext, long j11, int i11, int i12) {
            return dateTimeParseContext.p(this.f63358b, j11, i11, i12);
        }

        public NumberPrinterParser d() {
            if (this.f63362f == -1) {
                return this;
            }
            return new NumberPrinterParser(this.f63358b, this.f63359c, this.f63360d, this.f63361e, -1);
        }

        public NumberPrinterParser e(int i11) {
            return new NumberPrinterParser(this.f63358b, this.f63359c, this.f63360d, this.f63361e, this.f63362f + i11);
        }

        /* JADX WARNING: Removed duplicated region for block: B:106:0x015e  */
        /* JADX WARNING: Removed duplicated region for block: B:111:0x017c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int parse(org.threeten.bp.format.DateTimeParseContext r20, java.lang.CharSequence r21, int r22) {
            /*
                r19 = this;
                r6 = r19
                r0 = r22
                int r1 = r21.length()
                if (r0 != r1) goto L_0x000c
                int r0 = ~r0
                return r0
            L_0x000c:
                char r2 = r21.charAt(r22)
                org.threeten.bp.format.DecimalStyle r3 = r20.j()
                char r3 = r3.getPositiveSign()
                r4 = 0
                r5 = 1
                if (r2 != r3) goto L_0x0039
                org.threeten.bp.format.SignStyle r2 = r6.f63361e
                boolean r3 = r20.l()
                int r7 = r6.f63359c
                int r8 = r6.f63360d
                if (r7 != r8) goto L_0x002a
                r7 = r5
                goto L_0x002b
            L_0x002a:
                r7 = r4
            L_0x002b:
                boolean r2 = r2.a(r5, r3, r7)
                if (r2 != 0) goto L_0x0033
                int r0 = ~r0
                return r0
            L_0x0033:
                int r0 = r0 + 1
                r7 = r0
                r0 = r4
                r2 = r5
                goto L_0x0071
            L_0x0039:
                org.threeten.bp.format.DecimalStyle r3 = r20.j()
                char r3 = r3.getNegativeSign()
                if (r2 != r3) goto L_0x0060
                org.threeten.bp.format.SignStyle r2 = r6.f63361e
                boolean r3 = r20.l()
                int r7 = r6.f63359c
                int r8 = r6.f63360d
                if (r7 != r8) goto L_0x0051
                r7 = r5
                goto L_0x0052
            L_0x0051:
                r7 = r4
            L_0x0052:
                boolean r2 = r2.a(r4, r3, r7)
                if (r2 != 0) goto L_0x005a
                int r0 = ~r0
                return r0
            L_0x005a:
                int r0 = r0 + 1
                r7 = r0
                r2 = r4
                r0 = r5
                goto L_0x0071
            L_0x0060:
                org.threeten.bp.format.SignStyle r2 = r6.f63361e
                org.threeten.bp.format.SignStyle r3 = org.threeten.bp.format.SignStyle.ALWAYS
                if (r2 != r3) goto L_0x006e
                boolean r2 = r20.l()
                if (r2 == 0) goto L_0x006e
                int r0 = ~r0
                return r0
            L_0x006e:
                r7 = r0
                r0 = r4
                r2 = r0
            L_0x0071:
                boolean r3 = r20.l()
                if (r3 != 0) goto L_0x0080
                boolean r3 = r19.b(r20)
                if (r3 == 0) goto L_0x007e
                goto L_0x0080
            L_0x007e:
                r3 = r5
                goto L_0x0082
            L_0x0080:
                int r3 = r6.f63359c
            L_0x0082:
                int r8 = r7 + r3
                if (r8 <= r1) goto L_0x0088
                int r0 = ~r7
                return r0
            L_0x0088:
                boolean r9 = r20.l()
                if (r9 != 0) goto L_0x0098
                boolean r9 = r19.b(r20)
                if (r9 == 0) goto L_0x0095
                goto L_0x0098
            L_0x0095:
                r9 = 9
                goto L_0x009a
            L_0x0098:
                int r9 = r6.f63360d
            L_0x009a:
                int r10 = r6.f63362f
                int r10 = java.lang.Math.max(r10, r4)
                int r9 = r9 + r10
            L_0x00a1:
                r10 = 2
                r13 = 0
                if (r4 >= r10) goto L_0x010c
                int r9 = r9 + r7
                int r9 = java.lang.Math.min(r9, r1)
                r10 = r7
                r14 = 0
            L_0x00ad:
                if (r10 >= r9) goto L_0x00f6
                int r16 = r10 + 1
                r11 = r21
                char r10 = r11.charAt(r10)
                org.threeten.bp.format.DecimalStyle r12 = r20.j()
                int r10 = r12.b(r10)
                if (r10 >= 0) goto L_0x00c7
                int r10 = r16 + -1
                if (r10 >= r8) goto L_0x00f8
                int r0 = ~r7
                return r0
            L_0x00c7:
                int r12 = r16 - r7
                r5 = 18
                if (r12 <= r5) goto L_0x00e6
                if (r13 != 0) goto L_0x00d3
                java.math.BigInteger r13 = java.math.BigInteger.valueOf(r14)
            L_0x00d3:
                java.math.BigInteger r5 = java.math.BigInteger.TEN
                java.math.BigInteger r5 = r13.multiply(r5)
                long r12 = (long) r10
                java.math.BigInteger r10 = java.math.BigInteger.valueOf(r12)
                java.math.BigInteger r13 = r5.add(r10)
                r5 = r8
                r22 = r9
                goto L_0x00ef
            L_0x00e6:
                r17 = 10
                long r14 = r14 * r17
                r5 = r8
                r22 = r9
                long r8 = (long) r10
                long r14 = r14 + r8
            L_0x00ef:
                r9 = r22
                r8 = r5
                r10 = r16
                r5 = 1
                goto L_0x00ad
            L_0x00f6:
                r11 = r21
            L_0x00f8:
                r5 = r8
                int r8 = r6.f63362f
                if (r8 <= 0) goto L_0x010a
                if (r4 != 0) goto L_0x010a
                int r10 = r10 - r7
                int r10 = r10 - r8
                int r9 = java.lang.Math.max(r3, r10)
                int r4 = r4 + 1
                r8 = r5
                r5 = 1
                goto L_0x00a1
            L_0x010a:
                r5 = r10
                goto L_0x010f
            L_0x010c:
                r5 = r7
                r14 = 0
            L_0x010f:
                if (r0 == 0) goto L_0x013d
                if (r13 == 0) goto L_0x012a
                java.math.BigInteger r0 = java.math.BigInteger.ZERO
                boolean r0 = r13.equals(r0)
                if (r0 == 0) goto L_0x0125
                boolean r0 = r20.l()
                if (r0 == 0) goto L_0x0125
                r0 = 1
                int r7 = r7 - r0
                int r0 = ~r7
                return r0
            L_0x0125:
                java.math.BigInteger r13 = r13.negate()
                goto L_0x015b
            L_0x012a:
                r0 = 1
                r1 = 0
                int r1 = (r14 > r1 ? 1 : (r14 == r1 ? 0 : -1))
                if (r1 != 0) goto L_0x013a
                boolean r1 = r20.l()
                if (r1 == 0) goto L_0x013a
                int r7 = r7 - r0
                int r0 = ~r7
                return r0
            L_0x013a:
                long r0 = -r14
                r2 = r0
                goto L_0x015c
            L_0x013d:
                org.threeten.bp.format.SignStyle r0 = r6.f63361e
                org.threeten.bp.format.SignStyle r1 = org.threeten.bp.format.SignStyle.EXCEEDS_PAD
                if (r0 != r1) goto L_0x015b
                boolean r0 = r20.l()
                if (r0 == 0) goto L_0x015b
                int r0 = r5 - r7
                if (r2 == 0) goto L_0x0155
                int r1 = r6.f63359c
                if (r0 > r1) goto L_0x015b
                r0 = 1
                int r7 = r7 - r0
                int r0 = ~r7
                return r0
            L_0x0155:
                int r1 = r6.f63359c
                if (r0 <= r1) goto L_0x015b
                int r0 = ~r7
                return r0
            L_0x015b:
                r2 = r14
            L_0x015c:
                if (r13 == 0) goto L_0x017c
                int r0 = r13.bitLength()
                r1 = 63
                if (r0 <= r1) goto L_0x016e
                java.math.BigInteger r0 = java.math.BigInteger.TEN
                java.math.BigInteger r13 = r13.divide(r0)
                int r5 = r5 + -1
            L_0x016e:
                long r2 = r13.longValue()
                r0 = r19
                r1 = r20
                r4 = r7
                int r0 = r0.c(r1, r2, r4, r5)
                return r0
            L_0x017c:
                r0 = r19
                r1 = r20
                r4 = r7
                int r0 = r0.c(r1, r2, r4, r5)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.format.DateTimeFormatterBuilder.NumberPrinterParser.parse(org.threeten.bp.format.DateTimeParseContext, java.lang.CharSequence, int):int");
        }

        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb2) {
            String str;
            Long e11 = dateTimePrintContext.e(this.f63358b);
            if (e11 == null) {
                return false;
            }
            long a11 = a(dateTimePrintContext, e11.longValue());
            DecimalStyle c11 = dateTimePrintContext.c();
            if (a11 == Long.MIN_VALUE) {
                str = "9223372036854775808";
            } else {
                str = Long.toString(Math.abs(a11));
            }
            if (str.length() <= this.f63360d) {
                String a12 = c11.a(str);
                if (a11 >= 0) {
                    int i11 = AnonymousClass4.f63356a[this.f63361e.ordinal()];
                    if (i11 == 1) {
                        int i12 = this.f63359c;
                        if (i12 < 19 && a11 >= ((long) f63357g[i12])) {
                            sb2.append(c11.getPositiveSign());
                        }
                    } else if (i11 == 2) {
                        sb2.append(c11.getPositiveSign());
                    }
                } else {
                    int i13 = AnonymousClass4.f63356a[this.f63361e.ordinal()];
                    if (i13 == 1 || i13 == 2 || i13 == 3) {
                        sb2.append(c11.getNegativeSign());
                    } else if (i13 == 4) {
                        throw new DateTimeException("Field " + this.f63358b + " cannot be printed as the value " + a11 + " cannot be negative according to the SignStyle");
                    }
                }
                for (int i14 = 0; i14 < this.f63359c - a12.length(); i14++) {
                    sb2.append(c11.getZeroDigit());
                }
                sb2.append(a12);
                return true;
            }
            throw new DateTimeException("Field " + this.f63358b + " cannot be printed as the value " + a11 + " exceeds the maximum print width of " + this.f63360d);
        }

        public String toString() {
            int i11 = this.f63359c;
            if (i11 == 1 && this.f63360d == 19 && this.f63361e == SignStyle.NORMAL) {
                return "Value(" + this.f63358b + ")";
            } else if (i11 == this.f63360d && this.f63361e == SignStyle.NOT_NEGATIVE) {
                return "Value(" + this.f63358b + "," + this.f63359c + ")";
            } else {
                return "Value(" + this.f63358b + "," + this.f63359c + "," + this.f63360d + "," + this.f63361e + ")";
            }
        }

        public NumberPrinterParser(TemporalField temporalField, int i11, int i12, SignStyle signStyle) {
            this.f63358b = temporalField;
            this.f63359c = i11;
            this.f63360d = i12;
            this.f63361e = signStyle;
            this.f63362f = 0;
        }

        private NumberPrinterParser(TemporalField temporalField, int i11, int i12, SignStyle signStyle, int i13) {
            this.f63358b = temporalField;
            this.f63359c = i11;
            this.f63360d = i12;
            this.f63361e = signStyle;
            this.f63362f = i13;
        }
    }

    public static final class OffsetIdPrinterParser implements DateTimePrinterParser {

        /* renamed from: b  reason: collision with root package name */
        public static final String[] f63363b = {"+HH", "+HHmm", "+HH:mm", "+HHMM", "+HH:MM", "+HHMMss", "+HH:MM:ss", "+HHMMSS", "+HH:MM:SS"};

        /* renamed from: c  reason: collision with root package name */
        public static final OffsetIdPrinterParser f63364c = new OffsetIdPrinterParser("Z", "+HH:MM:ss");

        /* renamed from: d  reason: collision with root package name */
        public static final OffsetIdPrinterParser f63365d = new OffsetIdPrinterParser("0", "+HH:MM:ss");
        private final String noOffsetText;
        private final int type;

        public OffsetIdPrinterParser(String str, String str2) {
            Jdk8Methods.requireNonNull(str, "noOffsetText");
            Jdk8Methods.requireNonNull(str2, Param.PATTERN);
            this.noOffsetText = str;
            this.type = checkPattern(str2);
        }

        private int checkPattern(String str) {
            int i11 = 0;
            while (true) {
                String[] strArr = f63363b;
                if (i11 >= strArr.length) {
                    throw new IllegalArgumentException("Invalid zone offset pattern: " + str);
                } else if (strArr[i11].equals(str)) {
                    return i11;
                } else {
                    i11++;
                }
            }
        }

        private boolean parseNumber(int[] iArr, int i11, CharSequence charSequence, boolean z11) {
            int i12;
            int i13 = this.type;
            if ((i13 + 3) / 2 < i11) {
                return false;
            }
            int i14 = iArr[0];
            if (i13 % 2 == 0 && i11 > 1) {
                int i15 = i14 + 1;
                if (i15 > charSequence.length() || charSequence.charAt(i14) != ':') {
                    return z11;
                }
                i14 = i15;
            }
            if (i14 + 2 > charSequence.length()) {
                return z11;
            }
            int i16 = i14 + 1;
            char charAt = charSequence.charAt(i14);
            int i17 = i16 + 1;
            char charAt2 = charSequence.charAt(i16);
            if (charAt < '0' || charAt > '9' || charAt2 < '0' || charAt2 > '9' || (i12 = ((charAt - '0') * 10) + (charAt2 - '0')) < 0 || i12 > 59) {
                return z11;
            }
            iArr[i11] = i12;
            iArr[0] = i17;
            return false;
        }

        /* JADX WARNING: Removed duplicated region for block: B:32:0x0080  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int parse(org.threeten.bp.format.DateTimeParseContext r16, java.lang.CharSequence r17, int r18) {
            /*
                r15 = this;
                r0 = r15
                r7 = r17
                r8 = r18
                int r1 = r17.length()
                java.lang.String r2 = r0.noOffsetText
                int r9 = r2.length()
                if (r9 != 0) goto L_0x0022
                if (r8 != r1) goto L_0x0045
                org.threeten.bp.temporal.ChronoField r2 = org.threeten.bp.temporal.ChronoField.OFFSET_SECONDS
                r3 = 0
                r1 = r16
                r5 = r18
                r6 = r18
                int r1 = r1.p(r2, r3, r5, r6)
                return r1
            L_0x0022:
                if (r8 != r1) goto L_0x0026
                int r1 = ~r8
                return r1
            L_0x0026:
                java.lang.String r4 = r0.noOffsetText
                r5 = 0
                r1 = r16
                r2 = r17
                r3 = r18
                r6 = r9
                boolean r1 = r1.t(r2, r3, r4, r5, r6)
                if (r1 == 0) goto L_0x0045
                org.threeten.bp.temporal.ChronoField r2 = org.threeten.bp.temporal.ChronoField.OFFSET_SECONDS
                r3 = 0
                int r6 = r8 + r9
                r1 = r16
                r5 = r18
                int r1 = r1.p(r2, r3, r5, r6)
                return r1
            L_0x0045:
                char r1 = r17.charAt(r18)
                r2 = 43
                r3 = 45
                if (r1 == r2) goto L_0x0051
                if (r1 != r3) goto L_0x00a3
            L_0x0051:
                r2 = 1
                if (r1 != r3) goto L_0x0056
                r1 = -1
                goto L_0x0057
            L_0x0056:
                r1 = r2
            L_0x0057:
                r3 = 4
                int[] r3 = new int[r3]
                int r4 = r8 + 1
                r5 = 0
                r3[r5] = r4
                boolean r4 = r15.parseNumber(r3, r2, r7, r2)
                r6 = 2
                r10 = 3
                if (r4 != 0) goto L_0x007d
                int r4 = r0.type
                if (r4 < r10) goto L_0x006d
                r4 = r2
                goto L_0x006e
            L_0x006d:
                r4 = r5
            L_0x006e:
                boolean r4 = r15.parseNumber(r3, r6, r7, r4)
                if (r4 != 0) goto L_0x007d
                boolean r4 = r15.parseNumber(r3, r10, r7, r5)
                if (r4 == 0) goto L_0x007b
                goto L_0x007d
            L_0x007b:
                r4 = r5
                goto L_0x007e
            L_0x007d:
                r4 = r2
            L_0x007e:
                if (r4 != 0) goto L_0x00a3
                long r11 = (long) r1
                r1 = r3[r2]
                long r1 = (long) r1
                r13 = 3600(0xe10, double:1.7786E-320)
                long r1 = r1 * r13
                r4 = r3[r6]
                long r6 = (long) r4
                r13 = 60
                long r6 = r6 * r13
                long r1 = r1 + r6
                r4 = r3[r10]
                long r6 = (long) r4
                long r1 = r1 + r6
                long r6 = r11 * r1
                org.threeten.bp.temporal.ChronoField r2 = org.threeten.bp.temporal.ChronoField.OFFSET_SECONDS
                r9 = r3[r5]
                r1 = r16
                r3 = r6
                r5 = r18
                r6 = r9
                int r1 = r1.p(r2, r3, r5, r6)
                return r1
            L_0x00a3:
                if (r9 != 0) goto L_0x00b4
                org.threeten.bp.temporal.ChronoField r2 = org.threeten.bp.temporal.ChronoField.OFFSET_SECONDS
                r3 = 0
                int r6 = r8 + r9
                r1 = r16
                r5 = r18
                int r1 = r1.p(r2, r3, r5, r6)
                return r1
            L_0x00b4:
                int r1 = ~r8
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.format.DateTimeFormatterBuilder.OffsetIdPrinterParser.parse(org.threeten.bp.format.DateTimeParseContext, java.lang.CharSequence, int):int");
        }

        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb2) {
            String str;
            String str2;
            Long e11 = dateTimePrintContext.e(ChronoField.OFFSET_SECONDS);
            if (e11 == null) {
                return false;
            }
            int safeToInt = Jdk8Methods.safeToInt(e11.longValue());
            if (safeToInt == 0) {
                sb2.append(this.noOffsetText);
            } else {
                int abs = Math.abs((safeToInt / 3600) % 100);
                int abs2 = Math.abs((safeToInt / 60) % 60);
                int abs3 = Math.abs(safeToInt % 60);
                int length = sb2.length();
                if (safeToInt < 0) {
                    str = SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE;
                } else {
                    str = "+";
                }
                sb2.append(str);
                sb2.append((char) ((abs / 10) + 48));
                sb2.append((char) ((abs % 10) + 48));
                int i11 = this.type;
                if (i11 >= 3 || (i11 >= 1 && abs2 > 0)) {
                    int i12 = i11 % 2;
                    String str3 = CertificateUtil.DELIMITER;
                    if (i12 == 0) {
                        str2 = str3;
                    } else {
                        str2 = "";
                    }
                    sb2.append(str2);
                    sb2.append((char) ((abs2 / 10) + 48));
                    sb2.append((char) ((abs2 % 10) + 48));
                    abs += abs2;
                    int i13 = this.type;
                    if (i13 >= 7 || (i13 >= 5 && abs3 > 0)) {
                        if (i13 % 2 != 0) {
                            str3 = "";
                        }
                        sb2.append(str3);
                        sb2.append((char) ((abs3 / 10) + 48));
                        sb2.append((char) ((abs3 % 10) + 48));
                        abs += abs3;
                    }
                }
                if (abs == 0) {
                    sb2.setLength(length);
                    sb2.append(this.noOffsetText);
                }
            }
            return true;
        }

        public String toString() {
            String replace = this.noOffsetText.replace("'", "''");
            return "Offset(" + f63363b[this.type] + ",'" + replace + "')";
        }
    }

    public static final class PadPrinterParserDecorator implements DateTimePrinterParser {
        private final char padChar;
        private final int padWidth;
        private final DateTimePrinterParser printerParser;

        public PadPrinterParserDecorator(DateTimePrinterParser dateTimePrinterParser, int i11, char c11) {
            this.printerParser = dateTimePrinterParser;
            this.padWidth = i11;
            this.padChar = c11;
        }

        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i11) {
            boolean l11 = dateTimeParseContext.l();
            boolean k11 = dateTimeParseContext.k();
            if (i11 > charSequence.length()) {
                throw new IndexOutOfBoundsException();
            } else if (i11 == charSequence.length()) {
                return ~i11;
            } else {
                int i12 = this.padWidth + i11;
                if (i12 > charSequence.length()) {
                    if (l11) {
                        return ~i11;
                    }
                    i12 = charSequence.length();
                }
                int i13 = i11;
                while (i13 < i12) {
                    if (!k11) {
                        if (!dateTimeParseContext.c(charSequence.charAt(i13), this.padChar)) {
                            break;
                        }
                    } else if (charSequence.charAt(i13) != this.padChar) {
                        break;
                    }
                    i13++;
                }
                int parse = this.printerParser.parse(dateTimeParseContext, charSequence.subSequence(0, i12), i13);
                if (parse == i12 || !l11) {
                    return parse;
                }
                return ~(i11 + i13);
            }
        }

        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb2) {
            int length = sb2.length();
            if (!this.printerParser.print(dateTimePrintContext, sb2)) {
                return false;
            }
            int length2 = sb2.length() - length;
            if (length2 <= this.padWidth) {
                for (int i11 = 0; i11 < this.padWidth - length2; i11++) {
                    sb2.insert(length, this.padChar);
                }
                return true;
            }
            throw new DateTimeException("Cannot print as output of " + length2 + " characters exceeds pad width of " + this.padWidth);
        }

        public String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Pad(");
            sb2.append(this.printerParser);
            sb2.append(",");
            sb2.append(this.padWidth);
            if (this.padChar == ' ') {
                str = ")";
            } else {
                str = ",'" + this.padChar + "')";
            }
            sb2.append(str);
            return sb2.toString();
        }
    }

    public enum SettingsParser implements DateTimePrinterParser {
        SENSITIVE,
        INSENSITIVE,
        STRICT,
        LENIENT;

        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i11) {
            int ordinal = ordinal();
            if (ordinal == 0) {
                dateTimeParseContext.m(true);
            } else if (ordinal == 1) {
                dateTimeParseContext.m(false);
            } else if (ordinal == 2) {
                dateTimeParseContext.r(true);
            } else if (ordinal == 3) {
                dateTimeParseContext.r(false);
            }
            return i11;
        }

        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb2) {
            return true;
        }

        public String toString() {
            int ordinal = ordinal();
            if (ordinal == 0) {
                return "ParseCaseSensitive(true)";
            }
            if (ordinal == 1) {
                return "ParseCaseSensitive(false)";
            }
            if (ordinal == 2) {
                return "ParseStrict(true)";
            }
            if (ordinal == 3) {
                return "ParseStrict(false)";
            }
            throw new IllegalStateException("Unreachable");
        }
    }

    public static final class StringLiteralPrinterParser implements DateTimePrinterParser {
        private final String literal;

        public StringLiteralPrinterParser(String str) {
            this.literal = str;
        }

        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i11) {
            if (i11 > charSequence.length() || i11 < 0) {
                throw new IndexOutOfBoundsException();
            }
            String str = this.literal;
            if (!dateTimeParseContext.t(charSequence, i11, str, 0, str.length())) {
                return ~i11;
            }
            return i11 + this.literal.length();
        }

        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb2) {
            sb2.append(this.literal);
            return true;
        }

        public String toString() {
            String replace = this.literal.replace("'", "''");
            return "'" + replace + "'";
        }
    }

    public static final class TextPrinterParser implements DateTimePrinterParser {
        private final TemporalField field;
        private volatile NumberPrinterParser numberPrinterParser;
        private final DateTimeTextProvider provider;
        private final TextStyle textStyle;

        public TextPrinterParser(TemporalField temporalField, TextStyle textStyle2, DateTimeTextProvider dateTimeTextProvider) {
            this.field = temporalField;
            this.textStyle = textStyle2;
            this.provider = dateTimeTextProvider;
        }

        private NumberPrinterParser numberPrinterParser() {
            if (this.numberPrinterParser == null) {
                this.numberPrinterParser = new NumberPrinterParser(this.field, 1, 19, SignStyle.NORMAL);
            }
            return this.numberPrinterParser;
        }

        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i11) {
            TextStyle textStyle2;
            int length = charSequence.length();
            if (i11 < 0 || i11 > length) {
                throw new IndexOutOfBoundsException();
            }
            if (dateTimeParseContext.l()) {
                textStyle2 = this.textStyle;
            } else {
                textStyle2 = null;
            }
            Iterator<Map.Entry<String, Long>> textIterator = this.provider.getTextIterator(this.field, textStyle2, dateTimeParseContext.h());
            if (textIterator != null) {
                while (textIterator.hasNext()) {
                    Map.Entry next = textIterator.next();
                    String str = (String) next.getKey();
                    if (dateTimeParseContext.t(str, 0, charSequence, i11, str.length())) {
                        return dateTimeParseContext.p(this.field, ((Long) next.getValue()).longValue(), i11, i11 + str.length());
                    }
                }
                if (dateTimeParseContext.l()) {
                    return ~i11;
                }
            }
            return numberPrinterParser().parse(dateTimeParseContext, charSequence, i11);
        }

        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb2) {
            Long e11 = dateTimePrintContext.e(this.field);
            if (e11 == null) {
                return false;
            }
            String text = this.provider.getText(this.field, e11.longValue(), this.textStyle, dateTimePrintContext.b());
            if (text == null) {
                return numberPrinterParser().print(dateTimePrintContext, sb2);
            }
            sb2.append(text);
            return true;
        }

        public String toString() {
            if (this.textStyle == TextStyle.FULL) {
                return "Text(" + this.field + ")";
            }
            return "Text(" + this.field + "," + this.textStyle + ")";
        }
    }

    public static final class WeekFieldsPrinterParser implements DateTimePrinterParser {
        private final int count;
        private final char letter;

        public WeekFieldsPrinterParser(char c11, int i11) {
            this.letter = c11;
            this.count = i11;
        }

        private DateTimePrinterParser evaluate(WeekFields weekFields) {
            SignStyle signStyle;
            char c11 = this.letter;
            if (c11 == 'W') {
                return new NumberPrinterParser(weekFields.weekOfMonth(), 1, 2, SignStyle.NOT_NEGATIVE);
            }
            if (c11 != 'Y') {
                if (c11 == 'c') {
                    return new NumberPrinterParser(weekFields.dayOfWeek(), this.count, 2, SignStyle.NOT_NEGATIVE);
                }
                if (c11 == 'e') {
                    return new NumberPrinterParser(weekFields.dayOfWeek(), this.count, 2, SignStyle.NOT_NEGATIVE);
                }
                if (c11 != 'w') {
                    return null;
                }
                return new NumberPrinterParser(weekFields.weekOfWeekBasedYear(), this.count, 2, SignStyle.NOT_NEGATIVE);
            } else if (this.count == 2) {
                return new ReducedPrinterParser(weekFields.weekBasedYear(), 2, 2, 0, ReducedPrinterParser.f63366h);
            } else {
                TemporalField weekBasedYear = weekFields.weekBasedYear();
                int i11 = this.count;
                if (i11 < 4) {
                    signStyle = SignStyle.NORMAL;
                } else {
                    signStyle = SignStyle.EXCEEDS_PAD;
                }
                return new NumberPrinterParser(weekBasedYear, i11, 19, signStyle, -1);
            }
        }

        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i11) {
            return evaluate(WeekFields.of(dateTimeParseContext.h())).parse(dateTimeParseContext, charSequence, i11);
        }

        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb2) {
            return evaluate(WeekFields.of(dateTimePrintContext.b())).print(dateTimePrintContext, sb2);
        }

        public String toString() {
            SignStyle signStyle;
            StringBuilder sb2 = new StringBuilder(30);
            sb2.append("Localized(");
            char c11 = this.letter;
            if (c11 == 'Y') {
                int i11 = this.count;
                if (i11 == 1) {
                    sb2.append("WeekBasedYear");
                } else if (i11 == 2) {
                    sb2.append("ReducedValue(WeekBasedYear,2,2,2000-01-01)");
                } else {
                    sb2.append("WeekBasedYear,");
                    sb2.append(this.count);
                    sb2.append(",");
                    sb2.append(19);
                    sb2.append(",");
                    if (this.count < 4) {
                        signStyle = SignStyle.NORMAL;
                    } else {
                        signStyle = SignStyle.EXCEEDS_PAD;
                    }
                    sb2.append(signStyle);
                }
            } else {
                if (c11 == 'c' || c11 == 'e') {
                    sb2.append("DayOfWeek");
                } else if (c11 == 'w') {
                    sb2.append("WeekOfWeekBasedYear");
                } else if (c11 == 'W') {
                    sb2.append("WeekOfMonth");
                }
                sb2.append(",");
                sb2.append(this.count);
            }
            sb2.append(")");
            return sb2.toString();
        }
    }

    public static final class ZoneIdPrinterParser implements DateTimePrinterParser {
        private static volatile Map.Entry<Integer, SubstringTree> cachedSubstringTree;
        private final String description;
        private final TemporalQuery<ZoneId> query;

        public static final class SubstringTree {

            /* renamed from: a  reason: collision with root package name */
            public final int f63367a;
            private final Map<CharSequence, SubstringTree> substringMap;
            private final Map<String, SubstringTree> substringMapCI;

            /* access modifiers changed from: private */
            public void add(String str) {
                int length = str.length();
                int i11 = this.f63367a;
                if (length == i11) {
                    this.substringMap.put(str, (Object) null);
                    this.substringMapCI.put(str.toLowerCase(Locale.ENGLISH), (Object) null);
                } else if (length > i11) {
                    String substring = str.substring(0, i11);
                    SubstringTree substringTree = this.substringMap.get(substring);
                    if (substringTree == null) {
                        substringTree = new SubstringTree(length);
                        this.substringMap.put(substring, substringTree);
                        this.substringMapCI.put(substring.toLowerCase(Locale.ENGLISH), substringTree);
                    }
                    substringTree.add(str);
                }
            }

            /* access modifiers changed from: private */
            public SubstringTree get(CharSequence charSequence, boolean z11) {
                if (z11) {
                    return this.substringMap.get(charSequence);
                }
                return this.substringMapCI.get(charSequence.toString().toLowerCase(Locale.ENGLISH));
            }

            private SubstringTree(int i11) {
                this.substringMap = new HashMap();
                this.substringMapCI = new HashMap();
                this.f63367a = i11;
            }
        }

        public ZoneIdPrinterParser(TemporalQuery<ZoneId> temporalQuery, String str) {
            this.query = temporalQuery;
            this.description = str;
        }

        private ZoneId convertToZone(Set<String> set, String str, boolean z11) {
            if (str == null) {
                return null;
            }
            if (!z11) {
                for (String next : set) {
                    if (next.equalsIgnoreCase(str)) {
                        return ZoneId.of(next);
                    }
                }
                return null;
            } else if (set.contains(str)) {
                return ZoneId.of(str);
            } else {
                return null;
            }
        }

        private int parsePrefixedOffset(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i11, int i12) {
            String upperCase = charSequence.subSequence(i11, i12).toString().toUpperCase();
            DateTimeParseContext e11 = dateTimeParseContext.e();
            if (i12 >= charSequence.length() || !dateTimeParseContext.c(charSequence.charAt(i12), 'Z')) {
                int parse = OffsetIdPrinterParser.f63364c.parse(e11, charSequence, i12);
                if (parse < 0) {
                    dateTimeParseContext.n(ZoneId.ofOffset(upperCase, ZoneOffset.UTC));
                    return i12;
                }
                dateTimeParseContext.n(ZoneId.ofOffset(upperCase, ZoneOffset.ofTotalSeconds((int) e11.i(ChronoField.OFFSET_SECONDS).longValue())));
                return parse;
            }
            dateTimeParseContext.n(ZoneId.ofOffset(upperCase, ZoneOffset.UTC));
            return i12;
        }

        private static SubstringTree prepareParser(Set<String> set) {
            ArrayList<String> arrayList = new ArrayList<>(set);
            Collections.sort(arrayList, DateTimeFormatterBuilder.f63353a);
            SubstringTree substringTree = new SubstringTree(((String) arrayList.get(0)).length());
            for (String b11 : arrayList) {
                substringTree.add(b11);
            }
            return substringTree;
        }

        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i11) {
            int i12;
            int length = charSequence.length();
            if (i11 > length) {
                throw new IndexOutOfBoundsException();
            } else if (i11 == length) {
                return ~i11;
            } else {
                char charAt = charSequence.charAt(i11);
                if (charAt == '+' || charAt == '-') {
                    DateTimeParseContext e11 = dateTimeParseContext.e();
                    int parse = OffsetIdPrinterParser.f63364c.parse(e11, charSequence, i11);
                    if (parse < 0) {
                        return parse;
                    }
                    dateTimeParseContext.n(ZoneOffset.ofTotalSeconds((int) e11.i(ChronoField.OFFSET_SECONDS).longValue()));
                    return parse;
                }
                int i13 = i11 + 2;
                if (length >= i13) {
                    char charAt2 = charSequence.charAt(i11 + 1);
                    if (dateTimeParseContext.c(charAt, 'U') && dateTimeParseContext.c(charAt2, 'T')) {
                        int i14 = i11 + 3;
                        if (length < i14 || !dateTimeParseContext.c(charSequence.charAt(i13), 'C')) {
                            return parsePrefixedOffset(dateTimeParseContext, charSequence, i11, i13);
                        }
                        return parsePrefixedOffset(dateTimeParseContext, charSequence, i11, i14);
                    } else if (dateTimeParseContext.c(charAt, 'G') && length >= (i12 = i11 + 3) && dateTimeParseContext.c(charAt2, 'M') && dateTimeParseContext.c(charSequence.charAt(i13), 'T')) {
                        return parsePrefixedOffset(dateTimeParseContext, charSequence, i11, i12);
                    }
                }
                Set<String> availableZoneIds = ZoneRulesProvider.getAvailableZoneIds();
                int size = availableZoneIds.size();
                Map.Entry<Integer, SubstringTree> entry = cachedSubstringTree;
                if (entry == null || entry.getKey().intValue() != size) {
                    synchronized (this) {
                        entry = cachedSubstringTree;
                        if (entry == null || entry.getKey().intValue() != size) {
                            entry = new AbstractMap.SimpleImmutableEntry<>(Integer.valueOf(size), prepareParser(availableZoneIds));
                            cachedSubstringTree = entry;
                        }
                    }
                }
                SubstringTree value = entry.getValue();
                String str = null;
                String str2 = null;
                while (value != null) {
                    int i15 = value.f63367a + i11;
                    if (i15 > length) {
                        break;
                    }
                    String charSequence2 = charSequence.subSequence(i11, i15).toString();
                    value = value.get(charSequence2, dateTimeParseContext.k());
                    String str3 = charSequence2;
                    str2 = str;
                    str = str3;
                }
                ZoneId convertToZone = convertToZone(availableZoneIds, str, dateTimeParseContext.k());
                if (convertToZone == null) {
                    convertToZone = convertToZone(availableZoneIds, str2, dateTimeParseContext.k());
                    if (convertToZone != null) {
                        str = str2;
                    } else if (!dateTimeParseContext.c(charAt, 'Z')) {
                        return ~i11;
                    } else {
                        dateTimeParseContext.n(ZoneOffset.UTC);
                        return i11 + 1;
                    }
                }
                dateTimeParseContext.n(convertToZone);
                return i11 + str.length();
            }
        }

        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb2) {
            ZoneId zoneId = (ZoneId) dateTimePrintContext.f(this.query);
            if (zoneId == null) {
                return false;
            }
            sb2.append(zoneId.getId());
            return true;
        }

        public String toString() {
            return this.description;
        }
    }

    public static final class ZoneTextPrinterParser implements DateTimePrinterParser {
        private static final Comparator<String> LENGTH_COMPARATOR = new Comparator<String>() {
            public int compare(String str, String str2) {
                int length = str2.length() - str.length();
                return length == 0 ? str.compareTo(str2) : length;
            }
        };
        private final TextStyle textStyle;

        public ZoneTextPrinterParser(TextStyle textStyle2) {
            this.textStyle = (TextStyle) Jdk8Methods.requireNonNull(textStyle2, "textStyle");
        }

        private int parseOffset(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i11, String str) {
            int length = str.length();
            int i12 = i11 + length;
            if (i12 >= charSequence.length()) {
                dateTimeParseContext.n(ZoneId.of(str));
                return i12;
            }
            char charAt = charSequence.charAt(i12);
            if (charAt == '+' || charAt == '-') {
                DateTimeParseContext e11 = dateTimeParseContext.e();
                try {
                    int parse = OffsetIdPrinterParser.f63365d.parse(e11, charSequence, i12);
                    if (parse < 0) {
                        dateTimeParseContext.n(ZoneId.of(str));
                        return i12;
                    }
                    ZoneOffset ofTotalSeconds = ZoneOffset.ofTotalSeconds((int) e11.i(ChronoField.OFFSET_SECONDS).longValue());
                    dateTimeParseContext.n(length == 0 ? ofTotalSeconds : ZoneId.ofOffset(str, ofTotalSeconds));
                    return parse;
                } catch (DateTimeException unused) {
                    return ~i11;
                }
            } else {
                dateTimeParseContext.n(ZoneId.of(str));
                return i12;
            }
        }

        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i11) {
            int i12;
            int length = charSequence.length();
            if (i11 > length) {
                throw new IndexOutOfBoundsException();
            } else if (i11 == length) {
                return ~i11;
            } else {
                char charAt = charSequence.charAt(i11);
                if (charAt == '+' || charAt == '-') {
                    if (i11 + 6 > length) {
                        return ~i11;
                    }
                    return parseOffset(dateTimeParseContext, charSequence, i11, "");
                } else if (dateTimeParseContext.t(charSequence, i11, "GMT", 0, 3)) {
                    return parseOffset(dateTimeParseContext, charSequence, i11, "GMT");
                } else {
                    if (dateTimeParseContext.t(charSequence, i11, "UTC", 0, 3)) {
                        return parseOffset(dateTimeParseContext, charSequence, i11, "UTC");
                    }
                    if (dateTimeParseContext.t(charSequence, i11, "UT", 0, 2)) {
                        return parseOffset(dateTimeParseContext, charSequence, i11, "UT");
                    }
                    TreeMap treeMap = new TreeMap(LENGTH_COMPARATOR);
                    for (String next : ZoneId.getAvailableZoneIds()) {
                        treeMap.put(next, next);
                        TimeZone timeZone = DesugarTimeZone.getTimeZone(next);
                        if (this.textStyle.asNormal() == TextStyle.FULL) {
                            i12 = 1;
                        } else {
                            i12 = 0;
                        }
                        String displayName = timeZone.getDisplayName(false, i12, dateTimeParseContext.h());
                        if (next.startsWith("Etc/") || (!displayName.startsWith("GMT+") && !displayName.startsWith("GMT+"))) {
                            treeMap.put(displayName, next);
                        }
                        String displayName2 = timeZone.getDisplayName(true, i12, dateTimeParseContext.h());
                        if (next.startsWith("Etc/") || (!displayName2.startsWith("GMT+") && !displayName2.startsWith("GMT+"))) {
                            treeMap.put(displayName2, next);
                        }
                    }
                    for (Map.Entry entry : treeMap.entrySet()) {
                        String str = (String) entry.getKey();
                        if (dateTimeParseContext.t(charSequence, i11, str, 0, str.length())) {
                            dateTimeParseContext.n(ZoneId.of((String) entry.getValue()));
                            return i11 + str.length();
                        }
                    }
                    if (charAt != 'Z') {
                        return ~i11;
                    }
                    dateTimeParseContext.n(ZoneOffset.UTC);
                    return i11 + 1;
                }
            }
        }

        public boolean print(DateTimePrintContext dateTimePrintContext, StringBuilder sb2) {
            boolean z11;
            ZoneId zoneId = (ZoneId) dateTimePrintContext.f(TemporalQueries.zoneId());
            int i11 = 0;
            if (zoneId == null) {
                return false;
            }
            if (zoneId.normalized() instanceof ZoneOffset) {
                sb2.append(zoneId.getId());
                return true;
            }
            TemporalAccessor d11 = dateTimePrintContext.d();
            ChronoField chronoField = ChronoField.INSTANT_SECONDS;
            if (d11.isSupported(chronoField)) {
                z11 = zoneId.getRules().isDaylightSavings(Instant.ofEpochSecond(d11.getLong(chronoField)));
            } else {
                z11 = false;
            }
            TimeZone timeZone = DesugarTimeZone.getTimeZone(zoneId.getId());
            if (this.textStyle.asNormal() == TextStyle.FULL) {
                i11 = 1;
            }
            sb2.append(timeZone.getDisplayName(z11, i11, dateTimePrintContext.b()));
            return true;
        }

        public String toString() {
            return "ZoneText(" + this.textStyle + ")";
        }
    }

    static {
        HashMap hashMap = new HashMap();
        FIELD_MAP = hashMap;
        hashMap.put('G', ChronoField.ERA);
        hashMap.put('y', ChronoField.YEAR_OF_ERA);
        hashMap.put(Character.valueOf(AbstractJsonLexerKt.UNICODE_ESC), ChronoField.YEAR);
        TemporalField temporalField = IsoFields.QUARTER_OF_YEAR;
        hashMap.put('Q', temporalField);
        hashMap.put('q', temporalField);
        ChronoField chronoField = ChronoField.MONTH_OF_YEAR;
        hashMap.put('M', chronoField);
        hashMap.put('L', chronoField);
        hashMap.put('D', ChronoField.DAY_OF_YEAR);
        hashMap.put(Character.valueOf(Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL), ChronoField.DAY_OF_MONTH);
        hashMap.put('F', ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        ChronoField chronoField2 = ChronoField.DAY_OF_WEEK;
        hashMap.put('E', chronoField2);
        hashMap.put('c', chronoField2);
        hashMap.put('e', chronoField2);
        hashMap.put('a', ChronoField.AMPM_OF_DAY);
        hashMap.put('H', ChronoField.HOUR_OF_DAY);
        hashMap.put('k', ChronoField.CLOCK_HOUR_OF_DAY);
        hashMap.put('K', ChronoField.HOUR_OF_AMPM);
        hashMap.put('h', ChronoField.CLOCK_HOUR_OF_AMPM);
        hashMap.put(Character.valueOf(Advice.OffsetMapping.ForOrigin.Renderer.ForMethodName.SYMBOL), ChronoField.MINUTE_OF_HOUR);
        hashMap.put(Character.valueOf(Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL), ChronoField.SECOND_OF_MINUTE);
        ChronoField chronoField3 = ChronoField.NANO_OF_SECOND;
        hashMap.put('S', chronoField3);
        hashMap.put('A', ChronoField.MILLI_OF_DAY);
        hashMap.put('n', chronoField3);
        hashMap.put('N', ChronoField.NANO_OF_DAY);
    }

    public DateTimeFormatterBuilder() {
        this.active = this;
        this.printerParsers = new ArrayList();
        this.valueParserIndex = -1;
        this.parent = null;
        this.optional = false;
    }

    private int appendInternal(DateTimePrinterParser dateTimePrinterParser) {
        Jdk8Methods.requireNonNull(dateTimePrinterParser, "pp");
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.active;
        int i11 = dateTimeFormatterBuilder.padNextWidth;
        if (i11 > 0) {
            if (dateTimePrinterParser != null) {
                dateTimePrinterParser = new PadPrinterParserDecorator(dateTimePrinterParser, i11, dateTimeFormatterBuilder.padNextChar);
            }
            DateTimeFormatterBuilder dateTimeFormatterBuilder2 = this.active;
            dateTimeFormatterBuilder2.padNextWidth = 0;
            dateTimeFormatterBuilder2.padNextChar = 0;
        }
        this.active.printerParsers.add(dateTimePrinterParser);
        DateTimeFormatterBuilder dateTimeFormatterBuilder3 = this.active;
        dateTimeFormatterBuilder3.valueParserIndex = -1;
        return dateTimeFormatterBuilder3.printerParsers.size() - 1;
    }

    public static String getLocalizedDateTimePattern(FormatStyle formatStyle, FormatStyle formatStyle2, Chronology chronology, Locale locale) {
        DateFormat dateFormat;
        Jdk8Methods.requireNonNull(locale, "locale");
        Jdk8Methods.requireNonNull(chronology, "chrono");
        if (formatStyle == null && formatStyle2 == null) {
            throw new IllegalArgumentException("Either dateStyle or timeStyle must be non-null");
        }
        if (formatStyle == null) {
            dateFormat = DateFormat.getTimeInstance(formatStyle2.ordinal(), locale);
        } else if (formatStyle2 != null) {
            dateFormat = DateFormat.getDateTimeInstance(formatStyle.ordinal(), formatStyle2.ordinal(), locale);
        } else {
            dateFormat = DateFormat.getDateInstance(formatStyle.ordinal(), locale);
        }
        if (dateFormat instanceof SimpleDateFormat) {
            return ((SimpleDateFormat) dateFormat).toPattern();
        }
        throw new IllegalArgumentException("Unable to determine pattern");
    }

    private void parseField(char c11, int i11, TemporalField temporalField) {
        if (c11 != 'Q') {
            if (c11 == 'S') {
                appendFraction(ChronoField.NANO_OF_SECOND, i11, i11, false);
                return;
            } else if (c11 != 'a') {
                if (!(c11 == 'h' || c11 == 'k' || c11 == 'm')) {
                    if (c11 != 'q') {
                        if (c11 != 's') {
                            if (c11 != 'u' && c11 != 'y') {
                                switch (c11) {
                                    case 'D':
                                        if (i11 == 1) {
                                            appendValue(temporalField);
                                            return;
                                        } else if (i11 <= 3) {
                                            appendValue(temporalField, i11);
                                            return;
                                        } else {
                                            throw new IllegalArgumentException("Too many pattern letters: " + c11);
                                        }
                                    case 'E':
                                    case 'G':
                                        if (i11 == 1 || i11 == 2 || i11 == 3) {
                                            appendText(temporalField, TextStyle.SHORT);
                                            return;
                                        } else if (i11 == 4) {
                                            appendText(temporalField, TextStyle.FULL);
                                            return;
                                        } else if (i11 == 5) {
                                            appendText(temporalField, TextStyle.NARROW);
                                            return;
                                        } else {
                                            throw new IllegalArgumentException("Too many pattern letters: " + c11);
                                        }
                                    case 'F':
                                        if (i11 == 1) {
                                            appendValue(temporalField);
                                            return;
                                        }
                                        throw new IllegalArgumentException("Too many pattern letters: " + c11);
                                    case 'H':
                                        break;
                                    default:
                                        switch (c11) {
                                            case 'K':
                                                break;
                                            case 'L':
                                                break;
                                            case 'M':
                                                break;
                                            default:
                                                switch (c11) {
                                                    case 'c':
                                                        if (i11 == 1) {
                                                            appendInternal(new WeekFieldsPrinterParser('c', i11));
                                                            return;
                                                        } else if (i11 == 2) {
                                                            throw new IllegalArgumentException("Invalid number of pattern letters: " + c11);
                                                        } else if (i11 == 3) {
                                                            appendText(temporalField, TextStyle.SHORT_STANDALONE);
                                                            return;
                                                        } else if (i11 == 4) {
                                                            appendText(temporalField, TextStyle.FULL_STANDALONE);
                                                            return;
                                                        } else if (i11 == 5) {
                                                            appendText(temporalField, TextStyle.NARROW_STANDALONE);
                                                            return;
                                                        } else {
                                                            throw new IllegalArgumentException("Too many pattern letters: " + c11);
                                                        }
                                                    case 'd':
                                                        break;
                                                    case 'e':
                                                        if (i11 == 1 || i11 == 2) {
                                                            appendInternal(new WeekFieldsPrinterParser('e', i11));
                                                            return;
                                                        } else if (i11 == 3) {
                                                            appendText(temporalField, TextStyle.SHORT);
                                                            return;
                                                        } else if (i11 == 4) {
                                                            appendText(temporalField, TextStyle.FULL);
                                                            return;
                                                        } else if (i11 == 5) {
                                                            appendText(temporalField, TextStyle.NARROW);
                                                            return;
                                                        } else {
                                                            throw new IllegalArgumentException("Too many pattern letters: " + c11);
                                                        }
                                                    default:
                                                        if (i11 == 1) {
                                                            appendValue(temporalField);
                                                            return;
                                                        } else {
                                                            appendValue(temporalField, i11);
                                                            return;
                                                        }
                                                }
                                        }
                                }
                            } else if (i11 == 2) {
                                appendValueReduced(temporalField, 2, 2, (ChronoLocalDate) ReducedPrinterParser.f63366h);
                                return;
                            } else if (i11 < 4) {
                                appendValue(temporalField, i11, 19, SignStyle.NORMAL);
                                return;
                            } else {
                                appendValue(temporalField, i11, 19, SignStyle.EXCEEDS_PAD);
                                return;
                            }
                        }
                    }
                    if (i11 == 1) {
                        appendValue(temporalField);
                        return;
                    } else if (i11 == 2) {
                        appendValue(temporalField, 2);
                        return;
                    } else if (i11 == 3) {
                        appendText(temporalField, TextStyle.SHORT_STANDALONE);
                        return;
                    } else if (i11 == 4) {
                        appendText(temporalField, TextStyle.FULL_STANDALONE);
                        return;
                    } else if (i11 == 5) {
                        appendText(temporalField, TextStyle.NARROW_STANDALONE);
                        return;
                    } else {
                        throw new IllegalArgumentException("Too many pattern letters: " + c11);
                    }
                }
                if (i11 == 1) {
                    appendValue(temporalField);
                    return;
                } else if (i11 == 2) {
                    appendValue(temporalField, i11);
                    return;
                } else {
                    throw new IllegalArgumentException("Too many pattern letters: " + c11);
                }
            } else if (i11 == 1) {
                appendText(temporalField, TextStyle.SHORT);
                return;
            } else {
                throw new IllegalArgumentException("Too many pattern letters: " + c11);
            }
        }
        if (i11 == 1) {
            appendValue(temporalField);
        } else if (i11 == 2) {
            appendValue(temporalField, 2);
        } else if (i11 == 3) {
            appendText(temporalField, TextStyle.SHORT);
        } else if (i11 == 4) {
            appendText(temporalField, TextStyle.FULL);
        } else if (i11 == 5) {
            appendText(temporalField, TextStyle.NARROW);
        } else {
            throw new IllegalArgumentException("Too many pattern letters: " + c11);
        }
    }

    private void parsePattern(String str) {
        int i11;
        int i12;
        int i13;
        int i14 = 0;
        while (i14 < str.length()) {
            char charAt = str.charAt(i14);
            if ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z')) {
                int i15 = i14 + 1;
                while (i15 < str.length() && str.charAt(i15) == charAt) {
                    i15++;
                }
                int i16 = i15 - i14;
                if (charAt == 'p') {
                    if (i15 >= str.length() || (((charAt = str.charAt(i15)) < 'A' || charAt > 'Z') && (charAt < 'a' || charAt > 'z'))) {
                        i13 = i16;
                        i16 = 0;
                    } else {
                        int i17 = i15 + 1;
                        while (i17 < str.length() && str.charAt(i17) == charAt) {
                            i17++;
                        }
                        i13 = i17 - i15;
                        i15 = i17;
                    }
                    if (i16 != 0) {
                        padNext(i16);
                        i16 = i13;
                    } else {
                        throw new IllegalArgumentException("Pad letter 'p' must be followed by valid pad pattern: " + str);
                    }
                }
                TemporalField temporalField = FIELD_MAP.get(Character.valueOf(charAt));
                if (temporalField != null) {
                    parseField(charAt, i16, temporalField);
                } else if (charAt == 'z') {
                    if (i16 > 4) {
                        throw new IllegalArgumentException("Too many pattern letters: " + charAt);
                    } else if (i16 == 4) {
                        appendZoneText(TextStyle.FULL);
                    } else {
                        appendZoneText(TextStyle.SHORT);
                    }
                } else if (charAt != 'V') {
                    String str2 = "+0000";
                    if (charAt == 'Z') {
                        if (i16 < 4) {
                            appendOffset("+HHMM", str2);
                        } else if (i16 == 4) {
                            appendLocalizedOffset(TextStyle.FULL);
                        } else if (i16 == 5) {
                            appendOffset("+HH:MM:ss", "Z");
                        } else {
                            throw new IllegalArgumentException("Too many pattern letters: " + charAt);
                        }
                    } else if (charAt == 'O') {
                        if (i16 == 1) {
                            appendLocalizedOffset(TextStyle.SHORT);
                        } else if (i16 == 4) {
                            appendLocalizedOffset(TextStyle.FULL);
                        } else {
                            throw new IllegalArgumentException("Pattern letter count must be 1 or 4: " + charAt);
                        }
                    } else if (charAt == 'X') {
                        if (i16 <= 5) {
                            String[] strArr = OffsetIdPrinterParser.f63363b;
                            if (i16 == 1) {
                                i12 = 0;
                            } else {
                                i12 = 1;
                            }
                            appendOffset(strArr[i16 + i12], "Z");
                        } else {
                            throw new IllegalArgumentException("Too many pattern letters: " + charAt);
                        }
                    } else if (charAt == 'x') {
                        if (i16 <= 5) {
                            if (i16 == 1) {
                                str2 = "+00";
                            } else if (i16 % 2 != 0) {
                                str2 = "+00:00";
                            }
                            String[] strArr2 = OffsetIdPrinterParser.f63363b;
                            if (i16 == 1) {
                                i11 = 0;
                            } else {
                                i11 = 1;
                            }
                            appendOffset(strArr2[i16 + i11], str2);
                        } else {
                            throw new IllegalArgumentException("Too many pattern letters: " + charAt);
                        }
                    } else if (charAt == 'W') {
                        if (i16 <= 1) {
                            appendInternal(new WeekFieldsPrinterParser('W', i16));
                        } else {
                            throw new IllegalArgumentException("Too many pattern letters: " + charAt);
                        }
                    } else if (charAt == 'w') {
                        if (i16 <= 2) {
                            appendInternal(new WeekFieldsPrinterParser('w', i16));
                        } else {
                            throw new IllegalArgumentException("Too many pattern letters: " + charAt);
                        }
                    } else if (charAt == 'Y') {
                        appendInternal(new WeekFieldsPrinterParser('Y', i16));
                    } else {
                        throw new IllegalArgumentException("Unknown pattern letter: " + charAt);
                    }
                } else if (i16 == 2) {
                    appendZoneId();
                } else {
                    throw new IllegalArgumentException("Pattern letter count must be 2: " + charAt);
                }
                i14 = i15 - 1;
            } else if (charAt == '\'') {
                int i18 = i14 + 1;
                int i19 = i18;
                while (i19 < str.length()) {
                    if (str.charAt(i19) == '\'') {
                        int i21 = i19 + 1;
                        if (i21 >= str.length() || str.charAt(i21) != '\'') {
                            break;
                        }
                        i19 = i21;
                    }
                    i19++;
                }
                if (i19 < str.length()) {
                    String substring = str.substring(i18, i19);
                    if (substring.length() == 0) {
                        appendLiteral('\'');
                    } else {
                        appendLiteral(substring.replace("''", "'"));
                    }
                    i14 = i19;
                } else {
                    throw new IllegalArgumentException("Pattern ends with an incomplete string literal: " + str);
                }
            } else if (charAt == '[') {
                optionalStart();
            } else if (charAt == ']') {
                if (this.active.parent != null) {
                    optionalEnd();
                } else {
                    throw new IllegalArgumentException("Pattern invalid as it contains ] without previous [");
                }
            } else if (charAt == '{' || charAt == '}' || charAt == '#') {
                throw new IllegalArgumentException("Pattern includes reserved character: '" + charAt + "'");
            } else {
                appendLiteral(charAt);
            }
            i14++;
        }
    }

    public DateTimeFormatter a(ResolverStyle resolverStyle) {
        return toFormatter().withResolverStyle(resolverStyle);
    }

    public DateTimeFormatterBuilder append(DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.requireNonNull(dateTimeFormatter, "formatter");
        appendInternal(dateTimeFormatter.c(false));
        return this;
    }

    public DateTimeFormatterBuilder appendChronologyId() {
        appendInternal(new ChronoPrinterParser((TextStyle) null));
        return this;
    }

    public DateTimeFormatterBuilder appendChronologyText(TextStyle textStyle) {
        Jdk8Methods.requireNonNull(textStyle, "textStyle");
        appendInternal(new ChronoPrinterParser(textStyle));
        return this;
    }

    public DateTimeFormatterBuilder appendFraction(TemporalField temporalField, int i11, int i12, boolean z11) {
        appendInternal(new FractionPrinterParser(temporalField, i11, i12, z11));
        return this;
    }

    public DateTimeFormatterBuilder appendInstant() {
        appendInternal(new InstantPrinterParser(-2));
        return this;
    }

    public DateTimeFormatterBuilder appendLiteral(char c11) {
        appendInternal(new CharLiteralPrinterParser(c11));
        return this;
    }

    public DateTimeFormatterBuilder appendLocalized(FormatStyle formatStyle, FormatStyle formatStyle2) {
        if (formatStyle == null && formatStyle2 == null) {
            throw new IllegalArgumentException("Either the date or time style must be non-null");
        }
        appendInternal(new LocalizedPrinterParser(formatStyle, formatStyle2));
        return this;
    }

    public DateTimeFormatterBuilder appendLocalizedOffset(TextStyle textStyle) {
        Jdk8Methods.requireNonNull(textStyle, "style");
        if (textStyle == TextStyle.FULL || textStyle == TextStyle.SHORT) {
            appendInternal(new LocalizedOffsetPrinterParser(textStyle));
            return this;
        }
        throw new IllegalArgumentException("Style must be either full or short");
    }

    public DateTimeFormatterBuilder appendOffset(String str, String str2) {
        appendInternal(new OffsetIdPrinterParser(str2, str));
        return this;
    }

    public DateTimeFormatterBuilder appendOffsetId() {
        appendInternal(OffsetIdPrinterParser.f63364c);
        return this;
    }

    public DateTimeFormatterBuilder appendOptional(DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.requireNonNull(dateTimeFormatter, "formatter");
        appendInternal(dateTimeFormatter.c(true));
        return this;
    }

    public DateTimeFormatterBuilder appendPattern(String str) {
        Jdk8Methods.requireNonNull(str, Param.PATTERN);
        parsePattern(str);
        return this;
    }

    public DateTimeFormatterBuilder appendText(TemporalField temporalField) {
        return appendText(temporalField, TextStyle.FULL);
    }

    public DateTimeFormatterBuilder appendValue(TemporalField temporalField) {
        Jdk8Methods.requireNonNull(temporalField, "field");
        appendValue(new NumberPrinterParser(temporalField, 1, 19, SignStyle.NORMAL));
        return this;
    }

    public DateTimeFormatterBuilder appendValueReduced(TemporalField temporalField, int i11, int i12, int i13) {
        Jdk8Methods.requireNonNull(temporalField, "field");
        appendValue((NumberPrinterParser) new ReducedPrinterParser(temporalField, i11, i12, i13, (ChronoLocalDate) null));
        return this;
    }

    public DateTimeFormatterBuilder appendZoneId() {
        appendInternal(new ZoneIdPrinterParser(TemporalQueries.zoneId(), "ZoneId()"));
        return this;
    }

    public DateTimeFormatterBuilder appendZoneOrOffsetId() {
        appendInternal(new ZoneIdPrinterParser(TemporalQueries.zone(), "ZoneOrOffsetId()"));
        return this;
    }

    public DateTimeFormatterBuilder appendZoneRegionId() {
        appendInternal(new ZoneIdPrinterParser(QUERY_REGION_ONLY, "ZoneRegionId()"));
        return this;
    }

    public DateTimeFormatterBuilder appendZoneText(TextStyle textStyle) {
        appendInternal(new ZoneTextPrinterParser(textStyle));
        return this;
    }

    public DateTimeFormatterBuilder optionalEnd() {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.active;
        if (dateTimeFormatterBuilder.parent != null) {
            if (dateTimeFormatterBuilder.printerParsers.size() > 0) {
                DateTimeFormatterBuilder dateTimeFormatterBuilder2 = this.active;
                CompositePrinterParser compositePrinterParser = new CompositePrinterParser(dateTimeFormatterBuilder2.printerParsers, dateTimeFormatterBuilder2.optional);
                this.active = this.active.parent;
                appendInternal(compositePrinterParser);
            } else {
                this.active = this.active.parent;
            }
            return this;
        }
        throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
    }

    public DateTimeFormatterBuilder optionalStart() {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.active;
        dateTimeFormatterBuilder.valueParserIndex = -1;
        this.active = new DateTimeFormatterBuilder(dateTimeFormatterBuilder, true);
        return this;
    }

    public DateTimeFormatterBuilder padNext(int i11) {
        return padNext(i11, ' ');
    }

    public DateTimeFormatterBuilder parseCaseInsensitive() {
        appendInternal(SettingsParser.INSENSITIVE);
        return this;
    }

    public DateTimeFormatterBuilder parseCaseSensitive() {
        appendInternal(SettingsParser.SENSITIVE);
        return this;
    }

    public DateTimeFormatterBuilder parseDefaulting(TemporalField temporalField, long j11) {
        Jdk8Methods.requireNonNull(temporalField, "field");
        appendInternal(new DefaultingParser(temporalField, j11));
        return this;
    }

    public DateTimeFormatterBuilder parseLenient() {
        appendInternal(SettingsParser.LENIENT);
        return this;
    }

    public DateTimeFormatterBuilder parseStrict() {
        appendInternal(SettingsParser.STRICT);
        return this;
    }

    public DateTimeFormatter toFormatter() {
        return toFormatter(Locale.getDefault());
    }

    public DateTimeFormatterBuilder appendInstant(int i11) {
        if (i11 < -1 || i11 > 9) {
            throw new IllegalArgumentException("Invalid fractional digits: " + i11);
        }
        appendInternal(new InstantPrinterParser(i11));
        return this;
    }

    public DateTimeFormatterBuilder appendLiteral(String str) {
        Jdk8Methods.requireNonNull(str, "literal");
        if (str.length() > 0) {
            if (str.length() == 1) {
                appendInternal(new CharLiteralPrinterParser(str.charAt(0)));
            } else {
                appendInternal(new StringLiteralPrinterParser(str));
            }
        }
        return this;
    }

    public DateTimeFormatterBuilder appendText(TemporalField temporalField, TextStyle textStyle) {
        Jdk8Methods.requireNonNull(temporalField, "field");
        Jdk8Methods.requireNonNull(textStyle, "textStyle");
        appendInternal(new TextPrinterParser(temporalField, textStyle, DateTimeTextProvider.b()));
        return this;
    }

    public DateTimeFormatterBuilder appendZoneText(TextStyle textStyle, Set<ZoneId> set) {
        Jdk8Methods.requireNonNull(set, "preferredZones");
        appendInternal(new ZoneTextPrinterParser(textStyle));
        return this;
    }

    public DateTimeFormatterBuilder padNext(int i11, char c11) {
        if (i11 >= 1) {
            DateTimeFormatterBuilder dateTimeFormatterBuilder = this.active;
            dateTimeFormatterBuilder.padNextWidth = i11;
            dateTimeFormatterBuilder.padNextChar = c11;
            dateTimeFormatterBuilder.valueParserIndex = -1;
            return this;
        }
        throw new IllegalArgumentException("The pad width must be at least one but was " + i11);
    }

    public DateTimeFormatter toFormatter(Locale locale) {
        Jdk8Methods.requireNonNull(locale, "locale");
        while (this.active.parent != null) {
            optionalEnd();
        }
        return new DateTimeFormatter(new CompositePrinterParser(this.printerParsers, false), locale, DecimalStyle.STANDARD, ResolverStyle.SMART, (Set<TemporalField>) null, (Chronology) null, (ZoneId) null);
    }

    public DateTimeFormatterBuilder appendValue(TemporalField temporalField, int i11) {
        Jdk8Methods.requireNonNull(temporalField, "field");
        if (i11 < 1 || i11 > 19) {
            throw new IllegalArgumentException("The width must be from 1 to 19 inclusive but was " + i11);
        }
        appendValue(new NumberPrinterParser(temporalField, i11, i11, SignStyle.NOT_NEGATIVE));
        return this;
    }

    public DateTimeFormatterBuilder appendValueReduced(TemporalField temporalField, int i11, int i12, ChronoLocalDate chronoLocalDate) {
        Jdk8Methods.requireNonNull(temporalField, "field");
        Jdk8Methods.requireNonNull(chronoLocalDate, "baseDate");
        appendValue((NumberPrinterParser) new ReducedPrinterParser(temporalField, i11, i12, 0, chronoLocalDate));
        return this;
    }

    public DateTimeFormatterBuilder appendText(TemporalField temporalField, Map<Long, String> map) {
        Jdk8Methods.requireNonNull(temporalField, "field");
        Jdk8Methods.requireNonNull(map, "textLookup");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        TextStyle textStyle = TextStyle.FULL;
        final SimpleDateTimeTextProvider.LocaleStore localeStore = new SimpleDateTimeTextProvider.LocaleStore(Collections.singletonMap(textStyle, linkedHashMap));
        appendInternal(new TextPrinterParser(temporalField, textStyle, new DateTimeTextProvider() {
            public String getText(TemporalField temporalField, long j11, TextStyle textStyle, Locale locale) {
                return localeStore.a(j11, textStyle);
            }

            public Iterator<Map.Entry<String, Long>> getTextIterator(TemporalField temporalField, TextStyle textStyle, Locale locale) {
                return localeStore.b(textStyle);
            }
        }));
        return this;
    }

    private DateTimeFormatterBuilder(DateTimeFormatterBuilder dateTimeFormatterBuilder, boolean z11) {
        this.active = this;
        this.printerParsers = new ArrayList();
        this.valueParserIndex = -1;
        this.parent = dateTimeFormatterBuilder;
        this.optional = z11;
    }

    public DateTimeFormatterBuilder appendValue(TemporalField temporalField, int i11, int i12, SignStyle signStyle) {
        if (i11 == i12 && signStyle == SignStyle.NOT_NEGATIVE) {
            return appendValue(temporalField, i12);
        }
        Jdk8Methods.requireNonNull(temporalField, "field");
        Jdk8Methods.requireNonNull(signStyle, "signStyle");
        if (i11 < 1 || i11 > 19) {
            throw new IllegalArgumentException("The minimum width must be from 1 to 19 inclusive but was " + i11);
        } else if (i12 < 1 || i12 > 19) {
            throw new IllegalArgumentException("The maximum width must be from 1 to 19 inclusive but was " + i12);
        } else if (i12 >= i11) {
            appendValue(new NumberPrinterParser(temporalField, i11, i12, signStyle));
            return this;
        } else {
            throw new IllegalArgumentException("The maximum width must exceed or equal the minimum width but " + i12 + " < " + i11);
        }
    }

    public static final class ReducedPrinterParser extends NumberPrinterParser {

        /* renamed from: h  reason: collision with root package name */
        public static final LocalDate f63366h = LocalDate.of(2000, 1, 1);
        private final ChronoLocalDate baseDate;
        private final int baseValue;

        public ReducedPrinterParser(TemporalField temporalField, int i11, int i12, int i13, ChronoLocalDate chronoLocalDate) {
            super(temporalField, i11, i12, SignStyle.NOT_NEGATIVE);
            if (i11 < 1 || i11 > 10) {
                throw new IllegalArgumentException("The width must be from 1 to 10 inclusive but was " + i11);
            } else if (i12 < 1 || i12 > 10) {
                throw new IllegalArgumentException("The maxWidth must be from 1 to 10 inclusive but was " + i12);
            } else if (i12 >= i11) {
                if (chronoLocalDate == null) {
                    long j11 = (long) i13;
                    if (!temporalField.range().isValidValue(j11)) {
                        throw new IllegalArgumentException("The base value must be within the range of the field");
                    } else if (j11 + ((long) NumberPrinterParser.f63357g[i11]) > 2147483647L) {
                        throw new DateTimeException("Unable to add printer-parser as the range exceeds the capacity of an int");
                    }
                }
                this.baseValue = i13;
                this.baseDate = chronoLocalDate;
            } else {
                throw new IllegalArgumentException("The maxWidth must be greater than the width");
            }
        }

        public long a(DateTimePrintContext dateTimePrintContext, long j11) {
            long abs = Math.abs(j11);
            int i11 = this.baseValue;
            if (this.baseDate != null) {
                i11 = Chronology.from(dateTimePrintContext.d()).date(this.baseDate).get(this.f63358b);
            }
            if (j11 >= ((long) i11)) {
                int i12 = NumberPrinterParser.f63357g[this.f63359c];
                if (j11 < ((long) (i11 + i12))) {
                    return abs % ((long) i12);
                }
            }
            return abs % ((long) NumberPrinterParser.f63357g[this.f63360d]);
        }

        public boolean b(DateTimeParseContext dateTimeParseContext) {
            if (!dateTimeParseContext.l()) {
                return false;
            }
            return super.b(dateTimeParseContext);
        }

        public int c(DateTimeParseContext dateTimeParseContext, long j11, int i11, int i12) {
            long j12;
            int i13 = this.baseValue;
            if (this.baseDate != null) {
                i13 = dateTimeParseContext.g().date(this.baseDate).get(this.f63358b);
                dateTimeParseContext.b(this, j11, i11, i12);
            }
            int i14 = i12 - i11;
            int i15 = this.f63359c;
            if (i14 == i15 && j11 >= 0) {
                long j13 = (long) NumberPrinterParser.f63357g[i15];
                long j14 = (long) i13;
                long j15 = j14 - (j14 % j13);
                if (i13 > 0) {
                    j12 = j15 + j11;
                } else {
                    j12 = j15 - j11;
                }
                j11 = j12;
                if (j11 < j14) {
                    j11 += j13;
                }
            }
            return dateTimeParseContext.p(this.f63358b, j11, i11, i12);
        }

        public NumberPrinterParser d() {
            if (this.f63362f == -1) {
                return this;
            }
            return new ReducedPrinterParser(this.f63358b, this.f63359c, this.f63360d, this.baseValue, this.baseDate, -1);
        }

        /* renamed from: f */
        public ReducedPrinterParser e(int i11) {
            return new ReducedPrinterParser(this.f63358b, this.f63359c, this.f63360d, this.baseValue, this.baseDate, this.f63362f + i11);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ReducedValue(");
            sb2.append(this.f63358b);
            sb2.append(",");
            sb2.append(this.f63359c);
            sb2.append(",");
            sb2.append(this.f63360d);
            sb2.append(",");
            Object obj = this.baseDate;
            if (obj == null) {
                obj = Integer.valueOf(this.baseValue);
            }
            sb2.append(obj);
            sb2.append(")");
            return sb2.toString();
        }

        private ReducedPrinterParser(TemporalField temporalField, int i11, int i12, int i13, ChronoLocalDate chronoLocalDate, int i14) {
            super(temporalField, i11, i12, SignStyle.NOT_NEGATIVE, i14);
            this.baseValue = i13;
            this.baseDate = chronoLocalDate;
        }
    }

    private DateTimeFormatterBuilder appendValue(NumberPrinterParser numberPrinterParser) {
        NumberPrinterParser numberPrinterParser2;
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.active;
        int i11 = dateTimeFormatterBuilder.valueParserIndex;
        if (i11 < 0 || !(dateTimeFormatterBuilder.printerParsers.get(i11) instanceof NumberPrinterParser)) {
            this.active.valueParserIndex = appendInternal(numberPrinterParser);
        } else {
            DateTimeFormatterBuilder dateTimeFormatterBuilder2 = this.active;
            int i12 = dateTimeFormatterBuilder2.valueParserIndex;
            NumberPrinterParser numberPrinterParser3 = (NumberPrinterParser) dateTimeFormatterBuilder2.printerParsers.get(i12);
            int i13 = numberPrinterParser.f63359c;
            int i14 = numberPrinterParser.f63360d;
            if (i13 == i14 && numberPrinterParser.f63361e == SignStyle.NOT_NEGATIVE) {
                numberPrinterParser2 = numberPrinterParser3.e(i14);
                appendInternal(numberPrinterParser.d());
                this.active.valueParserIndex = i12;
            } else {
                numberPrinterParser2 = numberPrinterParser3.d();
                this.active.valueParserIndex = appendInternal(numberPrinterParser);
            }
            this.active.printerParsers.set(i12, numberPrinterParser2);
        }
        return this;
    }
}
