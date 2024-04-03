package org.apache.commons.lang3.time;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class FastDateFormat extends Format implements DateParser, DatePrinter {
    public static final int FULL = 0;
    public static final int LONG = 1;
    public static final int MEDIUM = 2;
    public static final int SHORT = 3;
    private static final FormatCache<FastDateFormat> cache = new FormatCache<FastDateFormat>() {
        /* renamed from: f */
        public FastDateFormat a(String str, TimeZone timeZone, Locale locale) {
            return new FastDateFormat(str, timeZone, locale);
        }
    };
    private static final long serialVersionUID = 2;
    private final FastDateParser parser;
    private final FastDatePrinter printer;

    public FastDateFormat(String str, TimeZone timeZone, Locale locale) {
        this(str, timeZone, locale, (Date) null);
    }

    public static FastDateFormat getDateInstance(int i11) {
        return cache.b(i11, (TimeZone) null, (Locale) null);
    }

    public static FastDateFormat getDateTimeInstance(int i11, int i12) {
        return cache.c(i11, i12, (TimeZone) null, (Locale) null);
    }

    public static FastDateFormat getInstance() {
        return cache.getInstance();
    }

    public static FastDateFormat getTimeInstance(int i11) {
        return cache.e(i11, (TimeZone) null, (Locale) null);
    }

    public StringBuffer applyRules(Calendar calendar, StringBuffer stringBuffer) {
        return this.printer.applyRules(calendar, stringBuffer);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FastDateFormat)) {
            return false;
        }
        return this.printer.equals(((FastDateFormat) obj).printer);
    }

    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return this.printer.format(obj, stringBuffer, fieldPosition);
    }

    public Locale getLocale() {
        return this.printer.getLocale();
    }

    public int getMaxLengthEstimate() {
        return this.printer.getMaxLengthEstimate();
    }

    public String getPattern() {
        return this.printer.getPattern();
    }

    public TimeZone getTimeZone() {
        return this.printer.getTimeZone();
    }

    public int hashCode() {
        return this.printer.hashCode();
    }

    public Date parse(String str) throws ParseException {
        return this.parser.parse(str);
    }

    public Object parseObject(String str, ParsePosition parsePosition) {
        return this.parser.parseObject(str, parsePosition);
    }

    public String toString() {
        return "FastDateFormat[" + this.printer.getPattern() + "," + this.printer.getLocale() + "," + this.printer.getTimeZone().getID() + "]";
    }

    public FastDateFormat(String str, TimeZone timeZone, Locale locale, Date date) {
        this.printer = new FastDatePrinter(str, timeZone, locale);
        this.parser = new FastDateParser(str, timeZone, locale, date);
    }

    public static FastDateFormat getDateInstance(int i11, Locale locale) {
        return cache.b(i11, (TimeZone) null, locale);
    }

    public static FastDateFormat getDateTimeInstance(int i11, int i12, Locale locale) {
        return cache.c(i11, i12, (TimeZone) null, locale);
    }

    public static FastDateFormat getInstance(String str) {
        return cache.getInstance(str, (TimeZone) null, (Locale) null);
    }

    public static FastDateFormat getTimeInstance(int i11, Locale locale) {
        return cache.e(i11, (TimeZone) null, locale);
    }

    public String format(long j11) {
        return this.printer.format(j11);
    }

    public Date parse(String str, ParsePosition parsePosition) {
        return this.parser.parse(str, parsePosition);
    }

    public static FastDateFormat getDateInstance(int i11, TimeZone timeZone) {
        return cache.b(i11, timeZone, (Locale) null);
    }

    public static FastDateFormat getDateTimeInstance(int i11, int i12, TimeZone timeZone) {
        return getDateTimeInstance(i11, i12, timeZone, (Locale) null);
    }

    public static FastDateFormat getInstance(String str, TimeZone timeZone) {
        return cache.getInstance(str, timeZone, (Locale) null);
    }

    public static FastDateFormat getTimeInstance(int i11, TimeZone timeZone) {
        return cache.e(i11, timeZone, (Locale) null);
    }

    public String format(Date date) {
        return this.printer.format(date);
    }

    public static FastDateFormat getDateInstance(int i11, TimeZone timeZone, Locale locale) {
        return cache.b(i11, timeZone, locale);
    }

    public static FastDateFormat getDateTimeInstance(int i11, int i12, TimeZone timeZone, Locale locale) {
        return cache.c(i11, i12, timeZone, locale);
    }

    public static FastDateFormat getInstance(String str, Locale locale) {
        return cache.getInstance(str, (TimeZone) null, locale);
    }

    public static FastDateFormat getTimeInstance(int i11, TimeZone timeZone, Locale locale) {
        return cache.e(i11, timeZone, locale);
    }

    public String format(Calendar calendar) {
        return this.printer.format(calendar);
    }

    public static FastDateFormat getInstance(String str, TimeZone timeZone, Locale locale) {
        return cache.getInstance(str, timeZone, locale);
    }

    public StringBuffer format(long j11, StringBuffer stringBuffer) {
        return this.printer.format(j11, stringBuffer);
    }

    public StringBuffer format(Date date, StringBuffer stringBuffer) {
        return this.printer.format(date, stringBuffer);
    }

    public StringBuffer format(Calendar calendar, StringBuffer stringBuffer) {
        return this.printer.format(calendar, stringBuffer);
    }
}
