package org.threeten.bp.format;

import java.io.IOException;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Period;
import org.threeten.bp.ZoneId;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.DateTimeParseContext;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.IsoFields;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQuery;

public final class DateTimeFormatter {
    public static final DateTimeFormatter BASIC_ISO_DATE;
    public static final DateTimeFormatter ISO_DATE;
    public static final DateTimeFormatter ISO_DATE_TIME;
    public static final DateTimeFormatter ISO_INSTANT;
    public static final DateTimeFormatter ISO_LOCAL_DATE;
    public static final DateTimeFormatter ISO_LOCAL_DATE_TIME;
    public static final DateTimeFormatter ISO_LOCAL_TIME;
    public static final DateTimeFormatter ISO_OFFSET_DATE;
    public static final DateTimeFormatter ISO_OFFSET_DATE_TIME;
    public static final DateTimeFormatter ISO_OFFSET_TIME;
    public static final DateTimeFormatter ISO_ORDINAL_DATE;
    public static final DateTimeFormatter ISO_TIME;
    public static final DateTimeFormatter ISO_WEEK_DATE;
    public static final DateTimeFormatter ISO_ZONED_DATE_TIME;
    private static final TemporalQuery<Period> PARSED_EXCESS_DAYS = new TemporalQuery<Period>() {
        public Period queryFrom(TemporalAccessor temporalAccessor) {
            if (temporalAccessor instanceof DateTimeBuilder) {
                return ((DateTimeBuilder) temporalAccessor).f63352h;
            }
            return Period.ZERO;
        }
    };
    private static final TemporalQuery<Boolean> PARSED_LEAP_SECOND = new TemporalQuery<Boolean>() {
        public Boolean queryFrom(TemporalAccessor temporalAccessor) {
            if (temporalAccessor instanceof DateTimeBuilder) {
                return Boolean.valueOf(((DateTimeBuilder) temporalAccessor).f63351g);
            }
            return Boolean.FALSE;
        }
    };
    public static final DateTimeFormatter RFC_1123_DATE_TIME;
    private final Chronology chrono;
    private final DecimalStyle decimalStyle;
    private final Locale locale;
    private final DateTimeFormatterBuilder.CompositePrinterParser printerParser;
    private final Set<TemporalField> resolverFields;
    private final ResolverStyle resolverStyle;
    private final ZoneId zone;

    static {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        ChronoField chronoField = ChronoField.YEAR;
        SignStyle signStyle = SignStyle.EXCEEDS_PAD;
        DateTimeFormatterBuilder appendLiteral = dateTimeFormatterBuilder.appendValue(chronoField, 4, 10, signStyle).appendLiteral((char) SignatureVisitor.SUPER);
        ChronoField chronoField2 = ChronoField.MONTH_OF_YEAR;
        DateTimeFormatterBuilder appendLiteral2 = appendLiteral.appendValue(chronoField2, 2).appendLiteral((char) SignatureVisitor.SUPER);
        ChronoField chronoField3 = ChronoField.DAY_OF_MONTH;
        DateTimeFormatterBuilder appendValue = appendLiteral2.appendValue(chronoField3, 2);
        ResolverStyle resolverStyle2 = ResolverStyle.STRICT;
        DateTimeFormatter a11 = appendValue.a(resolverStyle2);
        IsoChronology isoChronology = IsoChronology.INSTANCE;
        DateTimeFormatter withChronology = a11.withChronology(isoChronology);
        ISO_LOCAL_DATE = withChronology;
        ISO_OFFSET_DATE = new DateTimeFormatterBuilder().parseCaseInsensitive().append(withChronology).appendOffsetId().a(resolverStyle2).withChronology(isoChronology);
        ISO_DATE = new DateTimeFormatterBuilder().parseCaseInsensitive().append(withChronology).optionalStart().appendOffsetId().a(resolverStyle2).withChronology(isoChronology);
        DateTimeFormatterBuilder dateTimeFormatterBuilder2 = new DateTimeFormatterBuilder();
        ChronoField chronoField4 = ChronoField.HOUR_OF_DAY;
        DateTimeFormatterBuilder appendLiteral3 = dateTimeFormatterBuilder2.appendValue(chronoField4, 2).appendLiteral((char) AbstractJsonLexerKt.COLON);
        ChronoField chronoField5 = ChronoField.MINUTE_OF_HOUR;
        DateTimeFormatterBuilder appendLiteral4 = appendLiteral3.appendValue(chronoField5, 2).optionalStart().appendLiteral((char) AbstractJsonLexerKt.COLON);
        ChronoField chronoField6 = ChronoField.SECOND_OF_MINUTE;
        DateTimeFormatter a12 = appendLiteral4.appendValue(chronoField6, 2).optionalStart().appendFraction(ChronoField.NANO_OF_SECOND, 0, 9, true).a(resolverStyle2);
        ISO_LOCAL_TIME = a12;
        ISO_OFFSET_TIME = new DateTimeFormatterBuilder().parseCaseInsensitive().append(a12).appendOffsetId().a(resolverStyle2);
        ISO_TIME = new DateTimeFormatterBuilder().parseCaseInsensitive().append(a12).optionalStart().appendOffsetId().a(resolverStyle2);
        DateTimeFormatter withChronology2 = new DateTimeFormatterBuilder().parseCaseInsensitive().append(withChronology).appendLiteral('T').append(a12).a(resolverStyle2).withChronology(isoChronology);
        ISO_LOCAL_DATE_TIME = withChronology2;
        DateTimeFormatter withChronology3 = new DateTimeFormatterBuilder().parseCaseInsensitive().append(withChronology2).appendOffsetId().a(resolverStyle2).withChronology(isoChronology);
        ISO_OFFSET_DATE_TIME = withChronology3;
        ISO_ZONED_DATE_TIME = new DateTimeFormatterBuilder().append(withChronology3).optionalStart().appendLiteral('[').parseCaseSensitive().appendZoneRegionId().appendLiteral((char) AbstractJsonLexerKt.END_LIST).a(resolverStyle2).withChronology(isoChronology);
        ISO_DATE_TIME = new DateTimeFormatterBuilder().append(withChronology2).optionalStart().appendOffsetId().optionalStart().appendLiteral('[').parseCaseSensitive().appendZoneRegionId().appendLiteral((char) AbstractJsonLexerKt.END_LIST).a(resolverStyle2).withChronology(isoChronology);
        ISO_ORDINAL_DATE = new DateTimeFormatterBuilder().parseCaseInsensitive().appendValue(chronoField, 4, 10, signStyle).appendLiteral((char) SignatureVisitor.SUPER).appendValue(ChronoField.DAY_OF_YEAR, 3).optionalStart().appendOffsetId().a(resolverStyle2).withChronology(isoChronology);
        DateTimeFormatterBuilder appendLiteral5 = new DateTimeFormatterBuilder().parseCaseInsensitive().appendValue(IsoFields.WEEK_BASED_YEAR, 4, 10, signStyle).appendLiteral("-W").appendValue(IsoFields.WEEK_OF_WEEK_BASED_YEAR, 2).appendLiteral((char) SignatureVisitor.SUPER);
        ChronoField chronoField7 = ChronoField.DAY_OF_WEEK;
        ISO_WEEK_DATE = appendLiteral5.appendValue(chronoField7, 1).optionalStart().appendOffsetId().a(resolverStyle2).withChronology(isoChronology);
        ISO_INSTANT = new DateTimeFormatterBuilder().parseCaseInsensitive().appendInstant().a(resolverStyle2);
        BASIC_ISO_DATE = new DateTimeFormatterBuilder().parseCaseInsensitive().appendValue(chronoField, 4).appendValue(chronoField2, 2).appendValue(chronoField3, 2).optionalStart().appendOffset("+HHMMss", "Z").a(resolverStyle2).withChronology(isoChronology);
        HashMap hashMap = new HashMap();
        hashMap.put(1L, "Mon");
        hashMap.put(2L, "Tue");
        hashMap.put(3L, "Wed");
        hashMap.put(4L, "Thu");
        hashMap.put(5L, "Fri");
        hashMap.put(6L, "Sat");
        IsoChronology isoChronology2 = isoChronology;
        hashMap.put(7L, "Sun");
        HashMap hashMap2 = new HashMap();
        hashMap2.put(1L, "Jan");
        hashMap2.put(2L, "Feb");
        hashMap2.put(3L, "Mar");
        hashMap2.put(4L, "Apr");
        hashMap2.put(5L, "May");
        hashMap2.put(6L, "Jun");
        hashMap2.put(7L, "Jul");
        hashMap2.put(8L, "Aug");
        hashMap2.put(9L, "Sep");
        hashMap2.put(10L, "Oct");
        hashMap2.put(11L, "Nov");
        hashMap2.put(12L, "Dec");
        RFC_1123_DATE_TIME = new DateTimeFormatterBuilder().parseCaseInsensitive().parseLenient().optionalStart().appendText((TemporalField) chronoField7, (Map<Long, String>) hashMap).appendLiteral(IndicativeSentencesGeneration.DEFAULT_SEPARATOR).optionalEnd().appendValue(chronoField3, 1, 2, SignStyle.NOT_NEGATIVE).appendLiteral(' ').appendText((TemporalField) chronoField2, (Map<Long, String>) hashMap2).appendLiteral(' ').appendValue(chronoField, 4).appendLiteral(' ').appendValue(chronoField4, 2).appendLiteral((char) AbstractJsonLexerKt.COLON).appendValue(chronoField5, 2).optionalStart().appendLiteral((char) AbstractJsonLexerKt.COLON).appendValue(chronoField6, 2).optionalEnd().appendLiteral(' ').appendOffset("+HHMM", "GMT").a(ResolverStyle.SMART).withChronology(isoChronology2);
    }

    public DateTimeFormatter(DateTimeFormatterBuilder.CompositePrinterParser compositePrinterParser, Locale locale2, DecimalStyle decimalStyle2, ResolverStyle resolverStyle2, Set<TemporalField> set, Chronology chronology, ZoneId zoneId) {
        this.printerParser = (DateTimeFormatterBuilder.CompositePrinterParser) Jdk8Methods.requireNonNull(compositePrinterParser, "printerParser");
        this.locale = (Locale) Jdk8Methods.requireNonNull(locale2, "locale");
        this.decimalStyle = (DecimalStyle) Jdk8Methods.requireNonNull(decimalStyle2, "decimalStyle");
        this.resolverStyle = (ResolverStyle) Jdk8Methods.requireNonNull(resolverStyle2, "resolverStyle");
        this.resolverFields = set;
        this.chrono = chronology;
        this.zone = zoneId;
    }

    private DateTimeParseException createError(CharSequence charSequence, RuntimeException runtimeException) {
        String str;
        if (charSequence.length() > 64) {
            str = charSequence.subSequence(0, 64).toString() + "...";
        } else {
            str = charSequence.toString();
        }
        return new DateTimeParseException("Text '" + str + "' could not be parsed: " + runtimeException.getMessage(), charSequence, 0, runtimeException);
    }

    public static DateTimeFormatter ofLocalizedDate(FormatStyle formatStyle) {
        Jdk8Methods.requireNonNull(formatStyle, "dateStyle");
        return new DateTimeFormatterBuilder().appendLocalized(formatStyle, (FormatStyle) null).toFormatter().withChronology(IsoChronology.INSTANCE);
    }

    public static DateTimeFormatter ofLocalizedDateTime(FormatStyle formatStyle) {
        Jdk8Methods.requireNonNull(formatStyle, "dateTimeStyle");
        return new DateTimeFormatterBuilder().appendLocalized(formatStyle, formatStyle).toFormatter().withChronology(IsoChronology.INSTANCE);
    }

    public static DateTimeFormatter ofLocalizedTime(FormatStyle formatStyle) {
        Jdk8Methods.requireNonNull(formatStyle, "timeStyle");
        return new DateTimeFormatterBuilder().appendLocalized((FormatStyle) null, formatStyle).toFormatter().withChronology(IsoChronology.INSTANCE);
    }

    public static DateTimeFormatter ofPattern(String str) {
        return new DateTimeFormatterBuilder().appendPattern(str).toFormatter();
    }

    /* access modifiers changed from: private */
    public DateTimeBuilder parseToBuilder(CharSequence charSequence, ParsePosition parsePosition) {
        ParsePosition parsePosition2;
        String str;
        if (parsePosition != null) {
            parsePosition2 = parsePosition;
        } else {
            parsePosition2 = new ParsePosition(0);
        }
        DateTimeParseContext.Parsed parseUnresolved0 = parseUnresolved0(charSequence, parsePosition2);
        if (parseUnresolved0 != null && parsePosition2.getErrorIndex() < 0 && (parsePosition != null || parsePosition2.getIndex() >= charSequence.length())) {
            return parseUnresolved0.b();
        }
        if (charSequence.length() > 64) {
            str = charSequence.subSequence(0, 64).toString() + "...";
        } else {
            str = charSequence.toString();
        }
        if (parsePosition2.getErrorIndex() >= 0) {
            throw new DateTimeParseException("Text '" + str + "' could not be parsed at index " + parsePosition2.getErrorIndex(), charSequence, parsePosition2.getErrorIndex());
        }
        throw new DateTimeParseException("Text '" + str + "' could not be parsed, unparsed text found at index " + parsePosition2.getIndex(), charSequence, parsePosition2.getIndex());
    }

    /* access modifiers changed from: private */
    public DateTimeParseContext.Parsed parseUnresolved0(CharSequence charSequence, ParsePosition parsePosition) {
        Jdk8Methods.requireNonNull(charSequence, "text");
        Jdk8Methods.requireNonNull(parsePosition, "position");
        DateTimeParseContext dateTimeParseContext = new DateTimeParseContext(this);
        int parse = this.printerParser.parse(dateTimeParseContext, charSequence, parsePosition.getIndex());
        if (parse < 0) {
            parsePosition.setErrorIndex(~parse);
            return null;
        }
        parsePosition.setIndex(parse);
        return dateTimeParseContext.u();
    }

    public static final TemporalQuery<Period> parsedExcessDays() {
        return PARSED_EXCESS_DAYS;
    }

    public static final TemporalQuery<Boolean> parsedLeapSecond() {
        return PARSED_LEAP_SECOND;
    }

    public DateTimeFormatterBuilder.CompositePrinterParser c(boolean z11) {
        return this.printerParser.withOptional(z11);
    }

    public String format(TemporalAccessor temporalAccessor) {
        StringBuilder sb2 = new StringBuilder(32);
        formatTo(temporalAccessor, sb2);
        return sb2.toString();
    }

    public void formatTo(TemporalAccessor temporalAccessor, Appendable appendable) {
        Jdk8Methods.requireNonNull(temporalAccessor, "temporal");
        Jdk8Methods.requireNonNull(appendable, "appendable");
        try {
            DateTimePrintContext dateTimePrintContext = new DateTimePrintContext(temporalAccessor, this);
            if (appendable instanceof StringBuilder) {
                this.printerParser.print(dateTimePrintContext, (StringBuilder) appendable);
                return;
            }
            StringBuilder sb2 = new StringBuilder(32);
            this.printerParser.print(dateTimePrintContext, sb2);
            appendable.append(sb2);
        } catch (IOException e11) {
            throw new DateTimeException(e11.getMessage(), e11);
        }
    }

    public Chronology getChronology() {
        return this.chrono;
    }

    public DecimalStyle getDecimalStyle() {
        return this.decimalStyle;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public Set<TemporalField> getResolverFields() {
        return this.resolverFields;
    }

    public ResolverStyle getResolverStyle() {
        return this.resolverStyle;
    }

    public ZoneId getZone() {
        return this.zone;
    }

    public TemporalAccessor parse(CharSequence charSequence) {
        Jdk8Methods.requireNonNull(charSequence, "text");
        try {
            return parseToBuilder(charSequence, (ParsePosition) null).resolve(this.resolverStyle, this.resolverFields);
        } catch (DateTimeParseException e11) {
            throw e11;
        } catch (RuntimeException e12) {
            throw createError(charSequence, e12);
        }
    }

    public TemporalAccessor parseBest(CharSequence charSequence, TemporalQuery<?>... temporalQueryArr) {
        Jdk8Methods.requireNonNull(charSequence, "text");
        Jdk8Methods.requireNonNull(temporalQueryArr, "types");
        if (temporalQueryArr.length >= 2) {
            try {
                DateTimeBuilder resolve = parseToBuilder(charSequence, (ParsePosition) null).resolve(this.resolverStyle, this.resolverFields);
                int i11 = 0;
                while (i11 < temporalQueryArr.length) {
                    try {
                        return (TemporalAccessor) resolve.build(temporalQueryArr[i11]);
                    } catch (RuntimeException unused) {
                        i11++;
                    }
                }
                throw new DateTimeException("Unable to convert parsed text to any specified type: " + Arrays.toString(temporalQueryArr));
            } catch (DateTimeParseException e11) {
                throw e11;
            } catch (RuntimeException e12) {
                throw createError(charSequence, e12);
            }
        } else {
            throw new IllegalArgumentException("At least two types must be specified");
        }
    }

    public TemporalAccessor parseUnresolved(CharSequence charSequence, ParsePosition parsePosition) {
        return parseUnresolved0(charSequence, parsePosition);
    }

    public Format toFormat() {
        return new ClassicFormat(this, (TemporalQuery<?>) null);
    }

    public String toString() {
        String compositePrinterParser = this.printerParser.toString();
        if (compositePrinterParser.startsWith("[")) {
            return compositePrinterParser;
        }
        return compositePrinterParser.substring(1, compositePrinterParser.length() - 1);
    }

    public DateTimeFormatter withChronology(Chronology chronology) {
        if (Jdk8Methods.equals(this.chrono, chronology)) {
            return this;
        }
        return new DateTimeFormatter(this.printerParser, this.locale, this.decimalStyle, this.resolverStyle, this.resolverFields, chronology, this.zone);
    }

    public DateTimeFormatter withDecimalStyle(DecimalStyle decimalStyle2) {
        if (this.decimalStyle.equals(decimalStyle2)) {
            return this;
        }
        return new DateTimeFormatter(this.printerParser, this.locale, decimalStyle2, this.resolverStyle, this.resolverFields, this.chrono, this.zone);
    }

    public DateTimeFormatter withLocale(Locale locale2) {
        if (this.locale.equals(locale2)) {
            return this;
        }
        return new DateTimeFormatter(this.printerParser, locale2, this.decimalStyle, this.resolverStyle, this.resolverFields, this.chrono, this.zone);
    }

    public DateTimeFormatter withResolverFields(TemporalField... temporalFieldArr) {
        if (temporalFieldArr == null) {
            return new DateTimeFormatter(this.printerParser, this.locale, this.decimalStyle, this.resolverStyle, (Set<TemporalField>) null, this.chrono, this.zone);
        }
        HashSet hashSet = new HashSet(Arrays.asList(temporalFieldArr));
        if (Jdk8Methods.equals(this.resolverFields, hashSet)) {
            return this;
        }
        return new DateTimeFormatter(this.printerParser, this.locale, this.decimalStyle, this.resolverStyle, Collections.unmodifiableSet(hashSet), this.chrono, this.zone);
    }

    public DateTimeFormatter withResolverStyle(ResolverStyle resolverStyle2) {
        Jdk8Methods.requireNonNull(resolverStyle2, "resolverStyle");
        if (Jdk8Methods.equals(this.resolverStyle, resolverStyle2)) {
            return this;
        }
        return new DateTimeFormatter(this.printerParser, this.locale, this.decimalStyle, resolverStyle2, this.resolverFields, this.chrono, this.zone);
    }

    public DateTimeFormatter withZone(ZoneId zoneId) {
        if (Jdk8Methods.equals(this.zone, zoneId)) {
            return this;
        }
        return new DateTimeFormatter(this.printerParser, this.locale, this.decimalStyle, this.resolverStyle, this.resolverFields, this.chrono, zoneId);
    }

    public static DateTimeFormatter ofPattern(String str, Locale locale2) {
        return new DateTimeFormatterBuilder().appendPattern(str).toFormatter(locale2);
    }

    public Format toFormat(TemporalQuery<?> temporalQuery) {
        Jdk8Methods.requireNonNull(temporalQuery, "query");
        return new ClassicFormat(this, temporalQuery);
    }

    public static DateTimeFormatter ofLocalizedDateTime(FormatStyle formatStyle, FormatStyle formatStyle2) {
        Jdk8Methods.requireNonNull(formatStyle, "dateStyle");
        Jdk8Methods.requireNonNull(formatStyle2, "timeStyle");
        return new DateTimeFormatterBuilder().appendLocalized(formatStyle, formatStyle2).toFormatter().withChronology(IsoChronology.INSTANCE);
    }

    public TemporalAccessor parse(CharSequence charSequence, ParsePosition parsePosition) {
        Jdk8Methods.requireNonNull(charSequence, "text");
        Jdk8Methods.requireNonNull(parsePosition, "position");
        try {
            return parseToBuilder(charSequence, parsePosition).resolve(this.resolverStyle, this.resolverFields);
        } catch (DateTimeParseException e11) {
            throw e11;
        } catch (IndexOutOfBoundsException e12) {
            throw e12;
        } catch (RuntimeException e13) {
            throw createError(charSequence, e13);
        }
    }

    public DateTimeFormatter withResolverFields(Set<TemporalField> set) {
        if (set == null) {
            return new DateTimeFormatter(this.printerParser, this.locale, this.decimalStyle, this.resolverStyle, (Set<TemporalField>) null, this.chrono, this.zone);
        }
        if (Jdk8Methods.equals(this.resolverFields, set)) {
            return this;
        }
        return new DateTimeFormatter(this.printerParser, this.locale, this.decimalStyle, this.resolverStyle, Collections.unmodifiableSet(new HashSet(set)), this.chrono, this.zone);
    }

    public static class ClassicFormat extends Format {
        private final DateTimeFormatter formatter;
        private final TemporalQuery<?> query;

        public ClassicFormat(DateTimeFormatter dateTimeFormatter, TemporalQuery<?> temporalQuery) {
            this.formatter = dateTimeFormatter;
            this.query = temporalQuery;
        }

        public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
            Jdk8Methods.requireNonNull(obj, "obj");
            Jdk8Methods.requireNonNull(stringBuffer, "toAppendTo");
            Jdk8Methods.requireNonNull(fieldPosition, "pos");
            if (obj instanceof TemporalAccessor) {
                fieldPosition.setBeginIndex(0);
                fieldPosition.setEndIndex(0);
                try {
                    this.formatter.formatTo((TemporalAccessor) obj, stringBuffer);
                    return stringBuffer;
                } catch (RuntimeException e11) {
                    throw new IllegalArgumentException(e11.getMessage(), e11);
                }
            } else {
                throw new IllegalArgumentException("Format target must implement TemporalAccessor");
            }
        }

        public Object parseObject(String str) throws ParseException {
            Jdk8Methods.requireNonNull(str, "text");
            try {
                TemporalQuery<?> temporalQuery = this.query;
                if (temporalQuery == null) {
                    return this.formatter.parseToBuilder(str, (ParsePosition) null).resolve(this.formatter.getResolverStyle(), this.formatter.getResolverFields());
                }
                return this.formatter.parse((CharSequence) str, temporalQuery);
            } catch (DateTimeParseException e11) {
                throw new ParseException(e11.getMessage(), e11.getErrorIndex());
            } catch (RuntimeException e12) {
                throw ((ParseException) new ParseException(e12.getMessage(), 0).initCause(e12));
            }
        }

        public Object parseObject(String str, ParsePosition parsePosition) {
            Jdk8Methods.requireNonNull(str, "text");
            try {
                DateTimeParseContext.Parsed b11 = this.formatter.parseUnresolved0(str, parsePosition);
                if (b11 == null) {
                    if (parsePosition.getErrorIndex() < 0) {
                        parsePosition.setErrorIndex(0);
                    }
                    return null;
                }
                try {
                    DateTimeBuilder resolve = b11.b().resolve(this.formatter.getResolverStyle(), this.formatter.getResolverFields());
                    TemporalQuery<?> temporalQuery = this.query;
                    if (temporalQuery == null) {
                        return resolve;
                    }
                    return resolve.build(temporalQuery);
                } catch (RuntimeException unused) {
                    parsePosition.setErrorIndex(0);
                    return null;
                }
            } catch (IndexOutOfBoundsException unused2) {
                if (parsePosition.getErrorIndex() < 0) {
                    parsePosition.setErrorIndex(0);
                }
                return null;
            }
        }
    }

    public <T> T parse(CharSequence charSequence, TemporalQuery<T> temporalQuery) {
        Jdk8Methods.requireNonNull(charSequence, "text");
        Jdk8Methods.requireNonNull(temporalQuery, "type");
        try {
            return parseToBuilder(charSequence, (ParsePosition) null).resolve(this.resolverStyle, this.resolverFields).build(temporalQuery);
        } catch (DateTimeParseException e11) {
            throw e11;
        } catch (RuntimeException e12) {
            throw createError(charSequence, e12);
        }
    }
}
